package service.factory;

import service.Service;
import service.UserService;
import service.exception.ServiceException;
import service.impl.ControllerCommandServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private static final String CONTROLLER_SERVICE = "commandService";
    private static final String USER_SERVICE = "userService";

    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {}

    public Service getService(String serviceName)  {

        if(serviceName.equalsIgnoreCase(CONTROLLER_SERVICE)){
            return new ControllerCommandServiceImpl();
        }else if(serviceName.equalsIgnoreCase(USER_SERVICE)) {
            return new UserServiceImpl();
        }else {
            throw  new RuntimeException("Unsupported service name");
        }

    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
