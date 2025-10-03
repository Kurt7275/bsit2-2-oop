public class DVD extends LibraryItem implements Borrowable {
    private int duration;
    private String rating;
    private String genre;

    public DVD(String itemId, String title, String author, int duration, String rating, String genre) {
        super(itemId, title, author);
        setDuration(duration);
        setRating(rating);
        this.genre = genre;
    }

    public int getDuration() { return duration; }
    public String getRating() { return rating; }
    public String getGenre() { return genre; }

    public void setRating(String rating) {
        if (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG-13")
                && !rating.equals("R") && !rating.equals("NC-17"))
            throw new IllegalArgumentException("Invalid rating");
        this.rating = rating;
    }

    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException("Duration must be positive");
        this.duration = duration;
    }

    @Override
    public String getItemType() { return "DVD"; }

    @Override
    public double calculateLateFee(int daysLate) { return daysLate * 1.00; }

    @Override
    public void borrowItem(String borrowerName) { checkOut(borrowerName); }

    @Override
    public void returnItem() { checkIn(); }

    @Override
    public boolean isAvailable() { return !isCheckedOut; }

    @Override
    public int getBorrowingPeriod() { return 5; }

    @Override
    public String getBorrowingStatus() {
        return "DVD: " + Borrowable.super.getBorrowingStatus();
    }
}
