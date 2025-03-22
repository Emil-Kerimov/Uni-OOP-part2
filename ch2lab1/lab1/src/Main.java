import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        CalculatingThread ct = new CalculatingThread();
        Pi pi = new Pi();
        MyRun myRun = new MyRun(pi);
        while(true) {
            System.out.println("1 - Synchronized");
            System.out.println("2 - ReentrantLock");
            Scanner scanner = new Scanner(System.in);
            int c = scanner.nextInt();
            int m = 0;
            if (c == 1) {
                while (m != 6) {
                    displayMenu();
                    m = scanner.nextInt();
                    switch (m) {
                        case 1: {
                            new Thread(ct).start();
                            break;
                        }
                        case 2: {
                            ct.activate();
                            break;
                        }
                        case 3: {
                            ct.deactivate();
                            break;
                        }
                        case 4: {
                            ct.displayResult();
                            break;
                        }
                        case 5: {
                            ct.displayElapsedTime();
                            break;
                        }
                    }
                }
            } else if (c == 2) {
                while (m != 6) {
                    displayMenu();
                    m = scanner.nextInt();
                    switch (m) {
                        case 1: {
                            new Thread(myRun).start();
                            break;
                        }
                        case 2: {
                            myRun.activate();
                            break;
                        }
                        case 3: {
                            myRun.deactivate();
                            break;
                        }
                        case 4: {
                            myRun.displayResult();
                            break;
                        }
                        case 5: {
                            myRun.displayElapsedTime();
                            break;
                        }
                    }
                }
            }
        }
    }
    public static  void displayMenu(){
        System.out.println("1 - start");
        System.out.println("2 - continue");
        System.out.println("3 - stop");
        System.out.println("4 - view current result");
        System.out.println("5 - Find out the total time spent on calculations. ");
        System.out.println("6 - exit");
    }
}

class CalculatingThread implements Runnable{
    double pi;
    private volatile boolean active;
    private long startTime = 0;
    private long startPauseTime = 0;
    private long endPauseTime = 0;
    private long totalActiveTime = 0;
    CalculatingThread(){
        active = true;
    }

    @Override
    public void run() {
        int i = 3;
        double expression = 1.0;
        double fraction;
        boolean add = false;
        startTime = System.currentTimeMillis();
        while (true) {
            synchronized (this) {
                while (!active) {
                    try {
                        wait(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            fraction = 1.0/i;
            if (add){
                expression += fraction;
            } else {
                expression -= fraction;
            }
            pi = 4 * expression;
            add = !add;
            i += 2;
        }
    }
    synchronized public void activate(){
        endPauseTime = System.currentTimeMillis();
        totalActiveTime += (endPauseTime-startPauseTime);
        active = true;
        notifyAll();
    }
    synchronized public void deactivate(){
        active = false;
        startPauseTime = System.currentTimeMillis();
        totalActiveTime += startPauseTime-startTime;
        System.out.println("deactivated");
    }
    public void displayResult(){
        System.out.println("current pi: " + pi);
    }
    public void displayElapsedTime(){
        long elapsedTime = totalActiveTime;
        if(active){
            elapsedTime += System.currentTimeMillis() - startTime;
        }
        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }
}
class Pi{
    double pi;
    ReentrantLock locker;
    Condition condition;
    private volatile boolean active;
    private long startTime = 0;
    private long startPauseTime = 0;
    private long endPauseTime = 0;
    private long totalActiveTime = 0;
    Pi() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
        active = true;
    }
    public void calculate(){

            int i = 3;
            double expression = 1.0;
            double fraction;
            boolean add = false;
            startTime = System.currentTimeMillis();
            while (true) {
                locker.lock();
                try {
                while (!active){
                    try {
                        condition.await();
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                } finally {
                    locker.unlock();
                }
                fraction = 1.0/i;
                if (add){
                    expression += fraction;
                } else {
                    expression -= fraction;
                }
                pi = 4 * expression;
                add = !add;
                i += 2;
            }

    }
    public void activate(){
        locker.lock();
        try{
            endPauseTime = System.currentTimeMillis();
            totalActiveTime += (endPauseTime- startPauseTime);
            active = true;
            condition.signalAll();
        } finally {
            locker.unlock();
        }
    }
    public void deactivate(){
        locker.lock();
        try {
            active = false;
            startPauseTime = System.currentTimeMillis();
            totalActiveTime += startPauseTime-startTime;
        }finally {
            locker.unlock();
        }
    }
    public void displayResult(){
        System.out.println("current pi: " + pi);
    }
    public void displayElapsedTime(){
        long elapsedTime = totalActiveTime;
        if(active){
            elapsedTime += System.currentTimeMillis() - startTime;
        }
        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }
}

class MyRun implements Runnable{
    Pi pi;
    MyRun(Pi pi){
        this.pi = pi;
    }

    @Override
    public void run() {
        pi.calculate();
    }

    public void activate(){
        pi.activate();
    }
    public void deactivate(){
        pi.deactivate();
    }
    public void displayResult(){
        pi.displayResult();
    }
    public void displayElapsedTime(){
        pi.displayElapsedTime();
    }

}