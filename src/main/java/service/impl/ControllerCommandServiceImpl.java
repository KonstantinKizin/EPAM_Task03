package service.impl;

import dao.exception.DAOException;
import dao.parser.CommandParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import service.ControllerCommandService;
import service.exception.ServiceException;

import java.util.Map;

public class ControllerCommandServiceImpl implements ControllerCommandService {

    private final CommandParser commandParser = new CommandParser();



    private Document getDocument() throws ServiceException {
        try {
            return commandParser.getDocument();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Map<String, String> getCommandMap() throws ServiceException {
        Document document = this.getDocument();
        NodeList root = document.getChildNodes();
        return commandParser.getCommandMap(root);
    }
}
