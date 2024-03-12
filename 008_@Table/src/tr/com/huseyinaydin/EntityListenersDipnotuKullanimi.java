package tr.com.huseyinaydin;

import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Entity
@ExcludeSuperclassListeners
public class EntityListenersDipnotuKullanimi extends ListenersKullanimi {

}

/*
try {
    em.getTransaction().begin();
    // Varlık nesnelerinin işlem kodları bu arada olur.
    em.getTransaction().commit();
}
finally {
    if (em.getTransaction().isActive()) //Eğer transaction aktifse
        em.getTransaction().rollback(); //tüm işlemleri başa geri sar.
}
*/