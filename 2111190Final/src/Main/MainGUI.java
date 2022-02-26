package Main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * @author AbRh
 *
 */

public class MainGUI extends JFrame {

	private TipBoard leader;
	private GameScreen gameField;
	private PointSystem score;
	private boolean check;
	private static int count;
	String name = null;
	public static String name1;
	
	private int Correct = 0, Wrong = 0;
	
	/**
	 * MainGUI UI
	 *
	 */

	public MainGUI() {
		super("Numbers Rumble");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\410283.jpg"));
		getContentPane().setBackground(Color.GRAY);

		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		leader = new TipBoard();
		gameField = new GameScreen();

		score = new PointSystem();
		score.setBackground(Color.GRAY);

		getContentPane().setLayout(null);

		JButton Yes = new JButton("CORRECT");
		Yes.setBackground(new Color(204, 255, 204));

		Yes.addActionListener(new ActionListener() {
			// increments wrong and correct 
			public void actionPerformed(ActionEvent e) {
				check = GameFunction.checkAnswer();
				if (check) {
					Correct = score.incCorrect(); 
					score.repaint();
					gameField.repaint();
					count++;

				} else {
					Wrong = score.incWrong(); 
					score.repaint();
					gameField.repaint();

					count++;
				}
				// gives the users 3 chances to try
				if (PointSystem.getWrong() > 2) {
					JOptionPane.showMessageDialog(null, "Game Over."); 
					Leaderboard sdf=new Leaderboard();
					sdf.assign(Correct, Wrong); 
					sdf.setVisible(true);
					score.reset();
					dispose(); 

				}

			}

		});

		JButton No = new JButton("WRONG");
		No.setBackground(new Color(255, 153, 153));

		No.addActionListener(new ActionListener() {
			//increase wrong
			public void actionPerformed(ActionEvent e) {

				check = GameFunction.checkAnswer();
				if (check) {
					Wrong=score.incWrong(); 
					score.repaint(); 
					gameField.repaint(); 
					count++;
				} else {
					Correct=score.incCorrect(); 
					score.repaint(); 
					gameField.repaint(); 

					count++;
				}

				if (PointSystem.getWrong() > 2) {
					JOptionPane.showMessageDialog(null, "Game Over.");
					Leaderboard sdf=new Leaderboard(); 
					sdf.assign(Correct, Wrong); 
					sdf.setVisible(true); 					
					QuickChart newchart = new QuickChart();
					dispose(); 
					
				}
			}

		});

		Yes.setBounds(71, 305, 134, 37);
		getContentPane().add(Yes);
		No.setBounds(270, 305, 141, 37);
		getContentPane().add(No);

		leader.setBounds(480, 0, 220, 340);
		getContentPane().add(leader);

		score.setBounds(0, 0, 482, 40);
		getContentPane().add(score);

		gameField.setBounds(0, 40, 480, 255);
		getContentPane().add(gameField);
		
		

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		JMenu file = new JMenu("File");
		mb.add(file);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});

		JMenu help = new JMenu("Help");
		mb.add(help);

		JMenuItem howToPlay = new JMenuItem("How To Play");
		help.add(howToPlay);

		final String howTo = "Two random numbers are generated together with the operand(random).\n"
				+ "Then some answer is generated. If its true and you press Yes, you have +1 Corrected,\n and if its true and you press No, you have +1 Wronged.\n"
				+ "\n"
				+ "And finally in total you get 3 chances before you mess up! so chop chop, good luck"
			;

		howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, howTo);
			}

		});


	}
	
	
	

	public static int getCount() {
		return count;
	}

	public static int getCorrect() {
		return count;
	}
	

}