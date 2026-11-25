import java.util.Scanner;
abstract class Course{
    protected double courseFee;

    public Course(double courseFee){
        this.courseFee = courseFee;
    }

    abstract double calculateDiscount();
    abstract String getCourseType();

    public double calculateFinalFee(){
        return courseFee - calculateDiscount();
    }
}

class ProgrammingCourse extends Course{
    public ProgrammingCourse(double courseFee){
        super(courseFee);
    }

    @Override 
    public double calculateDiscount(){
        return courseFee * 0.10;
    }

    @Override 
    public String getCourseType(){
        return "ProgrammingCourse";
    }
}

class DataScienceCourse extends Course{
    public DataScienceCourse(double courseFee){
        super(courseFee);
    }
    @Override 
    public double calculateDiscount(){
        return courseFee * 0.15;
    }

    @Override 
    public String getCourseType(){
        return "Data Science";
    }
}

class CloudCourse extends Course{
    public CloudCourse(double courseFee){
        super(courseFee);
    }

    @Override 
    public double calculateDiscount(){
        return courseFee * 0.05;
    }

    @Override 
    public String getCourseType(){
        return "Cloud Course";
    }

}
public class OnlineCourseFeeCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int courseType = scanner.nextInt();
        double courseFee = scanner.nextDouble();

        Course course;
        if (courseType == 1) {
            course = new ProgrammingCourse(courseFee);
        } else if (courseType == 2) {
            course = new DataScienceCourse(courseFee);
        }  else if (courseType == 3) {
            course = new CloudCourse(courseFee);
        } else {
            System.out.println("Invalid");
            scanner.close();
            return;
        }

        System.out.printf("Course Type: %s%n", course.getCourseType());
        System.out.printf("Discount: %.2f%n", course.calculateDiscount());
        System.out.printf("Final Fee: %.2f%n", course.calculateFinalFee());
        scanner.close();
    }
}
