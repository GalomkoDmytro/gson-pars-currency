package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetDataTest {

    /**
     * check if return String class
     */
    @Test
    public void downloadFile() {
        GetData getData = new GetData();
        assertEquals(String.class, getData.downloadFile().getClass());
    }

    /**
     * check if return String class
     */
    @Test
    public void downloadFileSpecific() {
        GetData getData = new GetData();
        String NBU_JSON_URL
                = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        assertEquals(String.class, getData.downloadFile(NBU_JSON_URL).getClass());
    }
}