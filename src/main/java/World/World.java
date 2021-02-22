package World;

import Factions.Factions;
import History.Scenario;
import Resources.Agriculture;
import Resources.Industry;
import Resources.Treasury;

import java.util.Arrays;
import java.util.Scanner;

public class World {

    private Island island;
    private Difficulty difficulty;

    public void initIsland(String island, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario)
    {
        this.island = new Island(island, factions, agriculture, industry, treasury, scenario);
    }

    public World(){
        setDifficulty();
    }

    public Island getIsland() {
        return island;
    }

    private void setDifficulty(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez la difficulté :");
        for (int i = 0; i < Difficulty.values().length; i++) {
            System.out.println(i + ": " + Arrays.stream(Difficulty.values()).toArray()[i]);
        }
        int choice = Integer.parseInt(sc.nextLine());
        difficulty = Difficulty.valueOf(Arrays.stream(Difficulty.values()).toArray()[choice].toString());
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
