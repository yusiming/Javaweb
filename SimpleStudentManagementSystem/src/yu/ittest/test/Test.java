package yu.ittest.test;

import yu.ittest.service.StuService;
import yu.ittest.vo.Student;

public class Test {
    public static void main(String[] args) throws Exception {
/*        Student student = new Student();
        student.setAge("22");
        student.setId("003");
        student.setName("王五");
        StuService.addStu(student);
        StuService.deleteStu("003");*/
        Student student = StuService.getStu("002");
        System.out.println(student.toString());
    }

}
