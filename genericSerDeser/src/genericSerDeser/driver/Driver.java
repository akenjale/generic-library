package genericSerDeser.driver;

import java.io.File;
import java.util.List;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.fileOperations.FileProcessorInterface;
import genericSerDeser.fileOperations.Logger;
import genericSerDeser.strategy.SerializationStrategy;
import genericSerDeser.util.DPML;
import genericSerDeser.util.PopulateObjects;

public class Driver{

	public static void main(String args[]) {
	    SerializationStrategy ss;
	    List<Object> list;
	    Driver dr = new Driver();
	    dr.validateArgs(args);

	    System.out.println("\n Geting Started\n");
	    FileProcessorInterface fpi = new FileProcessor(args[0], args[1]);
	    PopulateObjects po = new PopulateObjects(fpi);
	    po.deserObjects();
	    list = po.getObjectList();
	    ss = new DPML();
	    po.processObjects(list, ss);
	}
	
	private void validateArgs(String args[]){
		//validate number of arguments
		if(args.length==3){
		    // get file names
			try{
				String inputfile = args[0];
				File file;
				file = new File(inputfile);
				if(!file.exists() || !file.canRead() || null==inputfile){
					System.err.println("The input file does not exist or is null.");
					System.exit(1);
				}
				else {
					if(file.length() == 0) {
						System.err.println("The input file is empty.");
						System.exit(1);
					}
				}
				String outputfile = args[1];
				if(null==outputfile){
					System.err.println("Please provide a valid .txt filename as argument.");
					System.exit(1);
				}
				Integer debuglevel = Integer.parseInt(args[2]);
				Logger.setDebugValue(debuglevel);

			}catch(IllegalArgumentException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}
			catch(Exception ex){
				System.err.println("Exception occured.");
				ex.printStackTrace();
				System.exit(1);
			}
			finally{

			}
		}else{
			System.err.println("Invalid number of arguments. Expected \n[Correct usage: ant -buildfile src/build.xml run -Darg0=<Input_file_name> -Darg1=<Debug_Level>]");
			System.exit(1);
		}
	}

} // end public class Driver