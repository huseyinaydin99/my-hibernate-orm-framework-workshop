package tr.com.huseyinaydin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class JpaDeneme {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;

        Ogrenci ogrenci = new Ogrenci();
        //ogrenci.setId(1);
        ogrenci.setNo("9999");
        ogrenci.setAdi("Hüseyin");
        ogrenci.setSoyadi("Aydın");
        ogrenci.setFakulte("MYO");
        ogrenci.setBolum("Bilgisayar Programcılığı");

        Ogrenci ogrenci2 = new Ogrenci("9998", "Yasin", "Aydın", "Lise", "Hayat Bölümü");

        Ogrenci ogrenci3 = new Ogrenci("9997", "Rümeysa", "Aydın", "MYO", "Sosyal Güvenlik");

        emf = Persistence.createEntityManagerFactory("PU_AyarDosyasi"); //persistence-unit adi
        em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(ogrenci);

            kayitEkle(em, "9996", "Velihan", "Karakuş", "Mimarlık", "Yok");

            em.persist(ogrenci2);
            em.persist(ogrenci3);

            kayitEkle(em, "9995", "Mehmet Ali", "Erbil", "Eğlence", "Çarkıfelek");

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            if (em != null) {
                kayitlariYazHepsi(em);
                kayitlariYazSecilen(em, 2);
                em.close();
                emf.close();
            }
        }
    }

    private static void kayitEkle(EntityManager em, String no,
                                  String adi, String soyadi, String fakulte, String bolum) {
        Ogrenci ogrenciNesnesi = new Ogrenci(no, adi, soyadi, fakulte, bolum);
        em.persist(ogrenciNesnesi);
    }

    private static void kayitlariYazHepsi(EntityManager em) {
        Query query = em.createNamedQuery("tumOgrenciKayitlariniGetir");
        List<?> list = query.getResultList();

        for (Object obj : list) {
            Ogrenci ogrenci = (Ogrenci) obj;

            System.out.println("\nID : " + ogrenci.getId() +
                    "\nADI SOYADI: " + ogrenci.getAdi() + " " + ogrenci.getSoyadi() +
                    "\nFAK�LTE : " + ogrenci.getFakulte() +
                    "\nB�L�M� : " + ogrenci.getBolum()
            );
        }
    }

    private static void kayitlariYazSecilen(EntityManager em, int gelenDeger) {
        Query query = em.createNamedQuery("secilenOgrenciKaydiniGetir").setParameter("p_id", gelenDeger);
        List<?> list = query.getResultList();

        for (Object obj : list) {
            Ogrenci ogrenci = (Ogrenci) obj;

            System.out.println("\nID : " + ogrenci.getId() +
                    "\nADI SOYADI: " + ogrenci.getAdi() + " " + ogrenci.getSoyadi() +
                    "\nFAK�LTE : " + ogrenci.getFakulte() +
                    "\nB�L�M� : " + ogrenci.getBolum()
            );
        }
    }
}
