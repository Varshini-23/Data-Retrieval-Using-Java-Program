import java.sql.*;

public class dataRetrieval {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Tiger123");
			Statement stat = conn.createStatement();
			
			//Table Creation
			String query="CREATE TABLE MOVIES ( name VARCHAR(20),actor VARCHAR(20),actress VARCHAR(20),director VARCHAR(20),PRIMARY KEY(name))";
			stat.execute(query);
			
			//Data Insertion
			stat.execute("insert into movies values ('Milana','Puneet Rajkumar','Parvathy Thiruvothu','Prakash')");
			stat.execute("insert into movies values ('Bahaddur','Dhruva Sarja','Radhika Pandit','Chetan Kumar')");
			stat.execute("insert into movies values ('Addhuri','Dhruva Sarja','Radhika Pandit','A.P.Arjun')");
			stat.execute("insert into movies values ('Ugram','Sri Muruli','Haripriya','Prashant Neel')");
			stat.execute("insert into movies values ('Hebbuli','Sudeep','Amala Paul','S.Krishna')");
			stat.execute("insert into movies values ('Pailwan','Sudeep','Aakanksha Singh','S.Krishna')");
			
		    //Data Retrieval
			System.out.println("Data Retrieval");
			ResultSet rs = stat.executeQuery("select * from MOVIES");
			ResultSetMetaData rsMeta = rs.getMetaData();
		
			int noOfColumns=rsMeta.getColumnCount();
			for(int i=1;i<noOfColumns;i++){
				System.out.printf("%-30s",rsMeta.getColumnName(i));
			}
			System.out.println();
			while(rs.next()){
				for(int i=1;i<noOfColumns;i++){
					System.out.printf("%-30s",rs.getObject(i));
				}
				System.out.println();
			}
			
			//Data Retrieval Based on Actor Name
			System.out.println();
			System.out.println("Data Retrieval Based on Actor Name");
			rs = stat.executeQuery("select * from MOVIES where actor='Sudeep'");
			rsMeta = rs.getMetaData();
			
			noOfColumns=rsMeta.getColumnCount();
			for(int i=1;i<noOfColumns;i++){
				System.out.printf("%-30s",rsMeta.getColumnName(i));
			}
			System.out.println();
			while(rs.next()){
				for(int i=1;i<noOfColumns;i++){
					System.out.printf("%-30s",rs.getObject(i));
				}
				System.out.println();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}