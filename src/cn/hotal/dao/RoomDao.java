
package cn.hotal.dao;

import cn.hotal.bean.Room;
import cn.hotal.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class RoomDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSouce());

    public static int insertRoom(Room insertRoom){
        String sql = "insert into room values(?,?,?)";
        int update = 0;
        try {
            update = jdbcTemplate.update(sql, insertRoom.getId(), insertRoom.getPrice(),insertRoom.getRoomType());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return update;
    }

    public static int updateRoom(Room updateRoom){
        String sql1 = "select * from room where rno = ?";

        Map<String, Object> map = null;
        try {
            jdbcTemplate.queryForMap(sql1, updateRoom.getId());
            String sql = "update room " +
                    "set " +
                    "price = ?, " +
                    "roomType = ? " +
                    "where rno = ?";
            int update = jdbcTemplate.update(sql,
                    updateRoom.getPrice(),
                    updateRoom.getRoomType(),
                    updateRoom.getId());

            return update;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteRoom(Room deleteRoom){
        String sql1 = "select * from Room where rno = ?";

        Map<String, Object> map = null;
        try {
            jdbcTemplate.queryForMap(sql1,deleteRoom.getId());
            String sql = "delete Room where rno = ?";
            int update = jdbcTemplate.update(sql,deleteRoom.getId());
            return update;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

