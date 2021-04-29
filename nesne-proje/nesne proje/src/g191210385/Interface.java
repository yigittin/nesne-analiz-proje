package g191210385;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {
	public static void main(String[] args) throws InterruptedException, SQLException {	
		TextLogger logtext=new TextLogger();
		List<Message> messages=new ArrayList<Message>();
		messages.add(logtext);
		MerkezIslemGiris merkezgiris=new MerkezIslemGiris();		
		MerkezIslemCihaz cihaz=new MerkezIslemCihaz();		
		Logger logger=new Logger(messages);
		
		System.out.println("So�utucu Program�na Ho�geldiniz");
		System.out.println("So�utucuyu Kullanmak i�in l�tfen giri� yap�n�z");
		Scanner scan=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		Scanner scan3=new Scanner(System.in);
		String userId,password;
		String roomId;
		int evethayir;		
		int secim;
		
		do {	
			System.out.println("ID : ");
			userId=scan.nextLine();
			System.out.println("Password : ");
			password=scan.nextLine();				
		}while(!merkezgiris.login(userId,password));
		logger.log(LocalDateTime.now()+" User : "+userId+" Uygulamaya Giri� Yapt�");
		
		do {
			
			System.out.println("Yapmak istedi�iniz i�lemi se�iniz");
			System.out.println("1. S�cakl�klar� Kontrol Et");
			System.out.println("2. So�utucuyu A�");
			System.out.println("3. Uygulamadan ��k��");
			secim=scan.nextInt();
		}while(!(secim>0&&secim<4));
		
		if(secim==1) {
			cihaz.SicaklikGoster();
			System.out.println("So�utucuyu A�mak �stiyor musunuz? : (1/0)");
			evethayir=scan2.nextInt();
			if(evethayir==1) {
				logger.log(LocalDateTime.now()+" User : "+userId+" So�utucuyu A�t�");	
				secim=2;
			}
			else {
				secim=3;
			}
		}
		if(secim==2) {			
			System.out.println("ODA SECIN : ");
			roomId=scan3.nextLine();
			int soguk=cihaz.SicaklikOku(roomId);		
			cihaz.SogutucuAc(roomId, soguk);			
		}	
		if(secim==3) {
			System.out.println("Program Kapat�l�yor");				
		}
		logger.log(LocalDateTime.now()+" User : "+userId+" Uygulamadan ��k�� Yapt�");	
		
	}

}
