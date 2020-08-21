package service.impl;

import model.DictModel;
import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    private static Map<Integer, DictModel> dictionary = new HashMap<>();

    static {
        dictionary.put(1, new DictModel("hello","xin chào"));
        dictionary.put(2,new DictModel("red","màu đỏ"));
        dictionary.put(3,new DictModel("dog","con chó"));
        dictionary.put(4,new DictModel("chicken","con gà"));
    }

    public List<DictModel> findAll(){
        return new ArrayList<>(dictionary.values());
    }

}