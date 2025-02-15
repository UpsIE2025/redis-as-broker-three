package ups.edu.ec.AppRedis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.PatternTopic;

@Configuration
public class RedisConfig {

    // Configuración de RedisTemplate
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    // Configuración del contenedor de escucha de mensajes de Redis
    @Bean
    public RedisMessageListenerContainer  messageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                             ConsumerListener consumerListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);

        // Configuración del canal de Redis
        Topic topic = new PatternTopic("my-channel");
        container.addMessageListener(consumerListener, topic);
        return container;
    }
}