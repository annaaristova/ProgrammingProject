
import java.io.*;
import java.util.*; 
import compressor.FileCompressor;

public class ProgrammingProject {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Map<Character, String> huffmanCodes = new HashMap<>();
        
        // check command−line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java Copy sourceFile targetfile");
            System.exit(1);
        }
        
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        
        // create an object of the FileCompressor class to compress the source file 
        FileCompressor compressor = new FileCompressor(sourceFile, targetFile, huffmanCodes);
        //compressor.compressHuffmanCodes();
        compressor.compressBinaryContent();      
    }   
}

