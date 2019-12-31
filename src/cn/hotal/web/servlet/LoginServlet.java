
package cn.hotal.web.servlet;

import cn.hotal.bean.Admin;
import cn.hotal.dao.AdminDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        Admin loginAdmin = new Admin();
        try {
            BeanUtils.populate(loginAdmin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Admin admin = AdminDao.login(loginAdmin);

        if (admin == null) {
            //登录失败
            response.setStatus(302);
            response.setHeader("location","/login_failed.html");

        }else{
            response.setStatus(302);
            response.setHeader("location","/admin_business.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

