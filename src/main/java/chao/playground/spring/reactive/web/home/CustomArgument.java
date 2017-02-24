package chao.playground.spring.reactive.web.home;

public class CustomArgument {
  private final String custom;

  public CustomArgument(String custom) {
    this.custom = custom;
  }

  public String getCustom() {
    return custom;
  }
}
