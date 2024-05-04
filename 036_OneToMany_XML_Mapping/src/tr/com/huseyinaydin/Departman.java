package tr.com.huseyinaydin;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

public class Departman {

    private Long departmanId;
    private String departmanAdi;

    //private Set<Calisan> calisanlar;
    //private List<Calisan> calisanlar;
    private Calisan[] calisanlar;

    /*
       public Set<Calisan> getCalisanlar() {
           return calisanlar;
       }

       public void setCalisanlar(Set<Calisan> calisanlar) {
           this.calisanlar = calisanlar;
       }
   */
	 /*
		public List<Calisan> getCalisanlar() {
			return calisanlar;
		}

		public void setCalisanlar(List<Calisan> calisanlar) {
			this.calisanlar = calisanlar;
		}
	 */

    public Calisan[] getCalisanlar() {
        return calisanlar;
    }
    public void setCalisanlar(Calisan[] calisanlar) {
        this.calisanlar = calisanlar;
    }
    public Long getDepartmanId() {
        return departmanId;
    }
    public void setDepartmanId(Long departmanId) {
        this.departmanId = departmanId;
    }
    public String getDepartmanAdi() {
        return departmanAdi;
    }
    public void setDepartmanAdi(String departmanAdi) {
        this.departmanAdi = departmanAdi;
    }
}