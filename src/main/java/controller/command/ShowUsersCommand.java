package controller.command;
import controller.exception.ControllerException;
import entity.User;
import service.exception.ServiceException;
import service.ServiceFactory;
import service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowUsersCommand implements Command {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserService userService = serviceFactory.getUserService();
    private final String SEARCH_RESULT_JSP = "/WEB-INF/jsp/Users.jsp";
    private List<User> searchResult;
    private final String NAME = "name";
    private final String SURE_NAME = "surename";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

        String name = request.getParameter(NAME);
        String sureName = request.getParameter(SURE_NAME);

        try {
            searchResult = userService.findUser(name , sureName);
            request.setAttribute("users", searchResult);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(SEARCH_RESULT_JSP);
            requestDispatcher.forward(request , response);
        } catch (ServiceException | ServletException | IOException e) {
            throw new ControllerException(e);
        }

    }
}
