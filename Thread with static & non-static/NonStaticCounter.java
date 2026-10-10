class NonStaticWorker extends Thread {

    long count = 0;
    long time;

    NonStaticWorker(long time) {
        this.time = time;
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < time) {
            count += 100;
        }
    }
}

public class NonStaticCounter {

    public static void main(String[] args)
            throws InterruptedException {

        int[] minutes = {1};

        for (int m : minutes) {

            NonStaticWorker t1 =
                    new NonStaticWorker(m * 60000L);
            NonStaticWorker t2 =
                    new NonStaticWorker(m * 60000L);
            NonStaticWorker t3 =
                    new NonStaticWorker(m * 60000L);

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            long total = t1.count + t2.count + t3.count;

            System.out.println(m + " minute(s)");
            System.out.println("Thread 1 Count: " + t1.count);
            System.out.println("Thread 2 Count: " + t2.count);
            System.out.println("Thread 3 Count: " + t3.count);
            System.out.println("Total Count: " + total);
            System.out.println("----------------");
        }
    }
}