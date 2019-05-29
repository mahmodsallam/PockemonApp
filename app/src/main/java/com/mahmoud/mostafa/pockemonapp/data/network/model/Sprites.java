package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Sprites{
  @SerializedName("back_shiny_female")
  @Expose
  private Object back_shiny_female;
  @SerializedName("back_female")
  @Expose
  private Object back_female;
  @SerializedName("back_default")
  @Expose
  private String back_default;
  @SerializedName("front_shiny_female")
  @Expose
  private Object front_shiny_female;
  @SerializedName("front_default")
  @Expose
  private String front_default;
  @SerializedName("front_female")
  @Expose
  private Object front_female;
  @SerializedName("back_shiny")
  @Expose
  private String back_shiny;
  @SerializedName("front_shiny")
  @Expose
  private String front_shiny;
  public void setBack_shiny_female(Object back_shiny_female){
   this.back_shiny_female=back_shiny_female;
  }
  public Object getBack_shiny_female(){
   return back_shiny_female;
  }
  public void setBack_female(Object back_female){
   this.back_female=back_female;
  }
  public Object getBack_female(){
   return back_female;
  }
  public void setBack_default(String back_default){
   this.back_default=back_default;
  }
  public String getBack_default(){
   return back_default;
  }
  public void setFront_shiny_female(Object front_shiny_female){
   this.front_shiny_female=front_shiny_female;
  }
  public Object getFront_shiny_female(){
   return front_shiny_female;
  }
  public void setFront_default(String front_default){
   this.front_default=front_default;
  }
  public String getFront_default(){
   return front_default;
  }
  public void setFront_female(Object front_female){
   this.front_female=front_female;
  }
  public Object getFront_female(){
   return front_female;
  }
  public void setBack_shiny(String back_shiny){
   this.back_shiny=back_shiny;
  }
  public String getBack_shiny(){
   return back_shiny;
  }
  public void setFront_shiny(String front_shiny){
   this.front_shiny=front_shiny;
  }
  public String getFront_shiny(){
   return front_shiny;
  }
}