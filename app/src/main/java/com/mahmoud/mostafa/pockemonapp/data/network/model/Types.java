package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Types{
  @SerializedName("slot")
  @Expose
  private Integer slot;
  @SerializedName("type")
  @Expose
  private Type type;
  public void setSlot(Integer slot){
   this.slot=slot;
  }
  public Integer getSlot(){
   return slot;
  }
  public void setType(Type type){
   this.type=type;
  }
  public Type getType(){
   return type;
  }
}