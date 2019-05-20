package com.wayyer.HelloWorld.javapattern.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: wayyer
 * @Description: abstract class of a dao
 * @Program: HelloWorld
 * @Date: 2019.05.20
 */
public abstract class AbstractDao {

    protected Object find(String sql, Object[] paramters) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object obj = null;

        connection = JDBCUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < paramters.length; i++) {
            preparedStatement.setObject(i+1, paramters[i]);
        }

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            obj = rowMapper(resultSet);
        }
        JDBCUtils.free(resultSet, preparedStatement, connection);

        return obj;
    }


    protected abstract Object rowMapper(ResultSet resultSet) throws Exception;

}
