package com.example.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    static Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put("hello", "xin chào");
        map.put("hi", "chào");
        map.put("bye", "tạm biệt");
    }

    public String late(String world) {
//        for (Map.Entry<String, String> item : map.entrySet()) {
//            if (item.getKey().equals(world)) {
//                return item.getValue();
//            }
//        }
//        return "không có";

        String result =  map.get(world);

        return result == null ? "không có" : result;

//        if(map.get(world) != null){
//            return map.get(world);
//        }else{
//            return "không có";
//        }
    }
}