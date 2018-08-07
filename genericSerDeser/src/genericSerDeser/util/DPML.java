package genericSerDeser.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericSerDeser.strategy.SerializationStrategy;

public class DPML implements SerializationStrategy {

	@Override
	public String createDPMLFormat(Object obj) {
		String serializedObject = "", value =null;
		Method getterMethod =null;
		Class<? extends Object> c = obj.getClass();
		String clsName = c.getName();
		serializedObject+="<fqn:"+clsName+">\n";
		
		Field[] fields = c.getDeclaredFields();
		
		for(Field f: fields) {
			String varName = f.getName();
			f.setAccessible(true);
			serializedObject+="<type="+f.getType().getSimpleName()+", ";
			serializedObject+="var="+varName.substring(0, 1).toUpperCase()+varName.substring(1)+", ";
			try {
				getterMethod = c.getMethod("get"+varName.substring(0, 1).toUpperCase()+varName.substring(1));
			} catch (NoSuchMethodException | SecurityException e1) {
				System.err.println("Error while getting the method.");
				e1.printStackTrace();
				System.exit(1);
			}
			finally {
				
			}
			try {
				value = getterMethod.invoke(obj).toString();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				System.err.println("Error while invoking the method.");
				e1.printStackTrace();
				System.exit(1);
			}
			finally {
				
			}
			serializedObject+="value="+value+">\n";
		}
		serializedObject+="</fqn:"+clsName+">\n";		
		return serializedObject;
	}

}
