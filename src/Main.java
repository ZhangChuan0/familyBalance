import ui.Login;
import ui.Register;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //启动类

    try{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int id = 0;
            System.out.println("家庭收入管理系统");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("EXIT.退出");
            System.out.println("请输入您的选择");


                switch (scanner.next()) {
                    case "1":
                        System.out.println("目前是：登录");
                        System.out.println("请输入您的账号:");
                        String name = scanner.next();
                        System.out.println("请输入您的密码:");
                        String pwd = scanner.next();
                        Login login = new Login(name,pwd);
                        break;

                    case "2":
                        System.out.println("目前是：注册");
                        Register register = new Register();
                        break;

                    case "exit":
                        System.out.println("退出");
                        return;
                    default:
                        System.err.println("输入有误");
                        break;
                }
            }

}catch (Exception e){
        System.err.println(e);
    }

    }



}