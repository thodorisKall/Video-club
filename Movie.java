import java.util.*;

public class Movie extends Item
{
	private String quality;	//Dvd or BlueRay
	private String director;
	private String writer;
	private String star;
	private String duration;
	private String arrival;
	
	public Movie (String serialNumber, String name, String category, String company, String year,int startCps, String quality, String director, String writer, String star, String duration, String arrival)
	{
		super(serialNumber, name, category, company, year, startCps, arrival);
		this.quality = quality;
		this.director = director;
		this.writer = writer;
		this.star = star;
		this.duration = duration;
		
	}
	
	public String getQuality()
	{
		return quality;
	}
	
	public String getArrival()
	{
		return this.arrival;
	}
	
	
	
	public String toString()
	{
		return "\n-----------" + 
				"\nMovie details: " + 
				super.toString() +
				"\nQuality: " + quality +
				"\nDirector: " + director+
				"\nWriter(s): " + writer+
				"\nStar: " + star+
				"\nDuration: " + duration +"mins";
	}
	
	
	
}