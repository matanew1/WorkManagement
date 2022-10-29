package MVC;

import java.util.ArrayList;
import java.util.Optional;

import MatanBardugo_OmerLande.EmployeeBaseAndSales;
import MatanBardugo_OmerLande.Preference.ePref;
import MatanBardugo_OmerLande.Role.eTypeSalary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class View {

	private Stage stage, secondaryStage;
	private Scene scene;
	private BorderPane bp;
	private Button addEmployeeButton, submitButton, printDataButton, addRoleButton, addDepartButton, changeDepartButton,
			changeRoleButton, printRolesButton, printEmployeesButton, printProfit, exitButton;
			
	private VBox vbButtons, oneBox, details;
	private TextField id, name, roleName, departName, salary, salesDaily;
	private ComboBox<String> cmbRole, cmbDepartment,cmbHoursWorkStart;
	private ComboBox<ePref> cmbPref, cmbWorkMethod;
	private ComboBox<eTypeSalary> cmbTypeSalary;
	private ComboBox<Boolean> cmbChangable,cmbSync;
	private ArrayList<ComboBox<Integer>> boxesTimeWork;
	private ArrayList<TextField> boxesSales;
	private Optional<ButtonType> result;
	private Alert alert;
	private ArrayList<String> hours, housrStart;
	private ArrayList<Integer> hoursNum;

	public View(Stage stg) {

		this.stage = stg;
		bp = new BorderPane();
		HBox hbTitle = new HBox();
		vbButtons = new VBox();

		addEmployeeButton = new Button("Add Employee");
		addEmployeeButton.setFont(Font.font("Baskerville Old Face", 22));
		addEmployeeButton.setMaxSize(250, 250);

		submitButton = new Button("Submit");
		submitButton.setFont(Font.font("Baskerville Old Face", 22));
		submitButton.setMaxSize(250, 250);

		printDataButton = new Button("Print All Department");
		printDataButton.setFont(Font.font("Baskerville Old Face", 22));
		printDataButton.setMaxSize(250, 250);

		printRolesButton = new Button("Print All Roles");
		printRolesButton.setFont(Font.font("Baskerville Old Face", 22));
		printRolesButton.setMaxSize(250, 250);

		printEmployeesButton = new Button("Print All Employees");
		printEmployeesButton.setFont(Font.font("Baskerville Old Face", 22));
		printEmployeesButton.setMaxSize(250, 250);

		addRoleButton = new Button("Add Role");
		addRoleButton.setFont(Font.font("Baskerville Old Face", 22));
		addRoleButton.setMaxSize(250, 250);

		addDepartButton = new Button("Add Department");
		addDepartButton.setFont(Font.font("Baskerville Old Face", 22));
		addDepartButton.setMaxSize(250, 250);

		changeDepartButton = new Button("Change Department");
		changeDepartButton.setFont(Font.font("Baskerville Old Face", 22));
		changeDepartButton.setMaxSize(250, 250);

		changeRoleButton = new Button("Change Role");
		changeRoleButton.setFont(Font.font("Baskerville Old Face", 22));
		changeRoleButton.setMaxSize(250, 250);

		printProfit = new Button("Print Profit Data");
		printProfit.setFont(Font.font("Baskerville Old Face", 22));
		printProfit.setMaxSize(250, 250);

		exitButton = new Button("Exit");
		exitButton.setFont(Font.font("Baskerville Old Face", 22));
		exitButton.setMaxSize(250, 250);

		vbButtons.getChildren().addAll(addEmployeeButton, addRoleButton, addDepartButton, printDataButton,
				printRolesButton, printEmployeesButton, changeDepartButton, changeRoleButton, /*dataEmployeeButton,*/
				printProfit, exitButton);
		vbButtons.setAlignment(Pos.CENTER);

		Text title = new Text("OMTechnology");
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(new Font(45));
		title.setStrokeWidth(3);
		title.setStroke(Color.BLACK);
		hbTitle.getChildren().add(title);
		hbTitle.setAlignment(Pos.TOP_CENTER);
		bp.setTop(hbTitle);
		bp.setCenter(vbButtons);

		scene = new Scene(bp, 600, 600);
		this.stage.setScene(scene);
		this.stage.show();
	}

	public ArrayList<String> getHours() {
		return hours;
	}

	public ArrayList<String> getHousrStart() {
		return housrStart;
	}

	public Alert getAlert() {
		return alert;
	}

	public Optional<ButtonType> getResult() {
		return result;
	}

	public ArrayList<TextField> getBoxesSales() {
		return boxesSales;
	}

	public ComboBox<String> getCmbHoursWorkStart() {
		return cmbHoursWorkStart;
	}

	public TextField getSalesDaily() {
		return salesDaily;
	}

	public TextField getRoleName() {
		return roleName;
	}

	public ArrayList<ComboBox<Integer>> getBoxesTimeWork() {
		return boxesTimeWork;
	}

	public VBox getOneBox() {
		return oneBox;
	}

	public VBox getDetails() {
		return details;
	}

	public ComboBox<String> getCmbDepartment() {
		return cmbDepartment;
	}

	public ComboBox<eTypeSalary> getCmbTypeSalary() {
		return cmbTypeSalary;
	}

	public void addEmployeeButtonEvent(EventHandler<ActionEvent> click) {
		addEmployeeButton.setOnAction(click);
	}

	public ComboBox<Boolean> getCmbSync() {
		return cmbSync;
	}

	public void printProfitButtonEvent(EventHandler<ActionEvent> click) {
		printProfit.setOnAction(click);
	}

	public void addRoleButtonEvent(EventHandler<ActionEvent> click) {
		addRoleButton.setOnAction(click);
	}

	public void SubmitButtonEvent(EventHandler<ActionEvent> click) {
		submitButton.setOnAction(click);
	}

	public void exitButtonEvent(EventHandler<ActionEvent> click) {
		exitButton.setOnAction(click);
	}

	public void printDataButtonEvent(EventHandler<ActionEvent> click) {
		printDataButton.setOnAction(click);
	}

	public void printRolesButtonEvent(EventHandler<ActionEvent> click) {
		printRolesButton.setOnAction(click);
	}

	public void printEmployeesButtonEvent(EventHandler<ActionEvent> click) {
		printEmployeesButton.setOnAction(click);
	}

	public void addDepartButtonEvent(EventHandler<ActionEvent> click) {
		addDepartButton.setOnAction(click);
	}

	public void changeDepartButtonEvent(EventHandler<ActionEvent> click) {
		changeDepartButton.setOnAction(click);
	}

	public void changeRoleButtonEvent(EventHandler<ActionEvent> click) {
		changeRoleButton.setOnAction(click);
	}


	public Button getSubmitButton() {
		return submitButton;
	}

	public Button getAddDepartButton() {
		return addDepartButton;
	}
	public ArrayList<Integer> getHoursNum() {
		return hoursNum;
	}

	public VBox getVbButtons() {
		return vbButtons;
	}

	public Button getAddEmployeeButton() {
		return addEmployeeButton;
	}

	public Stage getSecondaryStage() {
		return secondaryStage;
	}

	public TextField getSalary() {
		return salary;
	}

	public Stage getStage() {
		return stage;
	}

	public Scene getScene() {
		return scene;
	}

	public BorderPane getBp() {
		return bp;
	}

	public TextField getId() {
		return id;
	}

	public TextField getName() {
		return name;
	}
/*
	public ComboBox<Integer> getCmbHoursWork() {
		return cmbHoursWork;
	}
*/
	public ComboBox<String> getCmbRole() {
		return cmbRole;
	}

	public ComboBox<ePref> getCmbPref() {
		return cmbPref;
	}

	public TextField getDepartName() {
		return departName;
	}

	public ComboBox<ePref> getCmbWorkMethod() {
		return cmbWorkMethod;
	}

	public ComboBox<Boolean> getCmbChangable() {
		return cmbChangable;
	}

	public void alertExit() {
		alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Current project is modified");
		alert.setContentText("Are you sure you want to exit? ");
		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonData.NO);
		alert.getButtonTypes().setAll(okButton, noButton);
		result = alert.showAndWait();
	}

	public void addScreenEmployee(Model m) {
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox details = new VBox();

		Text tID = new Text("Enter id number: ");
		tID.setFont(new Font(16));
		id = new TextField();
		id.setText(" ");
		HBox hbID = new HBox();
		hbID.getChildren().addAll(tID, id);

		Text tName = new Text("Enter your name: ");
		tName.setFont(new Font(16));
		name = new TextField();
		name.setText(" ");
		HBox hbName = new HBox();
		hbName.getChildren().addAll(tName, name);

		Label lRole = new Label("Choose your role: ");
		lRole.setFont(new Font(16));

		ArrayList<String> rolesName = new ArrayList<String>();
		for (int i = 0; i < m.getCompany().getRoles().size(); i++) {
			rolesName.add(m.getCompany().getRoles().get(i).getRoleName());
		}

		cmbRole = new ComboBox<>();
		cmbRole.getItems().addAll(rolesName);
		HBox hbRole = new HBox();
		hbRole.getChildren().addAll(lRole, cmbRole);

		Label lPref = new Label("Choose your Preference: ");
		lPref.setFont(new Font(16));
		cmbPref = new ComboBox<ePref>();
		cmbPref.getItems().addAll(ePref.values());
		cmbPref.getItems().remove(ePref.values().length-1);
		HBox hbPref = new HBox();
		hbPref.getChildren().addAll(lPref, cmbPref);
		
		hoursNum = new ArrayList<>();
		housrStart = new ArrayList<>();
		for (int k = 0; k < 24; k++) {
			housrStart.add(k+":00");
			hoursNum.add(k);
		}

		Label lHours = new Label("Enter work start hour you want to start everyday: ");
		lHours.setFont(new Font(16));
		cmbHoursWorkStart = new ComboBox<>();
		cmbHoursWorkStart.getItems().addAll(housrStart);
		HBox hbhours = new HBox();
		hbhours.getChildren().addAll(lHours, cmbHoursWorkStart);
		
		Label lSales = new Label("Enter average daily sales: ");
		lSales.setFont(new Font(16));
		salesDaily = new TextField();
		salesDaily.setText("0");
		HBox hbSales = new HBox();
		hbSales.getChildren().addAll(lSales,salesDaily);

		details.getChildren().addAll(hbID, hbName, hbRole, hbPref, hbhours,hbSales);

		bp.setCenter(details);
		bp.setBottom(submitButton);

		scene = new Scene(bp, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();

	}

	public void addScreenPrintDepartment(Model model) {
		ScrollPane scroll = new ScrollPane();
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox vbDetails = new VBox();
		String e = "";
		for (int i = 0; i < model.getCompany().getAllDepartment().size(); i++) {
			e = e + model.getCompany().getAllDepartment().get(i).toString();
			e = e + "\n";
		}
		Text t = new Text(e);
		t.setFont(new Font(15));
		vbDetails.getChildren().add(t);
		bp.setCenter(vbDetails);

		scroll.setContent(bp);
		scroll.setPannable(false);

		scene = new Scene(scroll, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addScreenPrintRoles(Model model) {
		ScrollPane scroll = new ScrollPane();
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox vbDetails = new VBox();

		String e = "";
		for (int i = 0; i < model.getCompany().getRoles().size(); i++) {
			e = e + model.getCompany().getRoles().get(i).toString();
			e = e + "\n";
			e = e + "\n";
		}
		Text t = new Text(e);
		t.setFont(new Font(15));
		vbDetails.getChildren().add(t);
		bp.setCenter(vbDetails);

		scroll.setContent(bp);
		scroll.setPannable(false);

		scene = new Scene(scroll, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addScreenRole(Model m) {
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox details = new VBox();

		Text tRoleName = new Text("Enter a new role name: ");
		tRoleName.setFont(new Font(16));
		roleName = new TextField();
		HBox hbRoleName = new HBox();
		hbRoleName.getChildren().addAll(tRoleName, roleName);

		Label lTypeSalary = new Label("Choose the type of salary: ");
		lTypeSalary.setFont(new Font(16));
		cmbTypeSalary = new ComboBox<eTypeSalary>();
		cmbTypeSalary.getItems().addAll(eTypeSalary.values());
		HBox hbTypeSalary = new HBox();
		hbTypeSalary.getChildren().addAll(lTypeSalary, cmbTypeSalary);
		
		Label lChangable = new Label("Changable: ");
		lChangable.setFont(new Font(16));
		cmbChangable = new ComboBox<Boolean>();
		cmbChangable.getItems().addAll(Boolean.FALSE, Boolean.TRUE);
		HBox hbChangable = new HBox();
		hbChangable.getChildren().addAll(lChangable, cmbChangable);
		
		Label lSync = new Label("is Synchronizable: ");
		lSync.setFont(new Font(16));
		cmbSync = new ComboBox<Boolean>();
		cmbSync.getItems().addAll(Boolean.FALSE, Boolean.TRUE);
		HBox hbSync = new HBox();
		hbSync.getChildren().addAll(lSync, cmbSync);

		Text tSalary = new Text("Enter hour salary: ");
		tSalary.setFont(new Font(16));
		salary = new TextField();
		HBox hbSalary = new HBox();
		hbSalary.getChildren().addAll(tSalary, salary);

		Label lDepart = new Label("Choose Department the new Role belongs: ");
		lDepart.setFont(new Font(16));
		ArrayList<String> departmentName = new ArrayList<String>();
		for (int i = 0; i < m.getCompany().getAllDepartment().size(); i++) {
			departmentName.add(m.getCompany().getAllDepartment().get(i).getDepartmentName());
			
			
		}
		cmbDepartment = new ComboBox<>();
		cmbDepartment.getItems().addAll(departmentName);
		HBox hbDepart = new HBox();
		hbDepart.getChildren().addAll(lDepart, cmbDepartment);
		
		Label lWorkMethod = new Label("Choose work method: ");
		lWorkMethod.setFont(new Font(16));
		cmbWorkMethod = new ComboBox<ePref>();
		cmbWorkMethod.getItems().addAll(ePref.values());
		cmbWorkMethod.getItems().remove(ePref.values().length-1);
		HBox hbWorkMethod = new HBox();
		hbWorkMethod.getChildren().addAll(lWorkMethod, cmbWorkMethod);
		
		hoursNum = new ArrayList<>();
		housrStart = new ArrayList<>();
		for (int k = 0; k < 24; k++) {
			housrStart.add(k+":00");
			hoursNum.add(k);
		}
		Label lHours = new Label("Enter work start hour role start everyday: ");
		lHours.setFont(new Font(16));
		cmbHoursWorkStart = new ComboBox<>();
		cmbHoursWorkStart.getItems().addAll(housrStart);
		HBox hbhours = new HBox();
		hbhours.getChildren().addAll(lHours, cmbHoursWorkStart);

		details.getChildren().addAll(hbRoleName, hbTypeSalary, hbSalary, hbDepart, hbChangable,hbSync,hbWorkMethod, hbhours);

		bp.setCenter(details);
		bp.setBottom(submitButton);

		scene = new Scene(bp, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();

	}

	public void addScreenDepart(Model m) {
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox details = new VBox();

		Text tDepartName = new Text("Enter a new department name: ");
		tDepartName.setFont(new Font(16));
		departName = new TextField(); // get
		HBox hbDepartName = new HBox();
		hbDepartName.getChildren().addAll(tDepartName, departName);

		Label lChangable = new Label("Changable: ");
		lChangable.setFont(new Font(16));
		cmbChangable = new ComboBox<Boolean>();
		cmbChangable.getItems().addAll(Boolean.FALSE, Boolean.TRUE);
		HBox hbChangable = new HBox();
		hbChangable.getChildren().addAll(lChangable, cmbChangable);

		Label lSync = new Label("is Synchronizable: ");
		lSync.setFont(new Font(16));
		cmbSync = new ComboBox<Boolean>();
		cmbSync.getItems().addAll(Boolean.FALSE, Boolean.TRUE);
		HBox hbSync = new HBox();
		hbSync.getChildren().addAll(lSync, cmbSync);
		
		Label lWorkMethod = new Label("Choose work method: ");
		lWorkMethod.setFont(new Font(16));
		cmbWorkMethod = new ComboBox<ePref>();
		cmbWorkMethod.getItems().addAll(ePref.values());
		cmbWorkMethod.getItems().remove(ePref.values().length-1);
		HBox hbWorkMethod = new HBox();
		hbWorkMethod.getChildren().addAll(lWorkMethod, cmbWorkMethod);
		
		
		hoursNum = new ArrayList<>();
		housrStart = new ArrayList<>();
		for (int k = 0; k < 24; k++) {
			housrStart.add(k+":00");
			hoursNum.add(k);
		}
		Label lHours = new Label("Enter work start hour department start everyday: ");
		lHours.setFont(new Font(16));
		cmbHoursWorkStart = new ComboBox<>();
		cmbHoursWorkStart.getItems().addAll(housrStart);
		HBox hbhours = new HBox();
		hbhours.getChildren().addAll(lHours, cmbHoursWorkStart);

		details.getChildren().addAll(hbDepartName, hbChangable, hbWorkMethod, hbhours, hbSync);
		bp.setCenter(details);
		bp.setBottom(submitButton);

		scene = new Scene(bp, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addChangeDepart(Model m) {
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox details = new VBox();

		Label lDepart = new Label("Choose Department you want to change: ");
		lDepart.setFont(new Font(16));
		ArrayList<String> departmentName = new ArrayList<String>();
		for (int i = 0; i < m.getCompany().getAllDepartment().size(); i++) {
			departmentName.add(m.getCompany().getAllDepartment().get(i).getDepartmentName());
		}
		cmbDepartment = new ComboBox<>();
		cmbDepartment.getItems().addAll(departmentName);
		HBox hbDepart = new HBox();
		hbDepart.getChildren().addAll(lDepart, cmbDepartment);

		Label lWorkMethod = new Label("Choose new work method: ");
		lWorkMethod.setFont(new Font(16));
		cmbWorkMethod = new ComboBox<ePref>();
		cmbWorkMethod.getItems().addAll(ePref.values());
		cmbWorkMethod.getItems().remove(ePref.values().length-1);
		HBox hbWorkMethod = new HBox();
		hbWorkMethod.getChildren().addAll(lWorkMethod, cmbWorkMethod);
		
		hoursNum = new ArrayList<>();
		housrStart = new ArrayList<>();
		for (int k = 0; k < 24; k++) {
			housrStart.add(k+":00");
			hoursNum.add(k);
		}

		Label lHours = new Label("Enter work start hour you want to start everyday: ");
		lHours.setFont(new Font(16));
		cmbHoursWorkStart = new ComboBox<>();
		cmbHoursWorkStart.getItems().addAll(housrStart);
		HBox hbhours = new HBox();
		hbhours.getChildren().addAll(lHours, cmbHoursWorkStart);

		details.getChildren().addAll(hbDepart, hbWorkMethod,hbhours);
		bp.setCenter(details);
		bp.setBottom(submitButton);

		scene = new Scene(bp, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addChangeRole(Model m) {
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox details = new VBox();

		Label lRole = new Label("Choose the role you want to change: ");
		lRole.setFont(new Font(16));

		ArrayList<String> rolesName = new ArrayList<String>();
		for (int i = 0; i < m.getCompany().getRoles().size(); i++) {
			rolesName.add(m.getCompany().getRoles().get(i).getRoleName());
		}

		cmbRole = new ComboBox<>();
		cmbRole.getItems().addAll(rolesName);
		HBox hbRole = new HBox();
		hbRole.getChildren().addAll(lRole, cmbRole);

		Label lWorkMethod = new Label("Choose new work method: ");
		lWorkMethod.setFont(new Font(16));
		cmbWorkMethod = new ComboBox<ePref>();
		cmbWorkMethod.getItems().addAll(ePref.values());
		cmbWorkMethod.getItems().remove(ePref.values().length-1);
		HBox hbWorkMethod = new HBox();
		hbWorkMethod.getChildren().addAll(lWorkMethod, cmbWorkMethod);
		
		hoursNum = new ArrayList<>();
		housrStart = new ArrayList<>();
		for (int k = 0; k < 24; k++) {
			housrStart.add(k+":00");
			hoursNum.add(k);
		}

		Label lHours = new Label("Enter work start hour you want to start everyday: ");
		lHours.setFont(new Font(16));
		cmbHoursWorkStart = new ComboBox<>();
		cmbHoursWorkStart.getItems().addAll(housrStart);
		HBox hbhours = new HBox();
		hbhours.getChildren().addAll(lHours, cmbHoursWorkStart);

		details.getChildren().addAll(hbRole, hbWorkMethod, hbhours);
		bp.setCenter(details);
		bp.setBottom(submitButton);

		scene = new Scene(bp, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addScreenPrintEmployees(Model model) {
		ScrollPane scroll = new ScrollPane();
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox vbDetails = new VBox();

		String e = "";
		for (int i = 0; i < model.getCompany().getAllEmployees().size(); i++) {

			e = e + model.getCompany().getAllEmployees().get(i).toString();
			e = e + "\n";
			e = e + "\n";
		}
		Text t = new Text(e);
		t.setFont(new Font(15));
		vbDetails.getChildren().add(t);
		bp.setCenter(vbDetails);

		scroll.setContent(bp);
		scroll.setPannable(false);

		scene = new Scene(scroll, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	public void addScreenPrintDataProfit(Model model) {
		ScrollPane scroll = new ScrollPane();
		secondaryStage = new Stage();
		bp = new BorderPane();
		VBox vbDetails = new VBox();

		String e = "Daily Report:\n\nEmployees:\n\n";
		for (int i = 0; i < model.getCompany().getAllEmployees().size(); i++) {
			e = e + model.getCompany().getAllEmployees().get(i).getName();
			e = e + ": ";
			if (model.getCompany().getAllEmployees().get(i).getProfit() > 0) {
				e = e + model.getCompany().getAllEmployees().get(i).calculateProfit();
				e = e + " (NIS)  The company earned from this employee\n";
			} else if (model.getCompany().getAllEmployees().get(i).getProfit() < 0) {
				e = e + model.getCompany().getAllEmployees().get(i).calculateProfit();
				e = e + " (NIS)  The company lost from this employee\n";
			} else {
				e = e + model.getCompany().getAllEmployees().get(i).calculateProfit();
				e = e + " (NIS)  The company doesn't lose or earn from this employee\n";
			}
		}
		e = e + "\n\nDepartments:\n\n";
		for (int i = 0; i < model.getCompany().getAllDepartment().size(); i++) {
			e = e + model.getCompany().getAllDepartment().get(i).getDepartmentName();
			e = e + ": ";
			if (model.getCompany().getAllDepartment().get(i).getProfit() > 0) {
				e = e + model.getCompany().getAllDepartment().get(i).calculateProfit();
				e = e + "(NIS)  The company earn from this department\n";
			} else if (model.getCompany().getAllDepartment().get(i).getProfit() < 0) {
				e = e + model.getCompany().getAllDepartment().get(i).calculateProfit();
				e = e + "(NIS)  The company lost from this department\n";
			} else {
				e = e + model.getCompany().getAllDepartment().get(i).calculateProfit();
				e = e + "(NIS)  The company doesn't lose or earn from this department\n";
			}

		}
		double sumSales = 0;
		for(int i = 0; i < model.getCompany().getAllEmployees().size(); i++) {
			if(model.getCompany().getAllEmployees().get(i) instanceof EmployeeBaseAndSales) {
				EmployeeBaseAndSales e1 = (EmployeeBaseAndSales) model.getCompany().getAllEmployees().get(i);
				sumSales += e1.getSales();
			}
		}
		e = e + "\n\nCompany:\n\n";
		if (model.getCompany().getProfit() > 0) {
			e = e + "The company earned: " + model.getCompany().calculateProfit();
			e = e + "(NIS)\nCompany earned from sales:  ";
		} else if (model.getCompany().getProfit() < 0) {
			e = e + "The company lost: " + model.getCompany().calculateProfit();
			e = e + "(NIS)\nCompany earned from sales:  ";
		} else {
			e = e + "The company didn't lose or earn: " + model.getCompany().calculateProfit();
			e = e + "(NIS)\nCompany earned from sales: "; 
		}
		
		e = e +sumSales+"(NIS)";
		
		Text t = new Text(e);
		t.setFont(new Font(15));
		vbDetails.getChildren().add(t);
		bp.setCenter(vbDetails);

		scroll.setContent(bp);
		scroll.setPannable(false);

		scene = new Scene(scroll, 500, 500);
		this.secondaryStage.setScene(scene);
		this.secondaryStage.show();
	}

	
}
