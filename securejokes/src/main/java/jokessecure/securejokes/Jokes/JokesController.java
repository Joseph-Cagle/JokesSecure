package jokessecure.securejokes.Jokes;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


@RestController
public class JokesController {

    public ArrayList<Jokes> jokesList = new ArrayList<>();

    public JokesController() {
        Jokes dadJoke1 = new Jokes();
        Jokes dadJoke2 = new Jokes();
        Jokes gameJoke1 = new Jokes();
        Jokes sportsJoke = new Jokes();
        Jokes sportsJoke2 = new Jokes();

        dadJoke1.setCategory("Dad");
        dadJoke1.setJoke("How does a mermaid clean its scales?");
        dadJoke1.setPunchL("With Tide");

        dadJoke2.setCategory("Dad");
        dadJoke2.setJoke("What do you call a cow that has given birth?");
        dadJoke2.setPunchL("De-calfinated");

        gameJoke1.setCategory("Game");
        gameJoke1.setJoke(" Why are cats so good at video games?");
        gameJoke1.setPunchL("Because they have 9 lives");

        sportsJoke.setCategory("Sport");
        sportsJoke.setJoke("What did the baseball glove say to the ball?");
        sportsJoke.setPunchL("Catch ya later!");

        sportsJoke2.setCategory("Sport");
        sportsJoke2.setJoke("Why did the football coach go to the bank?");
        sportsJoke2.setPunchL("To get his quarterback");

        jokesList.add(dadJoke1);
        jokesList.add(dadJoke2);
        jokesList.add(gameJoke1);
        jokesList.add(sportsJoke);
        jokesList.add(sportsJoke2);

    }

    @RequestMapping(value = "/Jokes", method = RequestMethod.GET)
   
        public Object login(@RequestHeader("Authorization") String auth,@RequestParam(value = "jokeType", defaultValue = "")String jokeType) {
	
        String userPass = auth.substring(6);
        byte[] decryptArray = Base64.decodeBase64(userPass);
        String decryptString = new String(decryptArray);
        int colon = decryptString.indexOf(":");
        String authUserName = decryptString.substring(0, colon);
        String authPassword = decryptString.substring(colon + 1);
        String un1 = "apples"; String un2 = "Star"; String un3 = "Cyber"; String un4 ="Tomayto"; String un5 = "Sonic";
        String pw1 = "oranges"; String pw2 = "Wars"; String pw3 = "Punk"; String pw4 = "Tohmato"; String pw5 ="Hedgehog";
        
        if(authUserName.equals(un1) && authPassword.equals(pw1) || authUserName.equals(un2) && authPassword.equals(pw2) || authUserName.equals(un3) && authPassword.equals(pw3)
        || authUserName.equals(un4) && authPassword.equals(pw4) || authUserName.equals(un5) && authPassword.equals(pw5) ){
            //do your service work here
            List <Jokes> anotherOne = new ArrayList<>();

            for(int x=0; x < jokesList.size(); x++){
                if(jokesList.get(x).getCategory().equalsIgnoreCase(jokeType)){
                    anotherOne.add(jokesList.get(x));
                }
            }
            if(anotherOne.isEmpty()){
                return jokesList;
            }
            else{
                return anotherOne;
            }
        }
        else{
            return "Not authorized, go away.";
        }
    }

    @PostMapping("/Jokes/add" )
   public Object loginAdd(@RequestHeader("Authorization") String auth,@RequestBody Jokes newJoke) {
	
        String userPass = auth.substring(6);
        byte[] decryptArray = Base64.decodeBase64(userPass);
        String decryptString = new String(decryptArray);
        int colon = decryptString.indexOf(":");
        String authUserName = decryptString.substring(0, colon);
        String authPassword = decryptString.substring(colon + 1);
        String un1 = "apples"; String un2 = "Star"; String un3 = "Cyber"; String un4 ="Tomayto"; String un5 = "Sonic";
        String pw1 = "oranges"; String pw2 = "Wars"; String pw3 = "Punk"; String pw4 = "Tohmato"; String pw5 ="Hedgehog";
        
        if(authUserName.equals(un1) && authPassword.equals(pw1) || authUserName.equals(un2) && authPassword.equals(pw2) || authUserName.equals(un3) && authPassword.equals(pw3)
        || authUserName.equals(un4) && authPassword.equals(pw4) || authUserName.equals(un5) && authPassword.equals(pw5) ){

            jokesList.add(newJoke);
            return jokesList;

        }
        else{
            return "Error 401: Bad Login Credentials";
        }
    }
    @DeleteMapping("/Jokes/{type}")

 public Object loginDelete(@RequestHeader("Authorization") String auth,@PathVariable String type) {
	
        String userPass = auth.substring(6);
        byte[] decryptArray = Base64.decodeBase64(userPass);
        String decryptString = new String(decryptArray);
        int colon = decryptString.indexOf(":");
        String authUserName = decryptString.substring(0, colon);
        String authPassword = decryptString.substring(colon + 1);
        String un1 = "apples"; String un2 = "Star"; String un3 = "Cyber"; String un4 ="Tomayto"; String un5 = "Sonic";
        String pw1 = "oranges"; String pw2 = "Wars"; String pw3 = "Punk"; String pw4 = "Tohmato"; String pw5 ="Hedgehog";
        
        if(authUserName.equals(un1) && authPassword.equals(pw1) || authUserName.equals(un2) && authPassword.equals(pw2) || authUserName.equals(un3) && authPassword.equals(pw3)
        || authUserName.equals(un4) && authPassword.equals(pw4) || authUserName.equals(un5) && authPassword.equals(pw5) ){

            jokesList.removeIf(t -> t.getCategory().equals(type));
            return "Jokes removed";

        }
        else{
            return "Error 401: Bad Login Credentials";
        }
    }

  }
