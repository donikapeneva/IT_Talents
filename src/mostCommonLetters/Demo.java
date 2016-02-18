package mostCommonLetters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		String text = sc.nextLine().trim().toUpperCase();
		
		String text = ("Az sum text na texta ot textovete na texta!").toUpperCase();
		
		Map<Character, Integer> letters = new HashMap<Character, Integer>();
		
		for(char letter : text.toCharArray()){
			if(letter < 'A' || letter > 'z'){
				continue;
			}
			if(letters.containsKey(letter)){
				letters.put(letter, letters.get(letter) + 1);
			} else {
				letters.put(letter, 1);
			}
		}
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(letters.entrySet());
		
		// Sortirame po value
		Collections.sort(list, (firstEntry, secondEntry) -> secondEntry.getValue().compareTo(firstEntry.getValue()));
		
		Map<Character, Integer> sorted = new LinkedHashMap<Character, Integer>();
		
		int mostCommon = 0;
		
		// Vkarvame gi v sortiran red
		for(Entry<Character, Integer> e : list) {
			sorted.put(e.getKey(), e.getValue());
			if(e.getValue() > mostCommon){
				mostCommon = e.getValue();
			}
		}
		
		for(Map.Entry<Character, Integer> entry : sorted.entrySet()){
			double procentage = 10 * entry.getValue() / mostCommon;
			StringBuilder signs = new StringBuilder();
			for(int i = 0; i < (int) procentage; i++){
				signs.append("#");
			}
			System.out.println(entry.getKey() + ": " + entry.getValue() + " " + signs);
		}
		
	}
	
}
