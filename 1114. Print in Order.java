import java.util.concurrent.Semaphore;

public class Foo {
    
    // Tracks when first() has finished executing
    private final Semaphore semFirstDone;
    // Tracks when second() has finished executing
    private final Semaphore semSecondDone;

    public Foo() {
        // We initialize both semaphores with 0 permits.
        // This causes any thread calling acquire() to block immediately.
        semFirstDone = new Semaphore(0);
        semSecondDone = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Release a permit to unblock the thread waiting in second()
        semFirstDone.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Block here until first() calls semFirstDone.release()
        semFirstDone.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Release a permit to unblock the thread waiting in third()
        semSecondDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Block here until second() calls semSecondDone.release()
        semSecondDone.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
