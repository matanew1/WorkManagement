package WorkManagementSystem;

import java.io.Serializable;

public class Preference implements Serializable {
	
	public enum ePref {
		START_EARLIER,START_LATER,REGULAR_TIME,WORK_FROM_HOME,DEFAULT
	}
	
	private ePref employeesPrefernces;

	public Preference(ePref employeesPrefernces) {
		this.employeesPrefernces = employeesPrefernces;
	}

	public ePref getEmployeesPrefernces() {
		return employeesPrefernces;
	}

	public void setEmployeesPrefernces(ePref employeesPrefernces) {
		this.employeesPrefernces = employeesPrefernces;
	}

	@Override
	public String toString() {
		return "" + employeesPrefernces;
	}

	@Override
	public boolean equals(Object obj) {
		Preference other = (Preference) obj;
		if (other == null) {
			return false;
		}
		return employeesPrefernces.equals(other.getEmployeesPrefernces());
	}
	
	
	
	
	
	
	
	

}
