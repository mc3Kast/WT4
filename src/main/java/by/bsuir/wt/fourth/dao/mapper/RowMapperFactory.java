package main.java.by.bsuir.wt.fourth.dao.mapper;

import main.java.by.bsuir.wt.fourth.dao.mapper.impl.ApartmentRowMapper;
import main.java.by.bsuir.wt.fourth.dao.mapper.impl.RoleRowMapper;
import main.java.by.bsuir.wt.fourth.dao.mapper.impl.UserInformationRowMapper;
import main.java.by.bsuir.wt.fourth.dao.mapper.impl.UserOrderRowMapper;
import main.java.by.bsuir.wt.fourth.dao.mapper.impl.UserRowMapper;
import main.java.by.bsuir.wt.fourth.entity.Apartment;
import main.java.by.bsuir.wt.fourth.entity.User;
import main.java.by.bsuir.wt.fourth.entity.UserInformation;
import main.java.by.bsuir.wt.fourth.entity.UserOrder;

public class RowMapperFactory {
    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final RowMapper<User> userRowMapper = new UserRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<Apartment> apartmentRowMapper = new ApartmentRowMapper();

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<Apartment> getApartmentRowMapper() {
        return apartmentRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
