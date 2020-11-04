package Files;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * A Controller for MainView, which displays if the user wants to proceed or not.
 * @author Group 1
 */

public class ControllerMain
{
   
   @FXML
   private Button yesBtn;
   
   @FXML
   private Button noBtn;
   
   @FXML
   private Button returnBtn;
   
   /**
    * If user pressed Yes, then it calls this method, and opens the Main menu.
    * @param event event caused by button clicked
    * @throws IOException thrown if fxml file can't be read
    */
   public void proceed(ActionEvent event) throws IOException {
	   FXMLLoader loader = new FXMLLoader();
	   loader.setLocation(getClass().getResource("designMatch.fxml"));
	   
	   Parent mainViewParent = loader.load();
	   Scene mainViewScene = new Scene(mainViewParent);
	   
	   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
	   window.setScene(mainViewScene);
	   window.show();
   }
   /**
    * If this method is called, then the application will quit.
    */
   
   public void exitProgram() {
	   System.exit(0);
   }
   
}
