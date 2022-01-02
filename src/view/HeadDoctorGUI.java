package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Helper.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.HeadDoctor;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HeadDoctorGUI extends JFrame {
	static HeadDoctor headdoctor = new HeadDoctor();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dPassp;
	private JTextField fld_dPassw;
	private JTextField fld_doctorID;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadDoctorGUI frame = new HeadDoctorGUI(headdoctor);
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
	public HeadDoctorGUI(HeadDoctor headdoctor) throws SQLException {
		
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Name";
		colDoctorName[2] = "Passport";
		colDoctorName[3] = "Password";
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for(int i = 0; i < headdoctor.getDoctorList().size(); i++ ) {
			doctorData[0]= headdoctor.getDoctorList().get(i).getId();
			doctorData[1]= headdoctor.getDoctorList().get(i).getName();
			doctorData[2]= headdoctor.getDoctorList().get(i).getPasp();
			doctorData[3]= headdoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		
		setTitle("Head Doctor Panel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + headdoctor.getName());
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 201, 24);
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnNewButton.setBounds(608, 11, 85, 21);
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tabepane = new JTabbedPane(JTabbedPane.TOP);
		w_tabepane.setBackground(Color.WHITE);
		w_tabepane.setBounds(10, 56, 716, 406);
		w_pane.add(w_tabepane);
		
		JPanel w_doctor = new JPanel();
		w_doctor.setBackground(Color.WHITE);
		w_tabepane.addTab("Doctor Management", null, w_doctor, null);
		w_doctor.setLayout(null);
		
		JLabel label_name = new JLabel("Name");
		label_name.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label_name.setBounds(517, 10, 47, 29);
		w_doctor.add(label_name);
		
		fld_dName = new JTextField();
		fld_dName.setBounds(517, 41, 163, 21);
		w_doctor.add(fld_dName);
		fld_dName.setColumns(10);
		
		JLabel label_1_pasp = new JLabel("Passport");
		label_1_pasp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label_1_pasp.setBounds(517, 72, 63, 29);
		w_doctor.add(label_1_pasp);
		
		fld_dPassp = new JTextField();
		fld_dPassp.setColumns(10);
		fld_dPassp.setBounds(517, 111, 163, 21);
		w_doctor.add(fld_dPassp);
		
		JLabel label_2_passw = new JLabel("Password");
		label_2_passw.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label_2_passw.setBounds(517, 142, 89, 29);
		w_doctor.add(label_2_passw);
		
		JButton btn_addDoctor = new JButton("Add Doctor");
		btn_addDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_dName.getText().length() == 0 || fld_dPassp.getText().length() == 0 || fld_dPassw.getText().length() == 0 ) {
					Helper.showMsg("fill");
				} else {
					try {
						boolean control = headdoctor.addDoctor (fld_dName.getText(), fld_dPassp.getText(), fld_dPassw.getText());
						if(control) {
							Helper.showMsg("sucsess");
							fld_dName.setText(null);
							fld_dPassp.setText(null);
							fld_dPassw.setText(null);
							updateDoctorModel();
						}
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btn_addDoctor.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btn_addDoctor.setBounds(517, 224, 131, 21);
		w_doctor.add(btn_addDoctor);
		
		fld_dPassw = new JTextField();
		fld_dPassw.setColumns(10);
		fld_dPassw.setBounds(517, 181, 163, 21);
		w_doctor.add(fld_dPassw);
		
		JLabel label_3_id = new JLabel("Doctor ID");
		label_3_id.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label_3_id.setBounds(517, 268, 89, 29);
		w_doctor.add(label_3_id);
		
		fld_doctorID = new JTextField();
		fld_doctorID.setColumns(10);
		fld_doctorID.setBounds(517, 307, 163, 21);
		w_doctor.add(fld_doctorID);
		
		JButton btn_delDoctor_2 = new JButton("Delete Doctor");
		btn_delDoctor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_doctorID.getText().length() == 0) {
					Helper.showMsg("Please choose the correct ID !");
				}
				else {
					if(Helper.confirm("sure")) {
						int selectId = Integer.parseInt(fld_doctorID.getText());
						try {
							boolean control = headdoctor.deleteDoctor(selectId);
							if(control) {
								Helper.showMsg("success");
								fld_doctorID.setText(null);
								updateDoctorModel();
							}
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}

				}
				
			}
		});
		btn_delDoctor_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btn_delDoctor_2.setBounds(517, 338, 131, 21);
		w_doctor.add(btn_delDoctor_2);
		
		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 10, 497, 359);
		w_doctor.add(w_scrollDoctor);
		
		table_doctor = new JTable(doctorModel);
		w_scrollDoctor.setViewportView(table_doctor);
		table_doctor.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					fld_doctorID.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
				} catch(Exception ex) {
					
				}
				
			}
		});
			table_doctor.getModel().addTableModelListener(new TableModelListener() {
				public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectId = Integer.parseInt(table_doctor.getValueAt(table_doctor.getSelectedRow(),0).toString());
					String selectName = table_doctor.getValueAt(table_doctor.getSelectedRow(),1).toString();
					String selectPasp = table_doctor.getValueAt(table_doctor.getSelectedRow(),2).toString();
					String selectPassw = table_doctor.getValueAt(table_doctor.getSelectedRow(),3).toString();
					try {
						boolean control =headdoctor.updateDoctor(selectId, selectPasp, selectPassw, selectName);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				
			});
	}
	
	public void updateDoctorModel () throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i < headdoctor.getDoctorList().size(); i++ ) {
			doctorData[0]= headdoctor.getDoctorList().get(i).getId();
			doctorData[1]= headdoctor.getDoctorList().get(i).getName();
			doctorData[2]= headdoctor.getDoctorList().get(i).getPasp();
			doctorData[3]= headdoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}
}
