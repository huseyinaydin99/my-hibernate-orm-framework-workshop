package tr.com.huseyinaydin;

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
        personel.setPersonelId(3);
        personel.setPersonelAdi("Emre");
        personel.setPersonelSoyadi("Sayın");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(personel);
        session.getTransaction().commit();

		session.close();
		sessionFactory.close();
    }
}