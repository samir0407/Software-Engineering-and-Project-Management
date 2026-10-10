class StaticWorker extends Thread {

    static long count = 0;
    long time;

    StaticWorker(long time) {
        this.time = time;
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < time) {
            synchronized (StaticWorker.class) {
                count += 100;
            }
        }
    }
}

public class StaticCounter {

    public static void main(String[] args)
            throws InterruptedException {

        int[] minutes = {1};

        for (int m : minutes) {
            StaticWorker.count = 0;

            StaticWorker t1 = new StaticWorker(m * 60000L);
            StaticWorker t2 = new StaticWorker(m * 60000L);
            StaticWorker t3 = new StaticWorker(m * 60000L);

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            System.out.println(m + " minute(s)");
            System.out.println("Static Count: "
                    + StaticWorker.count);
            System.out.println("----------------");
        }
    }
}