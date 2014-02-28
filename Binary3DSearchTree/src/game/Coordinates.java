 package game;

 /**
  * Stellt Koordinaten in einem dreidimensionalen
  * Koordinatensystem dar.
  *
  * @author Roland Ganaus
  * @project Second AI-Test
  * @version 32.0
  */
 public class Coordinates extends Vector3D
 {
    /**
     * Konstruktor: Legt die Startkoordinaten fest.
     * @param x Startposition auf der X-Achse
     * @param y Startposition auf der Y-Achse
     * @param z Startposition auf der Z-Achse
     */
    public Coordinates(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Kopier-Konstruktor: �bernimmt die Startkoordinaten von einem Vektor.
     * @param vector Vektor, dessen Werte als Startkoordinaten �bernommen werden.
     */
    public Coordinates(Vector3D vector) {
        super(vector);
    }

    /**
     * Gibt die Distanz von der aktuellen Position zu Vergleichskoordinaten zurück.
     * @param coordinates Koordinaten, die mit den aktuellen Koordinaten verglichen werden
     */
    public double getDistance(Coordinates coordinates) {
        double tempX = coordinates.getX() - this.getX();
        double tempY = coordinates.getY() - this.getY();
        double tempZ = coordinates.getZ() - this.getZ();
        return Math.sqrt(Math.pow(tempX, 2) + Math.pow(tempY, 2) + Math.pow(tempZ, 2));
    }

    /**
     * Gibt die Richtung von der aktuellen Position zu Vergleichskoordinaten
     * als dreidimensionalen Vektor zurück.
     * @param coordinates Koordinaten, die mit den aktuellen Koordinaten verglichen werden
     */
    public Vector3D getDirection(Coordinates coordinates) {

        if (this.equals(coordinates)) {
                return new Vector3D(0.0, 0.0, 0.0);
        }

        double tempX = coordinates.getX() - this.getX();
        double tempY = coordinates.getY() - this.getY();
        double tempZ = coordinates.getZ() - this.getZ();
        double vectorLength = this.getDistance(coordinates);

        return new Vector3D(tempX / vectorLength, tempY / vectorLength, tempZ / vectorLength);
    }
 }