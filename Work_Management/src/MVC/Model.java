package MVC;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import MatanBardugo_OmerLande.Company;
import MatanBardugo_OmerLande.Department;
import MatanBardugo_OmerLande.Employee;
import MatanBardugo_OmerLande.EmployeeBase;
import MatanBardugo_OmerLande.EmployeeBaseAndSales;
import MatanBardugo_OmerLande.EmployeeHours;
import MatanBardugo_OmerLande.Preference;
import MatanBardugo_OmerLande.Preference.ePref;
import MatanBardugo_OmerLande.Role;
import MatanBardugo_OmerLande.Role.eTypeSalary;
import MatanBardugo_OmerLande.Synchronizable;

public class Model implements Serializable {
	
	private Company company;
	
	public Model() throws Exception {		
		this.company = new Company("OmerAndMatanTechnology");
		hardCode();
	}

	public Model(File f) throws Exception {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(f.getAbsolutePath()));
		company = (Company) inFile.readObject();		
		inFile.close();	
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public void addEmployee(Employee newEmp) throws Exception {
		this.company.addEmployee(newEmp);
	}
	
	public void hardCode() throws Exception {
		this.company.getAllDepartment().add(new Department("ADMINISTRATION",false,new Preference(ePref.REGULAR_TIME), true, 8));
		this.company.getAllDepartment().add(new Department("CUSTOMERS_SERVICE",true,new Preference(ePref.REGULAR_TIME), false, 8));
		this.company.getAllDepartment().add(new Department("SALES",true,new Preference(ePref.REGULAR_TIME), false, 8));
		
		this.company.getRoles().add(new Role("Manager", eTypeSalary.BASE, 60, company.getAllDepartment().get(0), true, true, 8, new Preference(ePref.REGULAR_TIME)));		
		this.company.getRoles().add(new Role("Customer Service", eTypeSalary.HOURS,38, company.getAllDepartment().get(1), false, false, 6, new Preference(ePref.START_EARLIER)));
		this.company.getRoles().add(new Role("Sales Man", eTypeSalary.BASEANDSALES,40, company.getAllDepartment().get(2), true, false, 8, new Preference(ePref.REGULAR_TIME)));
				
		this.company.getAllEmployees().add(new EmployeeBase("123123123", "George",company.getRoles().get(0),new Preference(ePref.START_LATER),9)); // salary per month
		this.company.getAllEmployees().add(new EmployeeHours("123124567", "David",company.getRoles().get(1),new Preference(ePref.START_EARLIER),(Math.random()*160),5)); 
		this.company.getAllEmployees().add(new EmployeeBaseAndSales("123124563", "Tom",company.getRoles().get(2),new Preference(ePref.REGULAR_TIME),8, 600));  
		
		this.company.getAllDepartment().get(0).addEmployee(company.getAllEmployees().get(0));
		this.company.getAllDepartment().get(1).addEmployee(company.getAllEmployees().get(1));
		this.company.getAllDepartment().get(2).addEmployee(company.getAllEmployees().get(2));

	}

	public void addRole(Role newRole) {
		company.addRole(newRole);
	}

	
	public void addDepartment(Department newDepartment) {
		this.company.addDepartment(newDepartment);
	}


}
