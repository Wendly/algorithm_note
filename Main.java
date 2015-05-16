import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;

public class Main {
	public Main() throws IOException {

		String input = br.readLine();
		work(input);

		System.out.print(sb);
	}

	private void work(String input) throws IOException {
		//debug(t, input);
		sb.append(input);
	}

	StringBuilder sb = new StringBuilder();
	BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new Main();
	}

	public static void debug(Object... arr) {
		System.err.println(Arrays.deepToString(arr));
	}
}
