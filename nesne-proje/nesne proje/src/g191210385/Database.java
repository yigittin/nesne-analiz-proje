package g191210385;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database implements IDatabase{		
	
	
	
	 public Connection connect() {
 
	        Connection conn = null;

	        try {
	            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g191210385_db",
	                    "postgres", "poyraz54");
	            if (conn != null) {}
	                //System.out.println("Veritaban�na Ba�land�!");
	            else
	                System.out.println("Veritaban�na eri�elemiyor!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	
	@Override
	public boolean girisYap(String id, String password) {
		// TODO Auto-generated method stub
	
		try {
			boolean login = false;
		    Connection conn = this.connect(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"users\" WHERE \"id\"='" + id + "' and \"password\"='" + password + "'";

            // Sorgu çalıştırılır
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            conn.close();
            
            if(result.next()) {
            	System.out.println("Giri� Do�ruland�");
            	login=true;
            }else {
            	System.out.println("Kullan�c� Bulunamad�");
            }
            result.close();
            statement.close();
            return login;

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public int odaBul(String odaId) throws SQLException {
			try {
				Connection conn=this.connect();
				int heat = 0;
				String sql="SELECT * FROM \"rooms\" WHERE \"id\"="+odaId;
				
				Statement statement = conn.createStatement();
		        ResultSet result = statement.executeQuery(sql);
		        
		        while(result.next()) {	        	
		          heat=result.getInt(2);
		        }
		        return heat;
		} catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
			
	}
	
	public int sicaklikGonder(String odaId,String sicaklik) throws SQLException{
				int i=Integer.parseInt(sicaklik);
				int z=Integer.parseInt(odaId);
				String SQLupdate = "UPDATE rooms "
				+ "SET degree = ? "
				+ "WHERE id = ?";
				
				int rowsAffected = 0;
	
				try (Connection conn = this.connect();					
				PreparedStatement prepareStatement = conn.prepareStatement(SQLupdate)){
					
				prepareStatement.setInt(1, i);
				prepareStatement.setInt(2, z);
	
	
				rowsAffected = prepareStatement.executeUpdate();
				} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				}
				return rowsAffected;
		}
		
	public int odaSay() throws SQLException, InterruptedException {
		Connection conn= this.connect();
		int odaNo;
		int heat;
		int counter=0;
		String sql="SELECT * FROM rooms";
		Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()) {
        	odaNo=rs.getInt(1);        
        	heat=rs.getInt(2);   
        	counter++;
        }
		return counter;
		
	}
		
}


