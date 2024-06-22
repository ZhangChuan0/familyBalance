package ui;

import dao.CheckUser;
import dao.User;
import service.CheckSafeNumber;
import service.imp.IsNumber;
import setting.Conn;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Login {

private Scanner scanner = new Scanner(System.in);
    Conn conn = new Conn();

    CheckSafeNumber checkSafeNumber = new IsNumber();

    private User user_1 = new User("aaa","123");

    public User getUser_1() {
        return user_1;
    }

    public void setUser_1(User user_1) {
        this.user_1 = user_1;
    }

    public  Login(String name,String pwd){
        User user = new User(name,pwd);
        CheckUser checkUser = new CheckUser();
        while (true){
            if (checkUser.isSave(user)) {
                while (true){
                    setUser_1(user);
                System.out.println("登录成功");
                System.out.println("-------家庭记账软件----");
                System.out.println("欢迎:"+getUser_1().getName()+"登录");
                System.out.println("1.收支明细");
                System.out.println("2.登记收入");
                System.out.println("3.登记支出");
                System.out.println("4.登出");
                System.out.println("5.退出系统");
                System.out.println("------------------");
//                以上选择功能

                System.out.println("请输入功能编号");
                if (!checkUser.isSave(user)){
                    break;
                }
                    switch (scanner.next()){
                        case "1":
                            incomeBreakdown();
                            break;

                        case "2":
                            RegisteredIncome("2");
                            break;

                        case "3":
                            RegisteredPay("3");
                            break;
//                        擦除登录信息
                        case "4":
                           while (true){
                               if (logOut(user,scanner)){
                                   break;
                               }
                           }
                            break;
                        case "5":
                            System.out.println("退出系统");
                            return;
                        default:
                            System.out.println("输入有误，请重新输入");
                    }
                }


            }else {
                System.out.println("登录失败,重新输入账号密码");
                System.out.println("是否登录(Y / anyone keyword)?:");
                if (!scanner.next().equals("Y")){
                    break;
                }
                System.out.println("------------账号------------");
                user.setName(scanner.next());
                System.out.println("------------密码------------");
                user.setPassword(scanner.next());
            }
        }


//184-1894-6978-5509


    }


    public String incomeBreakdown(){
        //放一个查询的sql语句,将收入信息查询出来
conn.queryInCome(getUser_1());

        return "desc";
    }
    public void RegisteredIncome(String num){
        System.out.println("请输入收入：回车结束");
        String next = scanner.next();
        if (!checkSafeNumber.isOk(next)){
            System.out.println("输入有误，请重新输入");
            return;
        }
        conn.insertIntoMoney(num,user_1,next);
        System.out.println("已经登记收入："+next);
    }

    public void RegisteredPay(String num){
        System.out.println("请输入支出：回车结束");
        String next = scanner.next();
        if (!checkSafeNumber.isOk(next)){
            System.out.println("输入有误，请重新输入");
            return;
        }
        conn.insertIntoMoney(num,user_1,next);
        System.out.println("已经登记支出："+next);

    }

    public boolean logOut(User user,Scanner scanner){
        System.out.println("是否登出(Y/N)?:");
        String next = scanner.next();
        if (next.equals("Y")){
            user.setName("");
            user.setPassword("");
            System.out.println("登出成功");
            return true;
        }else if (next.equals("N")){
            System.out.println("取消登出");
            return true;
        }else {
            System.out.println("输入有误，请重新输入");
        return false;
        }

    }

}
