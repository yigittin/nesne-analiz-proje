package g191210385;

import java.sql.SQLException;

public interface IMerkezIslemCihaz {
	 int SicaklikOku(String roomId) throws InterruptedException, SQLException;

	 int SogutucuAc(String roomId,int sicaklik) throws InterruptedException, SQLException;

	 void SogutucuKapat() throws InterruptedException;
	 
	 void SicaklikGoster() throws SQLException, InterruptedException;
}
