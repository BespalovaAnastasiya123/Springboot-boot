package traffic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class TrafficController {
    @Autowired
    Driver driver;

    private Logger logger = Logger.getLogger(TrafficController.class.getName());


    @Pointcut("within(org.itstep.TrafficLight)")
    public void someMethods(){}

    @AfterReturning(pointcut = "execution(public String traffic.TrafficLight.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        String value = (String)result;
        System.out.println(value);
        if (name.equals("switchYellow"))
            driver.ready();
        else if (name.equals("switchGreen"))
            driver.go();
    }
}
