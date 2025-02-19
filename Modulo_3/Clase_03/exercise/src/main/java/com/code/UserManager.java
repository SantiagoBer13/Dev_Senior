package com.code;

import java.util.ArrayList;
import java.util.List;

import com.code.Exceptions.ExceptionInformationInvalidUser;
import com.code.Exceptions.ExceptionNotFoundIdUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManager {

    private static UserManager userManager;
    private static List<User> users = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(UserManager.class);

    private UserManager() {}

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public void addUser(String name, String email, String occupation) {
        boolean valName = true, valEmail = true, valOccupation = true;
        logger.debug("Adding user {} with email {} and occupation {}", name, email, occupation);
        try {
            logger.debug("Validation name {}", name);
            validateName(name);
            logger.info("Name validated");
        } catch (ExceptionInformationInvalidUser e) {
            System.out.println(e.getMessage());
            valName = false;
            logger.warn(e.getMessage());
        }
        try {
            logger.debug("Validation email {}", email);
            validateEmail(email);
            logger.info("Email validated");
        } catch (ExceptionInformationInvalidUser e) {
            System.out.println(e.getMessage());
            valEmail = false;
            logger.warn(e.getMessage());
        }
        try {
            logger.debug("Validation occupation {}", occupation);
            validateOccupation(occupation);
            logger.info("Occupation validated");
        } catch (ExceptionInformationInvalidUser e) {
            System.out.println(e.getMessage());
            valOccupation = false;
            logger.warn(e.getMessage());
        }
        if (valName && valEmail && valOccupation) {
            logger.debug("Adding user {} with email {} and occupation {}", name, email, occupation);
            System.out.println("User added");
            User user = new User(name, email, occupation);
            System.out.println(user);
            users.add(user);
            logger.info("User added successfully");
        }else{
            System.out.println("User not added");
            logger.info("User not added");
        }   
        
    }

    public User getUser(int id) {
        logger.debug("Getting user with id {}", id);
        for (User user : users) {
            if (user.getId() == id) {
                logger.info("User found");
                System.out.println("User found");
                return user;
            }
        }
        logger.warn("Id user not found");
        throw new ExceptionNotFoundIdUser("Id user not found");
    }

    public void deleteUser(int id) {
        logger.debug("Deleting user with id {}", id);
        try {
            User user = getUser(id);
            if (user != null) {
                users.remove(user);
            }
            logger.info("User deleted");
        } catch (ExceptionNotFoundIdUser e) {
            System.out.println(e.getMessage());
            logger.warn(e.getMessage());
        }
    }

    private void validateName(String name) {
        if (name.length() < 1) {
            throw new ExceptionInformationInvalidUser("name cannot be empty");
        }
    }

    private void validateEmail(String email) {
        if (email.length() < 1) {
            throw new ExceptionInformationInvalidUser("email cannot be empty");
        }
        if (email.contains("@") == false) {
            throw new ExceptionInformationInvalidUser("email must contain @");
        }
    }

    private void validateOccupation(String occupation) {
        if (occupation.length() < 1) {
            throw new ExceptionInformationInvalidUser("occupation cannot be empty");
        }
    }

}
