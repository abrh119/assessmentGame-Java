package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
/**
 * @author AbRh
 *
 */
public class GameScreen extends JPanel {
	//Inheritance

	private int[] seekNumbers;

	private boolean check;


	public int[] getseekNumbers() {

	
		return seekNumbers;
	}

	public GameScreen() {

		setLayout(new BorderLayout());
		setVisible(true);
	}
	/**
	 * UI
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		GameFunction model = new GameFunction();

		int[] numbers = model.getendAnswers();
		String operand = model.getOperand();
		seekNumbers = numbers;

		check = model.checkAnswer();

		int width = getWidth();
		int height = getHeight();

		Font font = new Font("AR JULIAN", Font.TRUETYPE_FONT, 55);

		g2.setFont(font);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(font);

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, width, height);

		g.setColor(Color.red);
		g.drawString(numbers[0] + " " + operand + " " + numbers[1] + " = "
				+ numbers[2], width / 7, 3 * height / 5);

	}

	public boolean getCheck() {
		System.out.println(check);
		return check;
	}
}