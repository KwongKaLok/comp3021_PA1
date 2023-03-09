package hk.ust.comp3021.person;

import java.util.ArrayList;
import java.util.Date;

import hk.ust.comp3021.resource.Comment;
import hk.ust.comp3021.resource.Label;

public class User extends Person {
  private Date registerDate;

  private ArrayList<Comment> userComments;

  private ArrayList<Label> userLabels;

  public User(String id, String name, Date registerDate) {
    // TODO: complete the definition of the constructor
    super(id, name);
    this.registerDate = registerDate;
    this.userComments = new ArrayList<Comment>();
    this.userLabels = new ArrayList<Label>();
  }

  /**
   * Return an ArrayList containing all the comments of the paper with a given
   * paper id. Return an empty ArrayList if no paper has a given id or the paper
   * has no comment. You may need to remove the `return null` in the skeleton.
   */
  public ArrayList<Comment> searchCommentByPaperObjID(String id) {
    // TODO: complete the definition of the method ``searchCommentByPaperObjID''
    ArrayList<Comment> allCommentByPaperObjID = new ArrayList<>();
    userComments.forEach((comment) -> {
      if (comment.getCommentObjId() == id) {
        allCommentByPaperObjID.add(comment);
      }
    });
    return allCommentByPaperObjID;
  }

  /**
   * Return an ArrayList containing all the comments of the comment with a given
   * comment id. Return an empty ArrayList if no comment has a given id or the
   * comment has no comment. You may need to remove the `return null` in the
   * skeleton.
   */
  public ArrayList<Comment> searchCommentByCommentObjID(String id) {
    // TODO: complete the definition of the method ``searchCommentByCommentObjID''
    ArrayList<Comment> allCommentByCommentObjID = new ArrayList<>();
    userComments.forEach((comment) -> {
      if (comment.getCommentObjId() == id) {
        allCommentByCommentObjID.add(comment);
      }
    });
    return allCommentByCommentObjID;
  }

  /**
   * Return an ArrayList containing all the labels of the paper with a given paper
   * id. Return an empty ArrayList if no paper has a given id or the paper has no
   * label. You may need to remove the `return null` in the skeleton.
   */
  public ArrayList<Label> searchLabelByPaperID(String id) {
    // TODO: complete the definition of the method ``searchLabelByPaperID''
    ArrayList<Label> allLabelByPaperID = new ArrayList<>();
    userLabels.forEach((label) -> {
      if (label.getLabelID() == id) {
        allLabelByPaperID.add(label);
      }
    });
    return allLabelByPaperID;
  }

  /**
   * Attention: You may need to define more methods to update or access the field
   * of the class `User` Feel free to define more method but remember not (1)
   * removing the fields or methods in our skeleton. (2) changing the type
   * signature of `public` methods (3) changing the modifiers of the fields and
   * methods, e.g., changing a modifier from "private" to "public"
   */
  public void updateCommentList(Comment comment) {
    this.userComments.add(comment);
  }

  public void updateLabelList(Label label) {
    this.userLabels.add(label);
  }
}
