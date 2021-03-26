package project0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String path; 

    //constructor to set the parameter we are going to be manipulating
    public ReadFile(String file_path) {
        path = file_path; 
    }

    /**
     * Open file
     * @return it returns a String array
     * @throws IOException
     */
    public String[] OpenFile() throws IOException {
 
        FileReader fr = new FileReader(path); 
        BufferedReader textReader = new BufferedReader(fr); 

        int numberOfLines = readLines(); 
        String[] textData = new String[numberOfLines]; 

        for (int i=0; i<numberOfLines; i++) {
            textData[i] = textReader.readLine(); 
        }

        textReader.close(); 
        return textData; 
    }

    /**
     * this method sets the number of lines we print in the console, based on the lines we have on the txt file
     * @return the number of lines to be printed
     * @throws IOException
     */
    int readLines() throws IOException {

        FileReader fileToRead = new FileReader(path); 
        BufferedReader bf = new BufferedReader(fileToRead); 

        String aLine; 
        int numberOfLines = 0; 

        while((aLine = bf.readLine()) != null) {
            numberOfLines++; 
        }
        bf.close();
        return numberOfLines; 
    }
}
