package mvjsp.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:/board");
	}
}

//jdbc:apache:commons:dbcp:/board
//board 여기는 board.jocl 이 이름에서 따온 것임
//table 이름과 전혀 상관 없음