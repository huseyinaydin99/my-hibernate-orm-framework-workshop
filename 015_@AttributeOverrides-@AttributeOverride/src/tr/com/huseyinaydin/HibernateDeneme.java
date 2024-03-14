package tr.com.huseyinaydin;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class HibernateDeneme {

    public static void main(String[] args) {

        Personel personel = new Personel();
        personel.setPersonelAdi("Evren");
        personel.setPersonelSoyadi("Kırkıl");
        personel.setPersonelKayitTarihi(new Date());

        Adres evAdres1 = new Adres();
        evAdres1.setSehir("Ankara");
        evAdres1.setSemt("Kızılay");
        evAdres1.setCadde("cadde14");
        evAdres1.setKapiNo("kapiNo153");
        evAdres1.setPostaKodu("postaKodu632");

        personel.setEvAdres(evAdres1);

        Adres isAdres1 = new Adres();
        isAdres1.setSehir("Ankara");
        isAdres1.setSemt("Keçiören");
        isAdres1.setCadde("cadde571");
        isAdres1.setKapiNo("kapiNo1071");
        isAdres1.setPostaKodu("postaKodu1517");

        personel.setIsAdres(isAdres1);

        Personel personel2 = new Personel();
        personel2.setPersonelAdi("Ayşe");
        personel2.setPersonelSoyadi("Bayrak");
        personel2.setPersonelKayitTarihi(new Date());

        Adres evAdres2 = new Adres();
        evAdres2.setSehir("Kahramanmaraş");
        evAdres2.setSemt("semt1");
        evAdres2.setCadde("cadde12");
        evAdres2.setKapiNo("kapiNo99");
        evAdres2.setPostaKodu("postaKodu628");

        personel2.setEvAdres(evAdres2);

        Adres isAdres2 = new Adres();
        isAdres2.setSehir("İstanbul");
        isAdres2.setSemt("Kartal");
        isAdres2.setCadde("cadde1040");
        isAdres2.setKapiNo("kapiNo1326");
        isAdres2.setPostaKodu("postaKodu1516");

        personel2.setIsAdres(isAdres2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(personel);
        session.save(personel2);
        session.getTransaction().commit();

        personel = null;

        session.beginTransaction();

        personel = (Personel) session.get(Personel.class, 1);
        System.out.println("ID : " + personel.getPersonelId());
        System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
        System.out.println("KAYIT TARİHİ  : " + personel.getPersonelKayitTarihi());

        System.out.println("EV ŞEHİR : " + personel.getEvAdres().getSehir());
        System.out.println("EV SEMT : " + personel.getEvAdres().getSemt());
        System.out.println("EV CADDE : " + personel.getEvAdres().getCadde());
        System.out.println("EV KAPI NO : " + personel.getEvAdres().getKapiNo());
        System.out.println("EV POSTA KODU : " + personel.getEvAdres().getPostaKodu());

        System.out.println("EV ŞEHİR : " + personel.getIsAdres().getSehir());
        System.out.println("EV SEMT : " + personel.getIsAdres().getSemt());
        System.out.println("EV CADDE : " + personel.getIsAdres().getCadde());
        System.out.println("EV KAPI NO : " + personel.getIsAdres().getKapiNo());
        System.out.println("EV POSTA KODU : " + personel.getIsAdres().getPostaKodu());

        personel2 = (Personel) session.get(Personel.class, 2);
        System.out.println("ID : " + personel2.getPersonelId());
        System.out.println("ADI SOYADI : " + personel2.getPersonelAdi() + " " + personel2.getPersonelSoyadi());
        System.out.println("KAYIT TARİHİ : " + personel2.getPersonelKayitTarihi());

        System.out.println("EV ŞEHİR : " + personel2.getEvAdres().getSehir());
        System.out.println("EV SEMT : " + personel2.getEvAdres().getSemt());
        System.out.println("EV CADDE : " + personel2.getEvAdres().getCadde());
        System.out.println("EV KAPI NO : " + personel2.getEvAdres().getKapiNo());
        System.out.println("EV POSTA KODU : " + personel2.getEvAdres().getPostaKodu());

        System.out.println("EV ŞEHİR : " + personel2.getIsAdres().getSehir());
        System.out.println("EV SEMT : " + personel2.getIsAdres().getSemt());
        System.out.println("EV CADDE : " + personel2.getIsAdres().getCadde());
        System.out.println("EV KAPI NO : " + personel2.getIsAdres().getKapiNo());
        System.out.println("EV POSTA KODU : " + personel2.getIsAdres().getPostaKodu());

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}