public class ThreadMethodsTest {

    public static void main(String[] args)
            throws InterruptedException {

        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread is running");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        });

        // getName() and setName()
        System.out.println("Name: " + t.getName());
        t.setName("MyThread");
        System.out.println("New Name: " + t.getName());

        // getPriority() and setPriority()
        System.out.println("Priority: " + t.getPriority());
        t.setPriority(7);
        System.out.println("New Priority: " + t.getPriority());

        // getState() before start
        System.out.println("State: " + t.getState());

        // isAlive() before start
        System.out.println("Alive: " + t.isAlive());

        // start()
        t.start();

        // currentThread()
        System.out.println("Current Thread: "
                + Thread.currentThread().getName());

        // yield()
        Thread.yield();

        // sleep()
        Thread.sleep(100);

        // getState() while sleeping
        System.out.println("State: " + t.getState());

        // interrupt()
        t.interrupt();

        // join()
        t.join();

        // isAlive() after completion
        System.out.println("Alive: " + t.isAlive());

        // isInterrupted()
        System.out.println("Interrupted: " + t.isInterrupted());

        // setDaemon() and isDaemon()
        Thread d = new Thread(() -> {
            System.out.println("Daemon Thread Running");
        });

        d.setDaemon(true);
        System.out.println("Is Daemon: " + d.isDaemon());

        d.start();
        d.join();

        // run() called directly
        Thread r = new Thread(() -> {
            System.out.println("run() called directly by: "
                    + Thread.currentThread().getName());
        });

        r.run();

        System.out.println("Program finished");
    }
}
