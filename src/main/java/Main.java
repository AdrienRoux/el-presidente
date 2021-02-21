import World.World;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        jsonParser json = new jsonParser(jsonParser.getFilePath());

        World world = json.initWorldFromJsonData("Monde");

        Arrays.asList(world.getIsland().getFactions()).forEach(System.out::println);

        System.out.println(world.getIsland().getScenario().toString());
    }
}
