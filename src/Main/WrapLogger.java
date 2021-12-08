package Main;

import java.io.File;
import java.io.IOException;

public class WrapLogger {
    static String logsDirectory = "/logs/";
    String pathToFile = null;
    Boolean rw = false;

    private WrapLogger() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public WrapLogger(String pathToFile) {
        this();
        this.pathToFile = pathToFile;
    }

    public WrapLogger(String pathToFile, Boolean rw) {
        this(pathToFile);
        this.rw = rw;
    }
}
