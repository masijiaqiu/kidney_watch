package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String pid;
    private String firstName;
    private String lastName;
    private String gender; // M; F
    private String dob;
    private String category; // MKCK, PD, HD, AHD

    private Double egfr;
    private String testDate;
    private Double changeRate;

    // Yes or No
    private String cancer;
    private String cancerNotes;
    private String smoking;
    private String smokingNotes;
    private String htn;
    private String htnNotes;
    private String diabetes;
    private String diabetesNotes;
    private String depression;
    private String depressionNotes;

    // Yes or No
    private String asprin;
    private String amitriptyline;
    private String metformin;
    private String furosemide;


	public Long getId() return this.id; 
	public void setId(Long id) this.id = id;
	
	public String getPid() return this.pid;
	public void setPid(String pid) this.pid = pid;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public Boolean getHtn() {
		return htn;
	}

	public void setHtn(Boolean htn) {
		this.htn = htn;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getDepression() {
		return depression;
	}

	public void setDepression(Boolean depression) {
		this.depression = depression;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}