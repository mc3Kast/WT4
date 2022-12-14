package main.java.by.bsuir.wt.fourth.dao.mapper;

import main.java.by.bsuir.wt.fourth.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {
    T map(ResultSet resultSet) throws SQLException;
}