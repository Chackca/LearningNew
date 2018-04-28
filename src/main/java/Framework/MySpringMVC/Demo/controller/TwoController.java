package Framework.MySpringMVC.Demo.controller;

import Framework.MySpringMVC.Demo.service.IDemoService;
import Framework.MySpringMVC.mvcframework.annotation.MyAutowried;
import Framework.MySpringMVC.mvcframework.annotation.MyController;
import Framework.MySpringMVC.mvcframework.annotation.MyRequestMapping;
import Framework.MySpringMVC.mvcframework.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MyController
@MyRequestMapping("/two")
public class TwoController {

    @MyAutowried
    private IDemoService demoService;

    @MyRequestMapping("/query.json")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("name") String name){
        String result = demoService.get(name);
        try {
            resp.getWriter().write("TwoController query My name is "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/edit.json")
    public void edit(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("id") Integer id){
        try {
            resp.getWriter().write("TwoController edit "+id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @MyRequestMapping("/check.json")
    public void check(HttpServletRequest req, HttpServletResponse resp,
                       @MyRequestParam("name") String name){
        String result = demoService.get(name);
        try {
            resp.getWriter().write("TwoController check My name is "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //
    @MyRequestMapping("/here.json")
    public void here(@MyRequestParam("name") String name){
        String result = demoService.get(name);
        System.out.println("测试参数中没有req与resp是否报错，成功打印表示不报错"+result);
    }

}
