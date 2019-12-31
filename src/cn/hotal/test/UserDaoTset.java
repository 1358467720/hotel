package cn.hotal.test;

import cn.hotal.bean.User;
import cn.hotal.dao.UserDao;
import org.junit.Test;

public class UserDaoTset {

    /*
    * 测试成功!
    * */
    @Test
    public void testInsert(){
        User user = new User();
        user.setAccount("20190005");
        user.setPassword("123456");
        user.setName("小华");
        user.setSex("男");
        user.setIDNum("522228200009000005");
        user.setPhoneNum("18908270005");

        //测试Dao层代码i
        int i = UserDao.insertUser(user);
        System.out.println(i);

    }
}
