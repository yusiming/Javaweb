/**
 * Created by yu on 2018/7/21
 */
public class MyException extends Exception{
    String message = "发生自定义异常";
    public MyException() {
    }

    public MyException(String message) {
        super(message);
        this.message += message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
