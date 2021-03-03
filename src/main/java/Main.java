import World.*;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        World.displayGameStart();

        jsonParser json = new jsonParser(jsonParser.getFilePath());

        World world = json.initWorldFromJsonData(World.chooseName());

        world.initGame();

        world.playYear();
    }
}
