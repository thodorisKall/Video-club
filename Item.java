import java.util.*;
import java.lang.*;

abstract public class Item
{
	private String name;
	private String category;
	private String company;
	private String year;
	
	private String arrival;
	
	private int startCps;
	private int avCps; 
	
	private String serialNumber;
	
	public Item(String serialNumber, String name, String category, String company, String year,int startCps, String arrival)
	{
		this.serialNumber = serialNumber;
		this.name = name;
		this.category = category;
		this.company = company;
		this.year = year;
		this.arrival = arrival;
		this.startCps = startCps;
		avCps = startCps;
	}
	
	public void raiseCopies()
	{
		avCps++;
	}
	
	public String getSerialNumber()
	{
		return this.serialNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getStartCps()
	{
		return this.startCps;
	}
	
	public int getAvCps()
	{
		return this.avCps;
	}
	
	public void setAvCps()
	{
		avCps--;
	}
	
	
	public String toString()
	{
		return  "\nName: " + name +
				"\nSerial number: #" + serialNumber +
				"\nCategory: " + category+
				"\nCompany: "+ company +
				"\nYear: " + year;
				
	}
}