
package compressor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class FileCompressor {
    
    private File sourceFile;
    private File targetFile;
    private Map<Character, String> huffmanCodes;
    
    public FileCompressor (File sourceFile, File targetFile, 
            Map<Character, String> huffmanCodes){
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        this.huffmanCodes = huffmanCodes;
    }
    // output the Huffman codes into the target file
    public void compressHuffmanCodes() throws FileNotFoundException, IOException{
        ObjectOutputStream huffmanCodesOutput = new ObjectOutputStream(new FileOutputStream(targetFile));
        huffmanCodesOutput.writeObject(huffmanCodes);
        huffmanCodesOutput.close();
    }
    // output the encoded binary contents to the target file
    public void compressBinaryContent() throws FileNotFoundException, IOException{
        BitOutputStream binaryContent = new BitOutputStream(targetFile);
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        int character;
        while ((character = reader.read()) != -1){
            char ch = (char) character;
            binaryContent.writeBit(huffmanCodes.get(ch));
        }
        binaryContent.close();
    }  
}
