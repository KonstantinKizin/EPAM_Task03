package controller.command.commandSetting;
import controller.ControllerException;
import controller.command.Command;
import dao.parser.CommandParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;



public class CommandMapCreator {

    private final String cfgFileName;
    private final CommandParser commandParser = new CommandParser();

    public CommandMapCreator(String cfgFileName){
        this.cfgFileName = cfgFileName;
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



    private String getAbsoluteFilePath(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        String path = new String(classLoader.getResource(fileName).getPath());
        return path;
    }




    public Map<String , Command> buildCommandMap() throws ControllerException {

        Map<String , Command> commandMap = new HashMap<>();

        Document document = null;
        try {
            document = this.getDocument(new File(getAbsoluteFilePath(cfgFileName)));
            NodeList root = document.getChildNodes();
            Map<String , String> map = commandParser.getCommandMap(root);
            Set<String> keySet = map.keySet();
            for(String key: keySet){
                String commandClassName = map.get(key);
                Command command = null;
                command = this.buildCommand(commandClassName);
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

    private Document getDocument(final File file) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        final Document document = builder.parse(file);
        return document;
    }
}
