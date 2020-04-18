import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;



public class ProtivaP3 {
	public static void main(String args[])
	{
	String hostname = "csdb.cs.eou.edu";
	String port     = "3306";
	String database = "dbProtivaTrack";
	String user     = "jprotiva";
	String password = "Dickens";
	String flags = "?noAccessToProcedureBodies=true";
	
	
	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("SELECT * from Athletes");

			ResultSet rs = stmt.getResultSet();			
			rs.first();
			
			String option = JOptionPane.showInputDialog(null,"please enter a Number from list\n1: To add new Athlete\n"+
			"2: Enter new result\n3: Disqulify Athlete all event\n4: Disqulify Athlete single events\n"+
			"5: get results for event\n6: score an event \n7: score meet ");
			int Option = Integer.parseInt(option);
			
			while(Option != 1 && Option != 2 && Option != 3 && Option != 4 && Option != 5 && Option != 6 && Option != 7)
			{
			option = JOptionPane.showInputDialog(null,"please enter a Number from list\n1: To add new Athlete\n"+
			"2: Enter new result\n3: Disqulify Athlete all event\n4: Disqulify Athlete single events\n"+
			"5: get results for event\n6: score an event \n7: score meet ");
			Option = Integer.parseInt(option);
			}
			
			if(Option == 1)
			{
				newAthlete();
			}
			else if(Option == 2)
			{
				newResults();
			}
			else if(Option == 3)
			{
				allDQ();
			}
	
			else if(Option == 4)
			{
				singleDQ();
			}
	
			else if(Option == 5)
			{
				getresults();	
			}
	
			else if(Option == 6)
			{
				scorring();
			}
			else if(Option == 7)
			{
				results();
			}
				
		} 
		
		
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}

	public static void newResults()
	{
		try 
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("SELECT * from Athletes");

			ResultSet rs = stmt.getResultSet();			
			rs.first();
		
			String Athnum = JOptionPane.showInputDialog(null,"please enter Athletes Number");
			int Anum = Integer.parseInt(Athnum);
			
			String Eventnum = JOptionPane.showInputDialog(null,"please enter event Number");
			int Enum = Integer.parseInt(Eventnum);
			
			String track = JOptionPane.showInputDialog(null,"please eneter event \na=track \nb = field");
			
			String tmpMark = JOptionPane.showInputDialog(null,"please enter Athlestes result");
			int mark = Integer.parseInt(tmpMark);
			
			String tmpplace = JOptionPane.showInputDialog(null,"please enter Athlestes place");
			int place = Integer.parseInt(tmpplace);
			
			int zero = 0;
				
				if (track.equals("a"))
				{
					String query = new String ("insert into Results values( '");
					query = query + Anum + "','" + Enum + "','" + mark + "',' "+ zero + "','" + place + "',' No');";
					System.out.println(query);
					stmt.execute(query);
				}
			
				else if(track.equals("b"))
				{
					String query = new String ("insert into Results values( '");
					query = query + Anum + "','" + Enum + "','" + zero + "','" + mark + "','" + place + "',' No');";
					System.out.println(query);
					stmt.execute(query);
				}
				else
				{
					System.out.println("you fail at life");
				}
			
		}
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}
	public static void newAthlete()
	{
		try 
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("SELECT * from Athletes");

			ResultSet rs = stmt.getResultSet();			
			rs.first();
		
			String Fname = JOptionPane.showInputDialog(null,"please enter Athletes First Name");
			String Lname = JOptionPane.showInputDialog(null,"please enter Athletes Last Name");
			String School = JOptionPane.showInputDialog(null,"please enter Athletes School number");
			int schoolnum = Integer.parseInt(School);
			String gender = JOptionPane.showInputDialog(null,"please enter Athletes Gender");
			
			
			String query = new String ("insert into Athletes( NumSchool,FirstName,LastName,Gender,DQ) values( '");
			
			query= query + schoolnum  + "','" + Fname + "','"  + Lname + "','" + gender + "','No');";
			System.out.println(query);
			
			stmt.execute(query);
		}
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}
	public static void allDQ()
	{
		try
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("SELECT * from Athletes");

			ResultSet rs = stmt.getResultSet();			
			rs.first();
			
			String Athnum = JOptionPane.showInputDialog(null,"please enter Athletes Number");
			int Anum = Integer.parseInt(Athnum);
			
			
			String query = new String ("update Results set DQ = 'yes' where AthleteNum = " + Anum + ";");
			System.out.println(query);
			stmt.execute(query);
		}	
			
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}
	
	public static void singleDQ()
	{
		try
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("SELECT * from Athletes");

			ResultSet rs = stmt.getResultSet();			
			rs.first();
			
			String Athnum = JOptionPane.showInputDialog(null,"please enter Athletes Number");
			int Anum = Integer.parseInt(Athnum);
			
			String Eventnum = JOptionPane.showInputDialog(null,"please enter event Number");
			int Enum = Integer.parseInt(Eventnum);
			
			String query = new String ("update Results set DQ = 'yes' where AthleteNum = '" + Anum + "' and EventNum = '" 
			+ Enum +"';");
			System.out.println(query);
			stmt.execute(query);
		}	
			
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}
	
	 public static void getresults()
	{
		try
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			String Eventnum = JOptionPane.showInputDialog(null,"please enter event Number");
			int Enum = Integer.parseInt(Eventnum);
			
			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("select * from Results as r,Athletes as a,Events as e,Schools as s where r.AthleteNum = a.AthleteNum and e.EventNum = r.EventNum and s.NumSchool = a.NumSchool and e.EventNum = '"+ Enum + "';");

			
			ResultSet rs = stmt.getResultSet();			
			
			rs.first();
			
			String evenType = rs.getString("EventType");
			
			if (evenType.equals("track")) 
			{
				System.out.printf("%-9s%-20s%-20s%-16s%-12s%-9s%-9s%-10s%s\n","place","first_name",
			"last_name","event_number","event_name","Times","points","school","disqualified");
				rs.first();
				while (gotResults) 
				{
					int place = rs.getInt("place");
					String firstName = rs.getString("FirstName");
					String lastName = rs.getString("LastName");
					int eventNum = rs.getInt("EventNum");
					String eventName = rs.getString("EventName");
					int times = rs.getInt("Times");
					int points = rs.getInt("Points");
					String nameOfSchool = rs.getString("NameofSchool");
					String dq = rs.getString("DQ");
				
					System.out.printf("%-9s%-20s%-20s%-16s%-12s%-9s%-9s%-10s%s\n",place,firstName
					,lastName,eventNum,eventName,times,points,nameOfSchool,dq);
					gotResults = rs.next();
				}
			}
		else 
			{
			System.out.printf("%-9s%-20s%-20s%-16s%-12s%-9s%-9s%-10s%s\n","place","first_name",
			"last_name","event_number","event_name","distance","points","school","disqualified");
				rs.first();
				while (gotResults) 
				{
					int place = rs.getInt("place");
					String firstName = rs.getString("FirstName");
					String lastName = rs.getString("LastName");
					int eventNum = rs.getInt("EventNum");
					String eventName = rs.getString("EventName");
					int distance = rs.getInt("Distance");
					int points = rs.getInt("Points");
					String nameOfSchool = rs.getString("NameofSchool");
					String dq = rs.getString("DQ");
				
					System.out.printf("%-9s%-20s%-20s%-16s%-12s%-9s%-9s%-10s%s\n",place,firstName
					,lastName,eventNum,eventName,distance,points,nameOfSchool,dq);
					gotResults = rs.next();
				}
			}
			
			
		}	
			
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}
	public static void scorring()
	{
		
		
		try
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			
			

			String Eventnum = JOptionPane.showInputDialog(null,"please enter event Number");
			int Enum = Integer.parseInt(Eventnum);
			
			CallableStatement cStmt = conn.prepareCall("{call scorring(?)}");
			
			cStmt.setInt(1,Enum );
      		
      		System.out.println("" );
      		cStmt.execute();
			
	
		}	
			
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	}	
	
	
	
	public static void results()
	{
		try
		{
			String hostname = "csdb.cs.eou.edu";
			String port     = "3306";
			String database = "dbProtivaTrack";
			String user     = "jprotiva";
			String password = "Dickens";
			String flags = "?noAccessToProcedureBodies=true";
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"
				+ hostname + "/" + database + flags, user, password);

			Statement stmt = conn.createStatement();
			boolean gotResults = stmt.execute("select * from Schools");

			
			
			ResultSet rs = stmt.getResultSet();			
			rs.first();
			
			CallableStatement cStmt = conn.prepareCall("{call Total()}");
			cStmt.execute();
			
			String moutput="Men's Team Scores\nSchool\tpoints\n";
			String woutput="Women's Team Scores\nSchool\tpoints\n";
			while(gotResults)
			{
				String school = rs.getString("NameofSchool");
				int mpoints= rs. getInt("Mpoints");
				int fpoints=rs. getInt("Fpoints");
				
				moutput=moutput + school +"\t" + mpoints + "\n";
				woutput=woutput + school +"\t" + fpoints + "\n";
				gotResults = rs.next();
			}
			System.out.println(moutput+"\n\n\n");
			System.out.println(woutput);
		}	
			
		catch (SQLException ex) 
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex2)
		{	
			System.out.println("Exception: " + ex2.getMessage());
			ex2.printStackTrace();
		}
	
	}
	
	
	
	 	
				
}







