/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RevisionHitory;

import common.Difference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mzc048
 */
public class RevisionHistory {

    /**
     * とりあえずListを含むDTOの差異検査のみ
     *
     * @param left
     * @param right
     * @param cls
     * @return
     */
    public static List<Difference> inspect(Object left, Object right) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        List<Difference> ret = new ArrayList<>();
        System.out.println("cls=" + left.getClass().getCanonicalName());
        Object instance = left.getClass().getConstructor().newInstance();
        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            System.out.println("field name=" + field.getName());
            System.out.println("field class=" + type.getCanonicalName());

            try {
                Object leftfieldvalue = field.get(left);
                if ((List.class).isAssignableFrom(type)) {
                    List<Difference> inspected = inspectList(leftfieldvalue, field.get(right));
                    if (inspected != null && inspected.size() > 0) {
                        ret.addAll(inspected);
                    }
                } else {
                    if (leftfieldvalue != null) {
                        System.out.println(leftfieldvalue.toString());
                    }
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(RevisionHistory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(RevisionHistory.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("--");
        }
        return ret;
    }

    private static List<Difference> inspectList(Object left, Object right) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("inspectList");
        return null;
    }
}
