/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    public String id, name;
    public double baseSalary;
    public int experienceYears;
    public double finalSalary;

    public Employee(String id, String name, double baseSalary, int experienceYears, double finalSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
        this.finalSalary = finalSalary;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", experienceYears=" + experienceYears + ", finalSalary=" + finalSalary + '}';
    }
    
    public void changeLuong()
    {
        String exp = String.valueOf(experienceYears);
        System.out.println(experienceYears);
        int hesoExp = 0;
        for (char c : exp.toCharArray())
        {
            String tmp = String.valueOf(c);
            hesoExp += Integer.parseInt(tmp);
        }
        System.out.println(hesoExp);
        int souoc = 0;
        for (int i = 1; i < Math.sqrt(experienceYears); i++)
        {
            if (experienceYears % i == 0)
                souoc += 2;
        }
        int sqrt = (int) Math.sqrt(experienceYears);
        if (sqrt*sqrt == experienceYears)
        {
            souoc += 1;
        }
        System.out.println(souoc);
        float factor = ((float)(experienceYears + hesoExp + souoc)) / 100.0F;
        finalSalary = baseSalary * (1 + factor);
    }
}
