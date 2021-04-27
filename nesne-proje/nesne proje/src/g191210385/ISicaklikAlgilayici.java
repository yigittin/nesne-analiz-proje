package g191210385;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface ISicaklikAlgilayici {	 
	 public int odalariGor() throws SQLException, InterruptedException;
		
	 int sicaklikOku(String odaId) throws InterruptedException;
}
