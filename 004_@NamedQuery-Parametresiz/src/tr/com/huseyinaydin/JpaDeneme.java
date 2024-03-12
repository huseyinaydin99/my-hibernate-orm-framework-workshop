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
        ogrenci.setAdi("Hüseyin");
        ogrenci.setSoyadi("Aydın");
        ogrenci.setBolum("Prof. Dr.");
        ogrenci.setFakulte("MYO");
        ogrenci.setNo("9999");

        emf = Persistence.createEntityManagerFactory("PU_SettingsFile"); //persistence-unit adi
        em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(ogrenci);
        et.commit();

        Query query = em.createNamedQuery("tumOgrenciKayitlariniGetir");
        List<?> list = query.getResultList();

        for (Object obj : list) {
            ogrenci = (Ogrenci) obj;

            System.out.println("\nID : " + ogrenci.getId() +
                    "\nADI SOYADI: " + ogrenci.getAdi() + " " + ogrenci.getSoyadi() +
                    "\nFAK�LTE : " + ogrenci.getFakulte() +
                    "\nB�L�M� : " + ogrenci.getBolum()
            );
        }

        em.close();
        emf.close();
    }
}
