import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    
    // Semaphore to control when foo() can run (starts with 1 permit to run first)
    private final Semaphore semFoo;
    // Semaphore to control when bar() can run (starts with 0 permits)
    private final Semaphore semBar;

    public FooBar(int n) {
        this.n = n;
        this.semFoo = new Semaphore(1);
        this.semBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "foo"
            semFoo.acquire();
            
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            
            // Allow bar() to execute
            semBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "bar"
            semBar.acquire();
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            
            // Allow foo() to execute next
            semFoo.release();
        }
    }
}
