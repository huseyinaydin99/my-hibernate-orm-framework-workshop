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
public class CallbacksKullanimi {
	@PrePersist
	void kaydetmeOncesi() {
		System.out.println("KAYDETME ÖNCESİNDE ÇALIŞTIRILIR");
	}

	@PostPersist
	void kaydetmeSonrasi() {
		System.out.println("KAYDETME SONRASINDA ÇALIŞTIRILIR");
	}

	@PostLoad
	void yuklemeSonrasi() {
		System.out.println("YÜKLEME SONRASINDA ÇALIŞTIRILIR");
	}

	@PreUpdate
	void guncellemeOncesi() {
		System.out.println("GÜNCELLEME ÖNCESİNDE ÇALIŞTIRILIR");
	}

	@PostUpdate
	void guncellemeSonrasi() {
		System.out.println("GÜNCELLEME SONRASINDA ÇALIŞTIRILIR");
	}

	@PreRemove
	void silmeOncesi() {
		System.out.println("SİLME ÖNCESİNDE ÇALIŞTIRILIR");
	}

	@PostRemove
	void silmeSonrasi() {
		System.out.println("SİLME SONRASINDA ÇALIŞTIRILIR");
	}
}















