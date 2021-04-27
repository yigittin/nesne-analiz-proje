package g191210385;

import java.sql.SQLException;

public interface ISubject {
    void attach(IObserver obs);

    void detach(IObserver obs);

    int kritikSicaklikBildir(int kritikSicaklik,String roomId, IEyleyici eyleyici) throws InterruptedException, SQLException;
}
