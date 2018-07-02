package com.elie.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;


/**
 * Singleton class
 */
public class FactorySingleton {


    private static SqlSessionFactory factory;


    /**
     * Singleton method inside the singleton class to return
     * a single instance of the static field whenever called
     * @return an instance of the {SqlSessionSfactory}
     * @throws Exception throws an exception if the file is not found
     */
    public static SqlSessionFactory getFactory() throws Exception{
        if(factory == null){
            InputStream inputStream;
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        return factory;
    }






    /**
     * invoques the factory static method and returns an instance
     * of the SqlSession class
     * @return SqlSession class instance
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = null;

        try {
            sqlSession =  getFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
