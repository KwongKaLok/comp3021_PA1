package hk.ust.comp3021.action;

import java.util.ArrayList;
import java.util.Date;

import hk.ust.comp3021.person.User;

public class DownloadPaperAction extends Action {
  private String downloadPath;

  private final ArrayList<String> papers = new ArrayList<>();

  private boolean actionResult;

  public DownloadPaperAction(String id, User user, Date time, String downloadPath) {
    // TODO: complete the definition of the constructor. Define the class as the
    // subclass of Action.
    super(id, user, time, ActionType.DOWNLOAD_PAPER);
    this.downloadPath = downloadPath;
  }

  // You may need the following methods to set or get the fields of
  // AddCommentAction
  // Plz DO NOT change the following methods. Otherwise, your test cases can fail
  // even if your implementation is correect.
  public String getDownloadPath() {
    return downloadPath;
  }

  public void setDownloadPath(String downloadPath) {
    this.downloadPath = downloadPath;
  }

  public ArrayList<String> getPaper() {
    return papers;
  }

  public void appendPapers(String paperID) {
    this.papers.add(paperID);
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
