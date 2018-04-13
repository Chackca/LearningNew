package Test.Lambda表达式.Test1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing","Zhao",25),
                new Person("Yanggui","Li",30),
                new Person("Chao","Ma",29)
        );


        checkAndExecute(guiltyPersons,
                p->p.getLastName().startsWith("Z"),
                p->System.out.println(p.getFirstName()));
    }




    public static void checkAndExecute(List<Person> personList,
                                       NameChecker nameChecker,
                                       Executor executor){
        for (Person p : personList){
            if (nameChecker.check(p)){
                executor.execute(p);
            }
        }
    }

}



