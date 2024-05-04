package tr.com.huseyinaydin.magaza;

import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.*;

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

        //Query query = session.createQuery("select U.urunId, U.urunAdi from Urun U");
        Query query = session.createQuery("SELECT u.urunId, u.urunAdi from Urun u");

        List<?> list = query.list();
        System.out.println("Kayıt sayısı : " + list.size());
        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object o[] = (Object[]) iterator.next();
            System.out.println("Ürün id : " + o[0] + " - Ürün Adı : " + o[1]);
            System.out.println("----------------");
        }
        session.close();
        factory.close();
    }
}