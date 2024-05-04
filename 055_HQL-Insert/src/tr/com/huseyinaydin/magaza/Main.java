package tr.com.huseyinaydin.magaza;

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

        @SuppressWarnings("deprecation")
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            String hql = "INSERT INTO Siparis(siparisUrunId, " +
                    "siparisUrunAdi, siparisUrunFiyati) " +
                    "SELECT U.urunId, U.urunAdi, U.urunFiyati " +
                    "FROM Urun U " +
                    "WHERE U.urunId = :urun_id";

            Query query = session.createQuery(hql);
            query.setParameter("urun_id", 3);

            int result = query.executeUpdate();
            transaction.commit();
            System.out.println("Eklenen kayıt sayısı : " + result);
            session.flush();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}