import org.junit.Test;
import utils.ReadWrite;

import java.io.File;

import static org.junit.Assert.*;

public class ReadWriteTest {
    private static final String fileName = "testFile.txt";
    private static final String text = "test text";

    @Test
    public void saveTxt() {
        ReadWrite rw = new ReadWrite();

        rw.saveTxt(fileName, text);
        File f = new File(fileName);

        assertTrue(f.exists() && !f.isDirectory());

        deleteFile(fileName);
    }

    @Test
    public void loadTxt() {
        ReadWrite rw = new ReadWrite();
        rw.saveTxt(fileName, text);

        String resultText = rw.loadTxt(fileName);

        assertEquals(text, resultText);

        deleteFile(fileName);
    }

    private void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}