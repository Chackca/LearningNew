package Framework.MyBatis.versionOne;

import Framework.MyBatis.beans.Test;

public class BootStrap {
    public static void start(){
        MySqlSession sqlSession = new MySqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);//MapperProxy
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }

    public static void main(String[] args) {
        start();
    }
}