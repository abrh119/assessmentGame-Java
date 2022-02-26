package Logins;
import Main.MainGUI;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;


/**
 * @author AbRh
 *
 */

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JPasswordField userPassField;
	private JTextField ipAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\410283.jpg"));
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userIDLabel = new JLabel("User ID:");
		userIDLabel.setForeground(Color.WHITE);
		userIDLabel.setBackground(new Color(0, 255, 255));
		userIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userIDLabel.setBounds(40, 40, 85, 22);
		contentPane.add(userIDLabel);
		
		JLabel userPassLabel = new JLabel("Password:");
		userPassLabel.setForeground(Color.WHITE);
		userPassLabel.setBackground(new Color(0, 255, 255));
		userPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userPassLabel.setBounds(40, 91, 85, 22);
		contentPane.add(userPassLabel);
		
		userTextField = new JTextField();
		userTextField.setBackground(new Color(248, 248, 255));
		userTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTextField.setBounds(135, 40, 255, 22);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		userPassField = new JPasswordField();
		userPassField.setForeground(Color.BLACK);
		userPassField.setBackground(Color.WHITE);
		userPassField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userPassField.setColumns(10);
		userPassField.setBounds(135, 91, 255, 22);
		contentPane.add(userPassField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		
		
		
		/**
		 * Server Connection
		 *
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = userTextField.getText();
				String password = String.valueOf(userPassField.getPassword());
				try {
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement st = con.createStatement();
					String sql = "select user_id,password from users where user_id = '" + userID+"'and password = '"+password+"'";
					ResultSet rs = st.executeQuery(sql);
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Success");
						dispose();	
						MainGUI gamePlay = new MainGUI();
						gamePlay.setVisible(true);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
						con.close();
					}
					
				}
				
				
				catch (Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(168, 155, 91, 27);
		contentPane.add(btnNewButton);
		
		ipAddress = new JTextField();
		ipAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ipAddress.setHorizontalAlignment(SwingConstants.CENTER);
		ipAddress.setText("Welcome to Numbers Rumble! Time to Rack your Brain");
		ipAddress.setBackground(Color.WHITE);
		ipAddress.setBounds(10, 226, 416, 27);
		contentPane.add(ipAddress);
		ipAddress.setColumns(10);
	}
}

