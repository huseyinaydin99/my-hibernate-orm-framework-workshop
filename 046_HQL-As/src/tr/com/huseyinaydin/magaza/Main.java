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
		//Query query = session.createQuery("from Urun u");
		//Query query = session.createQuery("from Urun AS u");

        String hql = "FROM Urun AS U";
        Query query = session.createQuery(hql);

        List<?> list = query.list();
        System.out.println("Kayıt sayısı : " + list.size());
        Iterator<?> it = list.iterator();

        while (it.hasNext()) {
            Object o = (Object) it.next();
            Urun urun = (Urun) o;
            System.out.println("Ürün id : " + urun.getUrunId());
            System.out.println("Ürün Adı : " + urun.getUrunAdi());
            System.out.println("Ürün Fiyatı : " + urun.getUrunFiyati());
            System.out.println("----------------------");
        }
        session.close();
        factory.close();
    }
}