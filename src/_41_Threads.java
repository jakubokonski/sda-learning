public class _41_Threads {
    public static void main(String[] args) {
        // main is a thread
        System.out.println(Thread.currentThread().getName());

        // create own thread
        Thread t0 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()); // obiekt w watku, nie wystartował
        });
        // how to start thread  start uruchamia wątek, run nie
        t0.start();
        System.out.println("Thread0 started");
    }
}
