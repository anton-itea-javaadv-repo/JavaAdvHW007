package ua.itea.javaadv.hw007;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class MinerTest {
    @Test
    public void ManyMinersAtOnce() {
        Mine mine = new Mine(1000);
        int minersCount = 20;
        int charCount = String.valueOf(minersCount).length();
        List<Thread> threads = new ArrayList<>(minersCount);
        for (int i = 0; i < minersCount; i++) {
            StringBuilder name = new StringBuilder("m");
            int zeroesCount = charCount - String.valueOf(i).length();
            for (int zero = 0; zero < zeroesCount; zero++) {
                name.append("0");
            }
            name.append(i);
            Miner miner = new Miner(name.toString(), mine);
            threads.add(miner.getMinerThread());
        }
        for (Thread t :
                threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done all.");
    }
}