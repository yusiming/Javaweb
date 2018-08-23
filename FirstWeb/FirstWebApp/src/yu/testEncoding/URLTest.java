package yu.testEncoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Auther: yusiming
 * @Date: 2018/7/25 11:18
 * @Description:
 */
public class URLTest {
    /**
     *
     * @Description:
     * 测试URL编码
     * @auther: yusiming
     * @date: 11:18 2018/7/25
     * @param: [args]
     * @return: void
     *
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "虞四明";
        String urlName = URLEncoder.encode(name, "utf-8");
        System.out.println(urlName);
        String decodeName = URLDecoder.decode(urlName,"utf-8");
        System.out.println(decodeName);
    }
}
