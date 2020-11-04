package Files;

import javafx.application.Application;

/*
 * @author Group 1
 * Launches the Application.
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Class which is used to launch the application
 * @author Group 1
 */
public class MainApp extends Application {
  
   /**
    * Launches the application with the mainView.fxml(Design)
    * Sets the window title. 
    */
	@Override
	public void start(Stage stage) throws Exception
	{
	  stage.setTitle("VIA Football Club");
      FXMLLoader loader= new FXMLLoader();
      loader.setLocation(getClass().getResource("MainView.fxml"));
      
      Scene scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.show();
	  
	}
	
	/**
	 * Launches the program.
	 * @param args  arguments
	 */

	public static void main(String[] args) {
		launch(args);
	}
}
