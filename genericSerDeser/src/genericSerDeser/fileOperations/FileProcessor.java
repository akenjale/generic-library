package genericSerDeser.fileOperations;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import genericSerDeser.fileOperations.Logger.DebugLevel;

public class FileProcessor implements FileProcessorInterface{
	private FileReader filereader;
	private FileWriter filewriter;
	private BufferedReader br;
	private BufferedWriter bw;
	
	/**
	 * Constructor
	 * @param inputfile
	 */
	public FileProcessor(String inputfile, String outputfile) {
		Logger.writeMessage("FileProcessor Constructor is called ", DebugLevel.CONSTRUCTOR);
		try {
			filereader = new FileReader(inputfile);
			filewriter = new FileWriter(outputfile);
			br = new BufferedReader(filereader);
			bw = new BufferedWriter(filewriter);
		}
		catch(FileNotFoundException ex) {
			System.err.println("Unable to open file " + inputfile +".");
			ex.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error writing to file " + outputfile +".");
			e.printStackTrace();
			System.exit(1);
		}
		
		finally{

		}
		
	}
	
	/**
	 * @return String
	 */
	public String readLineFromFile() {
		try {		
			return br.readLine();
		}
		catch(FileNotFoundException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		catch(IOException ex) {
			System.err.println("Unable to open file.");
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
		finally{

		}
	}

	@Override
	public void writeLineToFile(String line) {
		try {
			bw.write(line);
		}
		catch(FileNotFoundException ex) {
			System.err.println("File not found.");
			ex.printStackTrace();
			System.exit(1);
			
		}
		catch(IOException ex) {
			System.err.println("Error while writing.");
			ex.printStackTrace();
			System.exit(1);
		}
		finally{

		}
	}

	@Override
	public void close() {
		try {
			bw.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File not found.");
			ex.printStackTrace();
			System.exit(1);
			
		}
		catch(IOException ex) {
			System.err.println("Error while writing.");
			ex.printStackTrace();
			System.exit(1);
		}
		finally{

		}		
	}
	
	
}