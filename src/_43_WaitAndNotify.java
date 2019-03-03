public class _43_WaitAndNotify {

    static volatile boolean go = true; // volatile - zabezpiecz zmienną żeby była zawsze w pamięci, żeby nie wrzucąć wyżej do cache np.

    public static void main(String[] args) {

        // DON'T

        Object monitor = new Object();

        Thread t0 = new Thread(() -> {
            System.out.println("Thread-0 started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                go = false; // zmiana go żeby watek ruszył
                monitor.notify(); // powiadamiamy monitor zeby ruszył wątek, sprawdzi w pętli while jaki jest stan go
            }
            System.out.println("Thread-0 stopped");
        });
        t0.start();

        System.out.println("Before wait");
        synchronized (monitor) {
            while (go) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("After wait");



    }
}
