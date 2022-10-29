package WorkManagementSystem;

public class EmployeeBaseAndSales extends EmployeeBase{

	private double sales;
	
	public EmployeeBaseAndSales(String id, String name, Role role, Preference preference,double startWorkEmp, double sales) throws Exception {
		super(id, name, role, preference,startWorkEmp);
		this.sales = sales*0.01;
	}

	public double getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return super.toString()+"\nDaily 1% sales: " + sales+" (NIS)";
	}


}
