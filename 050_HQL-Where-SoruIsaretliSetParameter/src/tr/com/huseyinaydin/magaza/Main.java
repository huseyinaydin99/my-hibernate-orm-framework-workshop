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

        //String hql = "FROM Urun M WHERE M.id = 2";
        //String hql = "FROM Urun M WHERE M.id = :parametre";
        String hql = "FROM Urun M WHERE M.id = ?";
        Query query = session.createQuery(hql);

        query.setParameter(0, 1);

        List<?> list = query.list();
        System.out.println("Kayıt sayısı : " + list.size());
        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("---------------");
            Object o = (Object) iterator.next();
            Urun urun = (Urun) o;
            System.out.println("Ürün Adı    : " + urun.getUrunAdi());
            System.out.println("Ürün Fiyatı : " + urun.getUrunFiyati());
            System.out.println("---------------");
        }
        session.close();
        factory.close();
    }
}