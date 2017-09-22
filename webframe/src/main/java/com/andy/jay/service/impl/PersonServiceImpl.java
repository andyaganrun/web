package com.andy.jay.service.impl;

import com.andy.jay.entity.PersonEntity;
import com.andy.jay.mapper.PersonMapper;
import com.andy.jay.service.PersonService;
import com.andy.jay.web.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonMapper personMapper;

    public List<Person> getPerson(Integer id) {
        List<PersonEntity> result = personMapper.getPersons(id);
        return Collections.emptyList();
    }

}
