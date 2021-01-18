package com.dao.impl;

import com.UserDao;
import com.pojo.User;

import java.io.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
    }

    private static ArrayList<User> array = new ArrayList();
    private static File file = new File("D:\\work\\JetBrains\\IntelliJ IDEA 2020.3.1\\workspace\\login_io\\src\\com\\UserInformation.txt");

    public boolean isLogin(String username,String password) throws IOException {
        boolean flag = false;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\$");
            System.out.println(split[0]);

            if(split[0].equals(username)){
                i++;
                System.out.println("登录测试");
                if(split[1].equals(password)){
                    System.out.println("登录成功");
                    flag = true;
                    break;
                }else {
                    System.out.println("密码错误");
                }
            }
        }
        if(i == 0){
            System.out.println("找不到用户");
        }
        br.close();
        return flag;
    }

    public void regist(User user) throws IOException {
        file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(user.getUsername() + "$" +user.getPassword());
        bw.newLine();
        bw.flush();
        bw.close();
    }

}
