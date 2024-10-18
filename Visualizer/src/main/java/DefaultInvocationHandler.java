import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DefaultInvocationHandler implements InvocationHandler {

	private final Object implementation;
	
	public DefaultInvocationHandler(final Object implementation) {
		this.implementation = implementation;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(implementation, args);
	}

}
