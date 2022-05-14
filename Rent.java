import java.time.LocalDate;

public class Rent
{

	private static int counter = 1000;
    private int codeR;			//rental's serial number
	
	private String copyID;		//disc serial number
	
	private String disc; 		//name of movie or game
	
	private String iD;			//username
	private String tel;			//telephone
	private String dateR;		//date
	private int daysR;
	
	private String costR;		//cost
	
	
	public Rent(String copyID, String disc, String iD, String tel, String dateR, int daysR)
	{
		this.copyID = copyID;
		this.disc = disc;
		
		this.iD = iD;
		this.tel = tel;
		this.dateR = dateR;
		this.daysR = daysR;
		
		costR = costFinal(daysR); 
		
		codeR = ++counter;

	}
	
	public String getCopyID()
	{
		return this.copyID;
	}
	
	
	public String costFinal(int day)
	{
		String costF;
		if (day == 1){
			return costF = "2.5";
		}
		else if (day == 7){
			return costF = "3.5";
		}
		else return costF = "Wrong input check the dates";	
		
	}
	
	public String getCostR()
	{
		return costR;
	}
	

	
	public double extraCost(long day)
	{
		String costF = getCostR();
		double extraC;
		if (costF == "2.5"){		//1day
			if (day <= 1){
				return extraC = 0;
			}
			else return extraC = (0.8* (day-1));
		}
		else{					//7days
			if (day <=7){
				return extraC = 0;
			}
			else return extraC = (0.5* (day-7));
		}
	}
	
	
	public int getCodeR() {
        return codeR;
	}
	
	
	public String toString()
	{
		return  "\nRental:"+
				"\nDisc: "+ disc +
				"\nOwner: "+ iD+	
				"\nOwner's telephone: "+ tel+
				"\nRental's date: "+ dateR+
				"\nDays for rent: " + daysR+
				"\nCost: "+ costR+ 
				"\nRental's serial number: #"+ codeR;
			
	}
	
}