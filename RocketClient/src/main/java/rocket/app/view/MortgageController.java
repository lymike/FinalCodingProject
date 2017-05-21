package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML private TextField txtCreditScore;
	@FXML private TextField txtIncome;
	@FXML private TextField txtExpenses;
	@FXML private TextField txtHouseCost;
	@FXML private TextField txtDownPayment;

	@FXML private Label lblMortgageTerm;
	@FXML private Label lblCreditScore;
	@FXML private Label lblDownPayment;
	@FXML private Label lblHouseCost;
	@FXML private Label lblIncome;
	@FXML private Label lblExpenses;
	@FXML private Label lblCalculatedPayment;
	@FXML private Label lblCalculation;
	
	@FXML ComboBox<Integer> cbTerm;
	
	@FXML private Button btnCalculate;
	
	@FXML private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		cbTerm.getItems().addAll(15, 30);
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		/*Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});*/
		LoanRequest lrq = new LoanRequest();
		
		lrq.setdAmount(Double.parseDouble(txtHouseCost.getCharacters().toString()));
		lrq.setiCreditScore(Integer.parseInt(txtCreditScore.getCharacters().toString()));
		lrq.setiDownPayment(Integer.parseInt(txtDownPayment.getCharacters().toString()));
		lrq.setiTerm(cbTerm.getValue() * 12);
		lrq.setIncome(Double.parseDouble(txtIncome.getCharacters().toString())/12);
		lrq.setExpenses(Double.parseDouble(txtExpenses.getCharacters().toString()));
		
		mainApp.messageSend(lrq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		
		double piti;
		
		if ((lRequest.getIncome()*28) < (lRequest.getIncome()*36 - lRequest.getExpenses())) {
			piti = lRequest.getIncome()*28;
		}
		else {
			piti = lRequest.getIncome()*36 - lRequest.getExpenses();
		}
		
		if(lRequest.getdRate() == 0) {
			lblCalculation.setText("Your Credit Score is too low.");
		}
		else if(lRequest.getdPayment() > piti) {
			lblCalculation.setText("House Cost too high.");
		}
		else {
			lblCalculation.setText("Your monthly payment: " + String.format("%.2f", lRequest.getdPayment()));
		}
	}
}
