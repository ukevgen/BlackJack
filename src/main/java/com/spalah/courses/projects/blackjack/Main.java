package com.spalah.courses.projects.blackjack;

import com.spalah.courses.projects.blackjack.exception.AccountException;
import com.spalah.courses.projects.blackjack.model.dao.AccountDao;
import com.spalah.courses.projects.blackjack.model.domain.account.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ukevgen on 03.06.2016.
 */
public class Main {
    private static EntityManagerFactory getEntityManagerFactory(String pUnit) {
        return Persistence.createEntityManagerFactory(pUnit);
    }

    public static void main(String[] args) throws AccountException {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/application-servlet.xml");
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        Account account = new Account();
        account.setLogin("Login");
        account.setNickName("Nick");
        account.setBalance(10_000L);
        accountDao.createAccount(account);
        accountDao.deleteAccount("Login");
    }
}
