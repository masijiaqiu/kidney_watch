package KW;

import javax.persistence.*;
import java.util.*;
import java.lang.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="pid")
    private String pid;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="gender")
    private String gender; // M; F
    @Column(name="dob")
    private String dob;
    @Column(name="category")
    private String category; // MKCK, PD, HD, AHD
    @Column(name="score")
    private Integer score;

    @Column(name="egfr")
    private Double egfr;
    // @Column(name="testDate")
    // private String testDate;
    @Column(name="changeRate")
    private Double changeRate;

    // Yes or No
    @Column(name="cancer")
    private String cancer;
    @Column(name="cancerNotes")
    private String cancerNotes;
    @Column(name="smoking")
    private String smoking;
    @Column(name="smokingNotes")
    private String smokingNotes;
    @Column(name="htn")
    private String htn;
    @Column(name="htnNotes")
    private String htnNotes;
    @Column(name="diabetes")
    private String diabetes;
    @Column(name="diabetesNotes")
    private String diabetesNotes;
    @Column(name="depression")
    private String depression;
    @Column(name="depressionNotes")
    private String depressionNotes;

    // Yes or No
    @Column(name="asprin")
    private String asprin;
    @Column(name="amitriptyline")
    private String amitriptyline;
    @Column(name="metformin")
    private String metformin;
    @Column(name="furosemide")
    private String furosemide;


	public Long getId() {return this.id;} 
	public void setId(Long id) {this.id = id;}

	public String getPid() {return this.pid;}
	public void setPid(String pid) {this.pid = pid;}
	public String getFirstName() {return this.firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return this.lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public String getGender() {return this.gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getDob() {return this.dob;}
	public void setDob(String dob) {this.dob = dob;}
	public String getCategory() {return this.category;}
	public void setCategory(String category) {this.category = category;}

	public Integer getScore() {return this.score;}
	public void setScore() {
		int score = 0;

		if (this.changeRate < 0) score += 3;
		if (this.cancer.equals("Yes")) score +=1;
		if (this.smoking.equals("Yes")) score +=1;
		if (this.htn.equals("Yes")) score +=1;
		if (this.diabetes.equals("Yes")) score +=1;
		if (this.depression.equals("Yes")) score +=1;

		this.score = new Integer(score);
	}

	public Double getEgfr() {return this.egfr;}
	public void setEgfr(Double egfr) {this.egfr = egfr;}
	// public String getTestDate() {return this.testDate;}
	// public void setTestDate(String testDate) {this.testDate = testDate;}
	public Double getChangeRate() {return this.changeRate;}
	public void setChangeRate(Double changeRate) {this.changeRate = changeRate;}

	public String getCancer() {return this.cancer;}
	public void setCancer(String cancer) {this.cancer = cancer;}
	public String getSmoking() {return this.smoking;}
	public void setSmoking(String smoking) {this.smoking = smoking;}
	public String getHtn() {return this.htn;}
	public void setHtn(String htn) {this.htn = htn;}
	public String getDiabetes() {return this.diabetes;}
	public void setDiabetes(String diabetes) {this.diabetes = diabetes;}
	public String getDepression() {return this.depression;}
	public void setDepression(String depression) {this.depression = depression;}

	public String getCancerNotes() {return this.cancerNotes;}
	public void setCancerNotes(String cancerNotes) {this.cancerNotes = cancerNotes;}
	public String getSmokingNotes() {return this.smokingNotes;}
	public void setSmokingNotes(String smokingNotes) {this.smokingNotes = smokingNotes;}
	public String getHtnNotes() {return this.htnNotes;}
	public void setHtnNotes(String htnNotes) {this.htnNotes = htnNotes;}
	public String getDiabetesNotes() {return this.diabetesNotes;}
	public void setDiabetesNotes(String diabetesNotes) {this.diabetesNotes = diabetesNotes;}
	public String getDepressionNotes() {return this.depressionNotes;}
	public void setDepressionNotes(String depressionNotes) {this.depressionNotes = depressionNotes;}

	public String getAsprin() {return this.asprin;}
	public void setAsprin(String asprin) {this.asprin = asprin;}
	public String getAmitriptyline() {return this.amitriptyline;}
	public void setAmitriptyline(String amitriptyline) {this.amitriptyline = amitriptyline;}
	public String getMetformin() {return this.metformin;}
	public void setMetformin(String metformin) {this.metformin = metformin;}
	public String getFurosemide() {return this.furosemide;}
	public void setFurosemide(String furosemide) {this.furosemide = furosemide;}

}


