import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.util.*;
public class filechoose {

	private JFrame frmChooseFile;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filechoose window = new filechoose();
					window.frmChooseFile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public filechoose() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException 
	{
		frmChooseFile = new JFrame();
		frmChooseFile.setTitle("Choose compression file");
		frmChooseFile.setBounds(100, 100, 578, 423);
		frmChooseFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseFile.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 0, 566, 389);
		frmChooseFile.getContentPane().add(fileChooser);
		//fileChooser.showSaveDialog(null);
		String path ;
		
		String filename;
		
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			path = fileChooser.getSelectedFile().getAbsolutePath();
			filename = fileChooser.getSelectedFile().getName();
			BufferedReader br = new BufferedReader(new FileReader(path));
			String Currentline = br.readLine();
			ArithmatiGUI.Result.setText(Main.compression(Currentline));
		}
		
		
	}

}
