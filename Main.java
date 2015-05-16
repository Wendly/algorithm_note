import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;

public class Main {
	private class Position implements Comparable<Position> {
		String position;
		String person;

		public Position(String person, String position) {
			this.person = person;
			this.position = position;
		}

		@Override
		public boolean equals(Object o) {
			return person.equals(((Position) o).person);
		}

		@Override
		public String toString() {
			return person + " " + position + "\n";
		}

		@Override
		public int compareTo(Position o) {
			return person.compareTo(o.person);
		}
	}

	public Main() throws IOException {

		String line;
		List<Position> dones = new ArrayList<Position>();
		while ((line = br.readLine()) != null) {
			String[] datas = line.split(" ");
			dones.add(new Position(datas[0], datas[1]));
		}
		work(dones);

		System.out.print(sb);
	}

	private void work(List<Position> dones) throws IOException {
		//debug(t, input);
		List<Position> results = new ArrayList<Position>(dones);

		List<Position> unknows = new ArrayList<Position>();
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("A1-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("A2-%02dF", i), "-1"));
		for (int i = 3 ; i <= 15; i++) unknows.add(new Position(String.format("A3-%02dF", i), "-1"));
		for (int i = 2 ; i <= 15; i++) unknows.add(new Position(String.format("A5-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("B1-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("B2-%02dF", i), "-1"));
		unknows.add(new Position("B3-01F", "-1"));
		for (int i = 3 ; i <= 15; i++) unknows.add(new Position(String.format("B3-%02dF", i), "-1"));
		for (int i = 2 ; i <= 15; i++) unknows.add(new Position(String.format("B5-%02dF", i), "-1"));
		for (int i = 2 ; i <= 15; i++) unknows.add(new Position(String.format("B6-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("C1-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("C2-%02dF", i), "-1"));
		for (int i = 1 ; i <= 15; i++) unknows.add(new Position(String.format("C3-%02dF", i), "-1"));
		for (int i = 2 ; i <= 15; i++) unknows.add(new Position(String.format("C5-%02dF", i), "-1"));
		for (int i = 2 ; i <= 15; i++) unknows.add(new Position(String.format("C6-%02dF", i), "-1"));

		unknows.removeAll(dones);

		List<String> donePositions = new ArrayList<String>();
		for (Position done : dones) {
			donePositions.add(done.position);
		}

		List<String> positions = new ArrayList<String>();
		for (int i = 1; i < 203; i++) {
			String position = String.valueOf(i);
			if (donePositions.contains(position)) {
				continue;
			}
			positions.add(position);
		}

		Collections.shuffle(unknows);
		Collections.shuffle(positions);
		for (Position unknow : unknows) {
			unknow.position = positions.remove(0);
		}

		results.addAll(unknows);

		Collections.sort(results);

		for (Position result : results) {
			sb.append(result.toString());
		}
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
