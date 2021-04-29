package g191210385;

import java.io.IOException;
import java.util.List;

public class Logger {
	 private List<Message> messages;

	    public Logger(List<Message> messages) {
	        this.messages = messages;
	    }
	    

		public void log(String mesaj) {

	    	messages.forEach(d->{
				try {
					d.sendMessage(mesaj);
				} catch (IOException e) {					
					e.printStackTrace();
				}
			});
	    }
		
}
