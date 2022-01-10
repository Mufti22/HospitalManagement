package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Doctor;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

import Helper.Helper;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DoctorGUI extends JFrame {

	private JPanel w_pane;
	private static Doctor doctor =  new Doctor();
	private JTable table_whour;
	private DefaultTableModel whourModel;
	private Object[] whourData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorGUI frame = new DoctorGUI(doctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DoctorGUI(Doctor doctor) throws SQLException {
		
		whourModel = new DefaultTableModel();
		Object[] colWhour = new Object[2];
		colWhour[0] = "ID";
		colWhour[1] = "Date";
		whourModel.setColumnIdentifiers(colWhour);
		whourData = new Object[2];
		for(int i=0; i< doctor.getWhourList(doctor.getId()).size(); i++) {
			whourData[0] = doctor.getWhourList(doctor.getId()).get(i).getId();
			whourData[1] = doctor.getWhourList(doctor.getId()).get(i).getWdate();
			whourModel.addRow(whourData);
		}
		
		setResizable(false);
		setTitle("Doctor Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome, " + doctor.getName());
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 201, 24);
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnNewButton.setBounds(608, 11, 85, 21);
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tabepane = new JTabbedPane(JTabbedPane.TOP);
		w_tabepane.setBackground(Color.WHITE);
		w_tabepane.setBounds(10, 56, 716, 406);
		w_pane.add(w_tabepane);
		
		JPanel w_whour = new JPanel();
		w_whour.setBackground(Color.WHITE);
		w_tabepane.addTab("Work Time", null, w_whour, null);
		w_whour.setLayout(null);
		
		JDateChooser select_date = new JDateChooser();
		select_date.setBounds(0, 10, 130, 20);
		w_whour.add(select_date);
		
		JComboBox select_time = new JComboBox();
		select_time.setModel(new DefaultComboBoxModel(new String[] {"10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "14:00", "14:30", "15:30"}));
		select_time.setBounds(140, 9, 60, 20);
		w_whour.add(select_time);
		
		JButton btn_addWhour = new JButton("Add");
		btn_addWhour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(select_date.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date.length() == 0) {
					Helper.showMsg("Error Time");
				}
				
				else {
					
					String time = " " + select_time.getSelectedItem().toString() + ":00";
					String SelectDate = date + time;
					try {
						boolean control = doctor.addWhour(doctor.getId(), doctor.getName(), SelectDate);
						if(control) {
							Helper.showMsg("Great!");
							updateWhourModel(doctor);
						}
						else {
							Helper.showMsg("Error!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btn_addWhour.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btn_addWhour.setBounds(210, 10, 85, 20);
		w_whour.add(btn_addWhour);
		
		JScrollPane w_scrollWhour = new JScrollPane();
		w_scrollWhour.setBounds(0, 40, 711, 339);
		w_whour.add(w_scrollWhour);
		
		table_whour = new JTable(whourModel);
		w_scrollWhour.setViewportView(table_whour);
	}
	
	public void updateWhourModel(Doctor doctor) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_whour.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i< doctor.getWhourList(doctor.getId()).size(); i++) {
			whourData[0] = doctor.getWhourList(doctor.getId()).get(i).getId();
			whourData[1] = doctor.getWhourList(doctor.getId()).get(i).getWdate();
			whourModel.addRow(whourData);
		}
	}
}
