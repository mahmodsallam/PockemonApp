package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Abilities{
  @SerializedName("is_hidden")
  @Expose
  private Boolean is_hidden;
  @SerializedName("ability")
  @Expose
  private Ability ability;
  @SerializedName("slot")
  @Expose
  private Integer slot;
  public void setIs_hidden(Boolean is_hidden){
   this.is_hidden=is_hidden;
  }
  public Boolean getIs_hidden(){
   return is_hidden;
  }
  public void setAbility(Ability ability){
   this.ability=ability;
  }
  public Ability getAbility(){
   return ability;
  }
  public void setSlot(Integer slot){
   this.slot=slot;
  }
  public Integer getSlot(){
   return slot;
  }
}