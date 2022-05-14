import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class mainApp
{

	public static void main(String[] arguments)
	{
		Scanner in = new Scanner (System.in);
		
		Date date = new Date();			//to use date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		//format date
		String dateR = dateFormat.format(date);		//date to String
		
		ArrayList <Item> available = new ArrayList <Item>(10);
		ArrayList <Rent> rented = new ArrayList <Rent>();
		
		
		Movie JPark = new Movie("100", "Jurassic Park", "science fiction, adventure", "Universal Pictures", "1993", 6, "DVD", "Steven Spielberg", "Michael Crichton", "Sam Neill, Laura Dern, Jeff Goldblum, Richard Attenborough", "126", "Old");
		Movie OceansEl = new Movie("101", "Ocean's Eleven", "Crime, Thriller ", "Warner Bros.", "2001", 6, "DVD", "Steven Soderbergh", "George C. Johnson", "George Clooney, Brad Pitt, Matt Damon, Andy García, Julia Roberts, ", "117", "Old");
		
		Movie Avatar = new Movie("102", "Avatar", "Action, Adventure, Fantasy", "Lightstorm ", "2009", 8, "BlueRay", "James Cameron", "James Cameron","Sam Worthington, Zoe Saldana, Stephen Lang", "161", "Hot");
		Movie Robot = new Movie("103", "Transformers: The Last Knight", "Action, Adventure, Sci-Fi", "Di Bonaventura Pictures", "2017", 10,"BlueRay", "Michael Bay", "Hasbro", "Mark Wahlberg, Anthony Hopkins, Josh Duhamel, Laura Haddock", "154", "Hot");
		
		Game Fifa = new Game("104", "Xbox", "FIFA 2018", "Simulation, Sports", "Electronic Arts Sports", "2018", 10, "Old");
		Game Kombat = new Game("105", "Xbox", "Mortal Kombat", "Action, Fighting", "Electronic Arts", "2019", 10, "Old");
		
		Game Pro = new Game("106", "Play Station", "Pro Evolution Soccer 2019", "Simulation, Sports","Konami", "2019", 10, "Old");
		Game Strike = new Game("107", "Play Station", "Counter-Strike Global Offensive", "Action, First Person, Shooter", "Nexon, Valve, Namco", "2012",8, "Old");
		
		Game Pika = new Game("108", "Nintendo", "Pokemon: Let's Go, Pikachu! and Let's Go, Eevee!","Role Playing (RPG)", "NINTENDO", "2018", 4, "Old" );
		Game Mario = new Game("109", "Nintendo", "Mario Kart 8 Deluxe", "Arcade, Racing", "NINTENDO", "2017", 8, "Old");
		
		Rent system = new Rent("####", "System", "Admin", "00000000", "2019-05-10", 0);
		
		rented.add(system);
		
		
		
		available.add(JPark);
		available.add(OceansEl);
		
		available.add(Avatar);
		available.add(Robot);
		
		available.add(Fifa);
		available.add(Kombat);
		
		available.add(Pro);
		available.add(Strike);
		
		available.add(Pika);
		available.add(Mario);
	
		
		String user;
		boolean done = false;		//cmd check(while)
		System.out.println("\n\nWelcome");
		while (!done )
		{
			System.out.println("\n1.Show the available Movies");
			System.out.println("2.Show the available Games");
			System.out.println("3.Show the rentals");
			System.out.println("0.Exit");
			System.out.print(">>>>");
			user = in.nextLine();
			
			
			
			if (user.equals("1"))		//Show Movies+
			{
				ArrayList <Movie> movies = new ArrayList <Movie>();//new Array for this case
				
				for (Item item : available)
				{
					if (item instanceof Movie)
					{
						movies.add((Movie)item);
					}
				} 
				System.out.println("\nDVD or BlueRay? (Press 1 for Dvd and 2 for BlueRay)");
				String  mchoice = in.nextLine();
				if (mchoice.equals("1"))	//DVD
				{
					for (Movie movie : movies)
					{
						if(movie.getQuality().equals("DVD"))
						{
							System.out.println(movie);
						}
					}
					System.out.println("\nChoose your DVD,press the serial number(NOT symbols)");
					String choiceDvd = in.nextLine();
					for (Movie movie : movies)
					{
						if(movie.getSerialNumber().equals(choiceDvd))
						{
							System.out.println("\n\nYour choice: "+movie);
							System.out.print("\nDo you want to rent this movie? Press 1 for YES, 2 for NO  >>>>  ");
							String answer = in.nextLine();
							if (answer.equals("1") && (movie.getAvCps()>=1))	//start rental for DVD
							{
								System.out.print("\nEnter your name:  >>> ");
								String nameR = in.nextLine();
								System.out.print("\nEnter your number: >>> ");
								String telR = in.nextLine();
								System.out.println("\n		Rented!");
								int days;
								if(movie.getArrival() == ("Hot")){
									days = 1;
								}
								else if(movie.getArrival() == ("Old")){
									days = 7;
								}
								else days = 7;
								
								Rent discDvd = new Rent(movie.getSerialNumber(), movie.getName(), nameR, telR, dateR, days);
								rented.add(discDvd);
								movie.setAvCps(); 	//
	
							}
							else if (answer.equals("1") && (movie.getAvCps()<1))
							{
								System.out.println("\nThere's no available copies to store for this code,choose something else");
							}
							else System.out.println("\nOk, back to the main menu!");
						}//1st if choice
					}
				}
				else if(mchoice.equals("2"))	//BlueRay
				{
					for (Movie movie : movies)
					{
						if(movie.getQuality().equals("BlueRay"))
						{
							System.out.println(movie);
						}
					}
					System.out.println("\nChoose your BlueRay,press the serial number(NOT symbols)");
					String choiceBRay = in.nextLine();
					for (Movie movie : movies)
					{
						if(movie.getSerialNumber().equals(choiceBRay))
						{
							System.out.println("\n\nYour choice: "+movie);
							System.out.print("\nDo you want to rent this movie? Press 1 for YES, 2 for NO  >>>>  ");
							String answerBRay = in.nextLine();
							if (answerBRay.equals("1")  && (movie.getAvCps() >= 1))		//start rental for BlueRay
							{
								System.out.print("\nEnter your name:  >>>");
								String nameR = in.nextLine();
								System.out.print("\nEnter your number: >>>");
								String telR = in.nextLine();
								System.out.println("		Rented!");
								
								Rent discBRay = new Rent(movie.getSerialNumber(), movie.getName(), nameR, telR, dateR, 1);
								rented.add(discBRay);
								movie.setAvCps();	//
							}
							else if (answerBRay.equals("1") && (movie.getAvCps()<1))
							{
								System.out.println("There's no available copies to store for this code,choose something else");
							}
							else System.out.println("\nOk, back to the main menu!");
						}
					}
				}
				
				
			}//show movies
			else if (user.equals("2"))	//Show Games+
			{
				ArrayList <Game> games = new ArrayList <Game>();	//new array for next this case-Games
				for (Item item : available)
				{
					if(item instanceof Game)
					{
						games.add((Game)item);
					}
				}
				
				System.out.println("\nPick a Platform(Press 1 for Xbox, 2 for Play Station or 3 for Nintendo)");
				String gchoice = in.nextLine();
				
				if(gchoice.equals("1"))	//Xbox
				{
					for (Game game : games)
					{
						if(game.getPlatform().equals("Xbox"))
						{
							System.out.println(game);
						}
					}
					System.out.println("\nChoose your Game! Press the serial number(NOT symbols)");
					String choiceXb = in.nextLine();
					for (Game game : games)
					{
						if(game.getSerialNumber().equals(choiceXb))
						{
							System.out.println("\n\nYour choice: "+game);
							System.out.print("\nDo you want to rent this game? Press 1 for YES, 2 for NO  >>>>  ");
							String answerXb = in.nextLine();
							if (answerXb.equals("1") && (game.getAvCps() >= 1))		//start rental for Xbox
							{
								System.out.print("\nEnter your name:  >>>");
								String nameR = in.nextLine();
								System.out.print("\nEnter your number: >>>");
								String telR = in.nextLine();
								System.out.println("		Rented!");
								
								Rent discXb = new Rent(game.getSerialNumber(), game.getName(), nameR, telR, dateR, 7);
								rented.add(discXb);
								game.setAvCps();	//
							}
							else if (answerXb.equals("1") && (game.getAvCps()<1))
							{
								System.out.println("There's no available copies to store for this code,choose something else");
							}
							else System.out.println("\nOk, back to the main menu!");
						}
					}
				}
				else if(gchoice.equals("2"))	//Play station
				{
					for (Game game : games)
					{
						if(game.getPlatform().equals("Play Station"))
						{
							System.out.println(game);
						}
					}
					System.out.println("\nChoose your Game! Press the serial number(NOT symbols)");
					String choicePS = in.nextLine();
					for (Game game : games)
					{
						if(game.getSerialNumber().equals(choicePS))
						{
							System.out.println("\n\nYour choice: "+game);
							System.out.print("\nDo you want to rent this game? Press 1 for YES, 2 for NO  >>>>  ");
							String answerPS = in.nextLine();
							if (answerPS.equals("1") && (game.getAvCps() >= 1))		//start rental for PS
							{
								System.out.print("\nEnter your name:  >>>");
								String nameR = in.nextLine();
								System.out.print("\nEnter your number: >>>");
								String telR = in.nextLine();
								System.out.println("		Rented!");
								
								Rent discPS = new Rent(game.getSerialNumber(), game.getName(), nameR, telR, dateR, 7);
								rented.add(discPS);
								game.setAvCps();	//
							}
							else if (answerPS.equals("1") && (game.getAvCps()<1))
							{
								System.out.println("There's no available copies to store for this code,choose something else");
							}
							else System.out.println("\nOk, back to the main menu!");
						}
					}
				}
				else if(gchoice.equals("3"))	//Nintendo
				{
					for (Game game : games)
					{
						if(game.getPlatform().equals("Nintendo"))
						{
							System.out.println(game);
						}
					}
					System.out.println("\nChoose your Game! Press the serial number(NOT symbols)");
					String choiceNint = in.nextLine();
					for (Game game : games)
					{
						if(game.getSerialNumber().equals(choiceNint))
						{
							System.out.println("\n\n		Your choice: "+game);
							System.out.print("\nDo you want to rent this game? Press 1 for YES, 2 for NO  >>>>  ");
							String answerNint = in.nextLine();
							if (answerNint.equals("1") && (game.getAvCps() >= 1))		//start rental for Nintendo
							{
								System.out.print("\nEnter your name:  >>>");
								String nameR = in.nextLine();
								System.out.print("\nEnter your number: >>>");
								String telR = in.nextLine();
								System.out.println("		Rented!");
								
								Rent discNint = new Rent(game.getSerialNumber(), game.getName(), nameR, telR, dateR, 7);
								rented.add(discNint);
								game.setAvCps();	//
							}
							else if (answerNint.equals("1") && (game.getAvCps()<1))
							{
								System.out.println("There's no available copies to store for this code,choose something else");
							}
							else System.out.println("\nOk, back to the main menu!");
						}
					}
					
				}
				
				
			}//show Games
			else if (user.equals("3"))	//show rentals+
			{
				for (Rent rent : rented)
				{
					System.out.println(rent);
				}
				
				System.out.println("\nDo you want to return one of them?(Pres 1 for YES, 2 for NO)");
				String choiceR = in.nextLine();
				if(choiceR.equals("1"))
				{
					System.out.print("\nEnter the Rental's serial number(NOT symbols) >>>>  ");
					int choiceSerial = in.nextInt();
					int hold = 0; //index for delete object(rented)
					int counter = 0;
					for (Rent rent : rented)
					{
						if ((rent.getCodeR()) == choiceSerial )
						{
							hold = counter;
							System.out.println("\n		Your choice: " + rent);
							
							System.out.print("\nDo you want to return it?(Pres 1 for YES, 2 for NO)  >>>>  ");
							String epilogi = in.next();
							in.nextLine();
							if (epilogi.equals("1"))
							{
								System.out.print("\nGive the return's date (example yyyy-MM-dd: 2019-11-28)  ");
								String userDate = in.nextLine();
								
								LocalDate dateBefore = LocalDate.parse(dateR);
								LocalDate dateAfter = LocalDate.parse(userDate);		//
								long daysOwn = ChronoUnit.DAYS.between(dateBefore, dateAfter);	//java 8 compare dates
								System.out.println("\nDays owned: " + daysOwn);
								System.out.println("\nExtra cost: "+ rent.extraCost(daysOwn));	
								double finalC = rent.extraCost(daysOwn);
								double finalC2 = Double.parseDouble(rent.getCostR());
								finalC +=finalC2;
								System.out.println("\nCost to pay: " + finalC+" euros");
					
								String serialR = rent.getCopyID();
								for (Item item : available)
								{
									if(item.getSerialNumber().equals(serialR))
									{					
										item.raiseCopies();
									}			
								}
								System.out.println("\nReturned!" );
							}
							else System.out.println("\nOk, back to the main menu!");
						}
						counter++;
					}//for loop rented
					rented.remove(hold); //delete the returned disc
				}
				else System.out.println("\nOk, back to the main menu!");
			}//show Rentals
			else if (user.equals("0")) done = true;
			
		}//while loop
	}
}