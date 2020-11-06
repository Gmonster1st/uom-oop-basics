package uom.oppbasics.shapes;

public class TestClass {

    public static void main(String[] args) {
//		Circle circle1 = new Circle();
//		Square square1 = new Square();
//		Triangle triangle1 = new Triangle();
//
//		circle1.makeVisible();
//		square1.makeVisible();
//		triangle1.makeVisible();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int x = 120 * j;
                int y = 150 * i;
                new House().draw(x, y);
            }
        }
    }

}