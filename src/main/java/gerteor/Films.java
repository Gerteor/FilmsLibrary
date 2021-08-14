package gerteor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Films {

    private static final String FILE_SPRING_CONTEXT_XML = "springContext.xml";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(FILE_SPRING_CONTEXT_XML);

    }
}
