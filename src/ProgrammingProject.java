
import java.io.*;
import java.util.*; 
import compressor.FileCompressor;

public class ProgrammingProject {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Map<Character, String> huffmanCodes = new HashMap<>();
        huffmanCodes.put('b', "00");
        huffmanCodes.put('e', "11");
        huffmanCodes.put('p', "101");
        huffmanCodes.put(' ', "011");
        huffmanCodes.put('o', "010");
        huffmanCodes.put('r', "1000");
        huffmanCodes.put('!', "1001");
        
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

