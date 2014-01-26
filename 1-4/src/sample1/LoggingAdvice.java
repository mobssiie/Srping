package sample1;

import org.springframework.util.StopWatch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {

		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD: " + methodName + " is calling.");
		Object rtnobj = invocation.proceed();
		
		sw.stop();
		System.out.println("[LOG] METHOD: " + methodName + " was called.");
		System.out.println("[LOG] 처리시간 : " + sw.getTotalTimeMillis() / 1000 + "초" );
		
		return rtnobj;
	}
}