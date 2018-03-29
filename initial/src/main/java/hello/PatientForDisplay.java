package hello;

import java.util.Date;

public class PatientForDisplay {

    private String pid;

    private String name;

    private String gender;

    private Integer age;

    private Double egfr;

    private Date testDate;

    private Double rate;

    private String cancer;

    private String cancerNotes;

    private String smoking;

    private String smokingNotes;

    private Boolean htn;

    private Boolean diabetes;

    private Boolean depression;

    private String category; 
    // 1: MKCK
    // 2: PD
    // 3: HD
    // 4: AHD

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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