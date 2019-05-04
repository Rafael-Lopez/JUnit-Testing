package lab5;

public class BookingSystem {

    private final int STARTING_HOUR = 9;
    private final int ENDING_HOUR = 16;

    private Integer[] bookedHours;

    public BookingSystem(Integer[] bookedHours) {
        for (int hour : bookedHours) {
            if (hour < STARTING_HOUR || hour > ENDING_HOUR) {
                throw new IllegalArgumentException("Invalid hour: " + hour);
            }
        }

        this.bookedHours = bookedHours;
    }

    public Integer[] getBookedHours() {
        return bookedHours;
    }

    public boolean checkAvailability(int hour) {
        boolean available = true;

        for (int item : bookedHours) {
            if (item == hour) {
                available = false;
            }
        }
        return available;
    }
}
