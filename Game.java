import java.util.*;

public class Game extends Item
{
	private String platform;	//playStation or xBox or nintendo
	
	public Game(String serialNumber, String platform, String name, String category, String company, String year,int startCps, String arrival)
	{
		super(serialNumber, name, category, company, year, startCps, arrival);
		this.platform = platform;
	}
	
	public String getPlatform()
	{
		return this.platform;
	}
	
	public String toString()
	{
		return"\n----------" +
				"\nGame details: " +
				"\nConsole: " + platform+
				super.toString();
				
	}
}