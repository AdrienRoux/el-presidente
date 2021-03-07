package History;

import java.util.ArrayList;

public class Events {

    private String name;
    private ArrayList<EventChoices> choices;

    public Events(String name, ArrayList<EventChoices> choices){
        this.name = name;
        this.choices = choices;
    }

    public String getName(){
        return name;
    }

    public ArrayList<EventChoices> getChoices(){
        return choices;
    }

}
