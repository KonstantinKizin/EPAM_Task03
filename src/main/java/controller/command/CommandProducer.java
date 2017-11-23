package controller.command;
import controller.exception.ControllerException;
import controller.command.commandSetting.CommandMapCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class CommandProducer implements Command {

    private Map<String , Command> commandMap = new HashMap<>();


    private final String HIDDEN_PARAMETER = "hidden";
    final CommandMapCreator commandMapCreator = new CommandMapCreator();// куда делся атрибут достапа?


    public CommandProducer(){
            init();
    }

    private void init()  {
        try {
            commandMap = commandMapCreator.buildCommandMap();
        } catch (ControllerException e) {
            throw new RuntimeException(e);// свой рантайм со своим названием нужен
            // а ты даже свое сообщене поленлся написать
        }
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

        String commandName = request.getParameter(HIDDEN_PARAMETER);
        Command command = commandMap.get(commandName);
        command.execute(request,response);
    }
}
