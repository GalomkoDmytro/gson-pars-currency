
import com.google.gson.Gson;
import entities.ExchangeRate;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage parsing data from JSON to POJO
 */
public class Parser {

    public Parser() {
    }

    /**
     * Parsing data from JSON to array of entities.ExchangeRate POJO
     * @param jsonFile
     * @return array of entities.ExchangeRate pojo
     */
    public ExchangeRate[] jsonParseGetAll(String jsonFile) {
        Gson gson = new Gson();
        ExchangeRate[] exchangeRates = gson.fromJson(jsonFile, ExchangeRate[].class);
        return exchangeRates;
    }

    /**
     * Parsing data from JSON to List of specific entities.ExchangeRate
     * @param jsonFile
     * @param lookingCurrency one or more looking currency. exmpl: "UA", "RUB", "Румунський лей"
     * @return List of looking CurrencyRate
     */
    public List<ExchangeRate> jsonParseGetSpecific(String jsonFile, String... lookingCurrency) {
        Gson gson = new Gson();
        ExchangeRate[] exchangeRates = gson.fromJson(jsonFile, ExchangeRate[].class);
        List<ExchangeRate> lookingRates = new ArrayList<>();

        for (ExchangeRate er : exchangeRates) {
            for (int i = 0; i < lookingCurrency.length; i++)
                if (er.getTxt().equals(lookingCurrency[i])
                        || er.getCc().equals(lookingCurrency[i])) {
                    lookingRates.add(er);
                }
        }
        return lookingRates;
    }
}
