import entities.ExchangeRate;
import utils.GetData;
import utils.ReadWrite;

import java.util.List;

/**
 * @author Dmytro_Galomko
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
    }

    public App() {
        GetData getData = new GetData();
        Parser parser = new Parser();
        // get currency for "GBR", "USD", "EUR"
        List<ExchangeRate> er = parser.jsonParseGetSpecific(getData.downloadFile(), "GBP", "USD", "EUR");

        ReadWrite rw = new ReadWrite();
        rw.saveTxt("exchange.txt", er.toString());
        System.out.println(rw.loadTxt("exchange.txt"));
    }
}
