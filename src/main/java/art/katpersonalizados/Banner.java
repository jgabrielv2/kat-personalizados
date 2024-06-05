package art.katpersonalizados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

public class Banner implements org.springframework.boot.Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("\u001b[35m    __ __      __                                               ___                 __");
        out.println("\u001b[35m   / //_/___ _/ /_      ____  ___  ______________  ____  ____ _/ (_)___  ____ _____/ /___  _____");
        out.println("\u001b[35m  / ,< / __ `/ __/_____/ __ \\/ _ \\/ ___/ ___/ __ \\/ __ \\/ __ `/ / /_  / / __ `/ __  / __ \\/ ___/");
        out.println("\u001b[35m / /| / /_/ / /_/_____/ /_/ /  __/ /  (__  ) /_/ / / / / /_/ / / / / /_/ /_/ / /_/ / /_/ (__  )");
        out.println("\u001b[35m/_/ |_\\__,_/\\__/     / .___/\\___/_/  /____/\\____/_/ /_/\\__,_/_/_/ /___/\\__,_/\\__,_/\\____/____/");
        out.println("\u001b[35m                    /_/");
        out.println("${application.title} ${application.version}");
        out.println("Powered by Spring Boot ${spring-boot.version}");
        out.println("\u001b[0m");
    }
}
