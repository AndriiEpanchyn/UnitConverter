import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Preparing and reading the files with dictionary
        String inputFileName = ".//Data//DictionaryStorage.json";
        File inputFile = new File(inputFileName);
        checkCatalog(inputFile);
        String dict = readFile(inputFile);
        Gson gson1 = new Gson();
        Dictionary d = gson1.fromJson(dict, Dictionary.class);

        //Preparing and reading the files with input data
        String inputDataFileName = ".//Data//InputRequest.json";
        File inputDataFile = new File(inputDataFileName);
        String query = readFile(inputDataFile);
        Gson gson2 = new Gson();
        QuerryFormat q = gson2.fromJson(query, QuerryFormat.class);

        //calculating the answer
        String fromUnit = q.getDistance().getUnit();
        double koefFromUnit = d.getVolumes().get(fromUnit);

        String toUnit = q.getConvert_to();
        double koefToUnit = d.getVolumes().get(toUnit);

        double answer = (q.getDistance().getValue() * koefFromUnit) / koefToUnit;
        System.out.print("Distance: " + q.getDistance().getValue() + " " + fromUnit + " (converted into " + toUnit + ") = "
                + answer + " " + toUnit);

        //write answer to the file
        Distance answerForJson = new Distance(toUnit, answer);
        Gson toFile = new GsonBuilder().setPrettyPrinting().create();
        String out = toFile.toJson(answerForJson);
        File outFile = new File(".//Data//Out.json");
        writeToFile(outFile, out);
    }  // end of Main

    static String readFile(File inputFile) throws IOException {
        StringBuilder read = new StringBuilder();
        try {
            FileReader fr = new FileReader(inputFile);
            Scanner newScan = new Scanner(fr);

            while (newScan.hasNextLine()) {
                read.append(newScan.nextLine());
            }
            newScan.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File " + inputFile + " not Found");
            e.printStackTrace();
            return "File " + inputFile + " not Found";
        }
        return read.toString();
    }  //End of readFile

    static boolean writeToFile(File filename, String output) {
        if (!filename.exists()) {
            try {
                Writer newWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
                newWriter.write(output);
                newWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else return false;
    } //End writeToFile

    static void checkCatalog(File filename) throws IOException {
        if (filename.exists()) {
            //прописать как сравнить шаблоннный каталог и тот что в файле
        } else {
            Dictionary dictionary = Dictionary.create();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String out = gson.toJson(dictionary);
            writeToFile(filename, out);
        }
    }//End of checkCatalog

}  // end of File
