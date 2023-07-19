package algorithm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class labVirus {
	
	
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(1,1);
		map.put(2,1);
		map.put(3,1);
		map.put(3,1);
		StringBuilder labels = new StringBuilder();
		StringBuilder values = new StringBuilder();
		if(map != null && !map.isEmpty()){
			int i = 0;
			for(Entry<Integer, Integer> elem : map.entrySet()){
				labels.append("\"" + elem.getKey() + "\",");
				values.append(elem.getValue()+ ",");
			}
			  labels.deleteCharAt(labels.length() - 1);
	          values.deleteCharAt(values.length() - 1);
		}
			System.out.println(labels.toString());
			System.out.println(values.toString());
		
	}
}
