/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.HashMap;
import java.util.ArrayList;
public class MarkovWordModel extends AbstractMarkov
{
	private int order;
	public MarkovWordModel(int order)
	{
		super(null,0);
		this.order=order;
	}
	public MarkovWordModel(String[] words)
	{
		super(words,0);
	}
	public MarkovWordModel(String[] words,int seed)
	{
		super(words,seed);	
	}
	@Override
	public String getRandomText(int numWords)
	{
		StringBuilder sb= new StringBuilder();
		this.map=buildMap();	
		int index=randomObj.nextInt(this.words.length-this.order);
		String[] targetWords=new String[this.order];
		for(int i=0;i<targetWords.length;i++)
			targetWords[i]=this.words[index++];
		WordGram wg=new WordGram(targetWords);
		sb.append(wg.toString()+" ");
		ArrayList<String> follows=null;
		for(int i=0,n=numWords-1;i<n;i++)
		{
			follows=map.get(wg);
			if(follows.isEmpty())break;
			index=randomObj.nextInt(follows.size());
			wg=wg.shiftAdd(follows.get(index));
			sb.append(follows.get(index)+" ");	
		}
		return sb.toString().trim();
	}

	@Override
	public String toString()
	{
		return "MarkovWord of Order "+this.order;
	}


}
