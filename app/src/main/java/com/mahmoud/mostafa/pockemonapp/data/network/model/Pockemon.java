package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Pockemon{
  @SerializedName("next")
  @Expose
  private String next;
  @SerializedName("previous")
  @Expose
  private Object previous;
  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("results")
  @Expose
  private List<Results> results;
  public void setNext(String next){
   this.next=next;
  }
  public String getNext(){
   return next;
  }
  public void setPrevious(Object previous){
   this.previous=previous;
  }
  public Object getPrevious(){
   return previous;
  }
  public void setCount(Integer count){
   this.count=count;
  }
  public Integer getCount(){
   return count;
  }
  public void setResults(List<Results> results){
   this.results=results;
  }
  public List<Results> getResults(){
   return results;
  }
}