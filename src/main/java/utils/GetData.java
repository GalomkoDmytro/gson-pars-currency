package utils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *Provide getting json data from url
 */
public class GetData {

    private static final String NBU_JSON_URL
            = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public GetData() {
    }

    /**
     * Read content from URL into string
     * @return
     */
    public String downloadFile() {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new URL(NBU_JSON_URL).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * Read content from specific URL into string
     * @param url Uniform Resource Locator
     * @return
     */
    public String downloadFile(String url) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new URL(url).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }
}
