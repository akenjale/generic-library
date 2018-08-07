Generic Library to Serialize and Deserialize Objects

#Compilation
From the folder: kenjale_ashish_assignment5\genericDeser\src

ant all
ant prepare

TO RUN:
From the folder: kenjale_ashish_assignment5\genericDeser

ant -buildfile src/build.xml clean all run -Darg0=<input-file-name> -Darg1=<output-file-name> -Darg2=<logger level>

Example:
ant -buildfile src/build.xml clean all run -Darg0=input-1.txt -Darg1=output.txt -Darg2=0

The files are read from here:
	kenjale_ashish_assignment5/genericDeser/src/input-1.txt

will use Logger for debug level 0

CHOICE OF DATA STRUCTURE:
Data structure used is LinkedList because there is no need to get unique objects like in assignment4.
Time complexity of inserting elements is O(1) and accessing elements is O(n).

Citations:
NA

