package uom.oppbasics.shapes;

public class House {

    private Triangle roof;
    private Square building;
    private Square window;

    public House() {
        this.roof = new Triangle();
        this.building = new Square();
        this.window = new Square();
    }

    private void makeVisible() {
        roof.makeVisible();
        building.makeVisible();
        window.makeVisible();
    }

    public void draw(){
        roof.changeSize(50, 120);
        roof.moveHorizontal(30);
        roof.moveVertical(50);

        window.changeColor("black");
        window.changeSize(60);
        window.moveHorizontal(50);

        building.changeSize(80);
        building.moveVertical(150);
        building.moveHorizontal(-20);
        makeVisible();
    }
}
