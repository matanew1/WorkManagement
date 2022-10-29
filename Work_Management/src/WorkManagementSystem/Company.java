package WorkManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable{
	
	private String companyName;
	private ArrayList<Department> allDepartment;
	private ArrayList<Employee> allEmployees;
	private Double profit;
	private ArrayList<Role> roles;

	public Company(String companyName) {
		this.companyName = companyName;
		this.allDepartment =  new ArrayList<Department>();	
		this.roles = new ArrayList<Role>();
		this.allEmployees = new ArrayList<Employee>();
		this.profit = 0.0;
	}


	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public String getCompanyName() {
		return companyName;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ArrayList<Department> getAllDepartment() {
		return allDepartment;
	}

	public void setAllDepartment(ArrayList<Department> allDepartment) {
		this.allDepartment = allDepartment;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public Role customTypeOfSalary(Role newRole) {
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).equals(newRole)) {
				newRole.setTypeOfSalary(roles.get(i).getTypeOfSalary());
			}
		}
		return newRole;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Company Name: " + companyName);
		sb.append("\nAll Department:\n");
		for (int i = 0; i < allDepartment.size(); i++) {
			sb.append(allDepartment.get(i)+"\n");
		}
		sb.append("\nProfit: " + profit);
		return sb.toString();
	}

	public void addEmployee(Employee newEmp) throws Exception {
		for (int i = 0; i < allDepartment.size(); i++) {
			if (allDepartment.get(i).equals(newEmp.getRole().getDepartment())) {
				allDepartment.get(i).addEmployee(newEmp);
			}			
		}
		allEmployees.add(newEmp);
		
		for (int i = 0; i < roles.size(); i++) {
			if (newEmp.getRole().equals(roles.get(i))) {
				roles.get(i).addEmployee(newEmp);
			}
		}
	}


	public Role customDepartment(Role newRole) {
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).equals(newRole)) {
				newRole.setDepartment(roles.get(i).getDepartment());
			}
		}
		return newRole;
	}

	public void addRole(Role newRole) {
		roles.add(newRole);
	}

	public void addDepartment(Department newDepartment) {
		this.allDepartment.add(newDepartment);
	}


	public Role customSalary(Role newRole) throws Exception {
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).equals(newRole)) {
				newRole.setHourSalary(roles.get(i).getHourSalary());
			}
		}
		return newRole;
	}

	public double calculateProfit() {
		double companyProfit = 0.0;
		for (int i = 0; i < allDepartment.size(); i++) {
			companyProfit += allDepartment.get(i).calculateProfit();
		}
		return (int)(Math.round(companyProfit*100))/100;
	}

}
