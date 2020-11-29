package ua.itea.javaadv.hw007;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class BarracksTest {
    @Test
    public void name() {
        Mine m = new Mine(40);
        Barracks b = new Barracks("tM", m);
        try {
            b.getBarracksThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(b.getCount());
    }
}