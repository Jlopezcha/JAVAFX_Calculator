package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {

	
	@FXML
	private Label result;
	private long num1 = 0, num2 = 0;
	private String operator = "";
	private boolean start = true;
	Model model = new Model();
	
	
	//assigns the first number when app starts or results
	@FXML
	public void processNumbers(ActionEvent event)
	{
		//reset result to blank instead of carrying over calculation
		if(start)
		{
			result.setText("");
			start = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
		
		
	}
	
	//assigns operator values and calculate result
	@FXML
	public void processOperators(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();
		
		if(!value.equals("=")) {
			if(!operator.isEmpty())
				return;
			
			operator = value;
			num1 = Long.parseLong(result.getText());
			
			//Square root can only take one number
			if(operator.equals("Sqrt"))
			{
								
				float output = model.calculate(num1, num2, operator);
				result.setText(String.valueOf(output));
				operator = "";
				start = true;
				return;
			}
				
			
			result.setText("");
		}
		else {
			if(operator.isEmpty())
				return;
		
			num2 = Long.parseLong(result.getText());
			float output = model.calculate(num1, num2, operator);
			result.setText(String.valueOf(output));
			operator = "";
			start = true;
					
		}
			
	}
}
