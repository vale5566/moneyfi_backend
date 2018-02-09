package de.moneyfi.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/group")
public class CompanyRequest {
    @Autowired
    private CompanyRepository companyRepository;
    @RequestMapping(path="/add")
    public Company addNewGroup (@RequestParam(name="name", required=true) String name,
                                @RequestParam(name="hashpassword", required=true) String hashpassword) {
        Company n = new Company();
        n.setName(name);
        n.setHashpassword(hashpassword);
        n = companyRepository.save(n);
        return n;
    }

    @RequestMapping(path="/get")
    public Company getGroup(@RequestParam(name="name", defaultValue="") String name) {
        if(!name.equals("")) {
            return companyRepository.findByName(name);
        }
        return null;
    }
}
