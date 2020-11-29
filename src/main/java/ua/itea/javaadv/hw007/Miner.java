package ua.itea.javaadv.hw007;

import java.util.concurrent.TimeUnit;

public class Miner implements Runnable {
    private String name;
    private Mine mine;
    private int minedGold = 0;
    private Thread minerThread;

    public Miner(String name, Mine mine) {
        this.name = name;
        this.mine = mine;

        this.mine.addMinerToList(this);

        minerThread = new Thread(this);
        minerThread.start();
    }

    @Override
    public void run() {
//        System.out.println(name + " started mining.");
        int gotGoldFromMine;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while ((gotGoldFromMine = mine.getGoldFromMine()) != 0) {
            minedGold = minedGold + gotGoldFromMine;
//            System.out.println(name + " got " + gotGoldFromMine + " gold from mine, total: " + minedGold);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(name + " done mining, total mined: " + minedGold);
    }

    public Thread getMinerThread() {
        return minerThread;
    }

    public int getMinedGold() {
        return minedGold;
    }

    public String getLoggingString() {
        return "{W:" + name + "," + minedGold + "}";
    }
}
