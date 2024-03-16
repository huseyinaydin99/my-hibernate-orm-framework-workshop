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

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        personel.setPersonelAdi("Tarık");
        personel.setPersonelSoyadi("Şen");
        session.save(personel);
        session.getTransaction().commit();
        session.close();

        System.out.println("Ekleme sonrası : " +
                personel.getPersonelAdi() + " " +
                personel.getPersonelSoyadi());

        session = sessionFactory.openSession();
        session.beginTransaction();
        personel.setPersonelAdi("Ayşe");
        personel.setPersonelSoyadi("Bayrak");
        session.update(personel);
        session.getTransaction().commit();
        session.close();

        System.out.println("Günceleme sonrası : " +
                personel.getPersonelAdi() + " " +
                personel.getPersonelSoyadi());
    }
}