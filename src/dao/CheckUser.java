package dao;

import setting.Conn;

/**
 * Created by zhouhuanping$ on 2024/6/18$.
 */
public class CheckUser {
//    检查用户是否存在
    public boolean isSave(User new_user){
        Conn conn = new Conn();

        return conn.queryUser(new_user.getName(),new_user.getPassword());
    }
}
