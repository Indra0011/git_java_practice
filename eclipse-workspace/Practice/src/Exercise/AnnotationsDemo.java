package Exercise;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * metadata about the code , (information about the code both to compiler and developer)
 * We can create our own annotations too. and specify the target of the annotations(where it can be applied)
 * 
 * elementType.type :- can be applied to class 
 * elementType.Method	:- can be applied to method
 * 
 * retentionPolicy.source		// life only till source code , like comments
 * 
 * we can get information in annotation from a class using reflection api.
 * 
 */
public class AnnotationsDemo {

	public static void main(String[] args) {
		
		//to get data about annotation
		Virat	 v = new Virat();
		Class c	= v.getClass();
		Annotation a = c.getAnnotation(CricketPlayer.class); // annotation is parent of all annotations
		
		CricketPlayer cp = (CricketPlayer)a;  // downcasting parent to child annotation.
		cp.country();  // to get data in the annotation

	}

}

// creation of annotation

@Target(ElementType.TYPE)      // specifies the target of the annotation (where it can be used)
@Retention(RetentionPolicy.SOURCE) // specifies the life of the annotation
@interface CricketPlayer        // @ tells that it's a annotation not an interface actually
{
	String country();   // when using annotation we have to specify the value
	int age() default 34; // using default values
}


@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
@interface FootbalPlayer
{
	
}

@CricketPlayer(country = "India")
class Virat
{

	
}


@FunctionalInterface // specifies that it's a functional interface (contains only one abstract method)
interface Telusko
{
	void learning();    // only one abstract method
	default int learn()
	{
		return 10;
	}
	@Deprecated            // to specify to use this function , it can also be applied on class
	public static void learns()
	{
		
	}
	
	int study();         // another abstract method causes error when annotation is used
}
