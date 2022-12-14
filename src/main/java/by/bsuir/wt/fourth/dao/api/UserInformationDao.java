package main.java.by.bsuir.wt.fourth.dao.api;

import main.java.by.bsuir.wt.fourth.dao.Dao;
import main.java.by.bsuir.wt.fourth.entity.UserInformation;
import main.java.by.bsuir.wt.fourth.exeptions.DaoException;


public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
