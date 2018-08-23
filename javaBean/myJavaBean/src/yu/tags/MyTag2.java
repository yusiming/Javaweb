package yu.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/1 16:36
 * @Description:
 * 自定义标签2
 */
public class MyTag2 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().print("Hello Tag Again !! ");
    }
}
