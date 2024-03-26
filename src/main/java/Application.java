import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args)
        throws SQLException {
        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test");

        var sql = "create table users (id bigint primary key auto_increment, username varchar(255), phone varchar(255));";
        var statement = conn.createStatement();
        statement.execute(sql);
        statement.close();

        var sql2 = "insert into users (username, phone) values ('tommy', '123456789'), ('bobby', '987654321');";
        var statement2 = conn.createStatement();
        statement2.executeUpdate(sql2);
        statement2.close();

        var sql3 = "select * from users;";
        var statement3 = conn.createStatement();
        var resultSet = statement3.executeQuery(sql3);
        while (resultSet.next()) {
            System.out.println("username: " + resultSet.getString("username"));
            System.out.println("phone: " + resultSet.getString("phone"));
            System.out.println();
        }
        statement3.close();

        conn.close();
    }
}
