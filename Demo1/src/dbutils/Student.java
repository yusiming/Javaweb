package dbutils;

/**
 * @Auther: yusiming
 * @Date: 2018/8/9 21:05
 * @Description:
 */
public class Student {
    private int sid;
    private String sname;

    public Student() {
    }

    public Student(int sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}
