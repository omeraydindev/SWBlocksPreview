package ma.swblockspreview.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Bean {

    public String toString(Bean newBean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Field[] fields = newBean.getClass().getFields();

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                try {
                    stringBuilder.append(field.getName());
                    stringBuilder.append("=");
                    stringBuilder.append(field.get(newBean));
                    stringBuilder.append(",");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
