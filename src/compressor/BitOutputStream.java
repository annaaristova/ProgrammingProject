
package compressor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class BitOutputStream {
    private FileOutputStream output;
    private int count = 0;
    private byte b = 0;

    public BitOutputStream(File file) throws IOException {
        this.output = new FileOutputStream(file, true);
    }

    public void writeBit(String bitString) throws IOException {
        for (int i = 0; i < bitString.length(); i++)
            writeBit(bitString.charAt(i));
    }

    public void writeBit(char bit) throws IOException { 
        if (bit == '1'){
            //use mask to add 1 bit to a byte
            b = (byte) (b | (1 << (7 - count)));
        }
        //count the number of bits to shift the variable to the correct position
        count++;
        if (count==8){
            output.write(b);
            count = 0;
            b = 0;
        }
    }

    public void close() throws IOException {
        //if the last byte is not full, invoke writeBit() function
        //to left-shift with zeros       
        if (count == 0){
            output.close();
        }
        else{
            int addZero = 8 - count;
            for (int i=0; i<addZero; i++){
                writeBit('0');
            }
            output.close();
        }
    }
}   