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

        personel.setMeslek(meslek);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(personel);
        session.save(meslek);
        session.getTransaction().commit();
        session.close();
    }
}