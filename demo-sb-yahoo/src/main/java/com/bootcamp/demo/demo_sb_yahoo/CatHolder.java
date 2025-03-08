package com.bootcamp.demo.demo_sb_yahoo;

// Cat -> name, age
public class CatHolder {
  // private Cat cat;
  private Gun gun;

  public CatHolder(Cat cat) {
    // this.cat = cat;
    this.gun = cat.getGun();
  }

  public void magic() {
    this.gun.setColor("Yellow");
  }

  public static void main(String[] args) {
    Cat supercat = new Cat(new Gun());
    CatHolder catHolder = new CatHolder(supercat);
    catHolder.magic();
    System.out.println(supercat.getGun().getColor()); // Yellow
  }
}
