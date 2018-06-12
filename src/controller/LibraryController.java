package controller;

import dao.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/library")
public class LibraryController extends HttpServlet {

    private List<Book> books;
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        bookDAO = new BookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        books = new ArrayList<>();

        if (request.getParameter("name1").isEmpty() ||
                request.getParameter("author1").isEmpty() ||
                request.getParameter("year1").isEmpty() ||
                request.getParameter("isbn1").isEmpty()) {
            //response.sendRedirect("/empty");
            request.setAttribute("books", books);
            request.getRequestDispatcher("empty.jsp").forward(request, response);
        }
        else {
            //Double.parseDouble(request.getParameter("year1"))
            Book b1 = new Book(request.getParameter("name1"), request.getParameter("author1"), request.getParameter("year1"), request.getParameter("isbn1"));
            //Book b2 = new Book(request.getParameter("name2"), request.getParameter("author2"), request.getParameter("year2"), request.getParameter("isbn2"));
            //System.out.println(bookDAO.read(1));
            bookDAO.save(b1);
            books.add(b1);
            //bookDAO.save(b2);

            //Book extraB1 = new Book("Bardzo dobry film - 10/10");
            //Book extraB2 = new Book("Sredni film - 6/10");

            //books.add(extraB1);
            //books.add(extraB2);

            request.setAttribute("books", books);
            //request.getRequestDispatcher("view.jsp").forward(request, response);
            request.getRequestDispatcher("added.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
