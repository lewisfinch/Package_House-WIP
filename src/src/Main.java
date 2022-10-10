import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Write a test for Locker: insert packages and unlock.



//        System.out.println("Enter the number of packages: ");
//        Scanner s = new Scanner(System.in);
//        int num = s.nextInt();
//        Package[] packages = new Package[num];
//        packageGenerator(packages, num);
//
//        System.out.println("Printing out packages: \n");
//        for (int i = 0; i < num; i++) {
//            packages[i].show();
//        }
//
//        System.out.println("Test Ends.\n");

    }




    /*
        packageGenerator():
        - use for testing
        - generate packages info and numbers
     */
    public static Package[] packageGenerator(Package[] packages, int number){
        for (int i = 0; i < number; i++) {
            packages[i] = new Package();
            packages[i].setStatus(0);
            packages[i].setOrderNumber(900000000 + i);
            packages[i].setInfo("NAME: "+i+"; ADDRESS: "+i*123);
        }
        return packages;
    }


}