package main.java.by.bsuir.wt.fourth.service.api;

import main.java.by.bsuir.wt.fourth.entity.User;
import main.java.by.bsuir.wt.fourth.entity.UserInformation;
import main.java.by.bsuir.wt.fourth.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
