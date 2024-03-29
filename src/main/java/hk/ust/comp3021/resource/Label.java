package hk.ust.comp3021.resource;

import java.util.Date;

import hk.ust.comp3021.person.User;

public class Label {

  private final String labelID;

  private String paperID;

  private Date creationTime;

  private String content;

  private User creator;

  public Label(String labelID, String paperID, Date creationTime, String content, User creator) {
    this.labelID = labelID;
    this.paperID = paperID;
    this.creationTime = creationTime;
    this.content = content;
    this.creator = creator;
  }

  public String getLabelID() {
    return labelID;
  }

  public String getPaperID() {
    return paperID;
  }

  public void setPaperID(String paperID) {
    this.paperID = paperID;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  /**
   * Attention: You may need to define more methods to update or access the field
   * of the class `User` Feel free to define more method but remember not (1)
   * removing the fields or methods in our skeleton. (2) changing the type
   * signature of `public` methods (3) changing the modifiers of the fields and
   * methods, e.g., changing a modifier from "private" to "public"
   */
  public void yourMethod() {

  }
}
