package cn.hotal.dao;

import cn.hotal.bean.User;
import cn.hotal.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class UserDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSouce());

    public static int insertUser(User insertUser){
        String sql = "insert into Huser values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, insertUser.getAccount(),
                insertUser.getPassword(),
                insertUser.getName(),
                insertUser.getSex(),
                insertUser.getIDNum(),
                insertUser.getPhoneNum());

        return update;
    }

    public static int updateUser(User updateUser){
        String sql1 = "select * from Huser where account = ?";

        Map<String, Object> map = null;
        try {
            map = jdbcTemplate.queryForMap(sql1, updateUser.getAccount());
            String sql = "update Huser " +
                    "set " +
                    "password = ?," +
                    "name = ?," +
                    "sex = ?," +
                    "IDNum = ?," +
                    "phoneNum = ? " +
                    "where account = ?";
            int update = jdbcTemplate.update(sql,
                    updateUser.getPassword(),
                    updateUser.getName(),
                    updateUser.getSex(),
                    updateUser.getIDNum(),
                    updateUser.getPhoneNum(),
                    updateUser.getAccount());

            return update;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteUser(User deleteUser){
        String sql1 = "select * from Huser where account = ?";

        Map<String, Object> map = null;
        try {
            map = jdbcTemplate.queryForMap(sql1, deleteUser.getAccount());
            String sql = "delete Huser where account = ?";
            int update = jdbcTemplate.update(sql,deleteUser.getAccount());
            return update;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
