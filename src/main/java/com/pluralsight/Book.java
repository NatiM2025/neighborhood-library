package com.pluralsight;

public class Book {
    private int id;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book (int id, String checkedOutTo, String title, boolean isCheckedOut) {
        this.id = id;
        this.checkedOutTo = checkedOutTo;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name) {

    }

    public void checkIn() {

    }

    @Override
    public String toString() {
        return id + " " + title ;
    }
}