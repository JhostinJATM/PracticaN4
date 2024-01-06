/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Jhostin
 */
public class Utilidades {
    
    public static Field getField(Class clazz, String attribte){
        
        Field[] fields = clazz.getFields();
        Field resp = null;
//        System.out.println(fields.length);

        for(Field f:fields){
            if(attribte.equalsIgnoreCase(f.getName())){
                resp = f;
            }
        }
        
        Field[] fields1 = clazz.getDeclaredFields();
//        System.out.println(fields1.length);
        for(Field f:fields1){
            if(attribte.equalsIgnoreCase(f.getName())){
                resp = f;
            }
        }
        return resp;
    }
    
    public static Object getData(Object clas, String attribte) throws InvocationTargetException, IllegalAccessException{
        Class clazz = clas.getClass();
        Field f = getField(clazz, attribte);
        Object obj = null;
        if(f != null){
            String auxAttribute = "get" + capitalize(attribte);
            Method method = null;
            for(Method m: clazz.getMethods()){
//                System.out.println(m.getName());
                if(m.getName().equalsIgnoreCase(auxAttribute)){
                    method = m;
                    break;
                }
            }
            for(Method m: clazz.getDeclaredMethods()){
//                System.out.println(m.getName());
                if(m.getName().equalsIgnoreCase(auxAttribute)){
                    method = m;
                    break;
                }
            }
            if(method != null){
                obj = method.invoke(clas);
            }
        }
        return obj;
    }
    
    public static String capitalize(String cnd){
        char [] caracteres = cnd.toCharArray();
        String aux = String.valueOf(caracteres[0]).toUpperCase();
        caracteres[0] = aux.charAt(0);
        return new String(caracteres);
    }
    
}
