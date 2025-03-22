public class BalChanger {
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        Account acc = new Account(0);
        Thread increaseThread = new Thread(()-> {
            for(int i = 0; i < 100; i++){
                System.out.println("increaseThread Thread");
                int bal = acc.getBal();
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e){
                    System.out.println("increaseThread thread has been interrupted");
                }
                acc.setBal(bal+1);
            }
        }, "IncreaseThread");

        Thread decreaseThread = new Thread(()-> {
            for(int i = 0; i < 100; i++){
                System.out.println("decreaseThread Thread");
                int bal = acc.getBal();
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e){
                    System.out.println("decreaseThread thread has been interrupted");
                }
                acc.setBal(bal-1);
            }
        }, "DecreaseThread");

        increaseThread.start();
        decreaseThread.start();

        try {
            increaseThread.join();
            decreaseThread.join();
        } catch (InterruptedException e){
            System.out.println("Main thread has been interrupted");
        }
        System.out.println("final bal: " + acc.getBal());
        System.out.println("Main thread finished...");
    }

}
