package com.model;

import org.owasp.encoder.Encode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserSearchData {

  @NotBlank
  @Size(max = 100)
  private String searchTerm;

  public String getSearchTerm() {
    return searchTerm;
  }

  public void setSearchTerm(String searchTerm) {
    this.searchTerm = Encode.forHtml(searchTerm);
  }
}
