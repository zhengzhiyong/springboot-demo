package com.springboot.craftsman.datasource;

import com.springboot.craftsman.base.UserPO;

import java.util.ArrayList;
import java.util.List;

public class UserDatas {

    private UserDatas(){}

    private static class UserDataHolder{
        private static final List<String> getUserNameList (){
            List<String> userNameList = new ArrayList<>(64);
            userNameList.add("admin");
            userNameList.add("administrator");
            userNameList.add("zzy");
            return userNameList;
        }

         private static final List<UserPO> getUserList(){
             List<String> userNameList =  getUserNameList();
             List<UserPO> userList = new ArrayList<>(64);
             for (int i = 0;i<userNameList.size();i++){
                 String userName = userNameList.get(i);
                 UserPO user = new UserPO();
                 user.setUuid("1");
                 user.setUsername(userName);
                 user.setPassword("111111");
                 userList.add(user);
             }
             return userList;
         }
    }

    public static final List<UserPO> getUserList(){
        return UserDataHolder.getUserList();
    }
}
