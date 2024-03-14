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

public class HibernateDeneme {

    public static void main(String[] args) {

        Personel personel = new Personel();
        //personel.setPersonelId(1);
        personel.setPersonelAdi("Furkan");
        personel.setPersonelSoyadi("Uğur");
        personel.setPersonelKayitTarihi(new Date());
        personel.setPersonelAdresi("localhost:8888");

        Personel personel2 = new Personel();
        //personel.setPersonelId(2);
        personel2.setPersonelAdi("Buğra");
        personel2.setPersonelSoyadi("Yılmaz");
        personel2.setPersonelKayitTarihi(new Date());
        personel2.setPersonelAdresi("Kurdunus");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(personel);
        session.save(personel2);
        session.getTransaction().commit();

        personel = null;

        session.beginTransaction();

        personel = (Personel) session.get(Personel.class, 1);
        System.out.println("ID : " + personel.getPersonelId());
        System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
        System.out.println("KAYIT TARİHİ  : " + personel.getPersonelKayitTarihi());
        System.out.println("ADRESİ  : " + personel.getPersonelAdresi());

        System.out.println("------------------------------------- ");

        personel = (Personel) session.get(Personel.class, 2);
        System.out.println("ID : " + personel.getPersonelId());
        System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
        System.out.println("KAYIT TARİHİ  : " + personel.getPersonelKayitTarihi());
        System.out.println("ADRESİ  : " + personel.getPersonelAdresi());

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}