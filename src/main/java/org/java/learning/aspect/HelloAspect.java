package org.java.learning.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
    
    @Before("execution(* org.java.learning.aspect.World.printAspect(..)")
    public void printAspect() {
        System.out.println("executing aspect before block");
    }
    @After("execution(* org.java.learning.aspect.World.printAspect(..))")
    public void logAfterDeposit() {
        System.out.println("A deposit transaction has been completed.");
    }
}

class World {
    private void printAspect() {
        System.out.println("aspect executed before this method");
    }
    public static void main(String[] args) {
        World w = new World();

        w.printAspect();
    }
}
