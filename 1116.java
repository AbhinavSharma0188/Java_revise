class ZeroEvenOdd {
    private int n;
    private int current = 1;
    private int state = 0;
    private final Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (state != 0) {
                    lock.wait();
                }

                printNumber.accept(0);

                if (current % 2 == 1) {
                    state = 1;
                } else {
                    state = 2;
                }

                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (state != 2) {
                    if (current > n) {
                        return;
                    }
                    lock.wait();
                }

                if (current > n) {
                    return;
                }

                printNumber.accept(current++);
                state = 0;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (state != 1) {
                    if (current > n) {
                        return;
                    }
                    lock.wait();
                }

                if (current > n) {
                    return;
                }

                printNumber.accept(current++);
                state = 0;
                lock.notifyAll();
            }
        }
    }
}