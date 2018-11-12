package xiaoyu;

public class binary {
	public static int findindex(int num) {
		int sum=0;
		while(num >9) {
			sum = 0;
			while(num>0) {
				sum = sum + num%10;
				num = num/10;
			}
			num = sum;
		}
		return num;
		
	}
	
	public static void main(String[] args) {
		System.out.println(findindex(0));
	}
}
