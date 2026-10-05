class TicketBooking {
    String passengerName;
    String bookingStatus;

    public TicketBooking(String passengerName, String bookingStatus) {
        this.passengerName = passengerName;
        this.bookingStatus = bookingStatus;
    }
    public void displayBookingDetails() {
        System.out.println("Passenger Name: " + passengerName + 
                           " | Booking Status: " + bookingStatus + 
                           " | Thread Name: " + Thread.currentThread().getName());
    }
}
class BookingThread extends Thread {
    TicketBooking booking;

    public BookingThread(TicketBooking booking, String threadName) {
        super(threadName);
        this.booking = booking;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            booking.displayBookingDetails();
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted for " + booking.passengerName);
        }
    }
}
class BookingRunnable implements Runnable {
    TicketBooking booking;

    public BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            booking.bookingStatus = "Confirmed";
            booking.displayBookingDetails();
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted for " + booking.passengerName);
        }
    }
}
public class RailwayReservationSystem {
    public static void main(String[] args) {
        TicketBooking passenger1 = new TicketBooking("Shreyas", "Processing");
        TicketBooking passenger2 = new TicketBooking("Aman", "Processing");
        TicketBooking passenger3 = new TicketBooking("Satwik", "Processing");
        TicketBooking passenger4 = new TicketBooking("Varshini", "Processing");
        BookingThread thread1 = new BookingThread(passenger1, "Thread-1 (Extends)");
        BookingThread thread2 = new BookingThread(passenger2, "Thread-2 (Extends)");
        BookingRunnable runnable1 = new BookingRunnable(passenger3);
        BookingRunnable runnable2 = new BookingRunnable(passenger4);
        Thread thread3 = new Thread(runnable1, "Thread-3 (Runnable)");
        Thread thread4 = new Thread(runnable2, "Thread-4 (Runnable)");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nAll passenger booking requests have been processed successfully.");
    }
}