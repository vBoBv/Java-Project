package main;

import java.util.ArrayList;

import javax.swing.JButton;
import data.Admin;
import data.GoldCustomer;
import data.RegularCustomer;
import data.SilverCustomer;
import dataController.DataController;
import listener.AdminSignInActionListener;
import listener.ChangeMemberDetailsActionListener;
import listener.HomePageActionListener;
import listener.ManageMemberActionListener;

import listener.NormalPaymentActionListener;
import listener.ProcessPaymentActionListener;
import listener.RegisterAdminActionListener;
import listener.RegisterMemberActionListener;
//import listener.ViewAndChangeNormalCustomerActionListener;
import ui.LoginInterface;
import ui.RegisterAdminInterface;
import ui.RegisterMember;
import ui.ViewAndChangeCustomerDetails;


public class MyApplication {

	public static void main(String[] args) {
				
				
				System.out.println("Program has been opened.");
				//Read Data
				ArrayList<Admin> adminDetails;
				adminDetails = DataController.readFileAdmin("data/usernamePassword.csv");
				ArrayList<RegularCustomer> customerDetails;
				customerDetails = DataController.readFile("data/customerDetails.csv");
				ArrayList<SilverCustomer> silverCustomerDetails;
				silverCustomerDetails = DataController.readFile1("data/silverCustomerDetails.csv");
				ArrayList<GoldCustomer> goldCustomerDetails;
				goldCustomerDetails = DataController.readFile2("data/goldCustomerDetails.csv");
//				System.out.println("File has been read.");
//				System.out.println(adminDetails);
//				System.out.println(customerDetails);
//				System.out.println(silverCustomerDetails);
//				System.out.println(goldCustomerDetails);
		 
				//Call a GUI
				LoginInterface ui = new LoginInterface();
				ui.setVisible(true);
				DataController dc = new DataController();
				
				//Listener to Sign In
				AdminSignInActionListener listenerForAdminSignIn = new AdminSignInActionListener(ui,dc);
				JButton signInButton = ui.getBtnLogin();
				signInButton.addActionListener(listenerForAdminSignIn);
				
				RegisterMember ui1 = new RegisterMember(); 
				RegisterMemberActionListener listenerForRegisterMember = new RegisterMemberActionListener(ui1,dc); 
				
				//Lister for HomePage
				HomePageActionListener listenerForHomePage = new HomePageActionListener(ui1,dc);
				JButton signOutAdmin = ui1.getBtnSignOut();
				signOutAdmin.addActionListener(listenerForHomePage);
				
				//Listener to Register
				JButton registerMember = ui1.getBtnRegister();
				registerMember.addActionListener(listenerForRegisterMember);
				
				//Listener to Manage Member 
				ManageMemberActionListener listenerForManageMember = new ManageMemberActionListener(ui1,dc);
				JButton manageMember = ui1.getBtnManageMember();
				manageMember.addActionListener(listenerForManageMember);
				
				JButton viewAndChangeMember = ui1.getBtnNormalViewchangeDetails();
				viewAndChangeMember.addActionListener(listenerForManageMember);
				
				JButton viewAndChangeMemberSilver = ui1.getBtnSilverViewchangeDetails();
				viewAndChangeMemberSilver.addActionListener(listenerForManageMember);
				
				JButton viewAndChangeMemberGold = ui1.getBtnGoldViewchangeDetails();
				viewAndChangeMemberGold.addActionListener(listenerForManageMember);
				
				JButton removeRegularMember = ui1.getBtnRemoveRegular();
				removeRegularMember.addActionListener(listenerForManageMember);
				
				JButton removeSilverMember = ui1.getBtnRemoveSilver();
				removeSilverMember.addActionListener(listenerForManageMember);
				
				JButton removeGoldMember = ui1.getBtnRemoveGold();
				removeGoldMember.addActionListener(listenerForManageMember);
				
				//Listener for Membership Payment
				ProcessPaymentActionListener listenerForProcessPayment = new ProcessPaymentActionListener(ui1,dc);
				JButton membershipPayment = ui1.getBtnProcessPayment();
				membershipPayment.addActionListener(listenerForProcessPayment);
				
				JButton proceedPayment = ui1.getBtnProceed();
				proceedPayment.addActionListener(listenerForProcessPayment);
				
				JButton confirmPayment = ui1.getBtnConfirmPayment();
				confirmPayment.addActionListener(listenerForProcessPayment);
				
				JButton calculatePayment = ui1.getBtnCalculate();
				calculatePayment.addActionListener(listenerForProcessPayment);
				
				//Listener for Normal Payment
				NormalPaymentActionListener listenerForNormalPayment = new NormalPaymentActionListener(ui1,dc);
				JButton normalPayment = ui1.getBtnUpdatePromotions();
				normalPayment.addActionListener(listenerForNormalPayment);
				
				JButton checkoutPayment = ui1.getBtnNormalPaymentCheckOut();
				checkoutPayment.addActionListener(listenerForNormalPayment);
				
				//Listener for Change Member Details
				ChangeMemberDetailsActionListener listenerForChangeMemberDetails= new ChangeMemberDetailsActionListener(ui1,dc);
				JButton modifyMember = ui1.getBtnModifyMemberDetail();
				modifyMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton editNormalMember = ui1.getBtnEdit();
				editNormalMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton editSilverMember = ui1.getBtnEditThisSilver();
				editSilverMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton editGoldMember = ui1.getBtnEditThisGold();
				editGoldMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton updateNormalMember = ui1.getBtnUpdate();
				updateNormalMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton updateSilverMember = ui1.getBtnUpdateSilver();
				updateSilverMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton updateGoldMember = ui1.getBtnUpdateGold();
				updateGoldMember.addActionListener(listenerForChangeMemberDetails);
				
				JButton searchMember = ui1.getBtnSearch();
				searchMember.addActionListener(listenerForChangeMemberDetails);
				
				

	}

}
