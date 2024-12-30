/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    public String id, code, name, email;

    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
    
    public void changeEmail()
    {
        name = name.toLowerCase();
        String[] arr = name.split(" ");
        String ans = "";
        ans = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++)
        {
            System.out.println(arr[i]);
            char c = arr[i].charAt(0);
            ans += c;
        }
        ans += "@ptit.edu.vn";
        System.out.println(name);
        System.out.println(ans);
        email = ans;
        String newname = "";
        
        for (int i = 0; i < arr.length; i++)
        {
            String tmp = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase();
            newname += tmp + " ";
        }
        name = newname.trim();
    }
}
