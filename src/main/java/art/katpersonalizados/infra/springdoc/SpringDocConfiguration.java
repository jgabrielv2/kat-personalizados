package art.katpersonalizados.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kat Personalizados API")
                        .description("API Rest da aplicação Kat Personalizados, contendo as funcionalidades de CRUD de produtos, categorias e clientes")
                        .contact(new Contact()
                                .name("jgabrielv")
                                .email("joao.vidal@aluno.unb.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://katpersonalizados.art/api/licenca")));
    }

}
