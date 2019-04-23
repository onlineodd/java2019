package java2019.com.java.project.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java2019.com.java.project.ui.MovieCollectionMainFrame;
import java2019.com.java.project.ui.MovieFindV;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class MovieCollectionControllerTwo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MovieCollectionControllerTwo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieCollectionControllerTwo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1310, 1073);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u89C2\u5F71\u5BA4");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 56));
		lblNewLabel.setBounds(474, 74, 431, 131);
		desktopPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, 0, 1374, 1009);
		ImageIcon imageIcon = new ImageIcon("D:/th.jpg");

		JButton btnNewButton = new JButton("≤È—Ø…œº‹ ”∆µ");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 48));
		btnNewButton.setBounds(145, 566, 334, 73);
		desktopPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MovieFindV();
				frame.setVisible(false);
			}
		});

		JButton btnNewButton_1 = new JButton("\u7CFB  \u7EDF  \u7BA1  \u7406");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 48));
		btnNewButton_1.setBounds(836, 566, 340, 73);
		desktopPane.add(btnNewButton_1);
		lblNewLabel_1.setIcon(imageIcon);
		desktopPane.add(lblNewLabel_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MovieCollectionMainFrame();
				frame.setVisible(false);
			}
		});
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
