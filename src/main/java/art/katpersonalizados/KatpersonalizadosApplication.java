package art.katpersonalizados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KatpersonalizadosApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(KatpersonalizadosApplication.class);
		app.setBanner(new Banner());
		app.run(args);
	}

}
