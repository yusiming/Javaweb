package yu.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/1 17:54
 * @Description:
 */
public class MyTag5 extends SimpleTagSupport {
    private boolean test;
    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            //传递的输出流为null表示使用当前页面的out
            this.getJspBody().invoke(null);
        }
    }

    public boolean isTest() {
        return test;
    }
    //这个方法会在doTag之前被tomcat调用
    public void setTest(boolean test) {
        this.test = test;
    }
}
