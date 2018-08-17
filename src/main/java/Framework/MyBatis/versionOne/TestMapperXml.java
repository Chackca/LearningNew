package Framework.MyBatis.versionOne;

import java.util.HashMap;
import java.util.Map;

public class TestMapperXml {
    public static final String nameSpace = "Framework.MyBatis.versionOne.TestMapper";

    public static final Map<String, String> methodSqlMapping = new HashMap<String, String>();

    static {
        methodSqlMapping.put("selectByPrimaryKey", "select * from test where id = %d");
    }
}