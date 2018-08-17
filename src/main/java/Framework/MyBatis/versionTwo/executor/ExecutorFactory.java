package Framework.MyBatis.versionTwo.executor;

import Framework.MyBatis.versionTwo.config.MyConfiguration;

public class ExecutorFactory {

    private static final String SIMPLE = "SIMPLE";
    private static final String CACHING = "CACHING";


    public static Executor DEFAULT(MyConfiguration configuration) {
        return get(SIMPLE, configuration);
    }

    public static Executor get(String key, MyConfiguration configuration) {
        if (SIMPLE.equalsIgnoreCase(key)) {
            return new SimpleExecutor(configuration);
        }
        if (CACHING.equalsIgnoreCase(key)) {
            return new CachingExecutor(new SimpleExecutor(configuration));
        }
        throw new RuntimeException("no executor found");
    }

    public enum ExecutorType {
        SIMPLE,CACHING
    }
}
