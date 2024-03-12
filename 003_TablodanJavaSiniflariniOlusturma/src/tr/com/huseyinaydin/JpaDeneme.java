package tr.com.huseyinaydin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class JpaDeneme {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;

        Ogrenci ogrenci = new Ogrenci();
        //ogrenci.setId(1);
        ogrenci.setAdi("Hüseyin");
        ogrenci.setSoyadi("Aydın");
        ogrenci.setBolum("Computer Programming");
        ogrenci.setFakulte("MYO");
        ogrenci.setNo("9999");

        emf = Persistence.createEntityManagerFactory("PU_SettingFile"); //persistence-unit adi
        em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ogrenci);
        et.commit();

        System.out.println("\nID : " + ogrenci.getId() +
                "\nADI : " + ogrenci.getAdi() +
                "\nSOYADI : " + ogrenci.getSoyadi()
        );
        em.close();
        emf.close();
    }
}