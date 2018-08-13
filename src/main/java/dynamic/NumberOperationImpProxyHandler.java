package dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NumberOperationImpProxyHandler implements InvocationHandler{

	private Object proxied;
	
	public NumberOperationImpProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.printf("调用函数%s\n", method.getName());
		return method.invoke(proxied, args);
	}
	
	public NumberOperationInterface wrap(NumberOperationInterface proxied) {
		return (NumberOperationInterface) Proxy.newProxyInstance(
				NumberOperationInterface.class.getClassLoader(),
				new Class[] {NumberOperationInterface.class},
				new NumberOperationImpProxyHandler(proxied));
	}
}
