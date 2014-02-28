package game;


 /**
  * Stellt einen dreidimensionalen Vektor dar.
  *
  * @author Roland Ganaus
  * @project Second AI-Test
  * @version 1.0
  */
 public class Vector3D
 {
	private double x;
	private double y;
	private double z;
 
	/**
	 * Konstruktor: Legt die Startwerte des Vektors fest.
	 * @param x Startwert f�r den x-Parameter
	 * @param y Startwert f�r den y-Parameter
	 * @param z Startwert f�r den z-Parameter
	 */
	public Vector3D(double x, double y, double z) {
		set(x, y, z);
	}
 
	/**
	 * Kopier-Konstruktor: �bernimmt die Startwerte des Vektors von einem anderen Vektor.
	 * @param vector Vektor, dessen Parameter f�rs aktuelle Objekt �bernommen werden
	 */
	public Vector3D(Vector3D vector) {
		set(vector);
	}
	
	/**
	 * Setzt die Werte des Vektors neu.
	 * @param x Neuer x-Parameter
	 * @param y Neuer y-Parameter
	 * @param z Neuer z-Parameter
	 */
	public void set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
 
	/**
	 * Setzt die Werte des Vektors neu.
	 * @param vector Vektor, dessen Parameter f�rs aktuelle Objekt �bernommen werden
	 */
	public void set(Vector3D vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}
	
	/**
	 * Gibt einen neuen Vector3D zur�ck, dessen Werte denen des aktuellen
	 * Vektors, multipliziert mit einem Skalar entsprechen.
	 * @param scalar Skalar, mit dem alle Vektorwerte multipliziert werden.
	 */
	public Vector3D multiply(double scalar) {
		return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
	}
	
	/**
	 * Gibt den x-Parameter zur�ck.
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Gibt den y-Parameter zur�ck.
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Gibt den z-Parameter zur�ck.
	 */
	public double getZ() {
		return this.z;
	}
	
	/**
	 * Vergleicht zwei Vector3D-Objekte auf Gleichheit.
	 * @param obj Objekt mit dem das aktuelle Objekt verglichen wird
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this.getClass() == obj.getClass()) {
			Vector3D vector = (Vector3D) obj;
			if (this.x == vector.x && 
			    this.y == vector.y && 
				 this.z == vector.z) {
				 
				return true;
			}
		}
		
		return false;
	}
	
 }