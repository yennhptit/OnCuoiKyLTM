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
public class Customer implements Serializable {

    private static final long serialVersionUID = 20151107;
    public String id, code, name, dayOfBirth, userName;

    public Customer() {
    }

    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", code=" + code + ", name=" + name + ", dayOfBirth=" + dayOfBirth + ", userName=" + userName + '}';
    }

    public void chuanHoaTen() {
        String[] arr = name.split(" ");
        String newName = "";
        newName += arr[arr.length - 1].toUpperCase() + ", ";
        for (int i = 0; i < arr.length - 1; i++) {
            newName += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase() + " ";
        }
        name = newName.trim();
    }

    public void chuanHoaNgaySinh() {
        String[] arr = dayOfBirth.split("-");
        String newDay = "";
        newDay = arr[1] + "/" + arr[0] + "/" + arr[2];
        dayOfBirth = newDay;
    }

    public void chuanHoaUsername() {
        String[] arr = name.split(" ");
        String newName = "";
        for (int i = 0; i < arr.length - 1; i++) {
            newName += arr[i].substring(0, 1).toLowerCase();
        }
        newName += arr[arr.length - 1].toLowerCase();

        userName = newName.trim();
    }
}
