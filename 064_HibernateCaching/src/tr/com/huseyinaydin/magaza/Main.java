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

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Urun");
        query.setCacheable(true);

        List users = query.list();
        session.getTransaction().commit();
        session.close();
    }
}