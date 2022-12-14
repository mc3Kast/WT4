package main.java.by.bsuir.wt.fourth.dao.mapper.impl;

import main.java.by.bsuir.wt.fourth.dao.mapper.Column;
import main.java.by.bsuir.wt.fourth.dao.mapper.RowMapper;
import main.java.by.bsuir.wt.fourth.entity.Apartment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentRowMapper implements RowMapper<Apartment> {

    @Override
    public Apartment map(ResultSet resultSet) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(resultSet.getInt(Column.ID));
        apartment.setPrice(resultSet.getDouble(Column.APARTMENT_PRICE));
        apartment.setStatus(resultSet.getString(Column.APARTMENT_STATUS));
        apartment.setType(resultSet.getString(Column.APARTMENT_TYPE));
        apartment.setApartmentNumber(resultSet.getInt(Column.APARTMENT_NUMBER));
        apartment.setNumberOfRooms(resultSet.getInt(Column.APARTMENT_NUMBER_OF_ROOMS));
        apartment.setNumberOfBeds(resultSet.getInt(Column.APARTMENT_NUMBER_OF_BEDS));
        apartment.setPhoto(resultSet.getString(Column.APARTMENT_PHOTO));
        return apartment;
    }
}
