import java.time.LocalDateTime;

public class demo {
    //1.nhập năm sinh 1 người. tính tuổi người đó
   public static void main(String[] args){
       LocalDateTime a = LocalDateTime.now();
       int year = a.getYear();
       System.out.println(year);
       int b = 1995;
       int c =year - b;
       System.out.println(c);
   }
}
