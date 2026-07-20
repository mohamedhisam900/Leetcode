import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    // 5 forks for 5 philosophers
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // Determine the fork indices for this philosopher
        int leftForkIdx = philosopher;
        int rightForkIdx = (philosopher + 1) % 5;
        
        // Enforce resource ordering: always lock the lower index first
        int firstFork = Math.min(leftForkIdx, rightForkIdx);
        int secondFork = Math.max(leftForkIdx, rightForkIdx);
        
        // Acquire the forks in order
        forks[firstFork].lock();
        forks[secondFork].lock();
        
        try {
            // Pick up both forks (order of calling execution doesn't matter for the problem output)
            pickLeftFork.run();
            pickRightFork.run();
            
            // Eat
            eat.run();
            
            // Put down both forks
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Always release locks in the reverse order of acquisition
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}
