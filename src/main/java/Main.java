import World.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
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

        System.out.println("Difficulty chosen : " + world.getDifficulty());

        //Arrays.asList(world.getIsland().getFactions()).forEach(System.out::println);

        //System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(world.getIsland().getScenario()));
    }
}
