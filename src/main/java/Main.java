import World.*;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        World.displayGameStart();

        jsonParser json = new jsonParser(jsonParser.getFilePath());

        World world = json.initWorldFromJsonData("Monde");

        world.initGame();

        //System.out.println("Difficulty chosen : " + world.getDifficulty());

        //Arrays.asList(world.getIsland().getFactions()).forEach(System.out::println);

        //System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(world.getIsland().getScenario()));
    }
}
