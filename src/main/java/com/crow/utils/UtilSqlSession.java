package com.crow.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UtilSqlSession {
    private UtilSqlSession() {
    }

    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
