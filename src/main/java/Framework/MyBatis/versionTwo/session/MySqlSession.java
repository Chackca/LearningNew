package Framework.MyBatis.versionTwo.session;

import Framework.MyBatis.versionTwo.config.MyConfiguration;
import Framework.MyBatis.versionTwo.config.MapperRegistory;
import Framework.MyBatis.versionTwo.executor.Executor;
import Framework.MyBatis.versionTwo.mapper.MapperProxy;

import java.lang.reflect.Proxy;

public class MySqlSession {
    private MyConfiguration configuration;
    private Executor executor;

    public MyConfiguration getConfiguration() {
        return configuration;
    }

    //关联起来
    public MySqlSession(MyConfiguration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},new MapperProxy(this,clazz));
    }

    public <T> T selectOne(MapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        return executor.query(mapperData, parameter);
    }
}
