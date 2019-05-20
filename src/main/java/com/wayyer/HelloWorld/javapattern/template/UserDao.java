package com.wayyer.HelloWorld.javapattern.template;

import java.sql.ResultSet;

/**
 * @Author: wayyer
 * @Description: child of abstract dao with template
 * @Program: HelloWorld
 * @Date: 2019.05.20
 */
public class UserDao extends AbstractDao {


    /**
     * 模板模式的优点
     * 　（1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构。
     * 　（2）代码复用的基本技术，在数据库设计中尤为重要。
     * 　（3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”。
     *
     * 不足
     *  每个不同的实现都需要定义一个子类，会导致类的个数增加，系统更加庞大。
     * @param userId
     * @return
     * @throws Exception
     */
    public User findUser(int userId) throws Exception {
        String sql = "select * from t_user where userId = ?";
        Object[] params = new Object[] { userId };
        Object user = super.find(sql, params);
        System.out.println((User) user);
        return (User) user;
    }

    @Override
    protected Object rowMapper(ResultSet resultSet) throws Exception {
        User user = new User();
        user.setId(resultSet.getInt("userId"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setSex(resultSet.getString("sex"));
        user.setAddress(resultSet.getString("address"));
        return user;
    }
}
