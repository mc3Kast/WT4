package main.java.by.bsuir.wt.fourth.controller.command.impl.transition;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import main.java.by.bsuir.wt.fourth.controller.command.Command;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResult;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResultType;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContext;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContextHelper;
import main.java.by.bsuir.wt.fourth.entity.Apartment;
import main.java.by.bsuir.wt.fourth.entity.User;
import main.java.by.bsuir.wt.fourth.entity.UserInformation;
import main.java.by.bsuir.wt.fourth.entity.UserOrder;
import main.java.by.bsuir.wt.fourth.exeptions.ServiceException;
import main.java.by.bsuir.wt.fourth.service.ServiceFactory;
import main.java.by.bsuir.wt.fourth.service.api.ApartmentService;
import main.java.by.bsuir.wt.fourth.service.api.UserInformationService;
import main.java.by.bsuir.wt.fourth.service.api.UserOrderService;
import main.java.by.bsuir.wt.fourth.service.api.UserService;

public class GoToViewOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String APARTMENTS = "apartments";
    private static final String USER_INFORMATION = "userInformation";
    private static final String EXPECTED = "booked";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {


            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders = userOrderService.retrieveUserOrderByStatus(EXPECTED);
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);



            UserService userService = ServiceFactory.getInstance().getUserService();
            List<User> users = userService.getUsersFromOrders(userOrders);
            requestContext.addRequestAttribute(USERS, users);

            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserOrders(userOrders);
            requestContext.addRequestAttribute(APARTMENTS, apartments);

            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();
            List<UserInformation> userInformation = userInformationService.getUserInformationFromUsers(users);
            requestContext.addRequestAttribute(USER_INFORMATION, userInformation);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
