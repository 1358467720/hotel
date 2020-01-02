
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

@WebServlet("/UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        Room updatetRoom = new Room();
        try {
            BeanUtils.populate(updatetRoom,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i = RoomDao.updateRoom(updatetRoom);

        if (i == 1) {
            //更新成功
            response.sendRedirect("/update_room_success.html");

        }else{
            //更新失败
            response.sendRedirect("/update_room_failed.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
