package World;

import Factions.Factions;
import History.Scenario;
import Resources.*;

import org.apache.commons.lang3.text.WordUtils;
import java.util.Arrays;
import java.util.Scanner;

public class World {

    public static Island island;
    private Difficulty difficulty;
    private final Season[] seasons;
    private int currentSeason;

    public void initIsland(String islandName, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario, Attic attic, Market market)
    {
        island = new Island(islandName, factions, agriculture, industry, treasury, scenario, attic, market);
    }

    public World(){
        setDifficulty();
        seasons = new Season[4];
        seasons[0] = Season.SPRING;
        seasons[1] = Season.SUMMER;
        seasons[2] = Season.AUTUMN;
        seasons[3] = Season.WINTER;
        currentSeason = 0;
    }

    public Island getIsland() {
        return island;
    }

    private void setDifficulty(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nChoisissez la difficulté :\n");
        for (int i = 0; i < Difficulty.values().length; i++) {
            System.out.println(i + ": " + Arrays.stream(Difficulty.values()).toArray()[i]);
        }
        System.out.println();
        int choice = Integer.parseInt(sc.nextLine());
        difficulty = Difficulty.valueOf(Arrays.stream(Difficulty.values()).toArray()[choice].toString());
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public static void displayGameStart(){
        System.out.println("Bienvenue sur El Presidente !");
        System.out.println("\n----------------------------------\n");
    }

    public void initGame(){
        String story = this.getIsland().getScenario().getStory();
        String name = this.getIsland().getScenario().getName();
        System.out.println("\nHistoire : " + name + "\n" + WordUtils.wrap(story, 100));
    }

    public static String chooseName(){
        System.out.println("\nVeuillez choisir un nom pour votre Monde :\n");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public void endSeason(){
        currentSeason++;
        if (currentSeason == 4)
            currentSeason = 0;
    }

    private void playSeason(){
        System.out.println();
        String seasonIntro;

        if (currentSeason == 0)
            seasonIntro = "Début du ";
        else seasonIntro = "Début de l'";

        seasonIntro += seasons[currentSeason];
        System.out.println(seasonIntro);
        System.out.println();

        island.getScenario().launchEvent();

        endSeason();
    }

    public void playYear(){
        for (int i = 0; i < 4; i++) {
            playSeason();
        }

        if (island.endYear()){
            System.out.println("Vous avez perdu !");
        } else {
            playYear();
        }
    }
}
