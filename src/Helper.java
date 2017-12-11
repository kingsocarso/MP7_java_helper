import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Helper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("NRHP_Midwest_Region.geojson");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int counter = 1;
			while(scanner.hasNextLine() && counter < 15) {
				String line = scanner.nextLine();
				if (line.contains("County: <\\/b>Cook")) {
					System.out.println(counter + ": " + line);
					counter++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
