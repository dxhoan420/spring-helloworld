import org.springframework.context.annotation.Scope;

import java.util.Random;

//Ни на что не влияет, потому что нет @Component
@Scope ("prototype")
public class Cat {
    int number;
    String message;

    public Cat() {
        number = new Random().nextInt(100);
        message = "I'm kitty #" + number;
    }

    public Cat(HelloWorld helloWorld) {
        this.message = helloWorld.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
