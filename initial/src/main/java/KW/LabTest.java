package KW;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "LabTest")
public class LabTest {
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

	public Long getId() return this.id;
	public void setId(Long id) this.id = id;

	public String getPid() return this.pid;
	public void setPid(String pid) this.pid = pid;

	public String getLabName() return this.labName;
	public void setLabName(String labName) this.labName = labName;

	public Double getLabValue() return this.labValue;
	public void setLabValue(Double labValue) this.labValue = labValue;

	public String getLabUnit() return this.labUnit;
	public void setLabUnit(String labUnit) this.labUnit = labUnit;

	public String getTestDate() return this.testDate;
	public void setTestDate(String testDate) this.testDate = testDate;

}