package gerteor.controller;

import gerteor.model.Director;
import gerteor.service.DirectorDAOImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet
public class FilmListController extends AbstractController {
    private static final long serialVersionUID = 1L;
    private DirectorDAOImpl director;
    public static final String WELCOME_PAGE = "/filmsList.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            director = new DirectorDAOImpl();
            List<Director> directorList;
            directorList = director.getAllDirectors();
            req.setAttribute("filmsList",directorList);
            forward(WELCOME_PAGE, req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
