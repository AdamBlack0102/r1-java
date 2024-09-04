import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public String readFile(String filePath) throws IOException {
        FileInputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            inputStream = new FileInputStream(filePath);
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                stringBuilder.append((char) byteRead);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return stringBuilder.toString();
    }
}
