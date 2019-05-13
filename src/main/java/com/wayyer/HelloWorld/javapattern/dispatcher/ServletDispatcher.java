package com.wayyer.HelloWorld.javapattern.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayyer
 * @Description: selvelt的任务分发者 ，主要完成url的映射和调用
 * @Program: HelloWorld
 * @Date: 2019.05.13
 */
public class ServletDispatcher {
    //这里也可以用map 对象来保存Hanlder对象
    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public ServletDispatcher() {
        //简单实现一个controller的映射
        try {
            Class clazz  = TestController.class;
            handlerMapping.add(new Handler(clazz.newInstance(),
                    "/findById",
                    clazz.getMethod("findById",new Class[]{String.class})
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void  doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        //1.获取用户请求的url
        String uri =   request.getRequestURI();
        Handler handler =null;

        ////2、根据uri 去handlerMapping找到对应的hanler
        for(Handler h :handlerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        //3.将具体的任务分发给Method（通过反射去调用其对应的方法）
        Object obj = null;
        try {
            obj =  handler.getMethod().invoke(handler.getController(),request.getParameter("id"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4、获取到Method执行的结果，通过Response返回出去
        // response.getWriter().write();

    }

    class Handler{
        //map controller对象
        private Object controller;

        //controller对象映射的方法
        private String url;

        //url对应的方法
        private Method method;

        public Handler(){}
        public Handler(Object controller, String url, Method method) {
            this.controller = controller;
            this.url = url;
            this.method = method;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }
    }
}
