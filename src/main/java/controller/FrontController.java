package controller;


import controller.command.Command;
import controller.command.factory.CommandFactory;
import controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {

    private final CommandFactory factory = CommandFactory.getInstance();
    private final Command commandProducer = factory.getCommandProducer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        try {
            commandProducer.execute(request,response);
        } catch (ControllerException e) {
            e.printStackTrace();// правда просто printStackTrace?
            // а пользователю что отправим?
        }

    }
}
