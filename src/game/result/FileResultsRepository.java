package game.result;

import java.io.*;
import java.util.Comparator;
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
        return new Result(split[0], Integer.valueOf(split[1]),Integer.valueOf(split[2]));
    }

    public static List<Result> getTopResult(){
        List<Result> results = getAllResult();
        results.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return o1.getResult() - o2.getResult();
            }
        });


        return results;
    }
}
