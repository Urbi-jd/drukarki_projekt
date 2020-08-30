import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PrintAll printAll = new PrintAll();
        System.out.println("Witaj uzytkowniku. Którą bazę chcesz wydrukować");
        System.out.println("1: lokalizacje");
        System.out.println("2: drukarki");
        int number = 0;
        String choice = "";
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        switch (number){
            case 1:
                choice += "location";
                break;
            case 2:
                choice += "printers";
                break;
            default:
                System.out.println("błędny wybór");
        }





        printAll.printAll(choice);

//        departmentDao.printAll();
//        System.out.println("-------------");
//        departmentDao.printOne(2);
//        System.out.println("-------------");
//    departmentDao.insert("Nowy departament");
//        departmentDao.printAll();


    }
}
