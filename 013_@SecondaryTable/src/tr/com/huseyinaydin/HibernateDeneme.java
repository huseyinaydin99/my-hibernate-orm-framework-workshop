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

public class HibernateDeneme {

	public static void main(String[] args) {
		
		Personel personel = new Personel();
		//personel.setPersonelId(1);
		personel.setPersonelAdi("Murat");
		personel.setPersonelSoyadi("Yücedağ");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Elazığ");
		personel.setPersonelMaasi("99999999999999999999999999");
		personel.setPersonelTelefonu("0333 333 33 33");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
		
		personel = null;
	
		session.beginTransaction();
		
		personel = (Personel) session.get(Personel.class, 1);
		System.out.println("ID : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TARİHİ  : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRESİ  : " + personel.getPersonelAdresi());
		System.out.println("MAAŞI  : " + personel.getPersonelMaasi());
		System.out.println("TELEFONU  : " + personel.getPersonelTelefonu());
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}