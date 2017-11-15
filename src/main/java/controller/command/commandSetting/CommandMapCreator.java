package controller.command.commandSetting;
import controller.exception.ControllerException;
import controller.command.Command;
import dao.parser.CommandParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;



public class CommandMapCreator {

    private CommandParser commandParser;

    public CommandMapCreator(String cfgFileName){
        this.commandParser = new CommandParser(cfgFileName);
    }

    private Command buildCommand(String commandClassName) throws ControllerException, ParserConfigurationException, SAXException, IOException {

        try {

            Class clazz = Class.forName(commandClassName);
            Command command = (Command) clazz.newInstance();
            return command;

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ControllerException(e);
        }
    }


    public Map<String , Command> buildCommandMap() throws ControllerException {

        Map<String , Command> commandMap = new HashMap<>();

        Document document = null;
        try {
            document = commandParser.getDocument();
            NodeList root = document.getChildNodes();
            Map<String , String> map = commandParser.getCommandMap(root);
            Set<String> keySet = map.keySet();
            for(String key: keySet){
                String commandClassName = map.get(key);
                Command command = this.buildCommand(commandClassName);
                commandMap.put(key,command);
            }
            return commandMap;

        } catch (ParserConfigurationException e) {
            throw new ControllerException(e);
        } catch (IOException e) {
            throw new ControllerException(e);
        } catch (SAXException e) {
            throw new ControllerException(e);
        }

    }

}
