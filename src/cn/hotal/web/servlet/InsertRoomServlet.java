
package cn.hotal.web.servlet;

import cn.hotal.bean.Room;
import cn.hotal.bean.User;
import cn.hotal.dao.RoomDao;
import cn.hotal.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/InsertRoomServlet")
public class InsertRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        Room insertRoom = new Room();
        try {
            BeanUtils.populate(insertRoom,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i = RoomDao.insertRoom(insertRoom);

        if (i == 1) {
            //插入成功
            response.sendRedirect("/insert_room_success.html");

        }else{
            //插入失败
            response.sendRedirect("/insert_room_failed.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

