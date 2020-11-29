package ua.itea.javaadv.hw007;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making a mine");
        Mine mine = new Mine();
        System.out.println("Making 5 miners");
        for (int i = 0; i < 5; i++) {
            Miner m = new Miner("sM"+i, mine);
        }
        System.out.println("Making barracks");
        Barracks b = new Barracks("nM", mine);
        System.out.println("Hard work is started");
        do {
            System.out.println(mine.getLoggingString() + " " + b.getLoggingString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (mine.isAllMinersAlive());
        try {
            b.getBarracksThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}
