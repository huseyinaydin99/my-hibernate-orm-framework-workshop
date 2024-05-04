package tr.com.huseyinaydin.okul;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.huseyinaydin.util.HibernateUtil;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Adres adres = new Adres("Niğde Bor(Mecburiyet) Caddesi", "Niğde", "Merkez", "51200");
            // cascade=all kullanılmamasına rağmen adres kaydedilir
            // session.save(adres);

            Ogrenci ogrenci1 = new Ogrenci("Şakir İki", adres);
            Ogrenci ogrenci2 = new Ogrenci("Recep İvedik", adres);
            Ogrenci ogrenci3 = new Ogrenci("Tanet ÜçT", adres);

            session.save(ogrenci1);
            session.save(ogrenci2);
            session.save(ogrenci3);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}