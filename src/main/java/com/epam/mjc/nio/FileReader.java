package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class FileReader {

    public static void main(String[] args) {
        new FileReader().getDataFromFile(new File("src/main/resources/Profile.txt"));
    }
    public Profile getDataFromFile(File file) {
        Path path = Paths.get(file.getAbsolutePath());
        Profile profile = new Profile();

        try (BufferedReader bufreader = Files.newBufferedReader(path)) {

            List<String> lines = bufreader.lines().collect(Collectors.toList());

            profile.setName(lines.get(0).split(":\\s")[1]);
            profile.setAge(Integer.parseInt(lines.get(1).split(":\\s")[1]));
            profile.setEmail(lines.get(2).split(":\\s")[1]);
            profile.setPhone(Long.parseLong(lines.get(3).split(":\\s")[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
