package yu.xstream;

/**
 * @Auther: yusiming
 * @Date: 2018/8/24 18:05
 * @Description:
 */
public class City {
    // 市名
    private String name;
    // 描述
    private String description;

    public City() {
    }

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
