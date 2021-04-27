package g191210385;

import java.sql.SQLException;

public interface IDatabase {
    boolean girisYap(String id, String password);   
    int odaBul(String odaId) throws SQLException;
    public int sicaklikGonder(String odaId,String sicaklik) throws SQLException;
	int odaSay() throws SQLException, InterruptedException;
}
