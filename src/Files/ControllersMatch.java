package Files;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This specifies the main page. Sets the methods for the MatchList button,Playerlist button and so on.
 * @author Group 1
 */

public class ControllersMatch
{

	   @FXML
	   private Button exitBtn;
	   
	   @FXML
	   private Button PlayerListBtn;
	   
	   @FXML
	   private Button addPlayerBtn;
	   
	   @FXML
	   private Button friendlyMatchBtn;
	   
	   @FXML
	   private Button addMatchBtn;
      /**
       * openPlayerList - Opens the playerList page.
       * @param event - event caused by button clicked
       * @throws IOException thrown if fxml file can't be read
       */
	   public void openPlayerList(ActionEvent event) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("designListPlayer.fxml"));
		   
		   Parent playerViewParent = loader.load();
		   Scene playerViewScene = new Scene(playerViewParent);
		   
		   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		   window.setScene(playerViewScene);
		   window.show();
	   }
	   
	    /**
	     * Opens the AddPlayer page.
	     * @param event - event caused by button clicked
	     * @throws IOException thrown if fxml file can't be read
	     */
	   public void openAddPlayer(ActionEvent event) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("designAddPlayerFile.fxml"));
		   
		   Parent addplayerViewParent = loader.load();
		   Scene addplayerViewScene = new Scene(addplayerViewParent);
		   
		   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		   window.setScene(addplayerViewScene);
		   window.show();
	   }
      /**
       * Opens the MatchList page.
       * @param event - event caused by button clicked
       * @throws IOException thrown if fxml file can't be read
       */
	   public void openFriendlyMatch(ActionEvent event) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("designFriendlyMatch.fxml"));
		   
		   Parent friendlymatchViewParent = loader.load();
		   Scene friendlymatchViewScene = new Scene(friendlymatchViewParent);
		   
		   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		   window.setScene(friendlymatchViewScene);
		   window.show();
	   }
      /**
       * Opens the AddMatch page.
       * @param event - event caused by button clicked
       * @throws IOException thrown if fxml file can't be read
       */
	   public void openAddMatch(ActionEvent event) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("designAddMatchList.fxml"));
		   
		   Parent addmatchViewParent = loader.load();
		   Scene addmatchViewScene = new Scene(addmatchViewParent);
		   
		   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		   window.setScene(addmatchViewScene);
		   window.show();
	   }
	   
      /**
       * Exits the program.
       */
	   public void exitProgram() {
		   System.exit(0);
	   }
   
   
   
}