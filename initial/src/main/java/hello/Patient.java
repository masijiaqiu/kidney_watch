package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private Boolean htn;

    private Boolean cancer;

    private Boolean diabetes;

    private Boolean smoking;

    private Boolean depression;

    private Integer category; 
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

	public Boolean getHtn() {
		return htn;
	}

	public void setHtn(Boolean htn) {
		this.htn = htn;
	}

	public Boolean getCancer() {
		return cancer;
	}

	public void setCancer(Boolean cancer) {
		this.cancer = cancer;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getSmoking() {
		return smoking;
	}

	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}

	public Boolean getDepression() {
		return depression;
	}

	public void setDepression(Boolean depression) {
		this.depression = depression;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
}