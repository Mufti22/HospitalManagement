package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Clinic;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_ClinicName;
	private static Clinic clinic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
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
	public UpdateClinicGUI(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 150);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_name_1 = new JLabel("Polyclinc Name");
		label_name_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		label_name_1.setBounds(38, 10, 114, 29);
		contentPane.add(label_name_1);

		fld_ClinicName = new JTextField();
		fld_ClinicName.setColumns(10);
		fld_ClinicName.setBounds(10, 41, 191, 21);
		fld_ClinicName.setText(clinic.getName());
		contentPane.add(fld_ClinicName);

		JButton btn_UpdateClinic = new JButton("Update Polyclinc");
		btn_UpdateClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
					try {
						clinic.updateClinic(clinic.getId(), fld_ClinicName.getText());
						Helper.showMsg("sucsess");
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btn_UpdateClinic.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btn_UpdateClinic.setBounds(10, 72, 191, 21);
		contentPane.add(btn_UpdateClinic);
	}
}
