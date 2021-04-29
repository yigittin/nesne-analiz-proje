package g191210385;

import java.sql.SQLException;


public class MerkezIslemCihaz implements IMerkezIslemCihaz {
	private final ISicaklikAlgilayici sicaklikAlgilayici;
	private final IEyleyici eyleyici;
	private final IEyleyici eyleyici2;
	private final ISubject publisher;
	
	MerkezIslemCihaz(){
	  this.sicaklikAlgilayici=new SicaklikAlgilayici();
	  this.eyleyici=new Eyleyici();
	  this.eyleyici2=new EyleyiciDIP();
	  this.publisher=new Publisher();
	}
	private int kritikSicaklik=40;
	private int dataSicaklik;
	
	private void kritikSicaklikKontrol(String roomId) throws InterruptedException, SQLException {		
        if (dataSicaklik >= this.kritikSicaklik) {
        	System.out.println("SICAKLIK KRITIK SEVIYEDE!!");
            this.dataSicaklik = this.publisher.kritikSicaklikBildir(this.dataSicaklik,roomId, this.eyleyici);
            this.SogutucuAc(roomId, dataSicaklik);
            this.eyleyici.sogutucuKapat();
            this.SicaklikGoster();
        }
    }
	
	public int SogutucuAc(String roomId,int sicaklik) throws InterruptedException, SQLException {
		eyleyici.sogutucuAc(sicaklik, roomId);
		return SicaklikOku(roomId);
	}
	
	 public void SogutucuKapat() throws InterruptedException {
	}

	
	public int SicaklikOku(String roomId) throws InterruptedException, SQLException {
		dataSicaklik=sicaklikAlgilayici.sicaklikOku(roomId);
		System.out.println("ODA NO : "+roomId+" SICAKLIK : "+dataSicaklik);
		this.kritikSicaklikKontrol(roomId);
		return dataSicaklik;
	}

	@Override
	public void SicaklikGoster() throws SQLException, InterruptedException {
		int roomIds=sicaklikAlgilayici.odalariGor();
		for(int i=0;i<roomIds;i++) {
			String id=String.valueOf(i);
			this.SicaklikOku(id);
		}
		
	}

	
	

	

	
}
