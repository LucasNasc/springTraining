package spring.begining.spring_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/hello")
public class HelloController {
	
	
	@RequestMapping
	@ResponseBody
	public String hello() {
		return "hello world by school of net";
	}
	
	@GetMapping(path = "/say/{name}")
	@ResponseBody
	public String say(@PathVariable String name) {
		return "hello"+ name + ", how are you ?";
	}
	
	@PostMapping(path = "/say")
	@ResponseBody
	public String sayPost(@RequestParam String name) {
		return " this is my result"+ name;
	}
}
