package History;

import World.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scenario {

    private String name;
    private String story;
    private ArrayList<Events> events;
    private ArrayList<Events> currentEventList;


    public Scenario(String name, String story, ArrayList<Events> events){
        this.name = name;
        this.story = story;
        this.events = events;
        this.currentEventList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", events=" + events +
                '}';
    }

    public String getStory() {
        return story;
    }

    public String getName() {
        return name;
    }

    public void launchEvent(){

        if (currentEventList.isEmpty()){
            currentEventList = events;
            Collections.shuffle(this.currentEventList);
        }

        Events e = currentEventList.get(0);

        System.out.println(e.getName() + "\n");

        for (int i = 0; i < e.getChoices().size(); i++) {

            System.out.println("Choix " + i + ": " + e.getChoices().get(i).getName());

        }

        Scanner sc = new Scanner(System.in);

        e.getChoices().get(sc.nextInt()).launchEffect();

        currentEventList.remove(e);
    }
}
