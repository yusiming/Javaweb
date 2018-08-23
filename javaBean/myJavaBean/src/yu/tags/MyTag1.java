
package yu.tags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * @Auther: yusiming
 * @Date: 2018/8/1 16:27
 * @Description: 自定义标签1
 */
public class MyTag1 implements SimpleTag {
    //得到服务器传递的参数
    private JspContext jspContext;
    private JspFragment jspFragment;
    @Override
    public void doTag() throws JspException, IOException {
        this.jspContext.getOut().print("Hello Tag!!");
    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.jspContext = jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        this.jspFragment = jspFragment;
    }
}
