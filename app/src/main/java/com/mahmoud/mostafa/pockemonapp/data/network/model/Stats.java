package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Stats{
  @SerializedName("stat")
  @Expose
  private Stat stat;
  @SerializedName("base_stat")
  @Expose
  private Integer base_stat;
  @SerializedName("effort")
  @Expose
  private Integer effort;
  public void setStat(Stat stat){
   this.stat=stat;
  }
  public Stat getStat(){
   return stat;
  }
  public void setBase_stat(Integer base_stat){
   this.base_stat=base_stat;
  }
  public Integer getBase_stat(){
   return base_stat;
  }
  public void setEffort(Integer effort){
   this.effort=effort;
  }
  public Integer getEffort(){
   return effort;
  }
}