import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;


public class jsonParser {



    public void displayJson() {
        String json = getContentStringFromResource("Json/attackOnTitans.json");


        JSONObject obj = new JSONObject(json);
        JSONArray key = obj.names();
        System.out.println(key);
        JSONArray keyb = obj.getJSONArray("events");
        System.out.println(keyb.length());

        JSONObject pageName = obj.getJSONObject("gameStartParameters").getJSONObject("NORMAL").getJSONObject("factions");

        //System.out.println(pageName);

    }

    public static String getContentStringFromResource(String fileName) {
        return new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream(fileName), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

}
