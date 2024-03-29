package hk.ust.comp3021.action;

import java.util.Date;
import java.util.HashMap;

import hk.ust.comp3021.person.User;
import hk.ust.comp3021.resource.Paper;

public class UploadPaperAction extends Action {
  private String bibfilePath;

  private HashMap<String, Paper> uploadedPapers = new HashMap<>();

  private boolean actionResult = false;

  public UploadPaperAction(String id, User user, Date time, String bibfilePath) {
    // TODO: complete the definition of the constructor. Define the class as the
    // subclass of Action.
    super(id, user, time, ActionType.UPLOAD_PAPER);
    this.bibfilePath = bibfilePath;
  }

  // You may need the following methods to set or get the fields of
  // AddCommentAction
  // Plz DO NOT change the following methods. Otherwise, your test cases can fail
  // even if your implementation is correect.
  public String getBibfilePath() {
    return bibfilePath;
  }

  public void setBibfilePath(String bibfilePath) {
    this.bibfilePath = bibfilePath;
  }

  public HashMap<String, Paper> getUploadedPapers() {
    return uploadedPapers;
  }

  public void setUploadedPapers(HashMap<String, Paper> uploadedPapers) {
    this.uploadedPapers = uploadedPapers;
  }

  public boolean getActionResult() {
    return actionResult;
  }

  public void setActionResult(boolean actionResult) {
    this.actionResult = actionResult;
  }

  /**
   * Attention: You may need to define more methods to update or access the field
   * of the class `User` Feel free to define more method but remember not (1)
   * removing the fields or methods in our skeleton. (2) changing the type
   * signature of `public` methods (3) changing the modifiers of the fields and
   * methods, e.g., changing a modifier from "private" to "public"
   */
  @Override
  public void yourMethod() {

  }
}
