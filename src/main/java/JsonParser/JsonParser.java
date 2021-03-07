package JsonParser;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

//TODO: refactor the whole class into sub-ones

public class JsonParser {

    private JSONObject json;

    public JsonParser(String fileName) {
        this.json = new JSONObject(getContentStringFromResource(fileName));
    }

    public static String getContentStringFromResource(String fileName) {
        return new BufferedReader(
                new InputStreamReader(JsonParser.class.getResourceAsStream(fileName), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public static String getFilePath() throws URISyntaxException {
        File[] listOfFiles = new File(JsonParser.class.getClassLoader().getResource("Json").toURI()).listFiles();
        String filePath = null;
        if (listOfFiles != null) {
            System.out.println("Sélectionnez un scénario :\n");
            for (int i = 0; i < listOfFiles.length; i++) {
                String file = i + ":  " + listOfFiles[i].getName();
                System.out.println(file.substring(0, file.length() - 5));
            }
            System.out.println();
            Scanner sc = new Scanner(System.in);  // Create a Scanner object
            int choice = Integer.parseInt(sc.nextLine());
            filePath = listOfFiles[choice].getName();
        }
        return "/Json/" + filePath;
    }

    public void displayJson() {
        JSONArray key = json.names();
        System.out.println(key);
        JSONArray keyb = json.getJSONArray("events");
        System.out.println(keyb.length());
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
