package tr.com.huseyinaydin;

import java.util.List;
import java.util.Iterator;

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
		Main obj = new Main();
		Long personelId1 = obj.personelKaydet("Hasan Hüseyin Çıldıroğlu");
		Long personelId2 = obj.personelKaydet("Hasan Yasin Kaplan");
		Long personelId3 = obj.personelKaydet("Şakir İki");
		Long personelId4 = obj.personelKaydet("Yusuf Üçyüz");
		Long personelId5 = obj.personelKaydet("Salih Binbeşyüziki");
		Long personelId6 = obj.personelKaydet("Murat Gün");
		obj.personelListe();
		
		obj.personelGuncelle(personelId3, "Samet Ünlü");
		obj.personelSil(personelId2);
		obj.personelSil(personelId6);
		obj.personelGuncelle(personelId5, "Mehmet Yaman");
		obj.personelSil(personelId4);
		obj.personelListe();
		
		obj.personelGuncelle(personelId1, "Hacı Cumali");
		obj.personelListe();
	}

	public Long personelKaydet(String personelAdi) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long personelId = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = new Personel();
			personel.setPersonelAdi(personelAdi);
			personelId = (Long) session.save(personel);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personelId;
	}

	public void personelListe() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Personel> personels = session.createQuery("FROM PERSONEL").list();
			for (Iterator<?> iterator = personels.iterator(); iterator.hasNext();) {
				Personel personel = (Personel) iterator.next();
				System.out.println(personel.getPersonelAdi());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void personelGuncelle(Long personelId, String personelAdi) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = (Personel) session.get(Personel.class, personelId);
			personel.setPersonelAdi(personelAdi);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void personelSil(Long personelId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Personel personel = (Personel) session.get(Personel.class, personelId);
			session.delete(personel);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}