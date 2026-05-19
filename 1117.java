class H2O {
    private int hydrogenCount = 0;
    private int oxygenCount = 0;
    private final Object lock = new Object();

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (hydrogenCount == 2) {
                lock.wait();
            }

            releaseHydrogen.run();
            hydrogenCount++;

            if (hydrogenCount == 2 && oxygenCount == 1) {
                hydrogenCount = 0;
                oxygenCount = 0;
            }

            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (oxygenCount == 1) {
                lock.wait();
            }

            releaseOxygen.run();
            oxygenCount++;

            if (hydrogenCount == 2 && oxygenCount == 1) {
                hydrogenCount = 0;
                oxygenCount = 0;
            }

            lock.notifyAll();
        }
    }
}