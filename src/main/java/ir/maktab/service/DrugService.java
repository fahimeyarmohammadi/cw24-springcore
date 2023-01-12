package ir.maktab.service;

import ir.maktab.data.entity.Drug;
import ir.maktab.data.repository.DrugRepository;
import ir.maktab.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {
   private final DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    public void save(Drug drug){
        drugRepository.save(drug);
    }
    public  void saveAll(List<Drug> drugList){
        drugRepository.saveAll(drugList);
    }


}
