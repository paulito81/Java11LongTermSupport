//#!/usr/bin/java --source 11
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {

    public ListFiles(String[] args) throws Exception {
        Files.walk(Paths.get(args[0])).forEach(System.out::println);
    }
}
