package com.example.bai_1.repo;

import com.example.bai_1.model.BoxEmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BoxEmailRepo implements IBoxEmailRepo{
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer>sizeList=new ArrayList<>();
    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
    }


    @Override
    public List<String> getLanguages() {
        return languagesList;
    }

    @Override
    public List<Integer> getSize() {
        return sizeList;
    }

    @Override
    public BoxEmail getEmail() {
        BoxEmail email = new BoxEmail(languagesList.get(0),sizeList.get(2),false,"IronMan");
        return email;
    }
}
