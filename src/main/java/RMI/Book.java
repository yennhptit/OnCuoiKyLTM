/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Book implements Serializable{
    private static final long serialVersionUID = 20241123L;
    public String id, title, author;
    public int yearPublished, pageCount;
    public String code;

    public Book() {
    }

    
    
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
   
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", pageCount=" + pageCount + ", code=" + code + '}';
    }
    
    public void setCodeForBook()
    {
        String ans = "";
        String author2 = author.toUpperCase();
        String[] arrTg = author2.split(" ");
        
        ans += arrTg[0].charAt(0);
        ans += arrTg[arrTg.length - 1].charAt(0);
        String nxb = String.valueOf(yearPublished);
        String subs = nxb.substring(nxb.length() - 2, nxb.length());
        System.out.println(subs);
        ans += subs;
        int cntChuCaiTitle = 0;
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : title.toCharArray())
        {
            if (Character.isLetter(c))
            {
                cntChuCaiTitle ++;
                arrayList.add(c);
            }
        }
        String sotrang = String.valueOf(pageCount);
        while (sotrang.length() < 3)
        {
            sotrang = "0" + sotrang;
        }
        ans += cntChuCaiTitle;
        ans += sotrang;
        code = ans;
    }

}
