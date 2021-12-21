package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.User;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/26
 */
public class ArrayTest {

    static void change(User[] users) {
        List list = new LinkedList();
        list.add(new User("hello"));

        users = new User[list.size()];
        list.toArray(users);

        System.out.println(users);
    }

    static void change2(List users, Map m) {
        List list = new LinkedList();
        list.add(new User("hello"));

        users = list;

        users.add(new User("iiisss"));

        m.put(1, 111);

        System.out.println(users);
    }

    @Test
    public void test() {
        User[] users = new User[2];
        for(int i=0;i< users.length;i++){
            users[i] = new User(i+"");
        }

        System.out.println(users.toString());
        change(users);
        System.out.println(users.toString());
    }

    public static void main(String[] args) {
        User[] users = new User[2];
        for(int i=0;i< users.length;i++){
            users[i] = new User(i+"");
        }

        System.out.println(users.length);
        change(users);
        System.out.println(users.length);

        List list = new ArrayList();
        list.add(new User("iii"));
        list.add(new User("222"));

        Map m = new HashMap();

        System.out.println(list);
        System.out.println(m);

        change2(list, m);
        System.out.println(m);
        System.out.println(list);
    }

}
