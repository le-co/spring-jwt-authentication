package guru.leco.springbootjwt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("guru.leco.springbootjwt.repositories")
public class BaseConfiguration {
}
