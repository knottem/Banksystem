import Users.User;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class History {
    File file = new File("resources/history.txt");

    public void writeToFile(String text, User user) {
        try(BufferedWriter print = new BufferedWriter(new FileWriter(file, true))){

            String textForHistoryTextFile = "User: "+ user.getName() + ". Activity: " + text + ". Time: " + LocalTime.now();
            print.write(textForHistoryTextFile);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}