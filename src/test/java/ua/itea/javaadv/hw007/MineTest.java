package ua.itea.javaadv.hw007;

import org.junit.Test;

import static org.junit.Assert.*;

public class MineTest {

    @Test
    public void getGoldFromMine() {
        Mine mine = new Mine(1000);
        int minedGold;
        int counter = 0;
        while ((minedGold = mine.getGoldFromMine()) != 0) {
            if (counter % 50 == 0) {
                System.out.println();
            }
            System.out.print(minedGold + ",");
            counter++;
        }
        System.out.println("Done!");
    }
}