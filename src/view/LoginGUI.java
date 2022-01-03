package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.*;
import Model.HeadDoctor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel w_panel;
	private JTextField fild_pasport;
	private JTextField fild_password;
	private JTextField fild_doctor_pasp;
	private JPasswordField fild_docotr_passw;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setTitle("Medical Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_panel = new JPanel();
		w_panel.setBackground(Color.WHITE);
		w_panel.setForeground(Color.BLACK);
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setLayout(null);

		JLabel lbl_Logo = new JLabel(new ImageIcon(getClass().getResource("Logo.png")));
		lbl_Logo.setBounds(186, 23, 100, 55);
		w_panel.add(lbl_Logo);

		JLabel Welcome_lbl = new JLabel("Welcome to Control Panel");
		Welcome_lbl.setBounds(103, 75, 266, 30);
		Welcome_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		w_panel.add(Welcome_lbl);

		JTabbedPane w_tabepanel = new JTabbedPane(JTabbedPane.TOP);
		w_tabepanel.setBounds(10, 115, 476, 247);
		w_panel.add(w_tabepanel);

		JPanel w_patient = new JPanel();
		w_patient.setBackground(Color.WHITE);
		w_tabepanel.addTab("Patient Join", null, w_patient, null);
		w_patient.setLayout(null);

		JLabel Pasp_lbl = new JLabel("Passport:");
		Pasp_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		Pasp_lbl.setBounds(10, 12, 105, 30);
		w_patient.add(Pasp_lbl);

		JLabel Pass_lbl = new JLabel("Password:");
		Pass_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		Pass_lbl.setBounds(10, 50, 105, 30);
		w_patient.add(Pass_lbl);

		fild_pasport = new JTextField();
		fild_pasport.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		fild_pasport.setBounds(112, 21, 307, 19);
		w_patient.add(fild_pasport);
		fild_pasport.setColumns(10);

		fild_password = new JTextField();
		fild_password.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		fild_password.setColumns(10);
		fild_password.setBounds(112, 59, 307, 19);
		w_patient.add(fild_password);

		JButton btn_Register_Patient = new JButton("Register");
		btn_Register_Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Register_Patient.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		btn_Register_Patient.setBounds(10, 135, 191, 51);
		w_patient.add(btn_Register_Patient);

		JButton btn_Login_Patient = new JButton("Login");
		btn_Login_Patient.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		btn_Login_Patient.setBounds(255, 135, 191, 51);
		w_patient.add(btn_Login_Patient);

		JPanel w_personal = new JPanel();
		w_personal.setBackground(Color.WHITE);
		w_tabepanel.addTab("Personal Join", null, w_personal, null);
		w_personal.setLayout(null);

		JLabel Pasp_lbl_1 = new JLabel("Passport:");
		Pasp_lbl_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		Pasp_lbl_1.setBounds(25, 20, 105, 30);
		w_personal.add(Pasp_lbl_1);

		JLabel Pass_lbl_1 = new JLabel("Password:");
		Pass_lbl_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		Pass_lbl_1.setBounds(25, 58, 105, 30);
		w_personal.add(Pass_lbl_1);

		fild_doctor_pasp = new JTextField();
		fild_doctor_pasp.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		fild_doctor_pasp.setColumns(10);
		fild_doctor_pasp.setBounds(127, 29, 307, 19);
		w_personal.add(fild_doctor_pasp);

		JButton btn_Login_Personal = new JButton("Login");
		btn_Login_Personal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fild_doctor_pasp.getText().length() == 0 || fild_docotr_passw.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {

					try {
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select * from user1");
						while (rs.next()) {
							if (fild_doctor_pasp.getText().equals(rs.getString("pasp"))
									&& fild_docotr_passw.getText().equals(rs.getString("password"))) {
								HeadDoctor head = new HeadDoctor();
								head.setId(rs.getInt("id"));
								head.setPassword("password");
								head.setPasp(rs.getString("pasp"));
								head.setName(rs.getString("name"));
								head.setType(rs.getString("type"));
								HeadDoctorGUI hGUI = new HeadDoctorGUI(head);
								hGUI.setVisible(true);
								dispose();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_Login_Personal.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		btn_Login_Personal.setBounds(25, 143, 436, 51);
		w_personal.add(btn_Login_Personal);

		fild_docotr_passw = new JPasswordField();
		fild_docotr_passw.setBounds(128, 69, 306, 19);
		w_personal.add(fild_docotr_passw);
	}
}
