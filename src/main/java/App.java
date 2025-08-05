import java.util.Scanner;

public class App {
    void run() {

        System.out.println("명령어:");

        String cmd = sc.nextLine().trim();

        if(cmd.equals("write")) {
           write();
        } else if(cmd.equals("list")) {
            // list();
        } else if(cmd.equals("detail")) { //조회수 증가
            // detail();
        } else if(cmd.equals("update")) { 
            // update();
        } else if(cmd.equals("delete")) {
            // delete();
        } else if(cmd.equals("exit")) {
            // exit();
        } else if(cmd.equals("search")) {
            // search();
        } else {
            System.out.println("알 수 없는 명령어입니다.");
        }



    }


}