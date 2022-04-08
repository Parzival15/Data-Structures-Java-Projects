import java.util.Scanner;
public class Sums {
	
	public static String sums(String s, long n) {
		int length=s.length();
		for(int i=1;i<length;i++) {
			String str1=s.substring(0,i);
			String str2=s.substring(i);
			if(Long.parseLong(str1)+Long.parseLong(str2)==n) {
				return str1+"+"+str2;
			}
			if(Long.parseLong(str1)<n && !sums(str2, n-Long.parseLong(str1)).contentEquals("false")) {
				return str1+"+"+sums(str2, n-Long.parseLong(str1));
				}
			}
		return "false";
		}
    
    public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		long n=in.nextLong();
		String sum=sums(s,n);
		if(sum!=null) {
			System.out.println(sum);
		}
		else {
			System.out.println(sum);
		}
    }
}

