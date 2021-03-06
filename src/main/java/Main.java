import World.*;
import java.net.URISyntaxException;

//TODO: implement tests
//TODO: implement save

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        World.displayGameStart();

        //TODO: implement 2 types of gameplay

        jsonParser json = new jsonParser(jsonParser.getFilePath());

        World world = json.initWorldFromJsonData(World.chooseName());

        world.initGame();

        world.playYear();
    }
}
