package Main;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
/**
 * @author AbRh
 *
 */
public class TipBoard extends JPanel {
	private JLabel label;
	/**
	 * Leaderlabed UI
	 *
	 */
	public TipBoard() {
		setBackground(Color.RED);
		
		Dimension dim = getPreferredSize();
		
		
		int width = 350;

		dim.width = width;
		setPreferredSize(new Dimension(119, 266));
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Border innerBorder = BorderFactory.createTitledBorder("Come on Now");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hey, ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(20, 33, 129, 26);
		add(lblNewLabel);
		
		JLabel lblWantATip = new JLabel("Want a tip?");
		lblWantATip.setForeground(Color.WHITE);
		lblWantATip.setBackground(Color.BLACK);
		lblWantATip.setBounds(20, 69, 89, 26);
		add(lblWantATip);
		
		JLabel lblYeahYouWish = new JLabel("Yeah you wish");
		lblYeahYouWish.setForeground(Color.WHITE);
		lblYeahYouWish.setBackground(Color.BLACK);
		lblYeahYouWish.setBounds(20, 112, 129, 26);
		add(lblYeahYouWish);
		
		JLabel lblGoodLuck = new JLabel("Good luck");
		lblGoodLuck.setForeground(Color.WHITE);
		lblGoodLuck.setBackground(Color.BLACK);
		lblGoodLuck.setBounds(20, 148, 129, 26);
		add(lblGoodLuck);
		
		JLabel lblFurtherHarder = new JLabel("Further you go");
		lblFurtherHarder.setForeground(Color.WHITE);
		lblFurtherHarder.setBackground(Color.BLACK);
		lblFurtherHarder.setBounds(20, 182, 129, 26);
		add(lblFurtherHarder);
		
		JLabel lblHarderItGets = new JLabel("Harder it gets");
		lblHarderItGets.setForeground(Color.WHITE);
		lblHarderItGets.setBackground(Color.BLACK);
		lblHarderItGets.setBounds(20, 218, 129, 26);
		add(lblHarderItGets);
	}
}