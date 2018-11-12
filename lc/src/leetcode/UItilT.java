package leetcode;

public class UItilT<T> {
	
	private T data;
	
	public static<T> void print(T data) {
		System.out.println(data);
	};
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
