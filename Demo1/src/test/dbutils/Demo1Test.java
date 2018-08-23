package test.dbutils;

import dbutils.Demo1;
import dbutils.Student;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.Map;

/**
 * Demo1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 10, 2018</pre>
 */
public class Demo1Test {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    /**
     * Method: addStu(Student student)
     */
    @Test
    public void testAddStu() throws Exception {
        Demo1 demo1 = new Demo1();
        Student student = new Student();
        student.setSid(1);
        student.setSname("刘德华");
        int i = demo1.addStu(student);
        System.out.println(i);
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        Student student = new Student();
        student.setSid(1);
        student.setSname("虞四明");
        int i = demo1.updateStudent(student);
        System.out.println(i);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        int i = demo1.deleteStudent(3);
        System.out.println(i);
    }

    @Test
    public void testSelectStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        Student student = demo1.selectStudent(3);
        System.out.println(student.toString());
    }

    @Test
    public void testSelectAllStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        List<Student> students = demo1.selectAllStudent();
        System.out.println(students);
    }

    @Test
    public void testSelectMapStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        Map map = demo1.selectMapStudent(1);
        System.out.println(map);
    }

    @Test
    public void testSelectMapListStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        List<Map<String, Object>> mapList = demo1.selectMapListStudent();
        System.out.println(mapList);
    }

    @Test
    public void testCountStudent() throws Exception {
        Demo1 demo1 = new Demo1();
        int i = demo1.countStudent();
        System.out.println(i);
    }
} 
