import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String TABLE_NAME = "employee";

    public static void main(String[] args) {
        DbFunctions db=new DbFunctions();
        Connection connection = db.connect_to_db("cruddb","postgres","8964");
        //db.createTable(connection, TABLE_NAME);
        //db.insert_row(connection, TABLE_NAME, "Samuel", "Denmark");
//        db.read_data(connection, TABLE_NAME);
//        db.update_data(connection, TABLE_NAME, "name","Jack","Jackson");
//        db.read_data(connection, TABLE_NAME);
//        db.search_by_name(connection,TABLE_NAME,"Samuel");
//        db.delete_row_by_name(connection,TABLE_NAME,"Jackson");
//        db.delete_row_by_id(connection,TABLE_NAME,1);
//        db.read_data(connection,TABLE_NAME);
        db.delete_table(connection,TABLE_NAME);
    }

}