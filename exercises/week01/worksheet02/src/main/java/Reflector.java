
import java.util.Scanner;
import java.lang.Class;
/**
 * Created by pabloren on 23/01/2017.
 */
public class Reflector {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Enter the class name: ");
        Scanner in = new Scanner(System.in);

        String str = "java.util.Scanner";

        while(str != "") {
            Class<?> c = Class.forName(str);
            System.out.println(c.getName());
            str = in.next();
        }
    }


}
