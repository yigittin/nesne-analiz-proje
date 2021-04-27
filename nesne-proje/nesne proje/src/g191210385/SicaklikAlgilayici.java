package g191210385;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{	
	DataReach dataHold=new DataReach();
	
	
	@Override
	public int sicaklikOku(String odaId) throws InterruptedException {
				try {
				// TODO Auto-generated method stub
				return dataHold.PullData(odaId);				
			}catch(Exception e){
				   e.printStackTrace();
		            return 0;				
			}
	}
	
	public int odalariGor() throws SQLException, InterruptedException {
		return dataHold.showData();		
	}
}
