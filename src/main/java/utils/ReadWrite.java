package utils;

import java.io.*;

public class ReadWrite {

    public ReadWrite() {
    }

    /**
     * Save String data to file
     * @param fileName , might contain file location
     * @param text data to save
     */
    public void saveTxt(String fileName, String text) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(text);
            bw.write("\n");
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Get text from file
     * @param fileName , might contain file location
     * @return String with content
     */
    public String loadTxt(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(fileName);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                stringBuilder.append(st);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stringBuilder.toString();
    }
}