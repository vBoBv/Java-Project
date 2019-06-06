
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dataController.DataController;
import ui.RegisterMember;
import data.GoldCustomer;
import data.RegularCustomer;
import data.SilverCustomer;

public class NormalPaymentActionListener implements ActionListener {
	
	private RegisterMember ui;
	private DataController dataHandler;
	
	double blueRayPrice = 8.00;
	double dvdPrice = 5.00;
	static double blueRayTotalPrice;
	static double dvdTotalPrice;
	double discTotalPrice;
	
	public static double calculateBlueRayTotalPrice(double blueRayPrice, double quantity) {
		blueRayTotalPrice = blueRayPrice * quantity;
		return blueRayTotalPrice;
	}
	
	public static double calculateDvdTotalPrice(double dvdPrice, double quantity) {
		dvdTotalPrice = dvdPrice * quantity;
		return dvdTotalPrice;
	}
	
	public double sumTotalPrice(double blueRayTotalPrice, double dvdTotalPrice) {
		discTotalPrice = blueRayTotalPrice + dvdTotalPrice;
		return discTotalPrice;
	}

	public NormalPaymentActionListener(RegisterMember ui, DataController dataHandler )
	{
		
		this.ui = ui;
		this.dataHandler = dataHandler;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ui.getBtnUpdatePromotions()) {
			
			
			ui.getBlueRaySpinner().addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					String blueRaySelectedQuantity = ui.getBlueRaySpinner().getValue().toString(); 
					String dvdSelectedQuantity = ui.getDvdSpinner().getValue().toString();
					Integer blueRaySelectedQuantityDouble = (Integer) ui.getBlueRaySpinner().getValue(); //Convert into int for calculation
					Integer dvdSelectedQuantityDouble = (Integer) ui.getDvdSpinner().getValue(); //Convert into int for calculation
					
					ui.getBlueRayQuan().setText(String.valueOf(blueRaySelectedQuantity));
					//Call the method to calculate the BlueRay Total price
					calculateBlueRayTotalPrice(blueRayPrice,blueRaySelectedQuantityDouble);
					ui.getBlueRaySumPrice().setText(String.valueOf("$" + blueRayTotalPrice));
					//Call the method to calculate the Total price of BlueRay and DVD
					sumTotalPrice(blueRayTotalPrice,dvdTotalPrice);
					ui.getDiscSumPrice().setText(String.valueOf("$"+ discTotalPrice));
				}
			});
			ui.getDvdSpinner().addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					String blueRaySelectedQuantity = ui.getBlueRaySpinner().getValue().toString();
					String dvdSelectedQuantity = ui.getDvdSpinner().getValue().toString();
					Integer blueRaySelectedQuantityDouble = (Integer) ui.getBlueRaySpinner().getValue(); //Convert into int for calculation
					Integer dvdSelectedQuantityDouble = (Integer) ui.getDvdSpinner().getValue(); //Convert into int for calculation
					
					ui.getDvdQuan().setText(String.valueOf(dvdSelectedQuantity));
					//Call the method to calculate the DVD Total price
					calculateDvdTotalPrice(dvdPrice,dvdSelectedQuantityDouble);
					ui.getDvdSumPrice().setText(String.valueOf("$" + dvdTotalPrice));
					//Call the method to calculate the Total price of BlueRay and DVD
					sumTotalPrice(blueRayTotalPrice,dvdTotalPrice);
					ui.getDiscSumPrice().setText(String.valueOf("$"+ discTotalPrice));
				}
			});
		}
	
		else if (e.getSource() == ui.getBtnNormalPaymentCheckOut()) {
			
			//confirm form submission
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			if(confirmation == JOptionPane.YES_OPTION ) {
				
				String blueRaySelectedQuantity = ui.getBlueRaySpinner().getValue().toString();
				String dvdSelectedQuantity = ui.getDvdSpinner().getValue().toString();
				Integer blueRaySelectedQuantityDouble = (Integer) ui.getBlueRaySpinner().getValue();
				Integer dvdSelectedQuantityDouble = (Integer) ui.getDvdSpinner().getValue();
				Boolean all_data_valid = true;
				String Error_Message = "";
				
			
				
				//Data Validation
				
				if(blueRaySelectedQuantityDouble == 0 && dvdSelectedQuantityDouble == 0) {
					Error_Message  += "+ Both DVD types cannot be empty.\n";
			    	all_data_valid = false;
				}
					
				
				if (all_data_valid == true)	{
					JOptionPane.showMessageDialog(ui, "+ Payment has been completed.", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					//Reset all the fields
					ui.getBlueRaySpinner().setValue(0);
					ui.getDvdSpinner().setValue(0);
					ui.getBlueRayQuan().setText("0");
					ui.getDvdQuan().setText("0");
					ui.getBlueRaySumPrice().setText("$0.00");
					ui.getDvdSumPrice().setText("$0.00");
					ui.getDiscSumPrice().setText("$0.00");
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




	





