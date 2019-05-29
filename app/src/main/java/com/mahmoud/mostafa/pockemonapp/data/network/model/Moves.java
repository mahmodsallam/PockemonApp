package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Moves{
  @SerializedName("version_group_details")
  @Expose
  private List<Version_group_details> version_group_details;
  @SerializedName("move")
  @Expose
  private Move move;
  public void setVersion_group_details(List<Version_group_details> version_group_details){
   this.version_group_details=version_group_details;
  }
  public List<Version_group_details> getVersion_group_details(){
   return version_group_details;
  }
  public void setMove(Move move){
   this.move=move;
  }
  public Move getMove(){
   return move;
  }
}