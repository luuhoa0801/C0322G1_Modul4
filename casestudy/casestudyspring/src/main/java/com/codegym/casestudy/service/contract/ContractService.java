package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAllContract( Pageable pageable) {
        return iContractRepository.findAllContract(pageable);
    }

    @Override
    public void create(Contract contract) {
    iContractRepository.save(contract);
    }

}
