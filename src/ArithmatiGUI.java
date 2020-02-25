import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class ArithmatiGUI {

	private JFrame frmArithmaticCoding;
	public static JTextField Result;
	public static JTextField Input;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArithmatiGUI window = new ArithmatiGUI();
					window.frmArithmaticCoding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArithmatiGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArithmaticCoding = new JFrame();
		frmArithmaticCoding.setTitle("Arithmatic Coding");
		frmArithmaticCoding.getContentPane().setBackground(new Color(240, 230, 140));
		frmArithmaticCoding.setBounds(100, 100, 690, 498);
		frmArithmaticCoding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArithmaticCoding.getContentPane().setLayout(null);
		
		Result = new JTextField();
		Result.setBounds(244, 388, 369, 40);
		frmArithmaticCoding.getContentPane().add(Result);
		Result.setColumns(10);
		
		Input = new JTextField();
		Input.setBounds(244, 56, 369, 40);
		frmArithmaticCoding.getContentPane().add(Input);
		Input.setColumns(10);
		
		JButton Compress = new JButton("Compress");
		Compress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s = Input.getText();
				Result.setText(Main.compression(s));
				
			}
		});
		Compress.setFont(new Font("Gadugi", Font.BOLD, 13));
		Compress.setBounds(517, 220, 108, 49);
		frmArithmaticCoding.getContentPane().add(Compress);
		
		JButton Decompress = new JButton("Decompress");
		Decompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DecompressionInfo nw = new DecompressionInfo();
				nw.NewScreen();
			}
		});
		Decompress.setFont(new Font("Gadugi", Font.BOLD, 13));
		Decompress.setBounds(44, 220, 108, 49);
		frmArithmaticCoding.getContentPane().add(Decompress);
		
		JLabel output = new JLabel("Output");
		output.setFont(new Font("Gadugi", Font.BOLD, 14));
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setBounds(-12, 385, 230, 43);
		frmArithmaticCoding.getContentPane().add(output);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 140, 653, 16);
		frmArithmaticCoding.getContentPane().add(separator);
		
		JLabel Message = new JLabel("Input");
		Message.setHorizontalAlignment(SwingConstants.CENTER);
		Message.setFont(new Font("Gadugi", Font.BOLD, 14));
		Message.setBounds(6, 56, 224, 49);
		frmArithmaticCoding.getContentPane().add(Message);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 346, 653, 2);
		frmArithmaticCoding.getContentPane().add(separator_1);
		
		JButton btnCompressionFromFile = new JButton("Compression from file");
		btnCompressionFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				filechoose co;
				try {
					co = new filechoose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				filechoose.NewScreen();
			}
		});
		btnCompressionFromFile.setFont(new Font("Gadugi", Font.BOLD, 11));
		btnCompressionFromFile.setBounds(244, 166, 165, 40);
		frmArithmaticCoding.getContentPane().add(btnCompressionFromFile);
		
		JButton btnNewButton = new JButton("Decompression from file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				filechoosedeco co;
				try {
					co = new filechoosedeco();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				filechoosedeco.NewScreen();
			}
		});
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 11));
		btnNewButton.setBounds(244, 285, 165, 40);
		frmArithmaticCoding.getContentPane().add(btnNewButton);
	}
}
