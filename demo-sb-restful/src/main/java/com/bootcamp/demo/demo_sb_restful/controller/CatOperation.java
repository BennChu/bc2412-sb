package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_sb_restful.Service.CatService;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.model.CatDatabase;

public class CatOperation {

  private CatService catService;

  @PostMapping(value = "/cat")
  public Cat createCat(@RequestBody Cat cat) {
    if (this.catService.put(cat)) // 唔會 null pointer exception, new CatService.put(cat), 會開多好多 object
      return cat;

    return null;
  }

  // select
  //
  // public Cat getCats()
  // http://localhost:8082/cats
  @GetMapping(value = "/cats")
  public List<Cat> getCats() {// cat[] 都一樣, 但唔easy 轉換
    return List.of(CatDatabase.HOME);// HOME is array List.of 都 enught
  }

  // get cat by id
  // http://localhost:8082/cat?id=1
  // Deserialization, 1 int -> long (int go to long is ok)
  @GetMapping(value = "/cat")
  public Cat getCat(@RequestParam Long id) { // (value = "catId")
    new Cat(id, null, null); // this is an example, new then find the cat, so can find will not null
    return CatDatabase.find(id).orElse(null);
  }


  // delete by id
  // http://localhost:8082/cat?id=1
  @DeleteMapping(value = "/cat") // delete usually by id
  public boolean delecteCat(@RequestParam Long id) { // boolean can success or unccess
    return CatDatabase.delete(id);
  }

  // http://localhost:8082/cat?id=1
  @PutMapping(value = "/cat")
  public Boolean updateCat(@RequestParam Long id, @RequestBody Cat cat) {

    return CatDatabase.update(id, cat);
  }

  //
  @PatchMapping(value = "/cat/name/{name}")
  public Boolean updateCat(@RequestParam Long id, @PathVariable String name) {
    return CatDatabase.patchName(id, name);
  }
}
