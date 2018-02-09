package de.moneyfi.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/group")
public class GroupRequest {
    @Autowired
    private GroupRepository groupRepository;
    @RequestMapping(path="/add")
    public Group addNewGroup (@RequestParam(name="name", required=true) String name,
                            @RequestParam(name="hashpassword", required=true) String hashpassword) {
        Group n = new Group();
        n.setName(name);
        n.setHashpassword(hashpassword);
        n = groupRepository.save(n);
        return n;
    }

    @RequestMapping(path="/get")
    public Group getGroup(@RequestParam(name="name", defaultValue="") String name) {
        if(!name.equals("")) {
            return groupRepository.findByName(name);
        }
        return null;
    }
}
