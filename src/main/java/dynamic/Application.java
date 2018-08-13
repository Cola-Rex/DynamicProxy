package dynamic;

public class Application {
	
	public static void main(String[] args) {
		NumberOperationInterface proxied = new NumberOperationImp();
		NumberOperationImpProxyHandler handler = new NumberOperationImpProxyHandler(proxied);
		NumberOperationInterface real = handler.wrap(proxied);
		int a = real.add(1, 2);
		System.out.println(a);
	}
}
