package g191210385;

import java.sql.SQLException;


public interface IEyleyici {    
	
	IObserver kritikSogutma = new KritikSogutma();
	
    int sogutucuAc(int sicaklik,String roomId) throws InterruptedException,SQLException;

    void sogutucuKapat() throws InterruptedException;
	
	
}
