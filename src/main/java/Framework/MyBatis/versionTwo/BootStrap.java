package Framework.MyBatis.versionTwo;

import Framework.MyBatis.beans.Test;
import Framework.MyBatis.versionTwo.config.MyConfiguration;
import Framework.MyBatis.versionTwo.executor.ExecutorFactory;
import Framework.MyBatis.versionTwo.session.MySqlSession;
import Framework.MyBatis.versionTwo.config.mappers.TestMapper;

import java.io.IOException;


public class BootStrap {
    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        MyConfiguration configuration = new MyConfiguration();
        configuration.setScanPath("framework.MyBatis.versionTwo.config.mappers");
        configuration.build();
//        MySqlSession sqlSession = new MySqlSession(configuration, ExecutorFactory.DEFAULT(configuration));
        MySqlSession sqlSession = new MySqlSession(configuration,
                ExecutorFactory.get(ExecutorFactory.ExecutorType.CACHING.name(),configuration));
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        long start = System.currentTimeMillis();
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println("cost:"+ (System.currentTimeMillis() -start));
//        start = System.currentTimeMillis();
//        test = testMapper.selectByPrimaryKey(1);
//        System.out.println("cost:"+ (System.currentTimeMillis() -start));
//        System.out.println(test);
    }
}
