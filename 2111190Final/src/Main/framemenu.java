package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logins.Login;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * @author AbRh
 *
 */
public class framemenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtDoYouWant;
	private JButton quitbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framemenu frame = new framemenu();
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
	public framemenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\410283.jpg"));
		setBackground(Color.BLACK);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDoYouWant = new JTextField();
		txtDoYouWant.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDoYouWant.setHorizontalAlignment(SwingConstants.CENTER);
		txtDoYouWant.setText("Do you want to play again or quit?");
		txtDoYouWant.setBounds(10, 56, 426, 32);
		contentPane.add(txtDoYouWant);
		txtDoYouWant.setColumns(10);
		
		JButton btnmenu = new JButton("Play Again");
		btnmenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnmenu.setBackground(Color.WHITE);
		btnmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login menulogging = new Login();
				menulogging.setVisible(true);
				dispose();
				
;			}
		});
		btnmenu.setBounds(64, 166, 125, 37);
		contentPane.add(btnmenu);
		
		quitbtn = new JButton("Quit");
		quitbtn.setBackground(Color.WHITE);
		quitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		quitbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quitbtn.setBounds(232, 166, 125, 37);
		contentPane.add(quitbtn);
	}

}
