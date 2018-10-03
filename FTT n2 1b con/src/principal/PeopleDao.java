package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PeopleDao implements Dao {
	
	//add -- Implemented
	//update
	//delete
	//read
	//list
	
	private Connection connection;
	
	public PeopleDao() {
		connection = DbUtil.getConnection();
	}
	
	public void AddPeople(People p) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO PEOPLE (ID, NAME) VALUES (?, ?)");
			
			preparedStatement.setLong(1, p.getId()); //atribui no coringa ? no seu respectivo indice.
			preparedStatement.setString(2, p.getName());
			
			preparedStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
