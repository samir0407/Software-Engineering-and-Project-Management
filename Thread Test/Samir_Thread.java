import java.util.concurrent.atomic.AtomicLong;

public class Samir_Thread extends Thread {

    static AtomicLong safeCounter = new AtomicLong(0);
    static long unsafeCounter = 0;
    static boolean threadSafe;

    int increments;
    long instanceCounter = 0;

    Samir_Thread(int increments) {
        this.increments = increments;
    }

    @Override
    public void run() {
        for (int i = 0; i < increments; i++) {
            if (threadSafe) {
                safeCounter.incrementAndGet();
            } else {
                unsafeCounter++;
            }

            instanceCounter++;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        if (args.length != 3) {
            System.out.println(
                "Usage: java Samir_Thread <threads> <increments> <true|false>"
            );
            return;
        }

        int n = Integer.parseInt(args[0]);
        int increments = Integer.parseInt(args[1]);
        threadSafe = Boolean.parseBoolean(args[2]);

        if (n <= 0 || increments < 0) {
            System.out.println(
                "Threads must be positive and increments cannot be negative."
            );
            return;
        }

        Samir_Thread[] threads = new Samir_Thread[n];

        safeCounter.set(0);
        unsafeCounter = 0;

        for (int i = 0; i < n; i++) {
            threads[i] = new Samir_Thread(increments);
            threads[i].start();
        }

        long nonStaticTotal = 0;

        for (int i = 0; i < n; i++) {
            threads[i].join();
            nonStaticTotal += threads[i].instanceCounter;
        }

        long staticCount;

        if (threadSafe) {
            staticCount = safeCounter.get();
        } else {
            staticCount = unsafeCounter;
        }

        long expectedCount = (long) n * increments;
        long difference = Math.abs(staticCount - nonStaticTotal);

        String percentage;

        if (nonStaticTotal == 0) {
            percentage = (staticCount == 0)
                    ? "0.00%"
                    : "Undefined";
        } else {
            double percent =
                    difference * 100.0 / nonStaticTotal;
            percentage = String.format("%.2f%%", percent);
        }

        System.out.println("Student: Samir");
        System.out.println("Threads: " + n);
        System.out.println("Increments per thread: " + increments);
        System.out.println("Mode: "
                + (threadSafe ? "Thread-safe" : "Unsafe"));
        System.out.println("Expected count: " + expectedCount);
        System.out.println("Static count: " + staticCount);
        System.out.println("Non-static total: " + nonStaticTotal);
        System.out.println("Absolute difference: " + difference);
        System.out.println("Percentage difference: " + percentage);
    }
}
