package roadrationing.aop;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionLoggerInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Logger logger = LoggerFactory.getLogger(invocation.getMethod().getDeclaringClass());
		logger.debug("Method enter.");
		LocalDateTime startTime = LocalDateTime.now();

		Object functionResult = invocation.proceed();
		LocalDateTime endTime = LocalDateTime.now();

		logger.debug("Method ends. duration:" + String.valueOf(Duration.between(startTime, endTime).toMillis()) + "ms");

		return functionResult;
	}

}
