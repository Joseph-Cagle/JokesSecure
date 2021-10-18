package jokessecure.securejokes;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurejokesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurejokesApplication.class, args);
	}

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String login(@RequestHeader("Authorization") String auth) {
	
			String userPass = auth.substring(6);
			byte[] decryptArray = Base64.decodeBase64(userPass);
			String decryptString = new String(decryptArray);
			int colon = decryptString.indexOf(":");
			String authUserName = decryptString.substring(0, colon);
			String authPassword = decryptString.substring(colon + 1);
			
			if(authUserName.equals("apples") && authPassword.equals("oranges")){
				//do your service work here
				return "Authorized!";	
			}
			else{
				return "Not authorized, go away.";
			}
	
	

		



	}

}
