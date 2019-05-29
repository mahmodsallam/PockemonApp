package com.mahmoud.mostafa.pockemonapp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class PockemonDetail{
  @SerializedName("location_area_encounters")
  @Expose
  private String location_area_encounters;
  @SerializedName("types")
  @Expose
  private List<Types> types;
  @SerializedName("base_experience")
  @Expose
  private Integer base_experience;
  /*@SerializedName("held_items")
  @Expose
  private List<Held_items> held_items;*/
  @SerializedName("weight")
  @Expose
  private Integer weight;
  @SerializedName("is_default")
  @Expose
  private Boolean is_default;
  @SerializedName("sprites")
  @Expose
  private Sprites sprites;
  @SerializedName("abilities")
  @Expose
  private List<Abilities> abilities;
  @SerializedName("game_indices")
  @Expose
  private List<Game_indices> game_indices;
  @SerializedName("species")
  @Expose
  private Species species;
  @SerializedName("stats")
  @Expose
  private List<Stats> stats;
  @SerializedName("moves")
  @Expose
  private List<Moves> moves;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("forms")
  @Expose
  private List<Forms> forms;
  @SerializedName("height")
  @Expose
  private Integer height;
  @SerializedName("order")
  @Expose
  private Integer order;
  public void setLocation_area_encounters(String location_area_encounters){
   this.location_area_encounters=location_area_encounters;
  }
  public String getLocation_area_encounters(){
   return location_area_encounters;
  }
  public void setTypes(List<Types> types){
   this.types=types;
  }
  public List<Types> getTypes(){
   return types;
  }
  public void setBase_experience(Integer base_experience){
   this.base_experience=base_experience;
  }
  public Integer getBase_experience(){
   return base_experience;
  }
//  public void setHeld_items(List<Held_items> held_items){
//   this.held_items=held_items;
//  }
//  public List<Held_items> getHeld_items(){
//   return held_items;
//  }
  public void setWeight(Integer weight){
   this.weight=weight;
  }
  public Integer getWeight(){
   return weight;
  }
  public void setIs_default(Boolean is_default){
   this.is_default=is_default;
  }
  public Boolean getIs_default(){
   return is_default;
  }
  public void setSprites(Sprites sprites){
   this.sprites=sprites;
  }
  public Sprites getSprites(){
   return sprites;
  }
  public void setAbilities(List<Abilities> abilities){
   this.abilities=abilities;
  }
  public List<Abilities> getAbilities(){
   return abilities;
  }
  public void setGame_indices(List<Game_indices> game_indices){
   this.game_indices=game_indices;
  }
  public List<Game_indices> getGame_indices(){
   return game_indices;
  }
  public void setSpecies(Species species){
   this.species=species;
  }
  public Species getSpecies(){
   return species;
  }
  public void setStats(List<Stats> stats){
   this.stats=stats;
  }
  public List<Stats> getStats(){
   return stats;
  }
  public void setMoves(List<Moves> moves){
   this.moves=moves;
  }
  public List<Moves> getMoves(){
   return moves;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
  public void setForms(List<Forms> forms){
   this.forms=forms;
  }
  public List<Forms> getForms(){
   return forms;
  }
  public void setHeight(Integer height){
   this.height=height;
  }
  public Integer getHeight(){
   return height;
  }
  public void setOrder(Integer order){
   this.order=order;
  }
  public Integer getOrder(){
   return order;
  }
}