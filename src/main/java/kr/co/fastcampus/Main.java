package kr.co.fastcampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("org.h2.Driver");
		String url = "jdbc:h2:mem:test;MODE=MySQL;";

		try (Connection connection = DriverManager.getConnection(url, "sa", "");
				Statement statement = connection.createStatement();) {
			connection.setAutoCommit(false);
			
			// make member table
			StringBuffer sb = new StringBuffer();
			sb.append("create table member(");
			sb.append(" id int auto_increment,");
			sb.append(" username varchar(255) not null,");
			sb.append("password varchar(255) not null,");
			sb.append(" primary key(id)");
			sb.append(");");
			statement.execute(sb.toString());
			
			try {
				// insert member
				statement.executeLargeUpdate("insert into member(username, password) values('joonsung', '1234');");
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}
			
			//select member
			ResultSet rs = statement.executeQuery("SELECT * FROM MEMBER");
			while (rs.next()) {
				Member member = Member.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getNString("password"))
						.build();
				log.info(member.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
