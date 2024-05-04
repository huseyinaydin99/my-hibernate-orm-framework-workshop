package tr.com.huseyinaydin.kurum;

import tr.com.huseyinaydin.util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            Set<Telefon> telefonNolari = new HashSet<Telefon>();
            telefonNolari.add(new Telefon("Ev", "2210203"));
            telefonNolari.add(new Telefon("Cep", "2210526"));
            Personel personel = new Personel("Cumali Cuma", telefonNolari);
            session.save(personel);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}