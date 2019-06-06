package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Admin;
import dataController.DataController;
import ui.RegisterAdminInterface;

public class RegisterAdminActionListener implements ActionListener{
	
	private RegisterAdminInterface ui;
	private DataController dataHandler;
	
	ArrayList<Admin> adminDetails = DataController.readFileAdmin("data/usernamePassword.csv");

	
	
	
	public RegisterAdminActionListener(RegisterAdminInterface ui, DataController dataHandler) {
		
		this.ui = ui;
		this.dataHandler = dataHandler;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ui.getBtnSignUp()) {
			
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				String registerUsername = ui.getRegisterUsernameTxtField().getText();
				String registerPassword = ui.getRegisterPasswordField().getText();
				Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Data validation
			    if (registerUsername==null || registerPassword==null) {
			    	Error_Message  += "+ Membership Class and Gender must be filled.\n";
			    	all_data_valid = false;
			    }
			    
			    if(registerUsername.length() < 3)
				{
					Error_Message  += "+ Username must be at least 4 characters.\n";
					all_data_valid = false;
				}
			
				if (registerPassword.length() < 3) {
					Error_Message += "+ Password must be at least 4 characters.\n";
					all_data_valid = false;
				}
				
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					
					String CSV_String = registerUsername + "," + registerPassword;
					this.dataHandler.writeUsernamePasswordData(CSV_String);
					JOptionPane.showMessageDialog(ui, "Your details have been saved", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					//reset form
					ui.getRegisterUsernameTxtField().setText(null);
					ui.getRegisterPasswordField().setText(null);
					
				}
				else
				{
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
	
	


