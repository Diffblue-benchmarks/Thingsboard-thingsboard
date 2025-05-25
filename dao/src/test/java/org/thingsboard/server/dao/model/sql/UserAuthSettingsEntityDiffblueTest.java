package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class UserAuthSettingsEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#UserAuthSettingsEntity()}
   *   <li>{@link UserAuthSettingsEntity#setTwoFaSettings(JsonNode)}
   *   <li>{@link UserAuthSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserAuthSettingsEntity#toString()}
   *   <li>{@link UserAuthSettingsEntity#getTwoFaSettings()}
   *   <li>{@link UserAuthSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>()", "JsonNode UserAuthSettingsEntity.getTwoFaSettings()",
      "UUID UserAuthSettingsEntity.getUserId()", "void UserAuthSettingsEntity.setTwoFaSettings(JsonNode)",
      "void UserAuthSettingsEntity.setUserId(UUID)", "String UserAuthSettingsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity();
    JsonNode twoFaSettings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserAuthSettingsEntity.setTwoFaSettings(twoFaSettings);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserAuthSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserAuthSettingsEntity.toString();
    JsonNode actualTwoFaSettings = actualUserAuthSettingsEntity.getTwoFaSettings();
    UUID actualUserId = actualUserAuthSettingsEntity.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals(
        "UserAuthSettingsEntity(userId=784f394c-42b6-435a-983c-b7beff2784f9, twoFaSettings={\"isPublic\":true})",
        actualToStringResult);
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(userId, actualUserId);
    assertSame(twoFaSettings, actualTwoFaSettings);
  }
}
