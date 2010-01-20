import java.util.ArrayList;

public class Truck {

    private int height, length, width;
    private int[][][] truck;
    private int counter = 0, count = 0;
    private int currX = 0, currY = 0, currZ = 0;
    /*
     * List of all parcels in the truck.
     */
    private ArrayList<ParcelAtPlace> parcels = new ArrayList<ParcelAtPlace>();

    /**
     * This constructor constructs a Truck with a certain height, length and width.
     * @param aHeight The height of the truck.
     * @param aLength The length of the truck.
     * @param aWidth The width of the truck.
     */
    public Truck(int aHeight, int aLength, int aWidth) {
        height = aHeight;
        length = aLength;
        width = aWidth;
        truck = new int[height][length][width];
    }

    /**
     * Prints out the the Truck-array as 2-dimensional.
     */
    public void getTruckValue() {
        for (int i = 0; i < truck.length; i++) {
            for (int j = 0; j < truck[i].length; j++) {
                for (int k = 0; k < truck[i][j].length; k++) {
                    System.out.print(truck[i][j][k]);
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Checks whether the truck is full.
     * @return Returns true when the truck is full, returns false when there is an empty space.
     */
    public boolean isFull() {

        for (int i = 0; i < truck.length; i++) {
            for (int j = 0; j < truck[i].length; j++) {
                for (int k = 0; k < truck[i][j].length; k++) {
                    if (truck[i][j][k] == 0) {
                        counter++;
                    }
                }
            }
        }

        if (counter == 0) {
            counter = 0;
            return true;
        }

        return false;
    }

    /**
     * Checks whether a certain parcel fits in the truck on the next empty space.
     * @param bParcel Needs a certain parcel.
     * @return If the parcel fits on the next blank spot, true is returned. Otherwise returns false.
     */
    public boolean fits(Parcel bParcel) {
        if (width - currX >= bParcel.getParcelX() && height - currY >= bParcel.getParcelY() && length - currZ >= bParcel.getParcelZ() && isCurrentSpaceEmpty(bParcel)) {
            return true;
        }
        return false;
    }

    public boolean isCurrentSpaceEmpty(Parcel a) {
        for (int i = 0; i < a.getParcelY(); i++) {
            for (int j = 0; j < a.getParcelZ(); j++) {
                for (int k = 0; k < a.getParcelX(); k++) {
                    if (truck[currY + i][currZ + j][currX + k] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Sets the next blank spot in the truck. Needs to be called when an objects is placed.
     */
    public void NextBlank() {
        for (int i = 0; i < truck.length - 1; i++) {
            for (int j = 0; j < truck[i].length - 1; j++) {
                for (int k = 0; k < truck[i][j].length - 1; k++) {
                    if (!isfilled(i, j, k)) {
                        currY = i;
                        currZ = j;
                        currX = k;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Returns the current X.
     * @return Returns an int.
     */
    public int getCurrX() {
        return currX;
    }

    /**
     * Returns the current Y.
     * @return Returns an int.
     */
    public int getCurrY() {
        return currY;
    }

    /**
     * Returns the current Z.
     * @return Returns an int.
     */
    public int getCurrZ() {
        return currZ;
    }

    /**
     * This method sets a Parcel object in the truck on the next blank spot.
     * @param a Requires a Parcel object.
     */
    public void setParcel(Parcel a) {
        for (int i = 0; i < a.getParcelY(); i++) {
            for (int j = 0; j < a.getParcelZ(); j++) {
                for (int k = 0; k < a.getParcelX(); k++) {
                    truck[currY + i][currZ + j][currX + k] = a.getValue();
                }
            }
        }
        parcels.add(new ParcelAtPlace(a, currX, currY, currZ));
    }

    /**
     * This method sets a Figure object in the Truck on the next blank spot.
     * @param b Requires a Figure object.
     */
    public void setParcel(Figure b) {
        for (int i = 0; i < b.getWidth(); i++) {
            for (int j = 0; j < b.getHeight(); j++) {
                for (int k = 0; k < b.getDepth(); k++) {
                    truck[currY + j][currZ + k][currX + i] = b.getName();
                }
            }
        }
    }

    /**
     * Checks whether a certain location is filled.
     * @param y The y coordinate (int)
     * @param z The z coordinate (int)
     * @param x The x coordinate (int)
     * @return Returns true when the space on x,y,z is filled, returns false if it isn't filled.
     */
    public boolean isfilled(int y, int z, int x) {
        if (truck[y][z][x] == 0) {
            return false;
        }
        return true;
    }

    /**
     * Sets the next blank spot as unusable.
     */
    public void setEmpty() {
        truck[currY][currZ][currX] = 9;
        System.out.println("empty used");
    }

    /**
     * Returns the height of the Truck.
     * @return Returns an int.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the length of the Truck.
     * @return Returns an int.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the width of the Truck.
     * @return Returns an int.
     */
    public int getWidth() {
        return width;
    }

    public Object[] getParcels() {
        return parcels.toArray();
    }

    public ArrayList<ParcelAtPlace> getRawParcels() {
        return parcels;
    }

    /**
     * Returns the truck array.
     * @return Returns a 3-dimensional array.
     */
    public int[][][] getTruck() {
        return truck;
    }

    /**
     * Use very very carefully
     * @param a
     */
    public void setParcels(ArrayList<ParcelAtPlace> a) {
        parcels = a;
    }

    public void reset() {
        truck = new int[height][length][width];
        counter = 0;
        currX = 0;
        currY = 0;
        currZ = 0;

        parcels = new ArrayList<ParcelAtPlace>();
    }


    public int getValue() {
        int value = 0;
        for (ParcelAtPlace p : parcels) {
            value += p.parcel.getValue();
        }
        return value;
    }

    public int getBoxesById(int anId) {
        int count = 0;
        for (ParcelAtPlace p : parcels) {
            if (p.parcel.getId() == anId) {
                count++;
            }
        }
        return count;
    }

    public int getABoxes() {
        return getBoxesById(0);
    }

    public int getBBoxes() {
        return getBoxesById(1);
    }

    public int getCBoxes() {
        return getBoxesById(2);
    }
}
