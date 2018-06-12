package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String user = "nex";
    private static final String pass = "nex";
    private static final String database = "Library";
    private static final String server = "localhost\\sqlexpress";
    private static final int port = 0;
    private Connection connection;

    private static final String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + user + ";password=" + pass + ";databaseName=" + database + "";

    public BookDAO() {
        try {
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) { //CREATE
        final String sql = "INSERT INTO Books(title, author, year, ISBN) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setString(4, book.getISBN());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public List<Book> readAll() {
        final String sql = "SELECT id, title, author, year, ISBN FROM Books";
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                List<Book> books = new ArrayList<>();
                while (result.next()) {
                    Book book = new Book();
                    book.setId(result.getInt("id"));
                    book.setTitle(result.getString("title"));
                    book.setAuthor(result.getString("author"));
                    book.setYear(result.getString("year"));
                    book.setISBN(result.getString("ISBN"));
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException e) {
            System.out.println("Could not get employee");
        }
        return null;
    }

    public Book read(int id) {
        final String sql = "SELECT id, title, author, year, ISBN FROM Books WHERE id = ?";
        try {
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) {
                    Book book = new Book();
                    book.setId(result.getInt("id"));
                    book.setTitle(result.getString("title"));
                    book.setAuthor(result.getString("author"));
                    book.setYear(result.getString("year"));
                    book.setISBN(result.getString("ISBN"));
                    return book;
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not get employee");
        }
        return null;
    }

    public void update(Book book) {
        final String sql = "UPDATE Books SET title=?, author=?, year=?, ISBN=? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setString(4, book.getISBN());
            preparedStatement.setInt(5, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
        }
    }

    public void delete(int id) {
        final String sql = "DELETE FROM Books WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
