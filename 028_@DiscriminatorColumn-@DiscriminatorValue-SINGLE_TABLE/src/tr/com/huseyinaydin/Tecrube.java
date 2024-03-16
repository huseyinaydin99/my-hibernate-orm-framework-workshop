package tr.com.huseyinaydin;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Entity
@DiscriminatorValue (value = "TECRUBE")
public class Tecrube extends Sektor {
	private int deneyimYili;
	public int getDeneyimYili() {
		return deneyimYili;
	}
	public void setDeneyimYili(int deneyimYili) {
		this.deneyimYili = deneyimYili;
	}
}