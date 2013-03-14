package de.novensa.cs.performance.macadamia;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * My developments´ test range.
 *
 * @author Daniel Schulz
 */
@SuppressWarnings({"UnusedDeclaration", "DefaultFileTemplate"})
public class TestRange {

    public static void main(String[] args) {
    }

    public void getMethods(String clazz) {
        Class c = null;
        try {
            c = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(c);

        Method[] methods = new Method[0];
        if (c != null) {
            methods = c.getMethods();
        }
        for (Method m : methods) {
            System.out.println(m);
            if ("public int java.lang.String.codePointCount(int,int)".equals(m.toString())) {
                try {
                    m.invoke(1, 2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InvocationTargetException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }
}
