package Framework.MyBatis.versionTwo.config;

import java.io.IOException;

//@Data
public class MyConfiguration {

    private String scanPath;
    //对应于mapper.xml文件的内容
    private MapperRegistory mapperRegistory = new MapperRegistory();

    public MyConfiguration scanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    public void build() throws IOException {
        if (null == scanPath || scanPath.length() < 1) {
            throw new RuntimeException("scan path is required .");
        }
    }

    public static void main(String[] args) throws IOException {
        new MyConfiguration().scanPath("Framework/Mybatis/versionTwo/config/mappers").build();
    }

    public String getScanPath() {
        return scanPath;
    }

    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }

    public MapperRegistory getMapperRegistory() {
        return mapperRegistory;
    }

    public void setMapperRegistory(MapperRegistory mapperRegistory) {
        this.mapperRegistory = mapperRegistory;
    }
}
