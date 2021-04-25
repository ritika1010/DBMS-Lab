import java.sql.*;
public class Java2MySql 
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://10.10.15.202:3306/";
		String dbName= "t3413db";
		String driver="com.mysql.jdbc.Driver";
		String userName="t3413"; String password = "t3413";
		 try {
			 Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			 Statement st = conn.createStatement();
			 ResultSet res1 = st.executeQuery("SELECT * FROM prof");
			while (res1.next()) {
			String id = res1.getString("prof_id");
			String name = res1.getString("prof_fname");
			String d_id = res1.getString("dept_id");
			String lname = res1.getString("prof_lname");
			System.out.println(id + "\t" + name +"\t" + lname +"\t" + d_id);
			}
			
			System.out.println("\n" +"=====VIEW prof names and salaries"+"\n");
			
			String command="CREATE OR REPLACE VIEW prof_salary AS SELECT prof_fname,prof_lname,salary FROM prof";
			st.executeUpdate(command);
			
			ResultSet res2 = st.executeQuery("SELECT * FROM prof_salary");
			while (res2.next()) {
			String salary = res2.getString("salary");
			String name = res2.getString("prof_fname");
			String lname = res2.getString("prof_lname");
			System.out.println(name +"\t" + lname +"\t" + salary);
			}
			
			System.out.println("\n" +"=====INDEX prof names and city"+"\n");
			
			String command2="CREATE INDEX city ON prof(city)";
			st.executeUpdate(command2);
			ResultSet res3 = st.executeQuery("SELECT * FROM prof where city='pune' ");
			while (res3.next()) {
				String name = res3.getString("prof_fname");
				String lname = res3.getString("prof_lname");
				System.out.println(name +"\t" + lname );
		
				}
			
			System.out.println("\n" +"=====INDEX from prof table with its type "+"\n\n"+"KEY_NAME  INDEX_TYPE\n");
			
			ResultSet res5 = st.executeQuery("SHOW INDEX FROM prof IN t3413db; ");
			while (res5.next()) {
				String iname = res5.getString("key_name");
				String itype = res5.getString("index_type");
				System.out.println(iname +"\t" + itype );
		
				}
			System.out.println("\n" +"=====SEQUENCE prof names"+"\n");
			
			String command3="ALTER TABLE Shift ADD id INTEGER PRIMARY KEY AUTO_INCREMENT;";
			st.executeUpdate(command3);
			ResultSet res4 = st.executeQuery("SELECT * FROM Shift");
			while (res4.next()) {
				String name = res4.getString("prof_id");
				int id = res4.getInt("id");
				System.out.println(name +"\t" +id );
		
				}
				
			
			String c1="DROP VIEW prof_salary";
			st.executeUpdate(c1);
			String c2="ALTER TABLE prof DROP INDEX city";
			st.executeUpdate(c2);
			String c3="ALTER TABLE Shift DROP PRIMARY KEY,CHANGE id id INTEGER(11);";
			st.executeUpdate(c3);
			String c4="ALTER TABLE Shift DROP COLUMN id;";
			st.executeUpdate(c4);
		 	conn.close();
		 } 
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }		 
	}
	
}


/*int val = st.executeUpdate("INSERT into prof VALUES("+"'1111'"+","+"'aaaa'"+")");
if(val==1)
System.out.print("Successfully inserted value");
 val=st.executeUpdate("delete from prof where prof_id='e0110'");
if(val==1)
	 System.out.print("deleted Successfully");*/