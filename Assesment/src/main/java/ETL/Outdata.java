package ETL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Outdata {
	
	public void connect()
	{
		
		Connection con;
		Statement st;
	
		ResultSet rs;
		
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String path="C:\\Users\\sangeethas\\Documents\\Database1.accdb";
			String url="jdbc:ucanaccess://"+path;
			String query="select row_number() over () * 1,ISIN,Quantity,Quantity*unitprice as tot  from instrumentdetails,\r\n"
					+ "positiondetails where instrumentdetails.ID=positiondetails.InstrumentID";
			 con = DriverManager.getConnection(url);
			 try {
			 
			 st=con.createStatement();
			 rs=st.executeQuery(query);
			 
			 System.out.format("%-12s  %12s %18s %18s","ID","ISIN","Quantity","TotalPrice");
			 System.out.println();
			 
			 while(rs.next()) {
				 String id=rs.getString(1);
				 String isin=rs.getString(2);
				 String qty=rs.getString(3);
				 String tot=rs.getString(4);
				 System.out.format("%-12s  %12s %18s %18s\n",id,isin,qty,tot);
				 
			
			 }
			
			 }catch(Exception ex) {
				 System.out.println("Error occured"+ex);
			 }
		}catch(Exception e) {
			
			 System.out.println("Error occured"+e);
		 }	
				
				
		}
	public static void main(String args[])
	{
		Outdata d=new Outdata();
		d.connect();
	}
	
	}


