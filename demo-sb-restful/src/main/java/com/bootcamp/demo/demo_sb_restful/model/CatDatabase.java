package com.bootcamp.demo.demo_sb_restful.model;

import java.util.Optional;

public class CatDatabase {

    public static final Cat[] HOME = new Cat[5];

    // public static boolean put(Cat cat) {
    //   for (int i = 0; i < HOME.length; i++) {
    //     if (HOME[i] == null) {
    //       HOME[i] = cat;
    //       return true;
    //     }
    //   }
    //   return false;
    // }

    public static Optional<Cat> find(Long catId) {
      for (Cat cat : HOME) {
        if (cat.getId() == catId)
            return Optional.of(cat);
      }
      return Optional.empty();// optional 既 object 包住 empty
    }

    //remember Wrapper class has null
    public static Boolean delete(Long catId) {
        for (int i = 0 ; i < HOME.length ; i++) {
            if (HOME[i].getId() == catId) {
              HOME[i] = null;
              return true;
            }
        }
        return false;
    }

    //remember return type use Wrapper class
      public static Boolean update(Long catId, Cat cat) {
        for (int i = 0 ; i < HOME.length ; i++) {
          if (HOME[i].getId() == catId) {
            HOME[i] = cat;
            return true;
          }
        }
        return false;
      }

      // don't create cat, we should find the cat object and call setName()
      // other value of this cat object remain unchange
      public static boolean patchName(Long catId, String catName) {
        for (int i = 0 ; i < HOME.length ; i++) {
          if (HOME[i].getId() == catId) {
            HOME[i].setName(catName);
            return true;
          }
        }
        return false;
      }

  }
