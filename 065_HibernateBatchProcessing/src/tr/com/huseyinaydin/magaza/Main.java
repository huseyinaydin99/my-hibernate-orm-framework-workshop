package tr.com.huseyinaydin.magaza;

import org.hibernate.*;
import org.hibernate.cfg.*;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        /*
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for ( int i=0; i<100000; i++ ) {                               
		    Urun urun = new Urun();
		    session.save(urun);
		    
		    if ( i % 25 == 0 ) {   							
		        session.flush(); 
		        session.clear(); 
		    } 
		}
	
		tx.commit();
		session.close();
	    */

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*
          ScrollableResults urunCursor = session.createQuery("FROM URUN")
          .scroll();
        */
        //SUNUCU TARAFINDAKİ KAYITLARI GEZERKEN scroll KULLANIYORUZ

        ScrollableResults urunCursor = session.getNamedQuery("GetUrun")
                .setCacheMode(CacheMode.IGNORE)
                .scroll(ScrollMode.FORWARD_ONLY);

        int sayac = 0; //SAYAÇ

        while (urunCursor.next()) { //BİR SONRAKI KAYIT
            Urun urun = (Urun) urunCursor.get(0);
            session.update(urun); //OTURUM NESNESİ ÜZERİNDEN GÜNCELLE
            if (++sayac % 25 == 0) {  //SAYACI MOD 25'E GÖRE
                session.flush();  //TRANSACTION ARALARINDA
                //ÖNBELLKETEKİ VERİLERİ KALICI HALE GET�R.
                session.clear();
                //ÖNBELLKEKTE ŞİŞME OLMASIN DİYE
                //İŞİ BİTEN NESNELERİ YÖNETMLİ OLMADAN ÇIKAR.
            }
        }
        tx.commit();
        session.close();
    }
}