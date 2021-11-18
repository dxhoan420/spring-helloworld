import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld nextBean = applicationContext.getBean(HelloWorld.class);
        System.out.println(nextBean.getMessage());
        System.out.println("Comparing bean and nextBean: "
                + (bean == nextBean));

//        Cat cat1 = (Cat)applicationContext.getBean("cat");
//        //Нелья, потому что есть 2 бина, которые Cat
////        Cat cat2 = applicationContext.getBean(Cat.class);
//        //То есть надо конкретное id бина
//        Cat cat2 = (Cat)applicationContext.getBean("cat");
//        System.out.println(cat1.getMessage());
//        System.out.println(cat2.getMessage());
//        System.out.println("Comparing cat1 and cat2: " + (cat1 == cat2));

        Cat helloCat1 = (Cat)applicationContext.getBean("hellocat", bean);
        Cat helloCat2 = applicationContext.getBean(Cat.class, HelloWorld.class);
        Cat helloCat3 = (Cat)applicationContext.getBean("hellocat", "helloworld");

        System.out.println(helloCat1.getMessage());
        System.out.println(helloCat2.getMessage());
        System.out.println(helloCat3.getMessage());
        System.out.println("Comparing helloCat1 and helloCat2: " + (helloCat1 == helloCat2));
        System.out.println("Comparing helloCat1 and helloCat3: " + (helloCat1 == helloCat3));
        System.out.println("Comparing helloCat3 and helloCat2: " + (helloCat3 == helloCat2));

    }
}