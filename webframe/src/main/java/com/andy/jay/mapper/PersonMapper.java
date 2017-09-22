package com.andy.jay.mapper;

import com.andy.jay.entity.PersonEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    List<PersonEntity> getPersons(@Param("personId") int personId);


}
