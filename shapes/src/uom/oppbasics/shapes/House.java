package uom.oppbasics.shapes;

import java.awt.*;

public class House {

    public static final int HORIZONTAL_LAYOUT = 5;
    public static final int VERTICAL_LAYOUT = 4;
    private static final int SPACING = HORIZONTAL_LAYOUT * VERTICAL_LAYOUT;

    private final Triangle roof;
    private final Square building;
    private final Square window;

    public House() {
        this.building = new Square();
        this.roof = new Triangle();
        this.window = new Square();
    }

    private void makeVisible() {
        building.makeVisible();
        roof.makeVisible();
        window.makeVisible();
    }

    public void draw(int x, int y) {
        makeVisible();
        Dimension canvasSize = Canvas.getCanvasSize();

        buildingSize(canvasSize);
        roofSize(canvasSize);
        window.changeColor("black");
        windowSize(building.getSize());

        assembleHouse(x, y);
    }

    private void assembleHouse(int x, int y) {
        roofPosition(x, y);
        buildingPosition();
        windowPosition();
    }

    private void roofPosition(int x, int y) {
        int resetX = (roof.getSize().width / 2) - roof.getPosition().x;
        int resetY = -roof.getPosition().y;

        roof.moveHorizontal(resetX + x);
        roof.moveVertical(resetY + y);
    }

    private void windowPosition() {
        int resetX = -window.getPosition().x;
        int resetY = -window.getPosition().y;

        int vertical = building.getPosition().y + window.getSize() + resetY;
        int horizontal = building.getPosition().x + (window.getSize() * 2) + resetX;

        window.moveHorizontal(horizontal);
        window.moveVertical(vertical);
    }

    private void buildingPosition() {
        int resetX = -building.getPosition().x;
        int resetY = -building.getPosition().y;

        int vertical = roof.getPosition().y + roof.getSize().height + resetY;
        int horizontal =
                (roof.getPosition().x + resetX)
                        - (roof.getSize().width / 2)
                        + (roof.getSize().width - building.getSize()) / 2;

        building.moveVertical(vertical);
        building.moveHorizontal(horizontal);
    }

    private void windowSize(int buildingSize) {
        int newSize = buildingSize / 4;
        window.changeSize(newSize);
    }

    private void buildingSize(Dimension canvasSize) {
        int newSize = (canvasSize.height + canvasSize.width) / (HORIZONTAL_LAYOUT * VERTICAL_LAYOUT);
        building.changeSize(newSize);
    }

    private void roofSize(Dimension canvasSize) {
        int roofWidth = (canvasSize.width / HORIZONTAL_LAYOUT) - SPACING;
        int roofHeight = (int) (roofWidth / 1.7);
        roof.changeSize(roofHeight, roofWidth);
    }
}
