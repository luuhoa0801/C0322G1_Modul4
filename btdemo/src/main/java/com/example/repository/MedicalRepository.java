package com.example.repository;

import com.example.model.Medical;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalRepository implements IMedicalRepository{
   private static List<Medical> medicalList = new ArrayList<>();
   static {
       medicalList.add( new Medical(1,"ip10","1998","o to","2020-09-09","2020-10-09","khong"));
   }

    @Override
    public List<Integer> year() {
    List<Integer> listYear = new ArrayList<>();
    listYear.add(1995);
    listYear.add(1996);
    listYear.add(1997);
    listYear.add(1998);
    listYear.add(1999);
    listYear.add(2000);
        return listYear;
    }

    @Override
    public List<String> travel() {
        List<String> listTravel = new ArrayList<>();
        listTravel.add("Tau bay");
        listTravel.add("Tau thuyen");
        listTravel.add("O to");
        listTravel.add("khac");
        return listTravel;
    }

    @Override
    public List<String> startDay() {
        List<String> listStart = new ArrayList<>();
        listStart.add("2020-01-01");
        listStart.add("2020-01-02");
        listStart.add("2020-01-03");
        return listStart;
    }

    @Override
    public List<String> endDay() {
        List<String> listEnd =new ArrayList<>();
        listEnd.add("2022-03-05");
        listEnd.add("2022-03-06");
        listEnd.add("2022-03-07");
        return listEnd;
    }

    @Override
    public List<Medical> fillAll() {
        return medicalList;
    }

    @Override
    public void save(Medical medical) {
        medicalList.add(medical);
    }

    @Override
    public Medical findById(int id) {
        for (Medical item: medicalList) {
            if(item.getId() == id){
                return  item;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Medical medical) {
      id = medical.getId();
        for (Medical item: medicalList) {
            if (item.getId() == id){
                item.setName(medical.getName());
                item.setAge(medical.getAge());
                item.setTravel(medical.getTravel());
                item.setStartDay(medical.getStartDay());
                item.setEndDay(medical.getEndDay());
                item.setStatus(medical.getStatus());
            }
        }
    }
}
