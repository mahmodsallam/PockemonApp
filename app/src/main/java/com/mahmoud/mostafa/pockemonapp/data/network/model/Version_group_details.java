package com.mahmoud.mostafa.pockemonapp.data.network.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Version_group_details{
  @SerializedName("level_learned_at")
  @Expose
  private Integer level_learned_at;
  @SerializedName("version_group")
  @Expose
  private Version_group version_group;
  @SerializedName("move_learn_method")
  @Expose
  private Move_learn_method move_learn_method;
  public void setLevel_learned_at(Integer level_learned_at){
   this.level_learned_at=level_learned_at;
  }
  public Integer getLevel_learned_at(){
   return level_learned_at;
  }
  public void setVersion_group(Version_group version_group){
   this.version_group=version_group;
  }
  public Version_group getVersion_group(){
   return version_group;
  }
  public void setMove_learn_method(Move_learn_method move_learn_method){
   this.move_learn_method=move_learn_method;
  }
  public Move_learn_method getMove_learn_method(){
   return move_learn_method;
  }
}