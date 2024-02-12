package multi.threading.project.example;

import java.util.ArrayList;

public class AscCheck {

	ArrayList<Integer> al = new ArrayList<Integer>();
	public  void checkAscendingDigits(int start, int end) {
		
		for(int i=start;i<=end;i++) {
			if(checkTheDigits(i)) {
				al.add(i);
			}
		}
		System.out.println(al);
	}
	private boolean checkTheDigits(int num) {
		String str = Integer.toString(num);
		for(int j=0;j<str.length()-1;j++) {
			
			if(str.charAt(j+1)-str.charAt(j)!=1) {
				return false;
			}
			
		}
		return true;
		
	}
	public static void main(String[] args) {
		
		AscCheck asc = new AscCheck();
		asc.checkAscendingDigits(100, 1000);
	}
}
