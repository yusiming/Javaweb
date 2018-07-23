/**
 * Created by yu on 2018/7/21
 */
public class Form {
    public static void main(String[] args) {
        RedCowForm form = new RedCowForm("红牛农场");
        System.out.println(form.showMessages());
        System.out.println(form.cow.speak());
        RedCowForm.RedCow redCow = new RedCowForm.RedCow(150,112,5000);
    }
}

class RedCowForm {
    static String formName;
    RedCow cow;
    public RedCowForm(String s) {
        formName = s;
        cow = new RedCow(150,112,5000);
    }

    public String showMessages() {
        return cow.speak();
    }
    static class RedCow {
        String cowName = "红牛";
        int height, weight, price;

        public RedCow(int height, int weight, int price) {
            this.height = height;
            this.weight = weight;
            this.price = price;
        }

        public String speak() {
            return "RedCow{" +
                    "cowName='" + cowName + '\'' +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", price=" + price +
                    //", formName=" + formName +
                    '}';
        }
    }
}
