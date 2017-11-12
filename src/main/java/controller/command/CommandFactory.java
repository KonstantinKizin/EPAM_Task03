package controller.command;

public class CommandFactory {

    private static final CommandFactory instance = new CommandFactory();

    private final Command  commandProducer = new CommandProducer();

    private CommandFactory() {}

    public Command getCommandProducer() {

        return commandProducer;
    }

    public static CommandFactory getInstance() {
        return instance;
    }

}
