package Framework.MyBatis.versionOne;


import Framework.MyBatis.beans.Test;

public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}