package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * @author AbRh
 *
 */
public class Leaderboard extends JFrame {

	// assigns scores and get scores to pass in to charts
	
	JPanel panel = new JPanel();
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private PointSystem score;
	private int correct, wrong; 
	
	 
	public int getCorrect() { 
		return correct; 
	}

	public void setCorrect(int correct) { 
		this.correct = correct; 
	}

	public int getWrong() { 
		return wrong; 
	}

	public void setWrong(int wrong) { 
		this.wrong = wrong; 
	}
	public void assign(int a, int b) { 
		this.correct = a; 
		this.wrong = b; 
		
		String Level = QuickChart.generateChart(correct); 
		
		URL url2 = null; 
		try {
			url2 = new URL(Level); 
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ImageIcon pic1 = new ImageIcon(url2);
		
		JLabel imgLable = new JLabel( pic1, SwingConstants.CENTER);
		imgLable.setBounds(0, 0, 424, 431);
		panel.add(imgLable);
		
		
		
		
	}
	
	/**
	 * LeaderBoard UI
	 *
	 */
	
	public Leaderboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\410283.jpg"));
		setBackground(Color.WHITE);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		
//		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton next = new JButton("Continue");
		next.setForeground(Color.BLACK);
		next.setBackground(Color.WHITE);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framemenu menulog = new framemenu();
				menulog.setVisible(true);
				dispose();
				
				
			}
		});
		next.setFont(new Font("Tahoma", Font.PLAIN, 12));
		next.setBounds(165, 438, 98, 25);
		contentPane.add(next);

		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leaderboard frame = new Leaderboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedEncodingException 
	 */
	

	public PointSystem getScore() {
		return score;
	}

	public void setScore(PointSystem score) {
		this.score = score;
	}
	
	
}
