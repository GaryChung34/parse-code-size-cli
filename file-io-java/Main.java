import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Main {
    long maxLines = 0;

    public static long countLine(File file) {
        long lines = 0;

        try (LineNumberReader reader = new LineNumberReader(new FileReader(file))) {
            
            while (reader.readLine() != null);

            lines = reader.getLineNumber();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public void showSubFiles(File file) {
        // String fname = "C:\\Users\\Gary-Home\\repos\\parse-code-size-cli\\file-io-java";
        String fname = "C:\\Users\\Gary-Home\\IdeaProjects\\eformss-backend\\src\\main\\java\\gov\\edb\\eformss";

        if (file.isDirectory()) {

            File[] subFiles = file.listFiles();

            for (int i = 0; i < subFiles.length; i++) {
                showSubFiles(subFiles[i]);
            }
        } else {
            System.out.print(file.getPath().replace(fname, "").replace(file.getName(), "") + "    " + file.getName() + "    ");
            histogram(file);
            System.out.println();
        }
    }

    public void countSubFiles(File file) {

        if (file.isDirectory()) {

            File[] subFiles = file.listFiles();

            for (int i = 0; i < subFiles.length; i++) {
                countSubFiles(subFiles[i]);
            }
        } else {
            long temp = countLine(file);
            // System.out.printf("maxLines: %d, temp: %d\n", maxLines, temp);
            if(maxLines < temp) {
                maxLines = temp;
            }
        }
    }

    public void histogram(File file) {

        long weight = countLine(file);
        long result = Math.round((double)weight/maxLines*10);
        
        // System.out.println("his: " + result);
        for (int i = 0; i < result; i++) {
            System.out.print("#");
        }
    }

    // public static long countMaxLines(File file) {
    //     long result = 0;

    //     if (file.isDirectory()) {
    //         File[] files = file.listFiles();

    //         for (int i = 0; i < files.length; i++){
                
    //         }

    //     } else {
    //         countLine
    //     }

    //     return result;
    // }

    public static void main(String[] args) {
        Main main = new Main();
        // String fname = "C:\\Users\\Gary-Home\\repos\\parse-code-size-cli\\file-io-java";
        String fname = "C:\\Users\\Gary-Home\\IdeaProjects\\eformss-backend\\src\\main\\java\\gov\\edb\\eformss";
        File file = new File(fname);
        main.countSubFiles(file);
        System.out.println("max: " + main.maxLines);

        File[] files = file.listFiles();

        System.out.println(file.getName() + " :");

        for (int i = 0; i < files.length; i++) {
            main.showSubFiles(files[i]);
        }

        // System.out.println();
        // File testFile = new File("C:\\Users\\user\\repos\\file-io-java\\Main.java");
        // System.out.println(testFile.getName() + ": " + countLine(testFile));
    }
}