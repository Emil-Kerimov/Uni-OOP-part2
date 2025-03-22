public class Program {
    public static void main(String[] args){
        System.out.println("Main thread started...");
        Runnable r = ()->{
            while (true){
                System.out.println("Daemon Thread");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    System.out.println("Daemon thread has been interrupted");
                }
            }
        };
        Thread daemonThread = new Thread(r, "DaemonThread");
        daemonThread.setDaemon(true);
        daemonThread.setPriority(Thread.MIN_PRIORITY);

        Thread highPriorityThread = new Thread(()-> {
            for(int i = 0; i < 5; i++){
                System.out.println("highPriorityThread Thread");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    System.out.println("highPriorityThread thread has been interrupted");
                }
            }
        }, "HighPriorityThread");
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        Thread mediumPriorityThread = new Thread(()-> {
            for(int i = 0; i < 5; i++){
                System.out.println("mediumPriorityThread Thread");
                try {
                    Thread.sleep(600);
                }
                catch (InterruptedException e){
                    System.out.println("mediumPriorityThread thread has been interrupted");
                }
            }
        }, "MediumPriorityThread");
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY);

        Thread minPriorityThread = new Thread(()-> {
            for(int i = 0; i < 5; i++){
                System.out.println("minPriorityThread Thread");
                try {
                    Thread.sleep(700);
                }
                catch (InterruptedException e){
                    System.out.println("minPriorityThread thread has been interrupted");
                }
            }
        }, "MinPriorityThread");
        minPriorityThread.setPriority(Thread.MIN_PRIORITY);

        daemonThread.start();
        highPriorityThread.start();
        mediumPriorityThread.start();
        minPriorityThread.start();

        try{
            highPriorityThread.join();
            mediumPriorityThread.join();
            minPriorityThread.join();
        }
        catch (InterruptedException e){
            System.out.println("Main thread has been interrupted");
        }

        System.out.println("Main thread finished...");
    }
}