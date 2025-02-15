package ups.edu.ec.AppRedis;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.redis.core.RedisTemplate;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.RequestParam;

	@RestController
	public class ProductorControlador {

	    @Autowired
	    private RedisTemplate<String, String> redisTemplate;

	    @GetMapping("/sendMessage")
	    public String sendMessage(@RequestParam String message) {
	        redisTemplate.convertAndSend("my-channel", message);
	        return "Message sent: " + message;
	    }
	}
