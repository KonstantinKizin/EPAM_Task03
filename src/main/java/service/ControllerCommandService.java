package service;

import service.exception.ServiceException;
import java.util.Map;

public interface ControllerCommandService extends Service {
    Map<String , String> getCommandMap() throws ServiceException;;
}
