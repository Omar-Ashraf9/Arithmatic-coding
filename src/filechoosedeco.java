import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

public class filechoosedeco {

	private JFrame frmChooseDecompressionFile;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filechoosedeco window = new filechoosedeco();
					window.frmChooseDecompressionFile.setVisible(true);
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
	public filechoosedeco() throws IOException 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException 
	{
		frmChooseDecompressionFile = new JFrame();
		frmChooseDecompressionFile.setTitle("Choose decompression file");
		frmChooseDecompressionFile.setBounds(100, 100, 590, 438);
		frmChooseDecompressionFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseDecompressionFile.getContentPane().setLayout(null);
		
		JFileChooser fileChooserdeco = new JFileChooser();
		fileChooserdeco.setBounds(0, 0, 576, 399);
		frmChooseDecompressionFile.getContentPane().add(fileChooserdeco);
		
		String path ;
		String filename;
		String strLine;
		String u = "";
		int NumberOfUnique = 0;
		String l = "";
		int NumberOfLetters = 0;
		String[] lines = new String[0];
		String message = "";
		int result = fileChooserdeco.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			path = fileChooserdeco.getSelectedFile().getAbsolutePath();
			filename = fileChooserdeco.getSelectedFile().getName();
			
			
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(path)));
			while ((strLine = reader.readLine()) != null)
			{
                if(reader.getLineNumber() == 1)
                {
                	
                	message = strLine;
                }else if(reader.getLineNumber() == 2)
                {
                	u = strLine;
                	NumberOfUnique = Integer.parseInt(u);
                }
                else if(reader.getLineNumber() == 3)
                {
                	l = strLine;
                	NumberOfLetters = Integer.parseInt(l);
                }else if(reader.getLineNumber() >= 4)
                {
                	/// create new array with size > previous size + 1.
                	strLine.split("\\n");
                	int currentSize = lines.length;
                	int newSize = currentSize + 1;
                	String[] tempArray = new String[ newSize ];
                	for (int i=0; i < currentSize; i++)
                	{
                	    tempArray[i] = lines [i];
                	}
                	tempArray[newSize- 1] = strLine;
                	lines = tempArray;   
                }
            }
			
			Main.FillDecompressionGUI(NumberOfUnique, lines);
			ArithmatiGUI.Result.setText(Main.decompressionGUI(message, NumberOfLetters));
		}
	}
}
