package MatanBardugo_OmerLande;

import java.io.Serializable;
import java.util.ArrayList;

import MatanBardugo_OmerLande.Preference.ePref;

public class Department implements Changable,Synchronizable,Serializable{

	private String departmentName;
	private ArrayList<Employee> allEmployees;
	private Preference workMethod;
	private boolean changable,isSynchronized;
	private double profit,startWorkTime;

	public Department(String departmentName,boolean changable,Preference workMethod, boolean isSynchronized,double startWorkTime) throws Exception {
		setDepartmentName(departmentName);
		this.allEmployees = new ArrayList<Employee>();
		this.changable = changable;
		this.workMethod = workMethod;
		this.profit = 0;
		this.isSynchronized = isSynchronized;
		this.startWorkTime = startWorkTime;
	}

	public void setSynchronized(boolean isSynchronized) {
		this.isSynchronized = isSynchronized;
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

	public boolean isSynchronized() {
		return isSynchronized;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public Preference getWorkMethod() {
		return workMethod;
	}

	public void setWorkMethod(Preference workMethod) throws Exception {
		if (!this.changable) {
			throw new Exception("Cannot change this department !");
		}		
		if (this.workMethod.equals(workMethod)) {
			throw new Exception(workMethod+" is the current work method !");
		}
		this.workMethod = workMethod;
	}


	public boolean isChangable() {
		return changable;
	}

	public void setChangable(boolean changable) {
		this.changable = changable;
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) throws Exception {		
		if (departmentName.isEmpty()) {
			throw new Exception("Missing Field");
		}
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Department name: " + departmentName+ "\nWork method: "+workMethod.getEmployeesPrefernces()+"\nChangable: "+changable);
		sb.append("\nSynchronized: "+isSynchronized+"\nStart work time: "+startWorkTime+"\n");
		for (int i = 0; i < allEmployees.size(); i++) {
			sb.append("\n"+(i+1)+") "+allEmployees.get(i)+"\n");
		}	
		return sb.toString();
	}

	public void addEmployee(Employee newEmp) throws Exception {
		for (int i = 0; i < allEmployees.size(); i++) {
			if (allEmployees.get(i).equals(newEmp)) {
				throw new Exception("Employee already exist ! ");
			}
		}
		this.allEmployees.add(newEmp);		
	}

	@Override
	public void changeWorkMethods(Preference newWorkMethod) throws Exception {
		if (this.isChangable()) {
			this.setWorkMethod(newWorkMethod);
		}
		else {
			throw new Exception("Department is not changable");
		}
	}

	@Override
	public boolean equals(Object obj) {

		Department other = (Department) obj;	
		return departmentName.equals(other.departmentName);
	}

	public double calculateProfit() {
		double departProfit = 0.0;
		for (int i = 0; i < allEmployees.size(); i++) {
			departProfit += allEmployees.get(i).calculateProfit();
		}
		return (int)(Math.round(departProfit*100))/100;
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
