package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Game_indices{
  @SerializedName("game_index")
  @Expose
  private Integer game_index;
  @SerializedName("version")
  @Expose
  private Version version;
  public void setGame_index(Integer game_index){
   this.game_index=game_index;
  }
  public Integer getGame_index(){
   return game_index;
  }
  public void setVersion(Version version){
   this.version=version;
  }
  public Version getVersion(){
   return version;
  }
}