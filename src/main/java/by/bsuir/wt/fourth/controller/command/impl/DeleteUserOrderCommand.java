package main.java.by.bsuir.wt.fourth.controller.command.impl;

import javax.servlet.http.HttpServletResponse;

import main.java.by.bsuir.wt.fourth.controller.command.Command;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResult;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResultType;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContext;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContextHelper;
import main.java.by.bsuir.wt.fourth.exeptions.ServiceException;
import main.java.by.bsuir.wt.fourth.service.ServiceFactory;
import main.java.by.bsuir.wt.fourth.service.api.UserOrderService;

public class DeleteUserOrderCommand implements Command {
    private static final String PAGE = "command=viewOrders";
    private static final String USER_ORDER_ID = "userOrderId";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CANCELED = "canceled";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            int userOrderId = Integer.parseInt(requestContext.getRequestParameter(USER_ORDER_ID));
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            userOrderService.updateStatusAtUserOrderById(userOrderId, CANCELED);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
