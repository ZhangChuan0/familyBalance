package ui;

import dao.User;
import service.CheckSafeNumber;
import service.imp.IsNumber;
import setting.Conn;

import java.util.Scanner;

/**
 * Created by zhouhuanping$ on 2024/6/18$.
 */
public class Register {

    private Conn conn;
    CheckSafeNumber checkSafeNumber = new IsNumber();


    public Register(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名");

         String username = scanner.nextLine();

        System.out.println("请输入密码");

        String  password = scanner.nextLine();

        if (!checkSafeNumber.rightLength(password)){
            System.out.println("密码长度不正确，重新输入");
            return;
        }

        User user = new User(username, password);
        Conn conn = new Conn();
       conn.insertInto(user);

        System.out.println("注册成功");
    }
}
