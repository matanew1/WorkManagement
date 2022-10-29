package WorkManagementSystem;

public class EmployeeBase extends Employee {
	

	public static final double timeWorkMonthly = 160;
	
	public EmployeeBase(String id, String name, Role role, Preference preference, double startWorkEmp) throws Exception {
		super(id, name, role, preference,startWorkEmp);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+":"+super.toString();
	}

}
