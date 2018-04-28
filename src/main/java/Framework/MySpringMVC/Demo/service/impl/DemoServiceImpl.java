package Framework.MySpringMVC.Demo.service.impl;

import Framework.MySpringMVC.Demo.service.IDemoService;
import Framework.MySpringMVC.mvcframework.annotation.MyService;

@MyService
public class DemoServiceImpl implements IDemoService{

    String name = "这是名字";

    public String get(String name){
        return name;
    }
}
