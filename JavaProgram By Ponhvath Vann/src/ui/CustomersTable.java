package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.RegularCustomer;

import javax.swing.JTable;

public class CustomersTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = {"Membership Class", "First Name", "Last Name", "Age", "Gender", "Phone Number", "Email Address"};
	private Object[][] data = new Object[][]{};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersTable frame = new CustomersTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomersTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}
	
	public void populateTable(ArrayList<RegularCustomer> customerDetails)
	{
		
		for(RegularCustomer line: customerDetails) // For data in each line
		{
		
				StringTokenizer tokenizer = new StringTokenizer(","); 
				
				
				String membershipClass = tokenizer.nextToken();
				String firstName = tokenizer.nextToken();
				String lastName = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String gender = tokenizer.nextToken();
				int phoneNumber = Integer.parseInt(tokenizer.nextToken());
				String emailAddress = tokenizer.nextToken();
				
				Object[] row = {membershipClass,firstName,lastName,age,gender,phoneNumber,emailAddress};
				
				
				DefaultTableModel model = (DefaultTableModel) this.table.getModel();
				
				model.addRow(row);
				
		
		}
	}
}
