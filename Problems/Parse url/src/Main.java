import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] url = scanner.nextLine().split("\\?");
        String[] parameters = url[1].split("&");
        Map<String, String> parsedURL = new LinkedHashMap<>();
        for (String parameter : parameters) {
            String[] values = parameter.split("=");
            if (values.length > 1) {
                parsedURL.put(values[0], values[1]);
            } else {
                parsedURL.put(values[0], "not found");
            }
        }
        if (parsedURL.containsKey("pass")) {
            String password = parsedURL.get("pass");
            parsedURL.put("password", password);
        }
        for (String key : parsedURL.keySet()) {
            System.out.printf("%s : %s\n", key, parsedURL.get(key));
        }
    }
}