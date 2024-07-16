import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkShortener {
    private Map<String, String> urlMap;
    private static final int SHORT_URL_LENGTH = 6;

    public LinkShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        if (urlMap.containsValue(longURL)) {
            return "Error: Duplicate long URL";
        }

        String shortURL = generateShortURL();
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        if (!urlMap.containsKey(shortURL)) {
            return "Error: Invalid short URL";
        }

        return urlMap.get(shortURL);
    }

    private String generateShortURL() {
        String shortURL = "";
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortURL += (char) ('a' + (int) (Math.random() * 26));
        }
        return shortURL;
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command (shorten/expand/quit): ");
            String command = scanner.nextLine();

            if (command.equals("shorten")) {
                System.out.println("Enter a long URL: ");
                String longURL = scanner.nextLine();
                String shortURL = linkShortener.shortenURL(longURL);
                System.out.println("Short URL: " + shortURL);
            } else if (command.equals("expand")) {
                System.out.println("Enter a short URL: ");
                String shortURL = scanner.nextLine();
                String expandedURL = linkShortener.expandURL(shortURL);
                System.out.println("Expanded URL: " + expandedURL);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command. Try again!");
            }
        }
        scanner.close();
    }
}
