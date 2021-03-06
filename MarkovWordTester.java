/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class MarkovWordTester
{
	public static void main(String[] args)
	{
		testing();
	}
	public static void testing()
	{
		AbstractMarkov m=new MarkovWordModel(3);
		m.setRandom(371);
		printOut(m.getRandomText(120));
	}
	public static void printOut(String unformatted)
	{
		String[] words=unformatted.split("\\s+");
		System.out.println("*************************** Start ****************************");
		for(int i=0,lineLength=0;i<words.length;i++)
		{
			System.out.print(words[i]+" ");
			lineLength+=words[i].length()+1;
			if(lineLength >60)
			{
				System.out.println();
				lineLength=0;
			}
		}
		System.out.println("\n*************************** End ****************************");
		return;
	}


}
