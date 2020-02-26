package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IHelloWorld {
    void sayHello();
}

class HelloWorld implements IHelloWorld {

    public void sayHello() {
        System.out.println("Hello ~");
    }

    public void sayHaHa() {
        System.out.println("haha!");
    }
}

class Logger implements InvocationHandler {
    private Object target;

    public Logger(Object target) {
        this.target = target;
    }

    public static void Log(String msg) {
        System.out.println(msg);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log("start");
        Object result = method.invoke(target, args);
        Log("end");
        return result;
    }
}

/**
 * 动态代理
 * 
 * @author suzl
 */
public class DynamicProxyMode {
    public static void main(String[] args) {
        IHelloWorld hw = new HelloWorld();
        Logger logger = new Logger(hw);
        IHelloWorld proxy = (IHelloWorld)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            hw.getClass().getInterfaces(), logger);
        proxy.sayHello();

    }
}