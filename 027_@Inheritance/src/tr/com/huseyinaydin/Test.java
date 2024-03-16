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

public class Test {

    public static void main(String[] args) {

        Meslek meslek = new Meslek();
        meslek.setMeslekAdi("Serbest");

        Sektor sektor = new Sektor();
        sektor.setMeslekAdi("Bilgisayar Programcısı");
        sektor.setCalismaAlani("Java ve .NET");

        Tecrube tecrube = new Tecrube();
        tecrube.setMeslekAdi("Hardcore");
        tecrube.setDeneyimYili(1500);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(meslek);
        session.save(sektor);
        session.save(tecrube);
        session.getTransaction().commit();
        session.close();
    }
}