package service;

import org.w3c.dom.NodeList;
import service.exception.ServiceException;

import org.w3c.dom.Document;
import java.util.Map;

public interface ControllerCommandService extends Service {


    Map<String , String> getCommandMap() throws ServiceException;;


}
