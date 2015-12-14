/**
 * Created by georgipavlov on 14.12.15.
 */
public class Box {
    public static  final int BOX_SIZE = 20;
    public int x;
    public int y;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;

        Box box = (Box) o;

        if (x != box.x) return false;
        return y == box.y;

    }
}
