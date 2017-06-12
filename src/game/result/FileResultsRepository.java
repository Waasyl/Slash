package game.result;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Lukasz on 2017-06-12.
 */
public class FileResultsRepository implements ResultsRepository {
    private String pathToFile;
    private static File fileWithResults;

    public FileResultsRepository(String pathToFile) {
        this.pathToFile = pathToFile;
        this.fileWithResults = new File(pathToFile);
    }

    @Override
    public void add(Result result){
        try (FileWriter fw = new FileWriter(fileWithResults, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getSize(){
        int counter =0;

        try {
            Scanner scanner = new Scanner(fileWithResults);
            while(scanner.hasNextLine()){
                counter++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static List<Result> getAllResult(){
        List<Result> results = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(fileWithResults);
            while (scanner.hasNextLine()) {
                results.add(mapToResult(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
    private static Result mapToResult(String resultString){
        String[] split = resultString.split(";");
        return new Result(split[0], Integer.valueOf(split[1]),Integer.valueOf(split[1]));
    }
}
