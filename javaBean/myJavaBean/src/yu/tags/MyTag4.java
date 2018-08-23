package yu.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/1 17:20
 * @Description: 执行这个标签时，标签下面的内容会无法执行
 */
public class MyTag4 extends SimpleTagSupport {
    /**
     * @Description: 在doTage方法中抛出一个SkipPageException异常，
     * @auther: yusiming
     * @date: 17:24 2018/8/1
     * @param: []
     * @return: void
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        out.print("下面的内容不会执行");
        throw new SkipPageException();
    }
}
