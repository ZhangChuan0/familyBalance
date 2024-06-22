import dao.CheckUser;
import dao.User;
import service.CheckSafeNumber;
import service.imp.IsNumber;
import setting.Conn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhouhuanping$ on 2024/6/18$.
 */
public class Test {
    public static void main(String[] args) throws SQLException {

        Conn conn = new Conn();
//        String sql = "insert into biao_2(usersname,password) values('zengqignmei','123')";
//       classonn.insertInto(sql);

//        System.out.println(conn.queryUser("aaa", "123"));

//        conn.queryInCome(new User("aaa","1"));


        CheckSafeNumber checkSafeNumber = new IsNumber();
        System.out.println(checkSafeNumber.isOk("123g"));
        System.out.println(checkSafeNumber.isOk("g123"));
        System.out.println(checkSafeNumber.isOk("12f3"));
    }
}
