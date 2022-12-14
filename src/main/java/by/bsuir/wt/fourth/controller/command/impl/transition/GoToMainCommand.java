package main.java.by.bsuir.wt.fourth.controller.command.impl.transition;

import javax.servlet.http.HttpServletResponse;

import main.java.by.bsuir.wt.fourth.controller.command.Command;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResult;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResultType;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContext;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContextHelper;

public class GoToMainCommand implements Command {
    private static final String PAGE = "WEB-INF/view/main.jsp";



    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();


        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}