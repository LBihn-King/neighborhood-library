package com.pluralsite;
import java.util.Scanner;
public class Book {
    Scanner scanner = new Scanner(System.in);
    public int id = 0;
    public String isbn = "";
    public String title = "";
    public String author = "";
    public String series = "";
    public boolean isCheckedOut = false;
    public String isCheckedOutTo = "";

    public Book (int id, String isbn, String title, String author, String series, boolean isCheckedOut, String isCheckedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.series = series;
        this.isCheckedOut = isCheckedOut;
        this.isCheckedOutTo = isCheckedOutTo;
    }


    public void checkOut() {
        if (!isCheckedOut) {
            setIsCheckedOut(true);
            System.out.println("Provide name: ");
            String name = scanner.nextLine();
            setIsCheckedOutTo(name);
            System.out.println("Book checked out to " + name);
        } else {
            System.out.println("Book not currently available");
        }
    }
    public void checkIn() {
        setIsCheckedOut(false);
        setIsCheckedOutTo("");
        System.out.println("Book has been checked in");
    }


    public int getId() {
        return id;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }
    public String getIsCheckedOutTo() {
        return isCheckedOutTo;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsCheckedOut(boolean isCheckedOut) {
        isCheckedOut = isCheckedOut;
    }
    public void setIsCheckedOutTo(String isCheckedOutTo) {
        this.isCheckedOutTo = isCheckedOutTo;
    }
}
