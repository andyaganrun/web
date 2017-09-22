package com.andy.jay.util;

import com.andy.jay.web.dto.Result;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private static final JsonHelper instance = new JsonHelper();

    public static JsonHelper getInstance() {
        return instance;
    }

    private final ObjectMapper mapper = new JsonObjectMapper();

    public <T> T toObject(String jsonText, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(jsonText, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public <T> Result<T> toGenericObject(String jsonText, Class<T> clazz) {
        Result<T> object = null;
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(Result.class, listType);
            object = mapper.readValue(jsonText, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public <T> List<T> toObjectList(String jsonText, Class<T> clazz) {
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        List<T> listObject = null;
        try {
            listObject = mapper.readValue(jsonText, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public String toString(Object object) {
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (Exception e) {
            jsonString = e.getMessage();
        }
        return jsonString;
    }
}
