package WorkManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;

import MatanBardugo_OmerLande.Preference.ePref;

public class Role implements Changable,Serializable,Synchronizable{
	
	public enum eTypeSalary {
		BASE,HOURS,BASEANDSALES
	}
		
	private String roleName;
	private Preference workMethod;
	private eTypeSalary typeOfSalary;
	private double hourSalary;
	private Department department;
	private boolean changable,isSynchronized;
	private ArrayList<Employee> allEmployees;
	private double startWorkTime;

	public Role(String roleName,eTypeSalary typeOfSalary, double hourSalary, Department department,
			boolean changable,boolean isSynchronized, double startWorkTime, Preference workMethod) throws Exception {
		setRoleName(roleName);
		this.workMethod = workMethod;	
		this.typeOfSalary = typeOfSalary;
		this.hourSalary = hourSalary;
		this.department = department;
		this.changable = changable;		
		this.isSynchronized = isSynchronized;
		allEmployees = new ArrayList<Employee>();
		this.startWorkTime = startWorkTime;
	}

	public double getStartWorkTime() {
		return startWorkTime;
	}

	public void setStartWorkTime(double startWorkTime) throws Exception {
		if (this.workMethod.getEmployeesPrefernces().equals(ePref.START_EARLIER)) {
			if (startWorkTime >= 8) {
				throw new Exception("You preference is to start earlier !");
			}			
		}
		else if (this.workMethod.getEmployeesPrefernces().equals(ePref.START_LATER)) {
			if (startWorkTime <= 8) {
				throw new Exception("You preference is to start later !");
			}
		}
		this.startWorkTime = startWorkTime;
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public boolean isSynchronized() {
		return isSynchronized;
	}

	public void setSynchronized(boolean isSynchronized) {
		this.isSynchronized = isSynchronized;
	}

	public boolean isChangable() {
		return changable;
	}

	public void setChangable(boolean changable) {
		this.changable = changable;
	}

	public double getHourSalary() {
		return hourSalary;
	}

	public void setHourSalary(double hourSalary) throws Exception {
		this.hourSalary = hourSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public eTypeSalary getTypeOfSalary() {
		return typeOfSalary;
	}

	public void setTypeOfSalary(eTypeSalary typeOfSalary) {
		this.typeOfSalary = typeOfSalary;
	}

	public Preference getWorkMethod() {
		return workMethod;
	}

	public void setWorkMethod(Preference workMethod) throws Exception {
		if (!this.department.isChangable()) {
			throw new Exception("Cannot change this role !");			
		}		
		if (this.getWorkMethod().equals(workMethod)) {
			throw new Exception(workMethod+" is the current work method !");
		}
		this.workMethod = workMethod;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) throws Exception {
		if (roleName.isEmpty()) {
			throw new Exception("Missing Field");
		}
		this.roleName = roleName;
	}
	
	public void addEmployee(Employee newEmp) throws Exception {
		for (int i = 0; i < allEmployees.size(); i++) {
			if (allEmployees.get(i).equals(newEmp)) {
				throw new Exception("Employee already exsit ! ");
			}
		}
		this.allEmployees.add(newEmp);		
	}

	@Override
	public void changeWorkMethods(Preference newWorkMethod) throws Exception {
		this.setWorkMethod(newWorkMethod);		
	}

	@Override
	public String toString() {
		return roleName +":"+"\nWork Method: " + workMethod + "\nType of salary: "+typeOfSalary+"\nHour salary: "
	+hourSalary+"\nDepartment: "+department.getDepartmentName()+"\nChangable: "+changable+"\nSynchronizable: "+isSynchronized+"\nstart work time: "+startWorkTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Role other = (Role) obj;
		if (other == null) {
			return false;
		}
		return roleName.equals(other.getRoleName());
		
	}

	@Override
	public void synchronize(double startWorkEmp) throws Exception {
		if (this.isSynchronized) {
			for (int i = 0; i < allEmployees.size(); i++) {
				allEmployees.get(i).setWantStartWorkEmp(startWorkEmp);
			}
		}
	}
}
