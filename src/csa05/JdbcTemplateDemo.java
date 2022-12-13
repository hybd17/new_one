package csa05;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test01(){
        String sql1 = "insert into student values('s001','zhangsan',20,'computer_college')";
        String sql2 = "insert into student values('s002','lisi',19,'computer_college')";
        String sql3 = "insert into student values('s003','wangwu',18,'computer_college')";
        String sql4 = "insert into student values('s004','zhaoliu',17,'computer_college')";
        int update = jdbcTemplate.update(sql1);
        int update1 = jdbcTemplate.update(sql2);
        int update2 = jdbcTemplate.update(sql3);
        int update3 = jdbcTemplate.update(sql4);
        System.out.println(update+"+"+update1+"+"+update2+"+"+update3);
    }
    @Test
    public void test02(){
        String sql = "select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for(Map<String, Object> stringObjectMap : maps){
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test03(){
        String sql = "delete from student where sno = ?";
        int i = jdbcTemplate.update(sql,"s004");
        System.out.println(i);
    }
    @Test
    public void test04(){
        String sql = "select sno,name,age,college from student where sno = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, "s003");
        System.out.println(stringObjectMap);
    }
    @Test
    public void test05(){
        String sql = "update student set college = 'communication_college' where sno = ?";
        int i = jdbcTemplate.update(sql, "s001");
        System.out.println(i);
    }
}
