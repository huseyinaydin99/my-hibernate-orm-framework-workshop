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

        @SuppressWarnings("deprecation")
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT U.urunAdi, SUM(U.urunFiyati) " +
                "FROM Urun U " +
                "GROUP BY U.urunAdi";
        Query query = session.createQuery(hql);

        List<?> list = query.list();
        System.out.println("Kayıt sayısı : " + list.size());
        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object o[] = (Object[]) iterator.next();
            System.out.println("Ürün Adı : " + o[0] + " - Toplam Fiyatı: " + o[1]);
            System.out.println("----------------");
        }
        session.close();
        factory.close();
    }
}