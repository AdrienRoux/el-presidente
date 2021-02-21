package History;

import java.util.ArrayList;

public class Scenario {

    private String name;
    private String story;
    private ArrayList<Events> events;


    public Scenario(String name, String story, ArrayList<Events> events){
        this.name = name;
        this.story = story;
        this.events = events;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", events=" + events +
                '}';
    }
}
