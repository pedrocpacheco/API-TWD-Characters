package br.com.alura.twd.characters;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "twdCharacters")
public class TwdCharacter {
  
  @Id
  private String id;
  private String name;
  private String image;
  private String firstSeason;
  private String community;
  private String gunType;
  private String status;

  public TwdCharacter(){
    
  }

  public TwdCharacter(String name, String image, String firstSeason, String community, String status) {
    this.name = name;
    this.image = image;
    this.firstSeason = firstSeason;
    this.community = community;
    this.status = status;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  public String getImage() {
    return image;
  }
  public String getFirstSeason() {
    return firstSeason;
  }
  public String getCommunity() {
    return community;
  }
  public String getStatus() {
    return status;
  }

  public String getGunType() {
    return gunType;
  }

}
