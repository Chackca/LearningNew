package Framework.MyBatis.versionOne;

public interface Executor {
    <E> E query(String statement, Object parameter);
}