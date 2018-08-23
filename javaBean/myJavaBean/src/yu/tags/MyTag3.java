package yu.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/1 16:49
 * @Description:
 */
public class MyTag3 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();
        out.print("********<br/>");
        this.getJspBody().invoke(out);
        out.print("<br/>********");
    }
}
