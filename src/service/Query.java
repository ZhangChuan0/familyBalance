package service;

import dao.User;

/**
 * Created by zhouhuanping$ on 2024/6/19$.
 */
public interface Query {


    public String queryMoney(User user);
    public String querySalary(User user);

}
