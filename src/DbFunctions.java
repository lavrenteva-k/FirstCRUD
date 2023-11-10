import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
            if (connection != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public void createTable(Connection connection, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + " (empid SERIAL, name varchar(200), address varchar(200), primary key(empid));";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insert_row(Connection connection, String table_name, String name, String address) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name,address) values('%s', '%s');", table_name, name, address);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(Connection connection, String table_name) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s", table_name);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("empid") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_data(Connection connection, String table_name, String data_name, String old_data, String new_data) {
        Statement statement;
        try {
            String query = String.format("update %s set %s='%s' where %s='%s'", table_name, data_name, new_data, data_name, old_data);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void search_by_name(Connection connection, String table_name, String name) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s where name='%s'", table_name, name);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("empid") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_row_by_name(Connection connection, String table_name, String name) {
        Statement statement;
        try {
            String query = String.format("delete from %s where name='%s'", table_name, name);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_row_by_id(Connection connection, String table_name, int id) {
        Statement statement;
        try {
            String query = String.format("delete from %s where empid=%s", table_name, id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_table(Connection connection, String table_name) {
        Statement statement;
        try {
            String query = String.format("drop table %s", table_name);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
