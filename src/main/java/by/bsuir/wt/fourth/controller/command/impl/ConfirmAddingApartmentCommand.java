package main.java.by.bsuir.wt.fourth.controller.command.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import main.java.by.bsuir.wt.fourth.controller.command.Command;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResult;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResultType;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContext;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContextHelper;
import main.java.by.bsuir.wt.fourth.exeptions.ServiceException;
import main.java.by.bsuir.wt.fourth.service.ServiceFactory;
import main.java.by.bsuir.wt.fourth.service.api.ApartmentService;

public class ConfirmAddingApartmentCommand implements Command {
    private static final String PAGE = "command=addApartment";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String STATUS = "status";
    private static final String TYPE = "type";
    private static final String PRICE = "price";
    private static final String NUMBER_OF_BEDS = "numberOfBeds";
    private static final String NUMBER_OF_ROOMS  = "numberOfRooms";
    private static final String APARTMENT_NUMBER = "apartmentNumber";
    private static final String PHOTO = "photo";
    private static final String MESSAGE_PARAMETER = "&message=";
    private static final String ERROR = "error";
    private static final String OK = "ok";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {

        RequestContext requestContext = helper.createContext();
        String message = ERROR;

        Optional<String> status = Optional.ofNullable(requestContext.getRequestParameter(STATUS));
        Optional<String> type = Optional.ofNullable(requestContext.getRequestParameter(TYPE));
        Optional<String> price = Optional.ofNullable(requestContext.getRequestParameter(PRICE));
        Optional<String> numberOfRooms = Optional.ofNullable(requestContext.getRequestParameter(NUMBER_OF_ROOMS));
        Optional<String> numberOfBeds = Optional.ofNullable(requestContext.getRequestParameter(NUMBER_OF_BEDS));
        Optional<String> apartmentNumber = Optional.ofNullable(requestContext.getRequestParameter(APARTMENT_NUMBER));
        Optional<String> photo = Optional.ofNullable(requestContext.getRequestParameter(PHOTO));

        try {
            if (status.isPresent() && type.isPresent() && price.isPresent() && numberOfBeds.isPresent() &&
                    numberOfRooms.isPresent() && apartmentNumber.isPresent() && photo.isPresent()) {

                ApartmentService apartmentService = ServiceFactory.getInstance().getApartmentService();
                boolean result = apartmentService.addNewApartment(status.get(),type.get(),numberOfRooms.get(),
                        apartmentNumber.get(),numberOfBeds.get(),price.get(),photo.get());
                if (result) {
                    message = OK;
                }
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE + MESSAGE_PARAMETER + message, CommandResultType.REDIRECT);
    }
}
