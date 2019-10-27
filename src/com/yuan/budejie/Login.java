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

public class Login extends HttpServlet {
    private String message;
    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!ÊÇ¶¥¶¥¶¥¶¥¶¥¶¥¶¥¶¥¶¥¶¥¶¥¶¥";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //½ÓÊÕ²ÎÊý

        String userName = req.getParameter("username");
        String userPwd = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        String result = "";

        if ("hetaoyuan".equals(userName) && "123456".equals(userPwd)) {
            //µÇÂ¼³É¹¦
            result = "success";
        } else {
            result = "fail";
        }

        Map<String, Object> map = new HashMap<>();
        map.put("username", userName);
        map.put("password", userPwd);
        map.put("sex", "ÄÐ");
        map.put("content", result);

        JSONObject jsonObject = JSONObject.fromObject(map);

        out.write(jsonObject.toString());
        out.flush();
        out.close();
        System.out.println(result);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
