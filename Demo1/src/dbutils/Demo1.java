package dbutils;

import jdbc.utils.JdbcUtilsV2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 20:59
 * @Description: 使用commons-dbutils,简化jdbc的代码
 */
public class Demo1 {
    /**
     * @Description: 添加学生信息, 返回影响的行数
     * @auther: yusiming
     * @date: 13:15 2018/8/10
     * @param: [student]
     * @return: void
     */
    public int addStu(Student student) throws SQLException {
        // 创建QueryRunner对象，需要提供连接池对象
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        // 提供sql语句
        String sql = "insert into student values(?,?)";
        // 执行update方法
        return queryRunner.update(sql, student.getSid(), student.getSname());
    }

    /**
     * @Description: 更新学生信息，返回影响的行数
     * @auther: yusiming
     * @date: 13:17 2018/8/10
     * @param: [student]
     * @return: void
     */
    public int updateStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "update student set sname=? where sid=?";
        return queryRunner.update(sql, student.getSname(), student.getSid());
    }

    /**
     * @Description: 根据学生id删除学生信息，返回影响的行数
     * @auther: yusiming
     * @date: 13:18 2018/8/10
     * @param: [sid]
     * @return: void
     */
    public int deleteStudent(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "delete from student where sid=?";
        return queryRunner.update(sql, sid);
    }

    /**
     * @Description: 根据学生id查询学生信息, 返回一个bean对象
     * @auther: yusiming
     * @date: 13:18 2018/8/10
     * @param: [sid]
     * @return: dbutils.Student
     */
    public Student selectStudent(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select * from student where sid=?";
        /* 执行query方法，需要提供一个结果集处理器，即一个BeanHandler对象，
         * query方法调用BeanHandler对象的handle方法，
         * handle方法把结果集转化为指定的bean对象，前提是结果集与bean对象匹配
         * 最后query方法返回handle方法返回的bean对象，BeanHandler，单行处理器
         */
        return queryRunner.query(sql, new BeanHandler<>(Student.class), sid);
    }

    /**
     * @Description: 查询所有学生信息，返回指定类的对象集合
     * @auther: yusiming
     * @date: 13:48 2018/8/10
     * @param: []
     * @return: java.util.List<dbutils.Student>
     */
    public List<Student> selectAllStudent() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select * from student";
        // BeanListHandler对象返回指定类的对象集合，多行处理器，
        return queryRunner.query(sql, new BeanListHandler<>(Student.class));
    }

    /**
     * @Description: 查询指定学生的信息，返回一个map
     * @auther: yusiming
     * @date: 13:58 2018/8/10
     * @param: [sid]
     * @return: java.util.Map
     */
    public Map selectMapStudent(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select * from student where sid=?";
        // MapHandler，把单行记录转换一个map对象，单行处理器，
        return queryRunner.query(sql, new MapHandler(), sid);
    }

    /**
     * @Description: 查询所有学生信息，返回一个List<Map>
     * @auther: yusiming
     * @date: 14:05 2018/8/10
     * @param: []
     * @return: java.util.List<java.util.Map
                       *       <
                       *       <   p>
     * java.lang.String
     * ,
     * java.lang.Object>>
     */
    public List<Map<String, Object>> selectMapListStudent() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select * from student";
        // MapListHandler，把多行记录转换一个list，list中的每个元素都是map，代表了一行记录
        return queryRunner.query(sql, new MapListHandler());
    }

    /**
     * @Description: ScalarHandler, 单行单列使用最为合适
     * @auther: yusiming
     * @date: 14:10 2018/8/10
     * @param: []
     * @return: java.lang.Object
     */
    public int countStudent() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
        String sql = "select count(*) from student";
        Number number = (Number) queryRunner.query(sql, new ScalarHandler());
        return number.intValue();
    }
}