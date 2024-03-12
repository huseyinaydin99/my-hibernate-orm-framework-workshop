package tr.com.huseyinaydin;

import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Entity
public class ListenersKullanimi2 {
	@PrePersist void kaydetmeOncesi(Object o) {}
	@PostPersist void kaydetmeSonrasi(Object o) {}
	@PostLoad void yuklemeSonrasi(Object o) {}
	@PreUpdate void guncellemeOncesi(Object o) {}
	@PostUpdate	void guncellemeSonrasi(Object o) {}
	@PreRemove void silmeOncesi(Object o) {}
	@PostRemove void silmeSonrasi(Object o) {}
}