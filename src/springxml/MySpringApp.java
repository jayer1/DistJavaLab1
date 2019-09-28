package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Dogs;
import springxml.beans.Registration;

public class MySpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        springxml.beans.Dogs myDogs = context.getBean("myDog", Dogs.class );
        springxml.beans.Registration myReg = context.getBean("myReg", Registration.class );

        System.out.println(myDogs.getLog());
        System.out.println("The dog's gender is " + myDogs.getGender());
        System.out.println("Has the dog been declawed? " + myDogs.getDeclawed());

        System.out.println(myReg.getLog());
        System.out.println("Hello " + myReg.getFirstName() + " " + myReg.getLastName());
        context.close();
    }
}
