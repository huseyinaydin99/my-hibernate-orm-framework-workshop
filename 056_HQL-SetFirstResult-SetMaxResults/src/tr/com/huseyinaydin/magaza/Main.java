package tr.com.huseyinaydin.magaza;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "SELECT urunAdi FROM Urun";
            Query query = session.createQuery(hql);
            query.setFirstResult(2); //Bu kayıttan başla
            query.setMaxResults(3); // Bu kadar kayıt getir

            List<String> urunler = (List<String>) query.list();
            transaction.commit();

            for (String u : urunler) {
                System.out.println(u);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}