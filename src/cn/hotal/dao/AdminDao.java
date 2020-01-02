package cn.hotal.dao;

import cn.hotal.bean.Admin;
import cn.hotal.bean.User;
import cn.hotal.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class AdminDao {

    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSouce());

    public static Admin login(Admin loginAdmin){
        try {
            String sql = "select * from admin where account = ? and password = ?";

            Admin user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),
                    loginAdmin.getAccount(), loginAdmin.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }finally {

        }
    }

    public static int updateUser(Admin updateAdmin){
        String sql1 = "select * from admin where account = ?";

        Map<String, Object> map = null;
        try {
            map = jdbcTemplate.queryForMap(sql1, updateAdmin.getAccount());
            String sql = "update Admin " +
                    "set " +
                    "password = ?," +
                    "where account = ?";
            int update = jdbcTemplate.update(sql,
                    updateAdmin.getPassword(),
                    updateAdmin.getAccount());

            return update;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
