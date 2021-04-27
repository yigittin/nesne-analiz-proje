package g191210385;

import java.sql.SQLException;

public class KritikSogutma implements IObserver{

	@Override
	public int kritikDurum(int kritikSicaklik,String roomId, IEyleyici eyleyici) throws InterruptedException, SQLException {
		
		Thread.sleep(500);
        return eyleyici.sogutucuAc(kritikSicaklik, roomId);
	}

}
