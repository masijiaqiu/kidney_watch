package KW;

import javax.persistence.*;
import java.util.*;
import java.text.*;
import java.lang.*;

@Entity
@Table(name = "LabTest")
public class LabTest implements Comparable<LabTest> {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="pid")
    private String pid;
	@Column(name="labName")	
    private String labName;
    @Column(name="labValue")
    private Double labValue;
    @Column(name="labUnit")
    private String labUnit;
    @Column(name="testDate")
    private String testDate;

	public Long getId() {return this.id;}
	public void setId(Long id) {this.id = id;}

	public String getPid() {return this.pid;}
	public void setPid(String pid) {this.pid = pid;}

	public String getLabName() {return this.labName;}
	public void setLabName(String labName) {this.labName = labName;}

	public Double getLabValue() {return this.labValue;}
	public void setLabValue(Double labValue) {this.labValue = labValue;}

	public String getLabUnit() {return this.labUnit;}
	public void setLabUnit(String labUnit) {this.labUnit = labUnit;}

	public String getTestDate() {return this.testDate;}
	public void setTestDate(String testDate) {this.testDate = testDate;}

	public int compareTo(LabTest compareLabTest) {
		Date testDate = new Date();

		try {
			testDate = new SimpleDateFormat("yyyy-MM-dd").parse(((LabTest) compareLabTest).getTestDate());
		} catch (Exception e) {

		}
		int compareQuantity = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(testDate));

		try {
			testDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.testDate);
		} catch (Exception e) {

		}
		int thisQuantity = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(testDate));

		//ascending order
		return thisQuantity - compareQuantity;
		//descending order
		//return compareQuantity - this.quantity;
		
	}

}