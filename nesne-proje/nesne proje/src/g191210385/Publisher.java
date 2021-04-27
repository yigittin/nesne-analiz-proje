package g191210385;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject {

	    private final List<IObserver> subscribers = new ArrayList<>();
	    
	    @Override
	    public void attach(IObserver subscriber) {
	        subscribers.add(subscriber);
	    }
	    
	    @Override
	    public void detach(IObserver subscriber) {
	        subscribers.remove(subscriber);
	    }
	    
	    @Override
	    public int kritikSicaklikBildir(int kritikSicaklik,String roomId, IEyleyici eyleyici) throws InterruptedException, SQLException {
	        
	        for (IObserver subscriber : subscribers) {
	            kritikSicaklik = subscriber.kritikDurum(kritikSicaklik, roomId, eyleyici);
	        }
	        return kritikSicaklik;
	    }
	}


