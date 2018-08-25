package yu.xstream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 18:08
 * @Description:
 */
public class Province {
    // 省名
    private String name;
    private List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city) {
        cities.add(city);
    }
}
