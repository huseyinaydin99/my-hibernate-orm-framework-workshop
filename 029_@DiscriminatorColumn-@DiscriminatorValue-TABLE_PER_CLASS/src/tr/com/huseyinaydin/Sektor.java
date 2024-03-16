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
@DiscriminatorValue(value = "SEKTOR")
public class Sektor extends Meslek {

    private String calismaAlani;
    public String getCalismaAlani() {
        return calismaAlani;
    }
    public void setCalismaAlani(String calismaAlani) {
        this.calismaAlani = calismaAlani;
    }
}