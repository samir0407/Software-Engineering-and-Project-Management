class CookingTask extends Thread {
    private String taskName;

    public CookingTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " - Running: " + taskName);
    }
}



public class ThreadMain1 {
    public static void main(String[] args) {
        CookingTask task1 = new CookingTask("Cooking");
        CookingTask task2 = new CookingTask("Washing");

        task1.run(); 
        task2.run();

        System.out.println("All tasks started...");
    }
}
