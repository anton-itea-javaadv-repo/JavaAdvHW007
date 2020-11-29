package ua.itea.javaadv.hw007;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mine {
    private int stock;
    private List<Miner> minersList = new ArrayList<>();

    public Mine() {
        this.stock = 1000;
    }

    public Mine(int stock) {
        this.stock = stock;
    }

    public synchronized int getGoldFromMine() {
        int goldInStock = stock;
        if (goldInStock > 0) {
            if (goldInStock > 3) {
                stock = goldInStock - 3;
                return 3;
            } else {
                stock = 0;
                return goldInStock;
            }
        } else {
            return 0;
        }
    }

    public boolean isExhausted() {
        return stock == 0;
    }

    public void addMinerToList(Miner aMinerToAdd) {
        minersList.add(aMinerToAdd);
    }

    public boolean isAllMinersAlive() {
        Optional<Boolean> firstAlive = new ArrayList<>(minersList).stream()
                .map(m -> m.getMinerThread().isAlive())
                .filter(b -> b)
                .findFirst();
        return firstAlive.orElse(false);
    }

    public String getLoggingString() {
        return "M: " + stock + ", " + (isExhausted() ? "exhausted, " : "") +
                new ArrayList<>(minersList).stream()
                        .map(Miner::getLoggingString)
                        .collect(Collectors.joining(", ")) + ";";
    }

}
