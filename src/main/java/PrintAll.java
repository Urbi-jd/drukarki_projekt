import java.sql.*;

public class PrintAll {

    void printAll(String tabela) {
        try (final Connection connection = getConnection()) {
            printAllData(connection, tabela);
        } catch (SQLException exp) {
            System.out.println("Błąd połączenia " + exp.getMessage());
        }
    }

    private void printAllData(Connection connection, String tabela) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "select * from " + tabela;
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();
        printResult(resultSet, tabela);
    }

    private void printResult(ResultSet resultSet, String table) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");

            if (table.equals("location")) {

                String locationBuilding = resultSet.getString("Budynek");
                String locationDepartment = resultSet.getString("Dział");
                System.out.println("id: " + id + " Budynek: " + locationBuilding + " Dział: " + locationDepartment);

            } else if (table.equals("printers")) {
                String printerProducer = resultSet.getString("Producent");
                String printerModel = resultSet.getString("Model");
                String printerTonerId = resultSet.getString("Model");
                System.out.println("id: " + id + " producent: " + printerProducer + " model: " + printerModel + " toner ID: " + printerTonerId);
            }
        }
    }

    private Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/projekt?autoReconnect=true&useSSL=false&serverTimezone=UTC";
        return DriverManager.getConnection(jdbcUrl, "scott", "scott");
    }
}
