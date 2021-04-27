package g191210385;

import java.sql.SQLException;


public class DataReach {
	    private final IDatabase database;
	   
	    DataReach(){
	    	this.database=new Database();
	    }
	public int PullData(String roomId) throws SQLException {
		//database.girisYap(userId, password);
		return database.odaBul(roomId);
	}
	
	public int PushData(String roomId,String sicaklik) throws SQLException {
		return database.sicaklikGonder(roomId,sicaklik);
	}
	
	public int showData() throws SQLException, InterruptedException {
		return database.odaSay();
	}
	
}
