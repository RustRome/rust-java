
public class Example8 {

    public static void main(String[] args) throws Exception {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            System.out.println(i + " " + (i + 1) % forks.length);
            

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher("Philosopher " + (i + 1), forks[0], forks[i]);
            } else {
                philosophers[i] = new Philosopher("Philosopher " + (i + 1), forks[i], forks[i+1]);
            }

            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }

    static public class Philosopher implements Runnable {

        private String name;
        private final Object leftFork;
        private final Object rightFork;

        Philosopher(String name, Object left, Object right) {
            this.name = name;
            this.leftFork = left;
            this.rightFork = right;
        }

        private void eat() throws InterruptedException {

            System.out.println(this.name + " is eating.");

            Thread.sleep(1000);

            System.out.println(this.name + " is done eating.");

        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (leftFork) {
                        synchronized (rightFork) {
                            eat();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}