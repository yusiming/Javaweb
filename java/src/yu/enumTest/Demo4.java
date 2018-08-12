package yu.enumTest;

/**
 * @Auther: yusiming
 * @Date: 2018/8/12 15:09
 * @Description:
 */
public class Demo4 {
    public static void main(String[] args) {
        Direction direction1 = Direction.FRONT;
        Direction direction2 = Direction.BEHIND;
        Direction direction3 = Direction.LEFT;
        Direction direction4 = Direction.RIGHT;
        Direction direction = direction1;
        switch (direction) {
            case FRONT:
                System.out.println("前面");
                break;
            case BEHIND:
                System.out.println("后面");
                break;
            case LEFT:
                System.out.println("左边");
                break;
            case RIGHT:
                System.out.println("右边");
                break;
        }
        System.out.println(direction1.compareTo(direction2));
        System.out.println(direction3.compareTo(direction2));
        System.out.println(direction4.compareTo(direction2));
        System.out.println(direction.hashCode());
        System.out.println(direction.name());
        System.out.println(direction.ordinal());
        System.out.println(direction.toString());
        System.out.println(direction.getName());
        direction.fun1();
    }
}

enum Direction {
    FRONT("虞四明") {
        @Override
        public void fun1() {
            System.out.println("FRONT 重写了方法");
        }
    }, BEHIND("hehe") {
        @Override
        public void fun1() {
            System.out.println("BEHIND 重写了方法");
        }
    }, LEFT("hh") {
        @Override
        public void fun1() {
            System.out.println("LEFT 重写了方法");
        }
    }, RIGHT("yusimng") {
        @Override
        public void fun1() {
            System.out.println("RIGHT 重写了方法");
        }
    };
    private String name;

    // 私有构造方法
    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void fun1();
}
