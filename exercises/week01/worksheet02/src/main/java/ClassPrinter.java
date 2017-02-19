

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * Created by pabloren on 27/01/2017.
 * Generic class to print Classes as a toString method would do.
 */
public class ClassPrinter {
    public static void main(String[] args) {
        Class<?> c = StudentClass.class;
        printing(c);
    }

    private static void printing(Class<?> aClass) {
        System.out.println("Printing the class...\n" + aClass.getCanonicalName());

        printMembers(aClass.getConstructors(), "Constructor");
        printMembers(aClass.getDeclaredFields(), "Fields");
        printMembers(aClass.getDeclaredMethods(), "Methods");


    }

    private static void printMembers(Member[] mbrs, String s) {
        System.out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                System.out.format("  %s%n", ((Field)mbr).toGenericString());
            else if (mbr instanceof Constructor)
                System.out.format("  %s%n", ((Constructor)mbr).toGenericString());
            else if (mbr instanceof Method)
                System.out.format("  %s%n", ((Method)mbr).toGenericString());
        }
        if (mbrs.length == 0)
            System.out.format("  -- No %s --%n", s);
        System.out.format("%n");
    }
}
