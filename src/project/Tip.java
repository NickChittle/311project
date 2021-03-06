/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

public class Tip {
  public enum TipType { 
    AMOUNT, PERCENT 
  }
  
  private TipType tipType;
  private double tipAmount;
  private double tipPercent;
  
  public Tip() {
    tipType = TipType.AMOUNT;
    tipAmount = 0;
    tipPercent = 0;
  }
  
  public double getTip(double total) {
    double tip = 0;
    if (tipType == TipType.PERCENT) {
      tip = total * tipPercent;
    } else {
      tip = tipAmount;
    }
    return tip;
  }
  
  public TipType getTipType() {
    return tipType;
  }
  
  public String getTipString(double total) {
    return String.format("%.2f", getTip(total));
  }
  
  public void setTipAmount(double amount) {
    this.tipType = TipType.AMOUNT;
    this.tipAmount = amount;
    this.tipPercent = 0;
  }
  
  public double getTipAmount() {
    return tipAmount;
  }
  
  public void setTipPercent(double percent) {
    this.tipType = TipType.PERCENT;
    this.tipPercent = percent;
    this.tipAmount = 0;
  }
  
  public double getTipPercent() {
    return tipPercent;
  }
  
  public String getLoadTipString(double amount) {
    if (tipType == TipType.AMOUNT) {
      return String.format("$%.2f", getTipAmount());
    } else if (tipType == TipType.PERCENT) {
      return String.format("%.2f%%, $%.2f", getTipPercent() * 100, getTip(amount));
    }
    return "";
  }
}
