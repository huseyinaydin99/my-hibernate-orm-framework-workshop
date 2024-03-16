package tr.com.huseyinaydin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class AnaMerkez {

    public static void main(String[] args) {

        Personel personel = new Personel();
        personel.setPersonelAdi("Hüseyin");
        personel.setPersonelSoyadi("Aydın");

        Meslek meslek = new Meslek();
        meslek.setMeslekAdi("Programcı");

        Meslek meslek2 = new Meslek();
        meslek2.setMeslekAdi("Yiyici");

        personel.getMeslekListe().add(meslek);
        personel.getMeslekListe().add(meslek2);

        meslek.getPersonelListe().add(personel);
        meslek2.getPersonelListe().add(personel);

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