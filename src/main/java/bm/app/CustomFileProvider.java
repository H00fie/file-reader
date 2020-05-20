package bm.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CustomFileProvider {

    private final String path;

    public CustomFileProvider(String path) {
        this.path = path;
    }

    public void readFile(String fileName) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String parseJSONFileToString(String fileName) {
        BufferedReader bufferedReader;
        StringBuilder result = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            result.append(line);
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null){
                    result.append(line.replaceAll("\\s+", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();

    }

    public void createFileFromCollection(String fileName, List<String> lines) {
        Path path = Paths.get(this.path + fileName);
        try {
            if (Files.notExists(path)) Files.createFile(path);
            Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
