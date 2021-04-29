package g191210385;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class TextLogger implements Message {
	
	private PrintWriter out;
	private static TextLogger instance;
	
	public TextLogger() {
        try {
            out = new PrintWriter(new FileWriter("log.txt", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void sendMessage(String mesaj) throws IOException {
		logText(mesaj);			
	}
	
	public void logText(String mesaj) throws IOException {	
	     out.println(mesaj);	   
	}
	public static synchronized TextLogger getInstance() {
        if (instance == null)
            instance = new TextLogger();
        return instance;
    }
}

