package Framework.MyBatis.versionTwo.mapper;

import Framework.MyBatis.versionTwo.config.MapperRegistory;
import Framework.MyBatis.versionTwo.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {
    private final MySqlSession sqlSession;
    private final Class<T> mappperInterface;

    public MapperProxy(MySqlSession mySqlSession, Class<T> clazz) {
        this.sqlSession = mySqlSession;
        this.mappperInterface = clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperRegistory.MapperData mapperData =
                sqlSession.getConfiguration()
                        .getMapperRegistory()
                        .get(method.getDeclaringClass().getName() + "." + method.getName());
        if (null != mapperData) {
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", mapperData.getSql(), args[0]));
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        throw new Exception("MapperProxy：可能因为数据库连接失败，抛出异常啦");
        //return method.invoke(proxy, args);
    }
}
