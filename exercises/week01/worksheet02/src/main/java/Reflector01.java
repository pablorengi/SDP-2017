

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;
/**
 * Created by pabloren on 23/01/2017.
 */
public class Reflector01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.println("Enter the class name: ");
        String str = in.nextLine();

        out.println("Enter the parameters: (exit to terminate)");
        String ars = in.nextLine();
        List<String> strings = new ArrayList<>();

        while(!ars.equals("exit")) {
            strings.add(ars);
            ars = in.nextLine();
        }

        if(strings.size() != 0) {
            for(String s : strings) {
                out.println(s);
            }
        }

        try{
            if(str != null || !str.equals("")) {
                Class<?> cls = Class.forName(str);
                out.println(cls.getName());
                Constructor ctr = cls.getConstructor();
//                Constructor ctr = null;
//                int len = ars.length();
//                for(Constructor c : constructors) {
//
//                    Class<?>[] type  = c.getParameterTypes();
//                    ctr = c;
//                }
                ctr.setAccessible(true);
                Object obj = (Object) ctr.newInstance();
                out.println(obj.getClass().getCanonicalName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}