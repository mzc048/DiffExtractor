/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author mzc048
 */
public class Difference<O> {
    String itemName;
    O left;
    O right;

    public Difference(String itemName, O left, O right) {
        this.itemName = itemName;
        this.left = left;
        this.right = right;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public O getLeft() {
        return left;
    }

    public void setLeft(O left) {
        this.left = left;
    }

    public O getRight() {
        return right;
    }

    public void setRight(O right) {
        this.right = right;
    }
    
}
