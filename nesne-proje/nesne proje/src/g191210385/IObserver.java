package g191210385;

import java.sql.SQLException;

public interface IObserver {
	 int kritikDurum(int kritikSicaklik,String roomId, IEyleyici eyleyici) throws InterruptedException, SQLException;
}
