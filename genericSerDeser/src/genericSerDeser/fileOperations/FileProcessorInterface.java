package genericSerDeser.fileOperations;

public interface FileProcessorInterface {
	String readLineFromFile();
	void writeLineToFile(String line);
	void close();
}
