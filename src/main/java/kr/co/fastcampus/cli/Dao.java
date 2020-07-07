package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dao {

	private Connection connection;

	public Dao(Connection connection) {
		this.connection = connection;
	}

	public void run() throws SQLException {

		Statement statement = connection.createStatement();
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

		// select member
		ResultSet rs = statement.executeQuery("SELECT * FROM MEMBER");
		while (rs.next()) {
			Member member = Member.builder().id(rs.getInt("id")).username(rs.getString("username"))
					.password(rs.getNString("password")).build();
			log.info(member.toString());
		}
	}
}
