

public class LambaTest {
	public static void main(String[] args) {
		
	MyLambda myFunc;
	
	myFunc = (n, m) -> n + m - 4;
	
	System.out.println(myFunc.myTotal(5, 6));
	
	
		
		
	}
}

interface MyLambda {
	
	int myTotal (int n, int m);
}
