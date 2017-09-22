package com.andy.jay.web;

import com.andy.jay.constant.Products;
import com.andy.jay.service.PersonService;
import com.andy.jay.web.dto.Person;
import com.andy.jay.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "list", method = RequestMethod.GET, produces = {Products.JSON})
    public Result<List<Person>> getPerson(HttpServletRequest request,
                                          @RequestParam(value = "personId", required = false) Integer personId) {

        List<Person> result = personService.getPerson(personId);
        return new Result<List<Person>>(true, result);
    }


}
