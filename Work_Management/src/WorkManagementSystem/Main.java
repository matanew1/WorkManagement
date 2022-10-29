package WorkManagementSystem;

import java.io.File;
import MVC.Controller;
import MVC.Model;
import MVC.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		Model model;
		File f = new File("company.dat");
		if (f.exists()) {
			model = new Model(f);
			System.out.println("Read data");
		}
		else {
			model = new Model();//data	
			System.out.println("normal");
		}
	
		View view = new View(stg);	
		Controller controller = new Controller(model, view); //handle everything
	}


}
