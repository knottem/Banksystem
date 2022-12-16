package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FAQ {
    Path faq = Paths.get("src/FrequentlyAskedQuestions.txt");
    public void readingFAQ() {

        String line = null;

            try (BufferedReader faqRead = Files.newBufferedReader(faq)) {
                while ((line = faqRead.readLine()) != null)
                    System.out.println(line);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }





}
