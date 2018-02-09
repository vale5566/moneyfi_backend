package de.moneyfi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserRequest {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(path="/add")
    public User addNewUser (@RequestParam(name="name", required=true) String name,
    		@RequestParam(name="hashpassword", required=true) String hashpassword,
                            @RequestParam(name="group", required = true) String group) {
        User n = new User();
        n.setName(name);
        n.setHashpassword(hashpassword);
        n.setGroup("default");
        n = userRepository.save(n);
        return n;
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(path="/get")
    public User getUser(@RequestParam(name="name", defaultValue="") String name,
    		@RequestParam(name="id", defaultValue="0") Integer id) {
    	if(id > 0) {
    		return userRepository.findOne(id);
    	} else if(!name.equals("")) {
            return userRepository.findByName(name);
    	}
    	return null;
    }
}
