public class _42_ManyThreads {
    public static void main(String[] args) {

        Thread t0 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // start all threads
        t0.start();
        t1.start();
        t2.start();
        // watki sa nieprzewidywalne, nie wiadomo który pierwszy się wykona

        // synchronised
        // monitor

        // atomic's

        // lock's

        // semaphores and phasers

        // cyclic barriers, latches, exchanger

        // concurrent collections, example: ConcurrentHashMap, CopyOnWriteArrayList

        // thread pools and executors / pool limituje wątki, są różne rodzaje pool
        // (fork join pool)

        // futures (promises), completable future

        // queue, example: BlockingPriorityQueue

    }
}
