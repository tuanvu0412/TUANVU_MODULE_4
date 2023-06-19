package com.example.bai_1.service;

import com.example.bai_1.model.BoxEmail;
import com.example.bai_1.repo.IBoxEmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxEmailService implements IBoxEmailService {
    @Autowired
    private IBoxEmailRepo boxEmailRepo;
    @Override
    public List<String> getLanguages() {
        return boxEmailRepo.getLanguages();
    }

    @Override
    public List<Integer> getSize() {
        return boxEmailRepo.getSize();
    }

    @Override
    public BoxEmail getEmail() {
        BoxEmail email = boxEmailRepo.getEmail();
        return email;
    }
}
