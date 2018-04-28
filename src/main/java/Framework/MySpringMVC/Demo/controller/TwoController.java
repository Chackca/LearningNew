package Framework.MySpringMVC.Demo.controller;

import Framework.MySpringMVC.Demo.service.IDemoService;
import Framework.MySpringMVC.mvcframework.annotation.MyAutowried;
import Framework.MySpringMVC.mvcframework.annotation.MyController;
import Framework.MySpringMVC.mvcframework.annotation.MyRequestMapping;
import Framework.MySpringMVC.mvcframework.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MyController("/two")
public class TwoController {

    @MyAutowried
    private IDemoService demoService;

    @MyRequestMapping("/query.json")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("name") String name){
        String result = demoService.get(name);
        try {
            resp.getWriter().write(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/edit.json")
    public void edit(HttpServletRequest req, HttpServletResponse resp,
                      @MyRequestParam("id") Integer id){
    }

    @MyRequestMapping("/remove.json")
    public void remove(HttpServletRequest req, HttpServletResponse resp,
                     @MyRequestParam("id") Integer id){
    }

}
