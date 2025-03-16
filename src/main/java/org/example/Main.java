package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println(checkLeapYear( -2028));
        //System.out.println(calculateAmountTaxi(30));
        //getMultiplicationTable();
        //System.out.println(getMax(-1,0,100));
        //System.out.println(capitalizerFirstLetter("bạn xinh đẹp quá"));
        //System.out.println(getMaxInArray(new int[]{34,1,23,4,3,12,45,33,6,22, 100}));
       // System.out.println(getSum(new int[]{34,1,23,4,3,12,45,33,6,2}));
        /* Viet chuong trinh tim ra nhung so <=30 trong mang so nguyen cho truoc {34,1,23,4,3,12,45,33,6,2}*/
        Integer[] numbers = {34, 1, 23, 4, 3, 12, 45, 33, 6, 2};
        System.out.println("Các số nhỏ hơn hoặc bằng 30 trong mảng:");
        List<Integer> list = Arrays.stream(numbers)
                .filter(num -> num <= 30)
                .toList();
        System.out.println(list);
        List<HocSinh> classroom = new ArrayList<HocSinh>();
        Random rand = new Random();
        String[] names = {"Huong", "Anh", "Mai", "Doti", "Hoa", "Nhu", "Hong", "Khanh", "Tien", "Phuong"};

        // Tạo danh sách 10 học sinh với dữ liệu random
        for (int i = 0; i < 10; i++) {
            String ten = names[rand.nextInt(names.length)]; // Random tên từ mảng
            int tuoi = rand.nextInt(8) + 18; // Random tuổi từ 18 đến 25
            double diemTB = Math.round((rand.nextDouble() * 9.0 + 1.0) * 100.0) / 100.0; // Random điểm từ 1.0 đến 10.0 (2 chữ số thập phân)
            classroom.add(new HocSinh(ten, tuoi, diemTB));
        }
        //in ra thing tin cua cac học sinh xuat sac
        classroom.stream().forEach(HocSinh::infor);
        classroom.stream()
                .filter(hocSinh -> hocSinh.rate() == Rating.XUAT_SAC)
                .forEach(HocSinh::infor);
        //in ra thong tin cua cac hoc sinh co tuoi >= 20
        classroom.stream()
                .filter(HocSinh -> HocSinh.getAge() >= 20)
                .map(HocSinh::getName)
                .forEach(System.out :: println);
        //in ra ten cua hoc sinh co diem trung binh cao nhat
        classroom.stream()
                .max(Comparator.comparing(HocSinh::getAverageScore))
                .get()
                .infor();
    }

    public static boolean checkEvenOrOdd(int number){
        return number % 2 == 0;
    }


    public static boolean checkLeapYear(int year){
        if(year < 0)
        {
            throw new IllegalArgumentException("Year must be greater than 0");
        }
        return((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0) );
    }

    public static Float calculateAmountTaxi(int km)
    {
        if(km <= 0)
        {
            throw new IllegalArgumentException("Km must be greater than 0");
        }
        float amount = 0;
        int firstKm = 13000;
        int betweenKm = 10000;
        int lastKm = 8000;
        if(km <= 1)
        {
            amount += firstKm;
        }
        if (km <= 10) {
            amount += firstKm + (km - 1) * betweenKm;
        }
        else
        {
                amount += firstKm +9 * betweenKm + (km-10) * lastKm;
        }
        return amount;
    }

    public static void getMultiplicationTable()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.printf("Bảng cửu chương %d\n", i);
            for(int j = 1; j <= 10; j++)
            {
                System.out.printf("%d x %d = %d\n", i , j, i * j);
            }
        }
    }
    public static int getMax(int a, int b, int c)
    {
        int max = a;
        if(b > max)
        {
            max = b;
        }
        if(c > max)
        {
            max = c;
        }
        return max;
    }
    public static String capitalizerFirstLetter(String str)
    {
        if(str == null || str.isEmpty())
        {
            throw new IllegalArgumentException("Invalid input");
        }
        String [] strings = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String s : strings)
        {
            sb.append(s.substring(0,1).toUpperCase())
            .append(s.substring(1))
            .append(" ");
        }
        return sb.toString().trim();
    }
    public static int getMaxInArray(int[] arrInt)
    {
//        if(arrInt == null || arrInt.length == 0)
//        {
//            throw new IllegalArgumentException("Invalid input");
//        }
//        int maxArr = arrInt[0];
//        for(int i = 1; i < arrInt.length; i++)
//        {
//            if(arrInt[i] > maxArr)
//            {
//                maxArr = arrInt[i];
//            }
//        }
        return Arrays.stream(arrInt).max().getAsInt();
    }
    public static int getSum(int[] arrInt)
    {
        return Arrays.stream(arrInt).sum();
    }
    /*    Viết chương trình để tạo một lớp học sinh    Giải thích đề bài
    Bài tập yêu cầu bạn viết một chương trình để tạo một lớp HocSinh.
    Lớp này sẽ chứa các thuộc tính và phương thức để mô tả và thao tác với đối tượng học sinh.
    Các thuộc tính cơ bản của học sinh có thể bao gồm tên, tuổi, điểm trung bình,
    và các phương thức để hiển thị thông tin học sinh hoặc tính toán các giá trị nào đó. */
}

