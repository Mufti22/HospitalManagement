package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.HeadDoctor;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HeadDoctorGUI extends JFrame {
	static HeadDoctor headdoctor = new HeadDoctor();
	private JPanel w_pane;

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
	 */
	public HeadDoctorGUI(HeadDoctor headdoctor) {
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
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnNewButton.setBounds(608, 11, 85, 21);
		w_pane.add(btnNewButton);
	}

}
