package main.java.by.bsuir.wt.fourth.dao.api;

import main.java.by.bsuir.wt.fourth.dao.Dao;
import main.java.by.bsuir.wt.fourth.entity.Role;
import main.java.by.bsuir.wt.fourth.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {


    Optional<Role> findByName(String name) throws DaoException;
}