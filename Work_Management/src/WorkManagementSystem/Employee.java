package MatanBardugo_OmerLande;

import java.io.Serializable;

import MatanBardugo_OmerLande.Preference.ePref;

public abstract class Employee implements Serializable{

	protected String id;
	protected String name;
	protected Role role;
	protected Preference preference;
	protected double profit;
	protected double wantStartWorkEmp;
	public static double startWorkTime = 8;

	public Employee(String id, String name, Role role, Preference preference, double wantStartWorkEmp) throws Exception {
		this.id = id;
		this.name = name;
		this.role = role;
		this.preference = preference;
		this.wantStartWorkEmp = wantStartWorkEmp;
		this.profit = 0; 
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getId() {
		return id;
	}

	public double getWantStartWorkEmp() {
		return wantStartWorkEmp;
	}

	public void setWantStartWorkEmp(double wantStartWorkEmp) throws Exception {
		if (this.preference.getEmployeesPrefernces().equals(ePref.START_EARLIER)) {
			if (wantStartWorkEmp >= 8) {
				throw new Exception("You preference is to start earlier !");
			}			
		}
		else if (this.preference.getEmployeesPrefernces().equals(ePref.START_LATER)) {
			if (wantStartWorkEmp <= 8) {
				throw new Exception("You preference is to start later !");
			}
		}
		this.wantStartWorkEmp = wantStartWorkEmp;
	}

	public void setId(String id) throws Exception {
		if (id.equals(null)) {
			throw new Exception("Id is null ! ");
		}
		if (!id.matches("\\d+")) {
			throw new Exception("Id number contains characters that are not numbers! ");
		}
		if (id.length() != 9) {
			throw new Exception("Id number must be 9 digits ! ");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.isBlank()) {
			throw new Exception("Missing Field");
		}
		if (name.matches("\\d+")) {
			throw new Exception("Name must be characters !!");
		}
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) throws Exception {
		this.role = role;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("\nID: " + this.id + "\nName: " + this.name + "\nRole: "
				+ this.role.getRoleName() + "\nType of salary: " + this.role.getTypeOfSalary() + "\nPreference: "
				+ this.preference.getEmployeesPrefernces());
		if (this instanceof EmployeeHours) {
			EmployeeHours e = (EmployeeHours) this;
			sb.append("\nMonthly salary: " + e.getRole().getHourSalary() * e.getTimeWorkMonthly());
		} else if (this instanceof EmployeeBaseAndSales) {
			EmployeeBaseAndSales e = (EmployeeBaseAndSales) this;
			sb.append("\nMonthly salary: " + (e.getRole().getHourSalary() + (e.getSales() * 0.01)) * 160);
		} else {
			sb.append("\nMonthly salary: " + this.getRole().getHourSalary() * 160);
		}
		if (!this.getPreference().getEmployeesPrefernces().equals(ePref.WORK_FROM_HOME)) {
			sb.append("\nWant to start work at : " + (int)(this.wantStartWorkEmp)+":00");
		}
		if (this.role.getDepartment().isSynchronized()) {
			sb.append("\nStart work at department time : " + (int)(this.role.getDepartment().getStartWorkTime())+":00");
		}
		else {
			if (this.role.isSynchronized()) {
				sb.append("\nStart work at role time : " + (int)(this.role.getStartWorkTime())+":00");
			}
		}

		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {

		Employee other = (Employee) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		}
		return (id.equals(other.id));
	}

	public double calculateProfit() {
		int numOfEmployees = 1;
		double effPerHour = 0, profitEmployee = 0;
		double hours = 0, profitCompanyEarnFromEmployee = 10, moneyWeShouldHave = 0;
		
		if (this instanceof EmployeeBaseAndSales) {
			EmployeeBaseAndSales e = (EmployeeBaseAndSales) this;
			profitCompanyEarnFromEmployee += (e.getSales());
		}
		
		if (!this.getRole().getDepartment().isChangable()) {			
			if (this.getRole().getDepartment().getWorkMethod().equals(this.getPreference())) {
				if (this.getPreference().getEmployeesPrefernces().equals(ePref.WORK_FROM_HOME)) {
					effPerHour = 1.1;
					hours = 8;
					profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
					moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
					
				}
				else {				
					effPerHour = 1.2;
					hours = Math.abs(this.wantStartWorkEmp - Employee.startWorkTime);
					profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
					moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
					
				}
				
			} else {
				
				if (this.getPreference().getEmployeesPrefernces().equals(ePref.WORK_FROM_HOME)) {
					hours = 8;			
				}
				else {
					hours = Math.abs(this.wantStartWorkEmp - Employee.startWorkTime);					
				}			
				effPerHour = 0.8;
				profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
				moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
			}
		}
		else {
			if (this.getRole().getWorkMethod().equals(this.getPreference())) {
				if (this.getPreference().getEmployeesPrefernces().equals(ePref.WORK_FROM_HOME)) {
					effPerHour = 1.1;
					hours = 9;
					profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
					moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
					
				}
				else {				
					effPerHour = 1.2;
					hours = Math.abs(this.wantStartWorkEmp - Employee.startWorkTime);
					profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
					moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
					
				}
				
			} else {
				hours = Math.abs(this.wantStartWorkEmp - Employee.startWorkTime);
				effPerHour = 0.8;
				profitEmployee = (effPerHour * numOfEmployees * hours) * profitCompanyEarnFromEmployee;
				moneyWeShouldHave = (1 * 1 * hours)*profitCompanyEarnFromEmployee;
			}
			
		}

		
		return (int)(Math.round((profitEmployee - moneyWeShouldHave)*100))/100;
	}

}
