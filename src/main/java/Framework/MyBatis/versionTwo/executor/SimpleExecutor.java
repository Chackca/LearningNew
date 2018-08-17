package Framework.MyBatis.versionTwo.executor;

import Framework.MyBatis.versionTwo.config.MyConfiguration;
import Framework.MyBatis.versionTwo.config.MapperRegistory;
import Framework.MyBatis.versionTwo.statement.StatementHandler;

public class SimpleExecutor implements Executor {
    private MyConfiguration configuration;

    public SimpleExecutor(MyConfiguration configuration) {
        this.configuration = configuration;
    }

    public MyConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(MyConfiguration configuration) {
        this.configuration = configuration;
    }

    public <E> E query(MapperRegistory.MapperData mapperData, Object parameter)
            throws Exception {
        //初始化StatementHandler --> ParameterHandler --> ResultSetHandler
        StatementHandler handler = new StatementHandler(configuration);
        return (E) handler.query(mapperData, parameter);
    }
}