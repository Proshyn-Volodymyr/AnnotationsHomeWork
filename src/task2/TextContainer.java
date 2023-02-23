package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo
public class TextContainer {
    private String text = "Glory to Ukraine";

    @Saver
    public void saveString(String path) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
