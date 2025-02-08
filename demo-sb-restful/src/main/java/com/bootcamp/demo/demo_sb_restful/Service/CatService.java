package com.bootcamp.demo.demo_sb_restful.Service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.model.CatDatabase;

@Service // this is Bean, put into spring context
         // stateless
         // Person.class -> name -> setName() -> getName() 有狀態
         // no attribute 冇狀態
         // 冇狀態, 有資格可以做 bean

// this object is stateless
public class CatService {
    
    // no need new
    // already into spring context
    public boolean put(Cat cat) {
      for (int i = 0; i < CatDatabase.HOME.length; i++) {
        if (CatDatabase.HOME[i] == null) {
          CatDatabase.HOME[i] = cat;
          return true;
        }
      }
      return false;
    }


}
