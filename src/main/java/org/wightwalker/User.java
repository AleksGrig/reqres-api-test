package org.wightwalker;

public record User(String email, String first_name, String last_name, String avatar) {
  @Override
  public String toString() {
    return """
        "email":"%s",
        "first_name":"%s",
        "last_name":"%s",
        "avatar":"%s"
        """.formatted(email, first_name, last_name, avatar);
  }
}
