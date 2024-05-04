package tr.com.huseyinaydin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tr.com.huseyinaydin.map.Ogrenci;
import tr.com.huseyinaydin.map.OgrenciBilgisi;
import tr.com.huseyinaydin.util.HibernateUtil;

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
          /*  
 	        Ogrenci ogrenci = new Ogrenci();
 	        ogrenci.setOgrenciAdi("Hüseyin");
 	        ogrenci.setOgrenciSoyadi("Aydın");
 	      */
            Ogrenci ogrenci = new Ogrenci("Hüseyin", "Aydın");

            OgrenciBilgisi ogrenciBilgisi = new OgrenciBilgisi();
            ogrenciBilgisi.setAdres("Niğde");
            ogrenciBilgisi.setKayitNo(("99999999"));
            ogrenciBilgisi.setTelefonNo("978364870");
            ogrenciBilgisi.setEmail("huseyinaydin99@facebook.com");
            ogrenciBilgisi.setKayitTarihi((new Date()));

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date date = format.parse("1994-01-01");
                ogrenciBilgisi.setDogumTarihi(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ogrenciBilgisi.setOgrenci(ogrenci);
            ogrenci.setOgrenciBilgisi(ogrenciBilgisi);

            session.save(ogrenci);

            //session.getTransaction().commit();
            transaction.commit();

            System.out.println("Başarıyla kaydedildi.");

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}