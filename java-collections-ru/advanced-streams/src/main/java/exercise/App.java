package exercise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.Arrays;

public class App {

    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(x -> x.trim().startsWith("environment"))
                .filter(x -> x.contains("X_FORWARDED_"))
                .flatMap(x -> {
                    String[] parts = x.split("\"");
                    return Arrays.stream(parts)
                            .filter(part -> part.contains("X_FORWARDED_"))
                            .flatMap(part -> {
                                String[] paths = part.split(",");
                                return Arrays.stream(paths)
                                        .filter(path -> path.startsWith("X_FORWARDED_"))
                                        .map(path -> path.replaceFirst("X_FORWARDED_", ""));

                            });
                })
                .collect(Collectors.joining(","));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "main", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    public static void main(String[] args) throws Exception {
        String data2 = readFixture("s2.conf");
       // getForwardedVariables(data2);
        System.out.println(getForwardedVariables(data2));
    }
}
