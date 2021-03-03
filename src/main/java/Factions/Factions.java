package Factions;

public class Factions {

    private String name;
    private int satisfaction;
    private int population;

    public Factions(String name, int satisfaction, int population) {
        this.name = name;
        this.satisfaction = satisfaction;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Factions{" +
                "name='" + name + '\'' +
                ", satisfaction=" + satisfaction +
                ", population=" + population +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getPopulation() {
        return population;
    }

    public void killPeople()
    {
        this.population --;
    }

    public void decreaseSatisfaction(int percentage)
    {
        this.satisfaction = this.satisfaction - percentage;
    }
}
