package Framework.MyBatis.versionTwo.config.mappers;

import Framework.MyBatis.beans.Test;

public interface TestMapper { //framework.MyBatis.versionTwo.config.mappers.TestMapper
    Test selectByPrimaryKey(Integer userId);
}