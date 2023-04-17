package br.com.arthur.cqrs;

import br.com.arthur.cqrs.infra.caching.redis.RedisServiceClient;
import java.io.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.DockerComposeContainer;

@Configuration
public class TestcontainersConfiguration {

  public static final DockerComposeContainer<?> container =
      new DockerComposeContainer<>(new File("docker-compose.yml"))
          .withLocalCompose(true);

  @Bean
  public RedisServiceClient beanRedisServiceClient() {
    return new RedisServiceClient();
  }

}
