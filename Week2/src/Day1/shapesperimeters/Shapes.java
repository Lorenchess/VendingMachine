package Day1.shapesperimeters;

public abstract class Shapes {
  protected int area;
    protected int perimeter;

    public Shapes(int area, int perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public int getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }


}
