package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class EGFR {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Double egfr;

    private Date testDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getEgfr() {
		return egfr;
	}

	public void setEgfr(Double egfr) {
		this.egfr = egfr;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

}