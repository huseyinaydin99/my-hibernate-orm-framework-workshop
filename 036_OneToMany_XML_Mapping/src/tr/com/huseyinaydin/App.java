package tr.com.huseyinaydin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Departman departman = new Departman();
            departman.setDepartmanAdi("Yazılım");
            session.save(departman);

            Calisan calisan1 = new Calisan("Hüseyin", "Aydın", "2048");
            Calisan calisan2 = new Calisan("Joe", "Baydın", "973154876");
            Calisan calisan3 = new Calisan("Serhat", "Beyazgül",
                    new Date(), "7412589");
            Calisan calisan4 = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse("1994-11-09");
                calisan4 = new Calisan("Salih", "Ercan", date, "764315480");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            calisan1.setDepartman(departman);
            calisan2.setDepartman(departman);
            calisan3.setDepartman(departman);

            session.save(calisan1);
            session.save(calisan2);
            session.save(calisan3);

            Departman departman2 = new Departman();
            departman2.setDepartmanAdi("Elektrik");
            session.save(departman2);

            calisan4.setDepartman(departman2);
            calisan3.setDepartman(departman2);

            session.save(calisan4);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}