package tr.com.huseyinaydin;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class HibernateMerkez {

	public static void main(String[] args) {
		
		Personel personel = new Personel();
		personel.setPersonelAdi("Recep Ali");
		personel.setPersonelSoyadi("Tellio�lu");
		personel.setPersonelKayitTarihi(new Date());
		//---------------------------------------------
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Oganizat�r");
	
		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Ekonomist");
		
		//---------------------------------------------
		personel.getMeslek().add(meslek);
		personel.getMeslek().add(meslek2);
		//---------------------------------------------
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			session.save(personel);
			session.save(meslek);
			session.save(meslek2);
		session.getTransaction().commit();
		session.close();


	}

}
