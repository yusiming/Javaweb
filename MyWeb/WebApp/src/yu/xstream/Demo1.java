package yu.xstream;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 18:05
 * @Description: 演示xstream
 */
public class Demo1 {
    // 返回一个JavaBean集合
    public List<Province> getProvinceList() {
        Province p1 = new Province();
        p1.setName("北京");
        p1.addCity(new City("东城区", "dongchengqu"));
        p1.addCity(new City("昌平区", "changpingqu"));
        Province p2 = new Province();
        p2.setName("辽宁");
        p2.addCity(new City("沈阳", "shenyang"));
        p2.addCity(new City("葫芦岛", "huludao"));
        List<Province> provinceList = new ArrayList<>();
        provinceList.add(p1);
        provinceList.add(p2);
        return provinceList;
    }

    // 将JavaBean集合转换为xml字符串
    /*
<list> --->list类型显示为list
  <yu.xstream.Province>  --->完整类名
    <name>北京</name>  --->javaBean的属性名
    <cities>
      <yu.xstream.City>
        <name>东城区</name>
        <description>dongchengqu</description>
      </yu.xstream.City>
      <yu.xstream.City>
        <name>昌平区</name>
        <description>changpingqu</description>
      </yu.xstream.City>
    </cities>
  </yu.xstream.Province>
  <yu.xstream.Province>
    <name>辽宁</name>
    <cities>
      <yu.xstream.City>
        <name>沈阳</name>
        <description>shenyang</description>
      </yu.xstream.City>
      <yu.xstream.City>
        <name>葫芦岛</name>
        <description>huludao</description>
      </yu.xstream.City>
    </cities>
  </yu.xstream.Province>
</list>
     * */
    public void fun1() {
        List<Province> provinceList = getProvinceList();
        // 创建XStream对象，调用toXML方法将集合转换为xml字符串
        XStream stream = new XStream();
        String s = stream.toXML(provinceList);
        System.out.println(s);
    }

    /*
<china>
  <province>
    <name>北京</name>
    <cities>
      <city>
        <name>东城区</name>
        <description>dongchengqu</description>
      </city>
      <city>
        <name>昌平区</name>
        <description>changpingqu</description>
      </city>
    </cities>
  </province>
  <province>
    <name>辽宁</name>
    <cities>
      <city>
        <name>沈阳</name>
        <description>shenyang</description>
      </city>
      <city>
        <name>葫芦岛</name>
        <description>huludao</description>
      </city>
    </cities>
  </province>
</china>
     * */
    // 将类名转换为别名
    public void fun2() {
        List<Province> provinceList = getProvinceList();
        // 创建XStream对象，调用toXML方法将集合转换为xml字符串
        XStream stream = new XStream();
        // 给指定的类型指定别名,list类型显示为china
        stream.alias("china", List.class);
        // 给Province指定别名为province
        stream.alias("province", Province.class);
        // 给City类指定别名为city
        stream.alias("city", City.class);
        String s = stream.toXML(provinceList);
        System.out.println(s);
    }

    /*
<china>
  <province name="北京">
    <cities>
      <city>
        <name>东城区</name>
        <description>dongchengqu</description>
      </city>
      <city>
        <name>昌平区</name>
        <description>changpingqu</description>
      </city>
    </cities>
  </province>
  <province name="辽宁">
    <cities>
      <city>
        <name>沈阳</name>
        <description>shenyang</description>
      </city>
      <city>
        <name>葫芦岛</name>
        <description>huludao</description>
      </city>
    </cities>
  </province>
</china>
    * */
    // 将类的元素显示为xml结点的属性
    public void fun3() {
        List<Province> provinceList = getProvinceList();
        // 创建XStream对象，调用toXML方法将集合转换为xml字符串
        XStream stream = new XStream();
        // 给指定的类型指定别名,list类型显示为china
        stream.alias("china", List.class);
        // 给Province指定别名为province
        stream.alias("province", Province.class);
        // 给City类指定别名为city
        stream.alias("city", City.class);

        // 将Province的name元素，生成为<province name="xxx">,指定类型和属性
        stream.useAttributeFor(Province.class, "name");
        //
        String s = stream.toXML(provinceList);
        System.out.println(s);
    }

    /*
<china>
  <province name="北京">
    <city>
      <name>东城区</name>
      <description>dongchengqu</description>
    </city>
    <city>
      <name>昌平区</name>
      <description>changpingqu</description>
    </city>
  </province>
  <province name="辽宁">
    <city>
      <name>沈阳</name>
      <description>shenyang</description>
    </city>
    <city>
      <name>葫芦岛</name>
      <description>huludao</description>
    </city>
  </province>
</china>
     */
    // 去除无用的元素
    public void fun4() {
        List<Province> provinceList = getProvinceList();
        // 创建XStream对象，调用toXML方法将集合转换为xml字符串
        XStream stream = new XStream();
        // 给指定的类型指定别名,list类型显示为china
        stream.alias("china", List.class);
        // 给Province指定别名为province
        stream.alias("province", Province.class);
        // 给City类指定别名为city
        stream.alias("city", City.class);
        // 将Province的name元素，生成为<province name="xxx">,指定类型和属性
        stream.useAttributeFor(Province.class, "name");
        // 去除<cities>这样的集合属性
        stream.addImplicitCollection(Province.class, "cities");
        String s = stream.toXML(provinceList);
        System.out.println(s);
    }

    /*
<china>
  <province name="北京">
    <city>
      <name>东城区</name>
    </city>
    <city>
      <name>昌平区</name>
    </city>
  </province>
  <province name="辽宁">
    <city>
      <name>沈阳</name>
    </city>
    <city>
      <name>葫芦岛</name>
    </city>
  </province>
</china>

Process finished with exit code 0

    * */
    // 去除description属性
    public void fun5() {
        List<Province> provinceList = getProvinceList();
        // 创建XStream对象，调用toXML方法将集合转换为xml字符串
        XStream stream = new XStream();
        // 给指定的类型指定别名,list类型显示为china
        stream.alias("china", List.class);
        // 给Province指定别名为province
        stream.alias("province", Province.class);
        // 给City类指定别名为city
        stream.alias("city", City.class);
        // 将Province的name元素，生成为<province name="xxx">,指定类型和属性
        stream.useAttributeFor(Province.class, "name");
        // 去除<cities>这样的集合属性
        stream.addImplicitCollection(Province.class, "cities");
        stream.omitField(City.class, "description");
        String s = stream.toXML(provinceList);
        System.out.println(s);
    }
}
