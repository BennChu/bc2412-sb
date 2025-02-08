package com.bootcamp.demo.demo_sb_restful.controller;

//import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_restful.Service.CatService;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.model.CatDatabase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


// RESTful API -> GET/POST/DELETE/PUT/PATCH
// Contorl singal resurce by these, 都係 Cat

// Controller -> The ways to control Cat resource
// insert, update, delete, select
@Controller
@ResponseBody
public class CatController {

  // Contoller (call)-> Service (call)-> CatDatabase

  // @ComponentScan
  // - Try to scan all classes with 
  // - Try to find out their relationship
  //    - for example, CatController @Autowired CatService -> CatService bean must be ready for
  //        CatContoller bean creation. If CatService bean not ready, CatController bean creation
  //        fail, server start fail.

  // IOC, 觀察所有 dependency 狀態, 先 start server

  // 我需要 new, 有人 help 我 new
  // find "caused by"


  // Autowired Dependency Injection (Spring Core Concept)
  // Try to find an object which fits into catService, (Before server start complete)
  // if fail, server start fail
  

  // Field injection
  @Autowired //boolean required() default true; return true 先 start 到 server
  private CatService catService;


  // Constructor injection
  // 有以下 constructor, 就唔洗 @Autowired
  // @Autowired(required = false), 搵唔到都 start server
  // public CatController(CatService catService) {
  //   this.catService = catService;
  // }

  // java 要諗 memory, 好多人 call memory 點算

  // insert
  //post is create, 用家唔使 create id
  // for method POST, PUT, the request body contains data in a specific
  //representation format to create or update resources
  @PostMapping(value = "/cat")
  public Cat createCat(@RequestBody Cat cat) {
    if (this.catService.put(cat)) // 唔會 null pointer exception, new CatService.put(cat), 會開多好多 object
      return cat;

    return null;
  }

  // select
  // public Cat getCats()
  @GetMapping(value = "/cats")
  public List<Cat> getCats() {//cat[] 都一樣, 但唔easy 轉換
      return List.of(CatDatabase.HOME);//HOME is array List.of 都 enught
  }
  
  // get cat by id
  // http://localhost:8082/cat?id=1
  // Deserialization, 1 int -> long (int go to long is ok)
  @GetMapping(value = "/cat")
  public Cat getCat (@RequestParam Long id) { //(value = "catId")
      new Cat(id, null, null); //this is an example, new then find the cat, so can find will not null
      return CatDatabase.find(id).orElse(null);
  }
  

  // delete by id
  // http://localhost:8082/cat?id=1
  @DeleteMapping(value = "/cat") //delete usually by id
  public boolean delecteCat(@RequestParam Long id) { //boolean can success or unccess
      return CatDatabase.delete(id);
  }

  //
  @PutMapping(value = "/cat")
  public Boolean updateCat(@RequestParam Long id, @RequestBody Cat cat) {
         
      return CatDatabase.update(id, cat);
  }

  @PatchMapping(value = "/cat/name/{name}")
  public Boolean updateCat(@RequestParam Long id, @PathVariable String name) {
      return CatDatabase.patchName(id, name);
  }






}
