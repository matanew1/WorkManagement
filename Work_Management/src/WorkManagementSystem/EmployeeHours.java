package WorkManagementSystem;

public class EmployeeHours extends Employee{

	private double timeWorkMonthly;
	
	
	public EmployeeHours(String id, String name, Role role, Preference preference, double timeWorkMonthly, double startWorkEmp) throws Exception {
		super(id, name, role, preference,startWorkEmp);
		this.timeWorkMonthly = timeWorkMonthly;
	}

	public double getTimeWorkMonthly() {
		return timeWorkMonthly;
	}

	public void setTimeWorkMonthly(double timeWorkMonthly) {
		this.timeWorkMonthly = timeWorkMonthly;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+":"+super.toString()+"\nTime work Monthly: " + (int)(Math.round(timeWorkMonthly*100))/100 +" (hours)";
	}


}
