package tr.com.huseyinaydin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        System.out.println("1. statik çalıştı");
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory oluşturulamadı." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    static {
        System.out.println("2. statik çalıştı");
    }

    static {
        System.out.println("3. statik çalıştı");
    }

    public HibernateUtil() {
        System.out.println("Constructor çalıştı");
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}