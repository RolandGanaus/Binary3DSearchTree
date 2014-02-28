
package game;

/**
 *
 * @author Roland
 */
public class WorldObject implements HasCoordinates {
    
    static int idGenerator = 0;

    int id;
    Coordinates coord;

    public WorldObject(double x, double y, double z) {
        this.id = idGenerator;
        ++idGenerator;
        this.coord = new Coordinates(x, y, z);
    }

    @Override
    public Coordinates getCoordinates() {
        return coord;
    }
    
    @Override
    public String toString() {
        return "(" + String.valueOf(this.id) + ")";
    }
}
