package controller.command;
import controller.ControllerException;
import controller.command.commandSetting.CommandMapCreator;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CommandProducer implements Command {

    private Map<String , Command> commandMap = new HashMap<>();


    private final String HIDDEN_PARAMETER = "hidden";
    private final String XML_SETTING_FILE_NAME = "Controller-Command.cfg.xml";
    final CommandMapCreator commandMapCreator = new CommandMapCreator(XML_SETTING_FILE_NAME);


    public CommandProducer() {
            init();
    }

    private void init() {
        try {
            commandMap = commandMapCreator.buildCommandMap();
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

        String commandName = request.getParameter(HIDDEN_PARAMETER);
        Command command = commandMap.get(commandName);
        command.execute(request,response);
    }
}
