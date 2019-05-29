package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Results{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("url")
  @Expose
  private String url;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setUrl(String url){
   this.url=url;
  }
  public String getUrl(){
   return url;
  }
}