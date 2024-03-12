package tr.com.huseyinaydin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Java Server Faces.
 * @since 1994
 */

public class JpaDeneme {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;

        Personel personel = new Personel();
        //personel.setPersonelId(1);
        personel.setPersonelAdi("Hüseyin");
        personel.setPersonelSoyadi("Aydın");
        emf = Persistence.createEntityManagerFactory("002_SelamJPA"); //persistence-unit adi
        em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(personel);
        et.commit();
        System.out.println("\nID : " + personel.getPersonelId() +
                "\nADI : " + personel.getPersonelAdi() +
                "\nSOYADI : " + personel.getPersonelSoyadi()
        );
        em.close();
        emf.close();
    }
}