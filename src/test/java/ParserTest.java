import entities.ExchangeRate;
import org.junit.Test;
import utils.ReadWrite;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserTest {

    @Test
    public void jsonParseGetAll() {
        Parser parser = new Parser();
        ReadWrite rw = new ReadWrite();
        String jsonText = rw.loadTxt("testData.txt");

        // parse 5 objects from json
        ExchangeRate[] returnArr = parser.jsonParseGetAll(jsonText);

        int expectedSizeArr = 5;
        assertEquals(expectedSizeArr, returnArr.length);
    }

    @Test
    public void jsonParseGetSpecific() {
        Parser parser = new Parser();
        ReadWrite rw = new ReadWrite();
        String jsonText = rw.loadTxt("testData.txt");

        // parse 2 objects from json
        List<ExchangeRate> rateList = parser.jsonParseGetSpecific(jsonText, "Платина", "CAD");

        int expectedSize = 2;
        assertEquals(expectedSize, rateList.size());

        // check if contain object for canadian dollar
        ExchangeRate caDollar =
                new ExchangeRate("124", "Канадський долар", "21.724158", "CAD", "01.10.2018");
        assertTrue(rateList.contains(caDollar));
    }
}