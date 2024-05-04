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
        //cfg.configure("hibernate.cfg.xml");
        cfg.configure("hibernate-mysql.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("FROM Urun");

        List<?> urunListesi = query.list();
        System.out.println("Kayıt sayısı : " + urunListesi.size());
        Iterator<?> it = urunListesi.iterator();

        while (it.hasNext()) {
            Object o = (Object) it.next();
            Urun u = (Urun) o;
            System.out.println("Ürün Id : " + u.getUrunId());
            System.out.println("Ürün Adı : " + u.getUrunAdi());
            System.out.println("Ürün Fiyatı : " + u.getUrunFiyati());
            System.out.println("----------------------");
        }
        session.close();
        factory.close();
    }
}