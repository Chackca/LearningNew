package Framework.MyBatis.versionTwo.executor;

import Framework.MyBatis.versionTwo.config.MapperRegistory;

public interface Executor {

    <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception;
}
