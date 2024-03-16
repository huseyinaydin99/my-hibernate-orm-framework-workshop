package tr.com.huseyinaydin;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class HibernateMerkez {

    public static void main(String[] args) {

        Personel personel = new Personel();
        personel.setPersonelAdi("Hüseyin");
        personel.setPersonelSoyadi("Aydın");
        personel.setPersonelKayitTarihi(new Date());

        Meslek meslek = new Meslek();
        meslek.setMeslekAdi("Programcı");

        Meslek meslek2 = new Meslek();
        meslek2.setMeslekAdi("Ekonomist");

        personel.getMeslek().add(meslek);
        personel.getMeslek().add(meslek2);

        meslek.setPersonel(personel);
        meslek2.setPersonel(personel);

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