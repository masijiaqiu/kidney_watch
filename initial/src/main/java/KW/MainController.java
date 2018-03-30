package KW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.*;
import java.text.*;
import java.lang.*;

import KW.Patient;
import KW.PatientRepository;
import KW.LabTest;
import KW.LabTestRepository;


@Controller
public class MainController {
	@Autowired 
	private PatientRepository patientRepository;
	@Autowired 
	private LabTestRepository labTestRepository;

	@GetMapping("/home")
    public String home(Model model) {
    	List<Patient> patients = new ArrayList<>();
	    patientRepository.findAll().forEach(patients::add);
	    model.addAttribute("total", patients.size());

	    int better = countBetterPatients();
	    int worse = countWorsePatients();
	    model.addAttribute("better", better);
	    model.addAttribute("worse", worse);
	    int male = countPatientsByGender("M");
	    int female = countPatientsByGender("F");
	    model.addAttribute("male", male);
	    model.addAttribute("female", female);

        return "home";
    }

    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }

    @GetMapping("/individual")
    public String individual(Model model, @RequestParam String pid
    	, @RequestParam String sdate, @RequestParam String edate) {
    	try{
	    	Patient p = findByPid(pid);
	    	model.addAttribute("patient", p);

	    	Date start = new Date();
	    	Date end = new Date();

	    	try {
		    	start = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		    	end = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		    } catch (Exception e) {

			}
	    	model.addAttribute("labTests", getLabTestsByPidWithDate(pid, start, end));
	    } catch (Exception e) {

	    }
        return "individual";
    }

    // @GetMapping("/population")
    // public String population(Model model) {
    //     return "population";
    // }

    @GetMapping("/mkck")
    public String mkck(Model model) {
    	List<Patient> patients = getCategoryPatients("MKCK");
	    model.addAttribute("patients", patients);
	    model.addAttribute("total", patients.size());
	    int better = countBetterPatientsByCategory("MKCK");
	    int worse = countWorsePatientsByCategory("MKCK");
	    model.addAttribute("better", better);
	    model.addAttribute("worse", worse);
	    int male = countPatientsByGenderWithCategory("MKCK", "M");
	    int female = countPatientsByGenderWithCategory("MKCK", "F");
	    model.addAttribute("male", male);
	    model.addAttribute("female", female);
        return "mkck";
    }

    @GetMapping("/pd")
    public String pd(Model model) {
	    model.addAttribute("patients", getCategoryPatients("PD"));
        return "pd";
    }

    @GetMapping("/hd")
    public String hd(Model model) {
    	model.addAttribute("patients", getCategoryPatients("HD"));
        return "hd";
    }

    @GetMapping("/ahd")
    public String ahd(Model model) {
    	model.addAttribute("patients", getCategoryPatients("AHD"));
        return "ahd";
    }

	@GetMapping("/patients")
    public @ResponseBody Iterable<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@GetMapping("/labTest")
    public @ResponseBody Iterable<LabTest> getAllLabTests() {
		return labTestRepository.findAll();
	}

	@GetMapping("/focus")
	public String focus(Model model, @RequestParam String category
		, @RequestParam String trend) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();

    	if (category.equals("all")) {
    		if (trend.equals("better")) {
    			model.addAttribute("patients", getBetterPatients());
    		} else {
    			model.addAttribute("patients", getWorsePatients());
    		}
    	} else {
    		if (trend.equals("better")) {
    			model.addAttribute("patients", getBetterPatientsByCategory(category));
    		} else {
    			model.addAttribute("patients", getWorsePatientsByCategory(category));
    		}
    	}

    	return "focus";
	}

	public Patient findByPid(String pid) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
    	Patient re = new Patient();
    	for(Patient p: iterator) {
    		if (p.getPid().equals(pid)) {
    			re = p;
    			break;
    		}
    	}

    	return re;
	}

	public List<Patient> getCategoryPatients(String category) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();

    	for(Patient p: iterator) {
	    	if (p.getCategory().equals(category)) {
	    		patients.add(p);
	    	}
	    }
	    return patients;
	}

	public int countBetterPatients() {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getChangeRate() > 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public int countWorsePatients() {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getChangeRate() < 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public List<Patient> getBetterPatients() {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getChangeRate() > 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients;
	}

	public List<Patient> getWorsePatients() {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getChangeRate() < 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients;
	}

	public List<Patient> getBetterPatientsByCategory(String category) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getCategory().equals(category) && p.getChangeRate() > 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients;
	}

	public List<Patient> getWorsePatientsByCategory(String category) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getCategory().equals(category) && p.getChangeRate() < 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients;
	}

	public int countBetterPatientsByCategory(String category) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getCategory().equals(category) && p.getChangeRate() > 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public int countWorsePatientsByCategory(String category) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getCategory().equals(category) && p.getChangeRate() < 0 ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public int countPatientsByGenderWithCategory(String category, String gender) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getCategory().equals(category) && p.getGender().equals(gender) ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public int countPatientsByGender(String gender) {
		List<Patient> patients = new ArrayList<>();
    	Iterable<Patient> iterator = patientRepository.findAll();
	    for(Patient p: iterator) {
	    	if (p.getGender().equals(gender) ) {
	    		patients.add(p);
	    	}
	    }
	    return patients.size();
	}

	public List<LabTest> getLabTestsByPidWithDate(String pid, Date sdate, Date edate) {
		List<LabTest> labTests = new ArrayList<>();
    	Iterable<LabTest> iterator = labTestRepository.findAll();
	    for(LabTest e: iterator) {
	    	Date testDate = new Date();
	    	try {
		    	testDate = new SimpleDateFormat("yyyy-MM-dd").parse(e.getTestDate());
		    } catch (Exception exp) {

			}
	    	if (e.getPid().equals(pid) && testDate.after(sdate) && testDate.before(edate)) {
	    		labTests.add(e);
	    	}
	    }
	    return labTests;
	}

	// @GetMapping(path="/add") 
	// public @ResponseBody String addNewPatient (@RequestParam String name
	// 		, @RequestParam String gender, @RequestParam String dob
	// 		, @RequestParam Double egfr, @RequestParam Integer date
	// 		, @RequestParam Double rate, @RequestParam String category
	// 		, @RequestParam String smoking, @RequestParam String cancer) {

	// 	Patient n = new Patient();
	// 	n.setName(name);
	// 	n.setGender(gender);
	// 	n.setDob(dob);
	// 	n.setEgfr(egfr);

	// 	Date testDate = new Date();
	// 	try {
	// 		testDate = new SimpleDateFormat("yyyyMMdd").parse(Integer.toString(date));
	// 	} catch (Exception e) {

	// 	}

	// 	n.setCategory(category);
	// 	n.setTestDate(new SimpleDateFormat("yyyy-MM-dd").format(testDate));
	// 	n.setRate(rate);
	// 	n.setSmoking(smoking);
	// 	n.setCancer(cancer);
	// 	patientRepository.save(n);
	// 	return "Saved";
	// }

	// @GetMapping(path="/lab")
	// public @ResponseBody String addNewLabTest (@RequestParam Long pid
	// 		, @RequestParam String labName, @RequestParam String labUnit
	// 		, @RequestParam Double labValue, @RequestParam Integer date) {

	// 	LabTest n = new LabTest();
	// 	n.setPid(pid);
	// 	n.setLabValue(labValue);
	// 	n.setLabName(labName);
	// 	n.setLabUnit(labUnit);

	// 	Date testDate = new Date();
	// 	try {
	// 		testDate = new SimpleDateFormat("yyyyMMdd").parse(Integer.toString(date));
	// 	} catch (Exception e) {

	// 	}
	// 	n.setTestDate(testDate);
	// 	labTestRepository.save(n);
	// 	return "Saved";
	// }

}