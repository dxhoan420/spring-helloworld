import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean(name="cat")
    @Scope(scopeName = "prototype")
    public Cat getCat() {
        return new Cat();
    }

    //Для проверки лучше использовать предыдущий коммит
//    @Bean(name="hellocat")
//    //TODO: Почему не работает, если поменять Scope на "prototype"?
//    @Scope("singleton")
//    public Cat getHelloCat() {
//        return new Cat(getHelloWorld());
//    }
}