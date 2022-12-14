package main.java.by.bsuir.wt.fourth.controller.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import main.java.by.bsuir.wt.fourth.controller.command.impl.CompleteOrderCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.ConfirmAddingApartmentCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.ConfirmChangingApartmentStatusCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.ConfirmUserOrderCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.DeleteUserOrderCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.LogInCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.LogOutCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.LogUpCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.DefaultCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToAddApartmentCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToAddUserOrderCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToCatalogCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToChangeApartmentStatusCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToContactsCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToLogInCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToLogUpCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToMainCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToMyOrdersCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToProfileCommand;
import main.java.by.bsuir.wt.fourth.controller.command.impl.transition.GoToViewOrdersCommand;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        commands.put(CommandName.DEFAULT_COMMAND, new DefaultCommand());
        commands.put(CommandName.MAIN_COMMAND, new GoToMainCommand());
        commands.put(CommandName.PROFILE_COMMAND, new GoToProfileCommand());
        commands.put(CommandName.REGISTRATION_COMMAND, new LogUpCommand());
        commands.put(CommandName.LOG_IN_COMMAND, new GoToLogInCommand());
        commands.put(CommandName.CONTACTS_COMMAND, new GoToContactsCommand());

        commands.put(CommandName.CATALOG_COMMAND, new GoToCatalogCommand());
        commands.put(CommandName.CHECK_LOGIN_COMMAND, new LogInCommand());
        commands.put(CommandName.LOG_OUT_COMMAND, new LogOutCommand());
        commands.put(CommandName.LOG_UP_COMMAND, new GoToLogUpCommand());

        commands.put(CommandName.VIEW_ORDERS_COMMAND, new GoToViewOrdersCommand());
        commands.put(CommandName.DELETE_USER_ORDER_COMMAND, new DeleteUserOrderCommand());

        commands.put(CommandName.ADD_APARTMENT_COMMAND, new GoToAddApartmentCommand());
        commands.put(CommandName.CONFIRM_ADDING_APARTMENT_COMMAND, new ConfirmAddingApartmentCommand());

        commands.put(CommandName.MY_ORDERS_COMMAND, new GoToMyOrdersCommand());

        commands.put(CommandName.CONFIRM_USER_ORDER_COMMAND, new ConfirmUserOrderCommand());
        commands.put(CommandName.ADD_USER_ORDER,new GoToAddUserOrderCommand());
        commands.put(CommandName.COMPLETE_USER_ORDER_COMMAND, new CompleteOrderCommand());
        commands.put(CommandName.EDIT_APARTMENT_STATUS, new GoToChangeApartmentStatusCommand());
        commands.put(CommandName.CONFIRM_CHANGING_APARTMENT_STATUS_COMMAND, new ConfirmChangingApartmentStatusCommand());
    }

    public static CommandFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Command getCommand(String name) {
        return Optional.ofNullable(commands.get(name)).orElse(commands.get(CommandName.DEFAULT_COMMAND));
    }

    private static class Holder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }

}
