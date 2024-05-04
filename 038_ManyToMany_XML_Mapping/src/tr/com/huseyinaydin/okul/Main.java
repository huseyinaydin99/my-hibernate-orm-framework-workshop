package tr.com.huseyinaydin.okul;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.huseyinaydin.util.HibernateUtil;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Ders> dersler = new HashSet<Ders>();
			dersler.add(new Ders("JSF - JavaServer Faces"));
			dersler.add(new Ders("JPA - Java Persistence API"));
			dersler.add(new Ders("Hibernate"));
		
			Ogrenci ogrenci1 = new Ogrenci("Hüseyin AYDIN", dersler);
			Ogrenci ogrenci2 = new Ogrenci("Buğra DOST", dersler);
			session.save(ogrenci1);
			session.save(ogrenci2);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}