package com.yuan.budejie;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!是顶顶顶顶顶顶顶顶顶顶顶顶";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();
//        out.println("<h1>" + message + "</h1>");

        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "成功");
        map.put("result", true);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("version", "2.1.0");
        map1.put("descirbe", "优化下载速度");
        map.put("data", map1);

        JSONObject jsonObject = JSONObject.fromObject(map);
        out.write(jsonObject.toString());
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
