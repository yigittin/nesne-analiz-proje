package g191210385;

public class MerkezIslemGiris implements IMerkezIslemGiris{
 
	private final IDatabase database;
	
	public MerkezIslemGiris() {
		this.database=new Database();
	}
	
	@Override
	public boolean login(String userId, String password) throws InterruptedException{
		if(this.database.girisYap(userId, password)) {
			return true;
		}else {
			return false;
		}
	}
		
	
}
