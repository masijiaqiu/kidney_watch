package KW;

import java.util.*;
import java.text.*;
import java.lang.*;

public class FlowSheet implements Comparable<FlowSheet> {

    private String testDate;
    private Double egfr;
    private Double acr;
    private Double srcr;

    public String getTestDate() {return this.testDate;}
	public void setTestDate(String testDate) {this.testDate = testDate;}

	public Double getEgfr() {return this.egfr;}
	public void setEgfr(Double egfr) {this.egfr = egfr;}

	public Double getAcr() {return this.acr;}
	public void setAcr(Double acr) {this.acr = acr;}

	public Double getSrcr() {return this.srcr;}
	public void setSrcr(Double srcr) {this.srcr = srcr;}

	public int compareTo(FlowSheet compareLabTest) {
		Date testDate = new Date();

		try {
			testDate = new SimpleDateFormat("yyyy-MM-dd").parse(((FlowSheet) compareLabTest).getTestDate());
		} catch (Exception e) {

		}
		int compareQuantity = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(testDate));

		try {
			testDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.testDate);
		} catch (Exception e) {

		}
		int thisQuantity = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(testDate));

		//descending order
		return compareQuantity - thisQuantity;
		//descending order
		//return compareQuantity - this.quantity;
		
	}

}