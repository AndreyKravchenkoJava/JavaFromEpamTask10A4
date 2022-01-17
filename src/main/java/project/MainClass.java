package project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath("Poem");
            List<String> poem1 = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder poem = new StringBuilder();
            for (String poems : poem1) {
                poem.append(poems + "\n");
            }

            String[] wordsArray = poem.toString().split("[\\s,.:!?]+");

            System.out.println(poem.toString());
            System.out.println("------------------------");
            System.out.println("");
            for (int i = 0; i < wordsArray.length - 1; i++) {
                if (Character.toLowerCase(wordsArray[i].charAt(wordsArray[i].length()-1)) == Character.toLowerCase(wordsArray[i+1].charAt(0))) {
                    System.out.println(wordsArray[i] + " " + wordsArray[i+1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}