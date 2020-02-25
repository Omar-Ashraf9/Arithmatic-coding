import java.util.*;


public class Main 
{
	static Vector<Character> symbol = new Vector<Character>();
	static Vector<Float> symbol_low = new Vector<Float>();
	static Vector<Float> symbol_upp = new Vector<Float>();
	static HashMap<Character, Float> map = new HashMap<Character, Float>();
	
	public static Scanner in = new Scanner(System.in);
/*******************************************************************************/	
	

	public static void fillmap(String compress)		/// DONE
	{
		float prob;
		float count = 0;
		for(int i = 0; i < compress.length(); i++)
		{
			for(int j = 0; j < compress.length(); j++)
			{
				if(compress.charAt(i) == compress.charAt(j))
				{
					count++;
				}
			}
			prob = count / compress.length();
			
			if(!map.containsKey(compress.charAt(i)))
			{
				map.put(compress.charAt(i), prob);
				symbol.add(compress.charAt(i));
			}
			count = 0;
			
		}
		Collections.sort(symbol);
		
		// Calculate cumulative for each symbol to determine the start and end for each symbol.
		float commulitive = 0;
		for(int i = 0; i < symbol.size(); i++)
		{
			if(i == 0)
			{
				symbol_low.add(commulitive);
				symbol_upp.add(map.get(symbol.get(i)));
				commulitive += map.get(symbol.get(i));
			}else 
			{
				
				symbol_low.add(commulitive);
				commulitive += map.get(symbol.get(i));
				symbol_upp.add(commulitive);
			}
		}
		
	}
	
	public static double GetDecimalValue(String s)		/// DONE
	{
		double power = 2;
		double result = 0;
	    for (int i = 0; i < s.length(); ++i) 
	    { 
	    	double converted = s.charAt(i) - '0';
	        result += (converted) / power; 
	        power *= 2.0; 
	    } 
		return result;
	}
	public static String GenerateBinaryCode(double low,double high)  	/// DONE
	{
		
		String s = "";
		double decimal = GetDecimalValue(s);
		
		while(decimal <= low)
		{
			s += '1';
			decimal = GetDecimalValue(s);
			while(decimal > high)
			{
				s = s.substring(0, s.length() - 1);
				s += "01";
				decimal = GetDecimalValue(s);

			}
		}
		
		
		return s;	
	}
	
	
	public static String compression(String compress)			/// DONE
	{
		String compressed; /// to be returned.
		
		fillmap(compress);/// 

		double low = 0;
		double high = 1;
		double temp = 0;
		for(int i = 0; i < compress.length(); i++)
		{
			int index = symbol.indexOf(compress.charAt(i));
			temp = low + (high - low) * symbol_low.get(index);
			high = low + (high - low) * symbol_upp.get(index);
			low = temp;
		}
		
		
		compressed = GenerateBinaryCode(low,high);
		symbol.clear();
		symbol_low.clear();
		symbol_upp.clear();
		map.clear();
		return compressed;
	}
	public static int CheckRange(double CompressionCode)
	{
		int indexOfChar = 0;
		for(int i = 0; i < symbol.size(); i++)
		{
			if((CompressionCode > symbol_low.elementAt(i)) && (CompressionCode < symbol_upp.elementAt(i)))
			{
				indexOfChar = i;
				break;
			}
		}
		return indexOfChar;
	}
	/*public static void FillDecompression()
	{
		int uniqe;
		char sym;
		float prob;
		System.out.println("Enter the number of uniqe symbols: ");
		uniqe = in.nextInt();
		in.nextLine();
		for(int i = 0; i < uniqe; i++)
		{
			System.out.println("Enter symbol: ");
			sym = in.next().charAt(0);
			System.out.println("Enter prob: ");
			prob = in.nextFloat();
			if(!map.containsKey(sym))
			{
				map.put(sym, prob);
				symbol.add(sym);
			}
		}
		Collections.sort(symbol);
		
		// Calculate cumulative for each symbol to determine the start and end for each symbol.
		float commulitive = 0;
		for(int i = 0; i < symbol.size(); i++)
		{
			if(i == 0)
			{
				symbol_low.add(commulitive);
				symbol_upp.add(map.get(symbol.get(i)));
				commulitive += map.get(symbol.get(i));
			}else 
			{
						
				symbol_low.add(commulitive);
				commulitive += map.get(symbol.get(i));
				symbol_upp.add(commulitive);
			}
		}	
	}*/
	
	public static void FillDecompressionGUI(int uniqe, String []s)
	{
		
		char sym;
		float prob;
		for(int i = 0; i < s.length; i++)
		{
			String[] a = s[i].split("_");
			prob = Float.parseFloat(a[1]); /// to parse the probability.
			sym = a[0].charAt(0);
			if(!map.containsKey(sym))
			{
				map.put(sym, prob);
				symbol.add(sym);
			}
		}
		
		
		Collections.sort(symbol);
		
		// Calculate cumulative for each symbol to determine the start and end for each symbol.
		float commulitive = 0;
		for(int i = 0; i < symbol.size(); i++)
		{
			if(i == 0)
			{
				symbol_low.add(commulitive);
				symbol_upp.add(map.get(symbol.get(i)));
				commulitive += map.get(symbol.get(i));
			}else 
			{
						
				symbol_low.add(commulitive);
				commulitive += map.get(symbol.get(i));
				symbol_upp.add(commulitive);
			}
		}	
	}
	
	
	/*public static String decompression(String s)
	{
		
		
		//FillDecompression();
		
		double low = 0;
		double high = 1;
		double temp = 0;
		double code;
		int NumOfSymbols;
		String result = "";
		int indexOfSymbol;
		
		
		double CompressionCode = GetDecimalValue(s);
		
		
		System.out.println("Enter number of symbols: ");
		NumOfSymbols = in.nextInt();
		for(int i = 0; i < NumOfSymbols; i++)
		{
			if(i == 0)
			{
				indexOfSymbol = CheckRange(CompressionCode);
				result += symbol.elementAt(indexOfSymbol);
				temp = low + (high - low) * symbol_low.get(indexOfSymbol);
				high = low + (high - low) * symbol_upp.get(indexOfSymbol);
				low = temp;
			}else
			{
				code = ((CompressionCode - low) / (high - low));
				System.out.println("The code is: " + code);

				indexOfSymbol = CheckRange(code);
				result += symbol.elementAt(indexOfSymbol);
				temp = low + (high - low) * symbol_low.get(indexOfSymbol);
				high = low + (high - low) * symbol_upp.get(indexOfSymbol);
				low = temp;
			}
		}
		
		
		return result;

		
	}*/

	public static String decompressionGUI(String s,int NumOfSymbols)
	{
		
				
		double low = 0;
		double high = 1;
		double temp = 0;
		double code;
		String result = "";
		int indexOfSymbol;
		
		
		double CompressionCode = GetDecimalValue(s);
		for(int i = 0; i < NumOfSymbols; i++)
		{
			if(i == 0)
			{
				indexOfSymbol = CheckRange(CompressionCode);
				result += symbol.elementAt(indexOfSymbol);
				temp = low + (high - low) * symbol_low.get(indexOfSymbol);
				high = low + (high - low) * symbol_upp.get(indexOfSymbol);
				low = temp;
			}else
			{
				code = ((CompressionCode - low) / (high - low));

				indexOfSymbol = CheckRange(code);
				result += symbol.elementAt(indexOfSymbol);
				temp = low + (high - low) * symbol_low.get(indexOfSymbol);
				high = low + (high - low) * symbol_upp.get(indexOfSymbol);
				low = temp;
			}
		}
		
		
		return result;

		
	}
	
	public static void main(String[] args) 
	{
		/*String input , result;
		String fordecompression = "";
		
		System.out.println("Enter Message: ");
		input = in.nextLine();
		result = compression(input);
		System.out.println(result);*/
		
	}

}
