package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class ACR {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Double acr;

    private Date testDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAcr() {
		return acr;
	}

	public void setAcr(Double acr) {
		this.acr = acr;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
}