package cn.hotal.dao;

import cn.hotal.bean.Admin;
import cn.hotal.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
        }
    }
}
