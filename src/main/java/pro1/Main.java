package pro1;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputdir = new File("input");
        if(Files.exists(inputdir.toPath())) {
            if(!Files.exists(Paths.get("output"))) {
                File outputdir = new File("output");
                outputdir.mkdir();
            }
            File[] files = inputdir.listFiles();
            for(File file : files) {
                if(file.getName().endsWith(".csv")){
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    File outputFile = new File("output",file.getName());
                    String line = "";
                    String outputline = "";
                    while((line = reader.readLine()) != null){

                        String[] row = line.split(";");
                        for(int i = 0; i < row.length; i++){
                            if(i == 0){outputline = row[i];}
                            if(i == 1){
                                outputline += " " + Fraction.parse(row[i]).toString();

                            }
                        }
                        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile,true));
                        writer.write(outputline);
                        writer.newLine();
                        writer.close();
                        outputline = "";
                    }
                    reader.close();
                }

            }

        }
    }
}
