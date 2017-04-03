package beans;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by aalle on 03.04.2017.
 */
public class SimpleLogger {

    @AroundInvoke
    public Object addLog(InvocationContext context) throws Exception{
        System.out.println("Мой логгер сообщает - запущен метод: "+context.getMethod());
        return context.proceed();
    }
}
