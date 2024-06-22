package service.imp;

import dao.User;
import service.Query;
import setting.Conn;

/**
 * Created by zhouhuanping$ on 2024/6/19$.
 */
public class QueryImp  implements Query {
    private Conn conn;
    @Override
    public String queryMoney(User user) {

        conn.getConnection();
        return null;
    }

    @Override
    public String querySalary(User user) {
        return null;
    }
}
