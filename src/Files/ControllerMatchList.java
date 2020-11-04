package Files;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * This class is for Match list window. It sets the columns, gets all the information from the Matchlist, and stores them
 * inside the Tableview.
 * @author Group 1
 */

public class ControllerMatchList implements Initializable{
   
   private CoachingToolAdapter matchFile = new CoachingToolAdapter("Matches.bin");
   private MatchList matchArray = new MatchList();
   
	@FXML
	private Button returnBtn;
	@FXML
	private TableView<Match> matchList;
	@FXML
	private TableColumn<Match, MyDate> dateCol;
	@FXML
	private TableColumn<Match, String> locationCol;
	@FXML
	private TableColumn<Match, Integer> subCountCol;
	@FXML
   private TableColumn<Match, String> TypeCol;
	@FXML
	private Button btnRemoveMatch;

   /**
    *It sets the values to the tableview from the Match 
    * @param location  we don't use this, we can't delete them because it is abstract method.
    * @param resources we don't use this, we can't delete them because it is abstract method.
    */
	public void initialize(URL location, ResourceBundle resources) 
	{
		matchArray = matchFile.getAllMatches();
		
		dateCol.setCellValueFactory(new PropertyValueFactory<Match, MyDate>("Date"));
		locationCol.setCellValueFactory(new PropertyValueFactory<Match, String>("Location"));
		subCountCol.setCellValueFactory(new PropertyValueFactory<Match, Integer>("Substitutes"));
		TypeCol.setCellValueFactory(new PropertyValueFactory<Match, String>("Type"));
		
		matchList.getItems().addAll(matchArray.getAllMatches());
	}
	
	/**
	 * Gets the selected object from the tableview, and when this function is called, it removes it from the matchlist
	 * and saves it to the Matches.bin file. After it got saved, it Refreshes the tableview.
	 */
	
	  public void removeMatch()
	   {
	      Match match = matchList.getSelectionModel().getSelectedItem();
	      matchArray.removeMatch(match.getDate());
	      matchFile.saveMatches(matchArray);
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Match has been removed successfully!");
         alert.setContentText("Match has been removed!");
         alert.showAndWait();
	      refreshTable();
	   }
	  
	  /**
	   * Refreshes the tableview, and calls the initialize method.
	   */
	  
	   public void refreshTable()
	   {
	      matchList.getItems().clear();
	      initialize(null,null);
	   }
	   /**
	    * Returns to the Menu
	    * @param event event caused by button clicked
	    * @throws IOException thrown if fxml file can't be read
	    */
	public void returnToMain(ActionEvent event) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   loader.setLocation(getClass().getResource("designMatch.fxml"));
		   
		   Parent mainViewParent = loader.load();
		   Scene mainViewScene = new Scene(mainViewParent);
		   
		   Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		   window.setScene(mainViewScene);
		   window.show();
	   }
}
