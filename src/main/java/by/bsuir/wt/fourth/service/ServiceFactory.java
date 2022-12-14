package main.java.by.bsuir.wt.fourth.service;

import main.java.by.bsuir.wt.fourth.service.api.ApartmentService;
import main.java.by.bsuir.wt.fourth.service.api.RoleService;
import main.java.by.bsuir.wt.fourth.service.api.UserInformationService;
import main.java.by.bsuir.wt.fourth.service.api.UserOrderService;
import main.java.by.bsuir.wt.fourth.service.api.UserService;
import main.java.by.bsuir.wt.fourth.service.impl.ApartmentServiceImpl;
import main.java.by.bsuir.wt.fourth.service.impl.RoleServiceImpl;
import main.java.by.bsuir.wt.fourth.service.impl.UserInformationServiceImpl;
import main.java.by.bsuir.wt.fourth.service.impl.UserOrderServiceImpl;
import main.java.by.bsuir.wt.fourth.service.impl.UserServiceImpl;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }



    private final UserOrderService userOrderService=new UserOrderServiceImpl();
    private final UserInformationService userInformationService=new UserInformationServiceImpl();
    private final ApartmentService apartmentService=new ApartmentServiceImpl();
    private final UserService userService=new UserServiceImpl();
    private final RoleService roleService=new RoleServiceImpl();


    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    public UserInformationService getUserInformationService() {
        return userInformationService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
