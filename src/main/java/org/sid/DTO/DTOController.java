
package org.sid.DTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DTOController {

	@GetMapping("/login")
	public String login() {
		return "Securite/login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}
}
