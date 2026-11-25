import java.util.Scanner;
interface AccessControl{
    String getRole();
    int getAccessLevel();
    boolean canAccess(int requiredLevel);
}

class Developer implements AccessControl{
    @Override 
    public String getRole(){
        return "Developer";
    }

    @Override
    public int getAccessLevel(){
        return 1;
    } 

    @Override 
    public boolean canAccess(int requiredLevel){
        return getAccessLevel() >= requiredLevel;
    }
}

class Manager implements AccessControl{
    @Override 
    public String getRole(){
        return "Manager";
    }

    @Override 
    public int getAccessLevel(){
        return 2;
    }

    @Override 
    public boolean canAccess(int requiredLevel){
        return getAccessLevel() >= requiredLevel;
    }
}

class Administrator implements AccessControl{
    @Override 
    public String getRole(){
        return "Administrator";
    }

    @Override 
    public int getAccessLevel(){
        return 3;
    }

    @Override 
    public boolean canAccess(int requiredLevel){
        return getAccessLevel() >= requiredLevel;
    }
}
public class EmployeeAccessAndPermissionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int roleType = scanner.nextInt();
        int requiredLevel = scanner.nextInt();
        scanner.close();
        AccessControl access;
        if(roleType == 1){
            access = new Developer();
        } else if(roleType == 2){
            access = new Manager();
        } else if(roleType == 3){
            access = new Administrator();
        } else {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Role: "+access.getRole());
        System.out.println("Access Level: "+access.getAccessLevel());
        System.out.println("Can Access: "+access.canAccess(requiredLevel));
    }
}
