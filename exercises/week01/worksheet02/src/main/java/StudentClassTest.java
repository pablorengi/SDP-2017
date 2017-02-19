import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
/**
 * Created by pabloren on 25/01/2017.
 */
public class StudentClassTest {

    private Class<?> aClass = StudentClass.class;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    @Test
    public void testFieldNumbers() throws ClassNotFoundException {

//        System.out.println("What's the name of the class you want to submit:");
//        Scanner in = new Scanner(System.in);
//        String aString = in.nextLine();

//        aClass = Class.forName();
        System.out.println(aClass.getName());


        int i = aClass.getDeclaredFields().length;
        System.out.println(i);
        assertTrue("The number of fields cannot be greater than 4", i <= 4);
    }

    @Test
    public void testFieldAccess() throws ClassNotFoundException {
        boolean result = true;
        Field[] fields = aClass.getDeclaredFields();
        ArrayList<Integer> list = new ArrayList<>();
        for (Field f : fields) {
            if(!Modifier.isPrivate(f.getModifiers())) {
                result = false;
            }
        }
        assertTrue("The fields cannot be private", result);
    }

    @Test
    public void testFieldTypes() throws ClassNotFoundException {
        boolean result = true;
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields) {
            if(ArrayList.class.isAssignableFrom(f.getType())) {
                result = false;
            }
        }
        assertTrue("The fields cannot be private", result);
    }

    @Test
    public void testMethodAccess() throws ClassNotFoundException {
        boolean result = true;
        int count = 0;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods) {
            int modifiers = m.getModifiers();
            if(Modifier.isPrivate(modifiers)) {
                count++;
            }
        }
        if(count < 2 ) {
            result = false;
        }
        assertTrue("There must be at least 2 methods private", result);
    }

    @Test
    public void testThrows() throws ClassNotFoundException {
        boolean result = true;
        Method[] methods = aClass.getDeclaredMethods();
        int exceptions = 0;
        for (Method m : methods) {
            Class<?>[] xType  = m.getExceptionTypes();
            exceptions += xType.length;
        }

        if (exceptions > 0) {
            System.out.println("The number of exceptions is " + exceptions);
            result = false;
        }
        assertTrue("There cannot be methods that throw exceptions ", result);
    }

    @Test
    public void testReturnType() throws ClassNotFoundException {
        boolean result = true;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods) {
            if(m.getReturnType().equals(Integer.TYPE)) {
                result = false;
            }
        }
        assertTrue("There should be no methods returning integers", result);
    }


    @Test
    public void testConstructor() throws ClassNotFoundException {
        boolean result = true;
        Constructor[] Constructors = aClass.getDeclaredConstructors();
        for (Constructor c: Constructors) {
            Class[] parameterTypes = c.getParameterTypes();
            if(parameterTypes.length > 0) {
                result = false;
            }
        }
        assertTrue("There should be no arguments in the constructors", result);
    }

    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

}
