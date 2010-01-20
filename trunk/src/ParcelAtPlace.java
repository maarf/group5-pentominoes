
/**
 * Represents one parcel at defined point in the truck.
 * 
 * 20/01/2010
 * 
 * @author Martins Spilners
 * 
 */
public class ParcelAtPlace {
	public Parcel parcel;
	public int x, y, z;
	public ParcelAtPlace(Parcel aParcel, int aX, int aY, int aZ) {
		parcel = aParcel;
		x = aX;
		y = aY;
		z = aZ;
	}
}