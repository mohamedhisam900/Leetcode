class ParkingSystem {
    // Array to store the count of available slots for each carType
    // Index 1 -> Big, Index 2 -> Medium, Index 3 -> Small
    private final int[] count;

    public ParkingSystem(int big, int medium, int small) {
        this.count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // If there is an available slot, decrement the count and return true
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        // No slots available for this car type
        return false;
    }
}
