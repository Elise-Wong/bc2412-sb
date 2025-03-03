public enum SysCode {
  OK(1, "successful"),
  XX(0, " station is suspended.")
  ;

  private final int status;
  private final String message;

  private SysCode (int status, String message){
    this.status = status;
    this.message = message;
  }

  public int getStatus(){
    return this.status;
  }

  public String getMessage(){
    return this.message;
  }
  
}
