package setting;

import dao.User;

import java.net.URL;
import java.sql.*;

public class Conn { // 创建类Conn
     Connection con  ; // 声明Connection对象
     public static String user;
     public static  String password;
     public Connection getConnection() { // 建立返回值为Connection的方法
          try { // 加载数据库驱动类
//               Class.forName("com.mysql.jdbc.Driver");
               //另个一版本的驱动
               Class.forName("com.mysql.cj.jdbc.Driver");

          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          }
          user = "root";//数据库登录名
          password = "123456";//密码

          try { // 通过访问数据库的URL获取数据库连接对象

//               String url = "jdbc:mysql://localhost:3306/javabase?useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


               String url = "jdbc:mysql://localhost:3306/javabase";

               con = DriverManager.getConnection(url,user,password);

          } catch (SQLException e) {
               e.printStackTrace();
          }
          return con; // 按方法要求返回一个Connection对象
     }

//     插入
     public boolean insertInto(User user) {
          try{
               String sql = "insert into biao_2(usersname,password) values(?,?)";
               String sql2 = "insert into biao_1(salary,money,users) values(0,0,?)";

               PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
               preparedStatement.setString(1, user.getName());
               preparedStatement.setString(2, user.getPassword());

               PreparedStatement preparedStatement1 = getConnection().prepareStatement(sql2);
               preparedStatement1.setString(1, user.getName());
               preparedStatement1.executeUpdate();

               System.out.println("添加成功");
          }catch (SQLException e){
               System.err.println(e);
          }


          return true;
     }

//     查询所有信息
     public void queryInCome(User user){
          System.out.println("---------------收支情况-----------------");
          try{
               String sql  = "select * from biao_1 where users = ?";

               PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
               preparedStatement.setString(1,user.getName());
               ResultSet resultSet = preparedStatement.executeQuery();


               while (resultSet.next()){
                    System.out.println("支出:"+resultSet.getString("money"));
                    System.out.println("收入:"+resultSet.getString("salary"));
                    System.out.println("存取类型："+resultSet.getString("pay"));

               }

               if (!resultSet.isBeforeFirst()){
                    System.out.println("暂无记录");
               }
          }catch (SQLException e){
               System.out.println(e);
          }




     }



//     查询单个user
     public boolean queryUser(String name, String pwd){
          try{

               String sql = "select id from biao_2 where usersname  = ? and password = ?";

               PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
               ResultSet resultSet = preparedStatement.executeQuery();


              return resultSet.next();

          }catch (SQLException e){
               System.out.println(e);
          }

         return true;
     }

     public boolean insertIntoMoney(String index,User user,String num) {
          String sql ;
          try{

               if (index == "2"){

                    sql = "UPDATE biao_1 SET salary = ? WHERE users = ?";
               }else {
                    sql = "UPDATE biao_1 SET money = ? WHERE users = ?";
               }


               PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
               preparedStatement.setString(1, num);
               preparedStatement.setString(2, user.getName());
               int i = preparedStatement.executeUpdate();
               System.out.println("添加成功");
          }catch (SQLException e){
               System.err.println(e);
          }


          return true;
     }






}
