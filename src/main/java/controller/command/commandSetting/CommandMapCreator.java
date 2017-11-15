package controller.command.commandSetting;
import controller.exception.ControllerException;
import controller.command.Command;
import service.ControllerCommandService;
import service.Service;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

import java.util.*;



public class CommandMapCreator {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private Service service = serviceFactory.getService("commandService");
    private ControllerCommandService commandService = (ControllerCommandService) service;

    public CommandMapCreator()  {

    }

    private Command buildCommand(String commandClassName) throws ControllerException {

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
        try {
            Map<String , String> map = commandService.getCommandMap();
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                String commandClassName = map.get(key);
                Command command = this.buildCommand(commandClassName);
                commandMap.put(key, command);
            }
            return commandMap;
        }catch (ServiceException e){
            throw new ControllerException(e);
        }

    }

}
