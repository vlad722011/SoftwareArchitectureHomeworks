package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Toy
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-19T15:14:41.617071088+07:00[Asia/Novosibirsk]")
public class Toy {

  private String toyId;

  private String name;

  /**
   * Статус (состояние) игрушки
   */
  public enum StatusEnum {
    NEW("new"),
    
    USED("used"),
    
    BROKEN("broken");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private String note;

  private String createdAt;

  public Toy() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Toy(String name, StatusEnum status) {
    this.name = name;
    this.status = status;
  }

  public Toy toyId(String toyId) {
    this.toyId = toyId;
    return this;
  }

  /**
   * Get toyId
   * @return toyId
  */
  
  @Schema(name = "toy_id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("toy_id")
  public String getToyId() {
    return toyId;
  }

  public void setToyId(String toyId) {
    this.toyId = toyId;
  }

  public Toy name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название игрушки
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Train", description = "Название игрушки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Toy status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Статус (состояние) игрушки
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "new", description = "Статус (состояние) игрушки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Toy note(String note) {
    this.note = note;
    return this;
  }

  /**
   * Описание, пометки
   * @return note
  */
  
  @Schema(name = "note", example = "Found on a street", description = "Описание, пометки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Toy createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Дата и время сохранения игрушки в каталоге
   * @return createdAt
  */
  
  @Schema(name = "created_at", example = "2022-07-01T15:00:00+01", description = "Дата и время сохранения игрушки в каталоге", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Toy toy = (Toy) o;
    return Objects.equals(this.toyId, toy.toyId) &&
        Objects.equals(this.name, toy.name) &&
        Objects.equals(this.status, toy.status) &&
        Objects.equals(this.note, toy.note) &&
        Objects.equals(this.createdAt, toy.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toyId, name, status, note, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Toy {\n");
    sb.append("    toyId: ").append(toIndentedString(toyId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

