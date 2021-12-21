package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/27
 */
public class ReferenceTest {

    static void change(List<User> list) {
        for(User u:list){
            u.setName("io");
            u.setAge(12);
        }

        System.out.println(list);
    }

    static void change2(User[] list) {
        for(int i=0;i<list.length;i++) {
            User u = list[i];
            u.setName("go");
            u.setAge(15);
        }

        /*for(int i=0;i<list.length;i++) {
            list[i].setName("go");
            list[i].setAge(92);
        }*/

        System.out.println(Arrays.toString(list));
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList();
        users.add(new User("test;"));
        users.add(new User("1112"));

        System.out.println(users);

        User[] list = new User[2];
        list[0] = new User("qqq");
        list[1] = new User("iiii");

        System.out.println(Arrays.toString(list));
        change2(list);
        System.out.println(Arrays.toString(list));

        System.out.println(users);

    }

}
