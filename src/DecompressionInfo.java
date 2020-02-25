import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DecompressionInfo {

	private JFrame frmDecompression;
	private JTextField uniqueletters;
	private JTextField letters;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecompressionInfo window = new DecompressionInfo();
					window.frmDecompression.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DecompressionInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDecompression = new JFrame();
		frmDecompression.setTitle("Decompression");
		frmDecompression.getContentPane().setBackground(new Color(240, 230, 140));
		frmDecompression.getContentPane().setLayout(null);
		
		JLabel lblNumberOfUnique = new JLabel("Number of unique letters");
		lblNumberOfUnique.setFont(new Font("Georgia", Font.BOLD, 14));
		lblNumberOfUnique.setBounds(20, 46, 193, 13);
		frmDecompression.getContentPane().add(lblNumberOfUnique);
		
		uniqueletters = new JTextField();
		uniqueletters.setBounds(223, 29, 163, 34);
		frmDecompression.getContentPane().add(uniqueletters);
		uniqueletters.setColumns(10);
		
		JLabel lblNumberOfLetters = new JLabel("Number of letters");
		lblNumberOfLetters.setFont(new Font("Georgia", Font.BOLD, 14));
		lblNumberOfLetters.setBounds(20, 110, 193, 25);
		frmDecompression.getContentPane().add(lblNumberOfLetters);
		
		letters = new JTextField();
		letters.setBounds(223, 99, 163, 34);
		frmDecompression.getContentPane().add(letters);
		letters.setColumns(10);
		
		JLabel lblLetterprobability = new JLabel("Letter_Probability");
		lblLetterprobability.setFont(new Font("Georgia", Font.BOLD, 14));
		lblLetterprobability.setBounds(20, 201, 193, 25);
		frmDecompression.getContentPane().add(lblLetterprobability);
		
		JTextArea letter_prob = new JTextArea();
		letter_prob.setBounds(223, 182, 163, 151);
		frmDecompression.getContentPane().add(letter_prob);
		
		JButton btnOk = new JButton("OK!");
		frmDecompression.setBounds(100, 100, 432, 404);
		frmDecompression.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String u = uniqueletters.getText();
				int NumberOfUnique = Integer.parseInt(u);
				String l = letters.getText();
				int NumberOfLetters = Integer.parseInt(l);
				String[] lines = letter_prob.getText().split("\\n");
				String message = ArithmatiGUI.Input.getText();
				Main.FillDecompressionGUI(NumberOfUnique, lines);
				ArithmatiGUI.Result.setText(Main.decompressionGUI(message, NumberOfLetters));
			}
		});
		btnOk.setFont(new Font("Georgia", Font.BOLD, 14));
		btnOk.setBounds(23, 291, 85, 42);
		frmDecompression.getContentPane().add(btnOk);
		
		
	}
}
