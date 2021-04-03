package project0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile2 {

    private String path; 

    public ReadFile2(String file_path) {
        path = file_path; 
    }

    public ArrayList<String> OpenFile() throws IOException {
        String line = null;
        BufferedReader reader;
        List<String> lines = new ArrayList<>();
        reader = new BufferedReader(new FileReader(path));

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
       
        return (ArrayList<String>) lines;
    }
}
