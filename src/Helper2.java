import java.io.*;
import java.util.Scanner;
public class Helper2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("NRHP_Midwest_Region.geojson");
		File output = new File("western_central_illinois.geojson");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
	        PrintWriter printer = new PrintWriter(output);
			int counter = 1;
			int counter2 = 0;
			int lineCount = countLines("NRHP_Midwest_Region.geojson");
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (counter2 < 4 || counter2 > lineCount - 2 || line.contains("County: <\\/b>Fulton") || line.contains("County: <\\/b>McDonough") || line.contains("County: <\\/b>Hancock") || line.contains("County: <\\/b>Adams") || line.contains("County: <\\/b>Schuyler") || line.contains("County: <\\/b>Brown") || line.contains("County: <\\/b>Pike") || line.contains("County: <\\/b>Peoria") || line.contains("County: <\\/b>Marshall") || line.contains("County: <\\/b>Warren") || line.contains("County: <\\/b>Knox") || line.contains("County: <\\/b>Stark") || line.contains("County: <\\/b>Henderson") || line.contains("County: <\\/b>Calhoun")) {
					System.out.println(counter + ": " + line);
					printer.println(line);
					counter++;
				}
				counter2++;
			}
			scanner.close();
			printer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}

}
