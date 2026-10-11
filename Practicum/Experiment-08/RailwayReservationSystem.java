class TicketBooking {
    private String passengerName;
    private String bookingStatus;

    public TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = "Pending";
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void displayBookingDetails(String threadInfo) {
        System.out.println("---------------------------------------------");
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Booking Status : " + bookingStatus);
        System.out.println("Executed By    : " + threadInfo);
        System.out.println("---------------------------------------------");
    }
}

class BookingThread extends Thread {
    private TicketBooking booking;

    public BookingThread(String passengerName, String threadName) {
        super(threadName);
        this.booking = new TicketBooking(passengerName);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            booking.setBookingStatus("Confirmed");
            String threadInfo = "Thread [Name: " + getName() + ", ID: " + getId() + "]";
            booking.displayBookingDetails(threadInfo);
        } catch (InterruptedException e) {
            System.err.println("Booking interrupted for: " + booking.getPassengerName());
        }
    }
}

class BookingRunnable implements Runnable {
    private TicketBooking booking;

    public BookingRunnable(String passengerName) {
        this.booking = new TicketBooking(passengerName);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            booking.setBookingStatus("Confirmed");
            Thread current = Thread.currentThread();
            String threadInfo = "Runnable Thread [Name: " + current.getName() + ", ID: " + current.getId() + "]";
            booking.displayBookingDetails(threadInfo);
        } catch (InterruptedException e) {
            System.err.println("Booking interrupted for: " + booking.getPassengerName());
        }
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("   RAILWAY TICKET RESERVATION SYSTEM");
        System.out.println("=============================================\n");

        BookingThread thread1 = new BookingThread("Rahul", "Thread-Rahul");
        BookingThread thread2 = new BookingThread("Aman", "Thread-Aman");
        Thread thread3 = new Thread(new BookingRunnable("Priya"), "Runnable-Priya");
        Thread thread4 = new Thread(new BookingRunnable("Neha"), "Runnable-Neha");

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
            System.err.println("Main thread interrupted while waiting for bookings to finish.");
        }

        System.out.println("\nAll passenger booking requests have been processed successfully.");
    }
}