package com;

import com.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserDao {
    boolean isLogin(String var1, String var2) throws FileNotFoundException, IOException;

    void regist(User var1) throws IOException;
}
