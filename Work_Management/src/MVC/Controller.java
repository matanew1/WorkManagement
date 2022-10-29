package MVC;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import MatanBardugo_OmerLande.Department;
import MatanBardugo_OmerLande.Employee;
import MatanBardugo_OmerLande.EmployeeBase;
import MatanBardugo_OmerLande.EmployeeBaseAndSales;
import MatanBardugo_OmerLande.EmployeeHours;
import MatanBardugo_OmerLande.Preference;
import MatanBardugo_OmerLande.Preference.ePref;
import MatanBardugo_OmerLande.Role;
import MatanBardugo_OmerLande.Role.eTypeSalary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model m, View v) {
		model = m;
		view = v;

		EventHandler<ActionEvent> exitButton = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.alertExit();

				if (view.getResult().get().getButtonData() == ButtonData.YES) {
					System.out.println("The program is over and saved");
					try {
						ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("company.dat"));
						outFile.writeObject(model.getCompany());
						outFile.close();
					} catch (Exception e) {
						Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
						alert.show();
						return;
					}
					System.out.println("close screen...");
					view.getStage().close();

				} else {
					view.getAlert().close();
				}
			}
		};
		view.exitButtonEvent(exitButton);

		EventHandler<ActionEvent> addDepartButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.addScreenDepart(m);

				EventHandler<ActionEvent> addEventSubmit = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						Department d;
						try {
							view.getCmbChangable().equals(null);
							view.getCmbWorkMethod().getValue().equals(null);
							view.getCmbSync().equals(null);

							String departmentName = view.getDepartName().getText();
							boolean changable = view.getCmbChangable().getValue();
							boolean isSynchro = view.getCmbSync().getValue();
							Preference workMethod = new Preference(view.getCmbWorkMethod().getValue());
							d = new Department(departmentName, changable, workMethod, isSynchro, 0);
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "please choose from all the options");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						double startWorkTime;
						try {
							view.getCmbHoursWorkStart().getValue().equals(null);
							startWorkTime = view.getHoursNum()
									.get(view.getCmbHoursWorkStart().getSelectionModel().getSelectedIndex());
							d.setStartWorkTime(startWorkTime);
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Start Time Work is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						model.addDepartment(d);
						System.out.println("Added a new Department");
						view.getSecondaryStage().close();
					}
				};
				view.SubmitButtonEvent(addEventSubmit);
			}
		};
		view.addDepartButtonEvent(addDepartButtonEvent);

		EventHandler<ActionEvent> addRoleButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.addScreenRole(m);

				EventHandler<ActionEvent> addEventSubmit = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						String roleName = view.getRoleName().getText();
						eTypeSalary typeOfSalary = view.getCmbTypeSalary().getValue();
						String depart = view.getCmbDepartment().getValue();
						boolean c = false, changable = false, isSynchro = false;
						double monthlySalary;
						try {
							view.getCmbSync().getValue().equals(null);
							isSynchro = view.getCmbSync().getValue();
							view.getCmbChangable().getValue().equals(null);
							changable = view.getCmbChangable().getValue();
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Please fill in the combo box");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							view.getSalary().getText().equals(null);
							monthlySalary = Double.valueOf(view.getSalary().getText());
						} catch (NumberFormatException e) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Please fill in numbers only");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}
						Preference p = null;

						for (int i = 0; i < m.getCompany().getAllDepartment().size(); i++) {
							if (m.getCompany().getAllDepartment().get(i).getDepartmentName().equals(depart)) {
								c = m.getCompany().getAllDepartment().get(i).isChangable();
								p = new Preference(m.getCompany().getAllDepartment().get(i).getWorkMethod()
										.getEmployeesPrefernces());
							}
						}
						Department department = null;

						try {
							view.getCmbDepartment().getValue().equals(null);
							department = new Department(depart, c, p, isSynchro, 0);
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "department is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						Role newRole = null;

						try {
							view.getCmbWorkMethod().getValue().equals(null);
							Preference pref = new Preference(view.getCmbWorkMethod().getValue());
							typeOfSalary.equals(null);
							newRole = new Role(roleName, typeOfSalary, monthlySalary, department, changable, isSynchro,
									0, pref);
						} catch (NumberFormatException e) {
							Alert a = new Alert(Alert.AlertType.ERROR, "salary must be numbers !");
							a.show();
							return;
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Type of salary is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						double startWorkTime;
						try {
							view.getCmbHoursWorkStart().getValue().equals(null);
							startWorkTime = view.getHoursNum()
									.get(view.getCmbHoursWorkStart().getSelectionModel().getSelectedIndex());
							newRole.setStartWorkTime(startWorkTime);
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Start Time Work is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						model.addRole(newRole);
						System.out.println("Added a new Role");
						view.getSecondaryStage().close();
					}
				};
				view.SubmitButtonEvent(addEventSubmit);

			}
		};
		view.addRoleButtonEvent(addRoleButtonEvent);

		EventHandler<ActionEvent> addEmployeeEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				view.addScreenEmployee(m);

				EventHandler<ActionEvent> addEventSubmit = new EventHandler<ActionEvent>() {

					private Preference pref;

					@Override
					public void handle(ActionEvent event) {
						String id = null, name = null;
						Role newRole = null;
						pref = null;
						double startWork = 0, sales = 0;

						try {

							view.getCmbRole().equals(null);
							for (int i = 0; i < m.getCompany().getRoles().size(); i++) {
								if (view.getCmbRole().getValue()
										.equals(m.getCompany().getRoles().get(i).getRoleName())) {
									newRole = m.getCompany().getRoles().get(i);
								}
							}

						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Role is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							view.getCmbPref().getValue().equals(null);
							pref = new Preference(view.getCmbPref().getValue());
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Pref is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							newRole = m.getCompany().customSalary(newRole);
						} catch (Exception e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, e1.getMessage());
							a.show();
							return;
						}

						newRole = m.getCompany().customTypeOfSalary(newRole);
						newRole = m.getCompany().customDepartment(newRole);

						Employee emp = null;
						try {
							id = view.getId().getText();
							name = view.getName().getText();
							if (newRole.getTypeOfSalary().equals(eTypeSalary.BASE)) {

								emp = new EmployeeBase(null, null, newRole, pref, 0);

							} else if (newRole.getTypeOfSalary().equals(eTypeSalary.BASEANDSALES)) {

								emp = new EmployeeBaseAndSales(null, null, newRole, pref, 0, sales);

							} else {

								emp = new EmployeeHours(null, null, newRole, pref, (Math.random() * 160), 0);
							}
							emp.setId(id);
							System.out.println(name);
							emp.setName(name);
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							view.getCmbHoursWorkStart().getValue().equals(null);
							startWork = view.getHoursNum()
									.get(view.getCmbHoursWorkStart().getSelectionModel().getSelectedIndex());
							emp.setWantStartWorkEmp(startWork);
						} catch (NullPointerException e1) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Start Time Work is null");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							for (int i = 0; i < model.getCompany().getRoles().size(); i++) {

								if (!view.getCmbRole().getValue().equals("Sales Man")) {
									if (Double.valueOf(view.getSalesDaily().getText()) != 0) {
										throw new Exception("You don't have sales !");
									}
								}
							}

							sales = Double.valueOf(view.getSalesDaily().getText());

						} catch (NumberFormatException e) {
							Alert a = new Alert(Alert.AlertType.ERROR, "Please fill in numbers only");
							a.show();
							return;
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}

						try {
							model.addEmployee(emp);
						} catch (Exception e) {
							Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
							a.show();
							return;
						}
						System.out.println("Added a new Employee");

						view.getSecondaryStage().close();
					}
				};
				view.SubmitButtonEvent(addEventSubmit);
			}
		};
		view.addEmployeeButtonEvent(addEmployeeEvent);

		EventHandler<ActionEvent> printDeparts = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < model.getCompany().getRoles().size(); i++) {
					if (model.getCompany().getRoles().get(i).getDepartment().isSynchronized()) {
						for (int j = 0; j < model.getCompany().getRoles().get(i).getDepartment().getAllEmployees()
								.size(); j++) {
							try {
								model.getCompany().getRoles().get(i).getDepartment().getAllEmployees().get(j).getRole()
								.setStartWorkTime(model.getCompany().getRoles().get(i).getDepartment()
										.getStartWorkTime());
							} catch (Exception e) {
								Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
								a.show();
								return;
							}
						}
					} else {
						if (model.getCompany().getRoles().get(i).isSynchronized()) {
							for (int j = 0; j < model.getCompany().getRoles().get(i).getAllEmployees().size(); j++) {
								try {
									model.getCompany().getRoles().get(i).getDepartment().getAllEmployees().get(j)
									.setWantStartWorkEmp(
											model.getCompany().getRoles().get(i).getStartWorkTime());
								} catch (Exception e) {
									Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
									a.show();
									return;
								}
							}
						}
					}

				}

				view.addScreenPrintDepartment(model);
			}
		};
		view.printDataButtonEvent(printDeparts);

		EventHandler<ActionEvent> printDatatProfit = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// model.customizeEfficiencyEmployee(model);
				for (int i = 0; i < model.getCompany().getAllEmployees().size(); i++) {

					if (model.getCompany().getAllEmployees().get(i) instanceof EmployeeHours) {
						double profit = model.getCompany().getAllEmployees().get(i).calculateProfit();
						model.getCompany().getAllEmployees().get(i).setProfit(profit);

					} else if (!(model.getCompany().getAllEmployees().get(i) instanceof EmployeeBaseAndSales)
							&& !(model.getCompany().getAllEmployees().get(i) instanceof EmployeeHours)) {
						model.getCompany().getAllEmployees().get(i)
						.setProfit(model.getCompany().getAllEmployees().get(i).calculateProfit());
					} else {
						model.getCompany().getAllEmployees().get(i)
						.setProfit(model.getCompany().getAllEmployees().get(i).calculateProfit());
					}

				}
				for (int i = 0; i < model.getCompany().getAllDepartment().size(); i++) {
					double profit = model.getCompany().getAllDepartment().get(i).calculateProfit();
					model.getCompany().getAllDepartment().get(i).setProfit(profit);
				}

				// model.getCompany().calculateProfit();
				model.getCompany().setProfit(Double.valueOf(model.getCompany().calculateProfit()));
				view.addScreenPrintDataProfit(model);
			}
		};
		view.printProfitButtonEvent(printDatatProfit);

		EventHandler<ActionEvent> printEmployees = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.addScreenPrintEmployees(model);
			}
		};
		view.printEmployeesButtonEvent(printEmployees);

		EventHandler<ActionEvent> printRoles = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				view.addScreenPrintRoles(model);
			}
		};
		view.printRolesButtonEvent(printRoles);

		EventHandler<ActionEvent> changeDepartButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.addChangeDepart(m);

				EventHandler<ActionEvent> addEventSubmit = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						for (int i = 0; i < m.getCompany().getAllDepartment().size(); i++) {
							try {
								view.getCmbDepartment().getValue().equals(null);
								view.getCmbWorkMethod().getValue().equals(null);
								view.getCmbHoursWorkStart().getValue().equals(null);
								
								if (m.getCompany().getAllDepartment().get(i).getDepartmentName().equals(view.getCmbDepartment().getValue())) {
									m.getCompany().getAllDepartment().get(i).setWorkMethod(new Preference(ePref.DEFAULT));
									m.getCompany().getAllDepartment().get(i).setWorkMethod(new Preference(view.getCmbWorkMethod().getValue()));
									m.getCompany().getAllDepartment().get(i).setStartWorkTime(view.getHoursNum().get(view.getCmbHoursWorkStart().getSelectionModel().getSelectedIndex()));
								}
							} catch (NullPointerException e1) {
								Alert a = new Alert(Alert.AlertType.ERROR, "Please choose the options");
								a.show();
								return;
							} catch (Exception e) {
								Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
								a.show();
								return;
							}
						}

						view.getSecondaryStage().close();
					}
				};
				view.SubmitButtonEvent(addEventSubmit);

			}
		};
		view.changeDepartButtonEvent(changeDepartButtonEvent);

		EventHandler<ActionEvent> changeRoleButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.addChangeRole(m);

				EventHandler<ActionEvent> addEventSubmit = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						for (int i = 0; i < m.getCompany().getRoles().size(); i++) {
							try {
								if (m.getCompany().getRoles().get(i).getRoleName()
										.equals(view.getCmbRole().getValue())) {
									if (m.getCompany().getRoles().get(i).getDepartment().isChangable()) {
										if (m.getCompany().getRoles().get(i).isChangable()) {
											m.getCompany().getRoles().get(i).setWorkMethod(new Preference(ePref.DEFAULT));
											m.getCompany().getRoles().get(i).setWorkMethod(new Preference(view.getCmbWorkMethod().getValue()));
											m.getCompany().getRoles().get(i).setStartWorkTime(
													Double.valueOf(view.getHoursNum().get(view.getCmbHoursWorkStart().getSelectionModel().getSelectedIndex())));
											System.out.println("Roles changed ");
										} else {
											throw new Exception("This role is not changable ! ");
										}
									} else {
										throw new Exception("This department's role is not changable ! ");
									}

								}
								view.getCmbRole().getValue().equals(null);
								view.getCmbWorkMethod().getValue().equals(null);
								view.getCmbHoursWorkStart().getValue().equals(null);

							} catch (NullPointerException e1) {
								Alert a = new Alert(Alert.AlertType.ERROR, "Please choose the options");
								a.show();
								return;
							} catch (Exception e) {
								Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
								a.show();
								return;
							}

						}
						view.getSecondaryStage().close();
					}
				};
				view.SubmitButtonEvent(addEventSubmit);

			}
		};
		view.changeRoleButtonEvent(changeRoleButtonEvent);
	}
}
