import JsonParser.InitWorld;
import JsonParser.JsonParser;
import World.World;

import java.net.URISyntaxException;

//TODO: implement tests
//TODO: implement save

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        World.displayGameStart();

        //TODO: implement 2 types of gameplay

        JsonParser json = new JsonParser(JsonParser.getFilePath());

        InitWorld initWorld = new InitWorld(json.getJson());

        World world = initWorld.initWorldFromJsonData(World.chooseName());
        world.initGame();

        world.playYear();
    }
}
