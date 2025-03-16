package org.example;

import java.util.Map;
import java.util.Random;

public class HocSinh {
    private  String id;
    private String Name;
    private int Age;
    private double averageScore;

    // Constructor (Hàm khởi tạo)
    public HocSinh(String name, int age, double averageScore) {
        Random random = new Random();
        int randomInt = 1000 + random.nextInt(9000);
        this.id = "TVN-AK48-" + randomInt;
        this.Name = name;
        this.Age = age;
        this.averageScore = averageScore;
    }

    public int getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }

    public double getAverageScore() {
        return averageScore;
    }

    // Phương thức hiển thị thông tin học sinh
    public void infor() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Rate: " + rate().getDescription());
        System.out.println("==================================");
    }

    // Phương thức xếp loại học sinh dựa vào điểm trung bình
    public Rating rate() {
        if(averageScore <= 0 || averageScore > 10)
        {
            throw new IllegalArgumentException("Invalid input");
        }
        if (averageScore >= 9.0) return Rating.XUAT_SAC;
        if (averageScore >= 8.0) return Rating.GIOI;
        if (averageScore >= 6.5) return Rating.KHA;
        if (averageScore >= 5.0) return Rating.TRUNG_BINH;
        return Rating.YEU;
    }

    //random student id with prefix "TVN-AK48"
}
//create array of students 10 students
//in ra thông tin của những học sinh xuất sắc