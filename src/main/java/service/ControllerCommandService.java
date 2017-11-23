package service;

import service.exception.ServiceException;
import java.util.Map;

public interface ControllerCommandService extends Service {// вырви глаз название класса
    // да и что оно делает на уровне сервисов
    // зачем сервисам знать команды контроллера
    Map<String , String> getCommandMap() throws ServiceException;;
}
