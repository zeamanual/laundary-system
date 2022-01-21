package com.aaulaundary.aau_laundary_system.ServiceImplementation;

import java.util.List;

import com.aaulaundary.aau_laundary_system.Repositories.RecordRepository;
import com.aaulaundary.aau_laundary_system.Services.RecordService;
import com.aaulaundary.aau_laundary_system.models.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecordServicesImplementation implements RecordService {

    @Autowired
    private RecordRepository recordRepository;


    @Override
    public List<Record> getAllRecord() {
        return recordRepository.findAll();
        
    }

    @Override
    public String checkIfExists(String id,String name) {
        name = name.toUpperCase();
     
        if(recordRepository.existsById(id)){
            Record record = recordRepository.findById(id).get();
            System.out.println(record.getName()+"***"+name);
            if (name.equals(record.getName().toUpperCase())){
                
                return "Found";
            }   
        }
        return "NotFound";
    }

    @Override
    public void updateRecordById(String id,Record record) {
        if(recordRepository.existsById(id)){
           Record existingRecord = recordRepository.findById(id).get();
           existingRecord = record;
           recordRepository.save(existingRecord);
        }
        else{
            throw new RuntimeException("The Record with the given specification doesnot exist");
        }
        }

    @Override
    public void createRecord(Record record) {
        recordRepository.save(record);  
    }

    @Override
    public void deleteRecordById(String id) {
       recordRepository.deleteById(id);
        
    }
    
}
