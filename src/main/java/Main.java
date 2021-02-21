import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        jsonParser json = new jsonParser();
        json.displayJson();
    }
}
