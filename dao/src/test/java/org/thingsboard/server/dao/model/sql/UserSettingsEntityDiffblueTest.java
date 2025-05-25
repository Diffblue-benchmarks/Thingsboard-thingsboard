package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class UserSettingsEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#UserSettingsEntity()}
   *   <li>{@link UserSettingsEntity#setSettings(JsonNode)}
   *   <li>{@link UserSettingsEntity#setType(String)}
   *   <li>{@link UserSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserSettingsEntity#toString()}
   *   <li>{@link UserSettingsEntity#getSettings()}
   *   <li>{@link UserSettingsEntity#getType()}
   *   <li>{@link UserSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserSettingsEntity.<init>()", "JsonNode UserSettingsEntity.getSettings()",
      "String UserSettingsEntity.getType()", "UUID UserSettingsEntity.getUserId()",
      "void UserSettingsEntity.setSettings(JsonNode)", "void UserSettingsEntity.setType(String)",
      "void UserSettingsEntity.setUserId(UUID)", "String UserSettingsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity();
    JsonNode settings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserSettingsEntity.setSettings(settings);
    actualUserSettingsEntity.setType("Type");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserSettingsEntity.toString();
    JsonNode actualSettings = actualUserSettingsEntity.getSettings();
    String actualType = actualUserSettingsEntity.getType();
    UUID actualUserId = actualUserSettingsEntity.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Type", actualType);
    assertEquals(
        "UserSettingsEntity(userId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, settings={\"isPublic" + "\":true})",
        actualToStringResult);
    assertSame(userId, actualUserId);
    assertSame(settings, actualSettings);
  }
}
