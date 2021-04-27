package g191210385;

import java.sql.SQLException;

public class Eyleyici implements IEyleyici{
    private final DataReach pusher;
    
    Eyleyici(){
    	this.pusher=new DataReach();
    }
	@Override
	public int sogutucuAc(int sicaklik,String roomId) throws InterruptedException, SQLException {
		System.out.println("Soðutucu çalýþtýrýlýyor");
		int heat=sicaklik-5;
		String sicaklik2=String.valueOf(heat);		
		Thread.sleep(2000);
		pusher.PushData(roomId,sicaklik2);			
		sogutucuKapat();	
		return heat;
		
	}

	@Override
	public void sogutucuKapat() throws InterruptedException {		
		System.out.println("Soðutucu Kapatýldý");
	}
	
	
		
	
	
}
