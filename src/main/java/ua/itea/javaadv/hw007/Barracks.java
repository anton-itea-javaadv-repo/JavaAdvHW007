package ua.itea.javaadv.hw007;

import java.util.concurrent.TimeUnit;

public class Barracks implements Runnable {
    private Mine mine;
    private String namePrefix;
    private int count = 0;
    private int sleepingSecond = 1;
    private Thread barracksThread;

    public Barracks(String namePrefix, Mine mine) {
        this.namePrefix = namePrefix;
        this.mine = mine;

        barracksThread = new Thread(this);
        barracksThread.start();
    }

    @Override
    public void run() {
        do {
            for (sleepingSecond = 1; sleepingSecond < 11 && !mine.isExhausted(); sleepingSecond++) {
//                System.out.println("Barracks sleeping " + sleepingSecond + " second.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!mine.isExhausted()) {
                Miner miner = new Miner(namePrefix + count++, mine);
            }
        } while (!mine.isExhausted());
    }

    public int getCount() {
        return count;
    }

    public Thread getBarracksThread() {
        return barracksThread;
    }

    public String getLoggingString() {
        return "{B:" + namePrefix + ",m:" + count + ",sl:" + sleepingSecond + "}";
    }
}
