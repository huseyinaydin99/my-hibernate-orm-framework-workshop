package tr.com.huseyinaydin.magaza;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;

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

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.eq("urunFiyati", 22.0));
        //  =   EQ	Equal         Eşittir

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.ne("urunFiyati", 22.0));
        // <>   NE	Not Equal     Eşit değil

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.lt("urunFiyati", 22.0));
        // <    LT	Lower Than    Küçük eşit

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.gt("urunFiyati", 22.0));
        // >    GT	Greater Than  Büyüktür

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.le("urunFiyati", 22.0));
        // <=  LE	Lower Equal   Küçük eşit

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.ge("urunFiyati", 22.0));
        // >=  GE	Greater Equal Büyük eşit

        //Criteria criteria = session.createCriteria(Urun.class)
        //.add(Restrictions.like("urunAdi", "K%"));
        //İlk harfi K olan ürün isimleri

        @SuppressWarnings("unchecked")
        List<Urun> urunlerListesi = session.createCriteria(Urun.class)
                .add(Restrictions.like("urunAdi", "K%"))
                .add(Restrictions.between("urunFiyati", 14.0, 35.0))
                .list();

        //List<Urun> urunlerListesi = criteria.list();

        for (Urun urun : urunlerListesi) {
            System.out.println(urun.getUrunId()
                    + " " + urun.getUrunAdi()
                    + " ---> " + urun.getUrunFiyati());
        }
    }
}