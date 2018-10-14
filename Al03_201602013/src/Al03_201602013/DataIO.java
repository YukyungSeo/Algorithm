package Al03_201602013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

class DataIO {

	// public method
	public void readDataSet(String fileName, ArrayList<Integer> al) {
		try {
			File file = new File(".\\", fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				al.append(Integer.parseInt(line));
//				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void writeDataSet(String fileName, Iterator<Integer> itr) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			while (itr.hasNext()) {
				out.write(itr.next().toString());
				out.newLine();
			}

			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

	}
}

