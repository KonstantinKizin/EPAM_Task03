package controller.command;
import service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class CommandProducer implements Command {

    private Map<String , Command> commandMap = new HashMap<>();
    private final String HIDDEN_PARAMETER = "hidden";

    public CommandProducer(){
        commandMap.put("search_user",new ShowUsersCommand());
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String commandName = request.getParameter(HIDDEN_PARAMETER);
        Command command = commandMap.get(commandName);
        command.execute(request,response);
    }
}
