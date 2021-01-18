package com.test;

import com.UserDao;
import com.dao.impl.UserDaoImpl;
import com.game.GuessNumber;
import com.pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class UserTest {
    public static void main(String[] args) throws IOException {
        while (true) {
        System.out.println("欢迎使用本系统，请选择使用的功能");//首页
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        Scanner scan = new Scanner(System.in);
        UserDao ud = new UserDaoImpl();
        int i =scan.nextInt();
        //功能选择
        switch (i){
            case 1:
                System.out.println("请输入您的用户名");
                String username = scan.next();
                System.out.println("请输入您的密码");
                String password = scan.next();
                boolean flag = ud.isLogin(username, password);
                if(flag){
//                    System.out.println("登录成功");
                    GuessNumber.start();
                }
                File file = null;
                break;
            case 2:
                User user = new User();
                System.out.println("请输入您的用户名");
                String result1 = scan.next();
                System.out.println("请输入您的密码");
                String result2 = scan.next();
                //用户信息不能含有$
                if(result1.contains("$")||result2.contains("$")){
                    System.out.println("用户名或密码不能含有$符号");
                }else {
                user.setUsername(result1);
                user.setPassword(result2);
                ud.regist(user);
                System.out.println("注册成功，返回首页");
                }
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("指令错误，请重新输入");
                break;
            }
        }
    }
}
