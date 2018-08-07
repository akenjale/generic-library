package genericSerDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import genericSerDeser.fileOperations.FileProcessorInterface;
import genericSerDeser.fileOperations.Logger;
import genericSerDeser.fileOperations.Logger.DebugLevel;
import genericSerDeser.strategy.SerializationStrategy;

public class PopulateObjects {

	private FileProcessorInterface fpi;
	private List<Object> objectList;
	
	/**
	 * Constructor
	 */
	public PopulateObjects(FileProcessorInterface fpiIn) {
		Logger.writeMessage("PopulateObjects Constructor is called ", DebugLevel.CONSTRUCTOR);
		fpi = fpiIn;
		objectList = new LinkedList<Object>();
	}
		
	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectListIn) {
		objectList = objectListIn;
	}

	/**
	 * This method uses java reflection to create objects from the 
	 * information in the input-file.
	 */
	public void deserObjects() {
		String line = null, nextLine = null, clsName = null;
		Class<?> cls = null;
		Object obj = null;
		while(null != (line=fpi.readLineFromFile())) {
			if(line.contains("<fqn:")){
				clsName = line.substring(5, line.length()-1);
				try {
					cls = Class.forName(clsName);
				} catch (ClassNotFoundException e) {
					System.err.println("Class not found.");
					e.printStackTrace();
					System.exit(1);
				} finally {
					
				}
				
				try {
					obj = cls.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					System.err.println("Error while instantiating object of class.");
					e.printStackTrace();
					System.exit(1);
				} finally {
					
				}
			}
			while(null != (nextLine = fpi.readLineFromFile())){
				if(nextLine.contains("</fqn:")||nextLine == null)
					break;
				else {
					String[] parts = nextLine.split(" ");
					String argType = parts[0].substring(6, parts[0].length()-1);
					String argVar = parts[1].substring(4, parts[1].length()-1);
					String argValue = parts[2].substring(6, parts[2].length()-1);
					
					Class[] signature = new Class[1];
					if (argType.equals("byte")) {
						signature[0] = Byte.TYPE;
					}
					if (argType.equals("short")) {
						signature[0] = Short.TYPE;
					}
					if (argType.equals("int")) {
						signature[0] = Integer.TYPE;
					}
					if (argType.equals("long")) {
						signature[0] = Long.TYPE;
					}
					if (argType.equals("float")) {
						signature[0] = Float.TYPE;
					}
					if (argType.equals("double")) {
						signature[0] = Double.TYPE;
					}
					if (argType.equals("boolean")) {
						signature[0] = Boolean.TYPE;
					}
					if (argType.equals("char")) {
						signature[0] = Character.TYPE;
					}
					if (argType.equals("String")) {
						signature[0] = String.class;
					}
					
					String methdName = "set" + argVar;
					Method meth= null;
					try {
						meth = cls.getMethod(methdName, signature[0]);
						
					} catch (NoSuchMethodException | SecurityException e) {
						System.err.println("Error finding the specified method.");
						e.printStackTrace();
						System.exit(1);
					} finally {
						
					}
					
				    Object[] params = new Object[1];
				    if(!argValue.equals("")) {
					    try {
						    if (argType.equals("byte")) {
						    	params[0] = Byte.valueOf(argValue);
						    }
						    if (argType.equals("short")) {
					    		Short s = Short.valueOf(argValue);
								params[0] = s;
							}
						    if (argType.equals("int")) {
						    	params[0] = Integer.parseInt(argValue);
							}
						    if (argType.equals("long")) {
								params[0] = Long.parseLong(argValue);
							}
						    if (argType.equals("float")) {
						    	params[0] = Float.parseFloat(argValue);
							}
						    if (argType.equals("double")) {
						    	params[0] = Double.parseDouble(argValue);
							}
						    if (argType.equals("boolean")) {
						    	params[0] = Boolean.parseBoolean(argValue);
							}
						    if (argType.equals("char")) {
								params[0] = argValue.charAt(0);
							}
						    if (argType.equals("String")) {
						    	params[0] = argValue;
							}
					    } catch (Exception e) {
					    	System.err.println("Error while parsing.");
					    	e.printStackTrace();
					    	System.exit(1);
					    } finally {
					    	
					    }
				    
					    try {
							meth.invoke(obj, params);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							System.err.println("Error while invoking the specified method.");
							e.printStackTrace();
							System.exit(1);
						} finally {
							
						}
				    }
				}
			}
			this.getObjectList().add(obj);
		}
	}
	
	public void processObjects(List<Object> list, SerializationStrategy ss) {
		for(Object obj: list) {
			String serializedObject = ss.createDPMLFormat(obj);
			fpi.writeLineToFile(serializedObject);
		}
		fpi.close();
	}
	
}
