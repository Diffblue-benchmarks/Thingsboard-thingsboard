package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class UserCredentialsEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCredentialsEntity#UserCredentialsEntity()}
   *   <li>{@link UserCredentialsEntity#setActivateToken(String)}
   *   <li>{@link UserCredentialsEntity#setActivateTokenExpTime(Long)}
   *   <li>{@link UserCredentialsEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link UserCredentialsEntity#setEnabled(boolean)}
   *   <li>{@link UserCredentialsEntity#setFailedLoginAttempts(Integer)}
   *   <li>{@link UserCredentialsEntity#setLastLoginTs(Long)}
   *   <li>{@link UserCredentialsEntity#setPassword(String)}
   *   <li>{@link UserCredentialsEntity#setResetToken(String)}
   *   <li>{@link UserCredentialsEntity#setResetTokenExpTime(Long)}
   *   <li>{@link UserCredentialsEntity#setUserId(UUID)}
   *   <li>{@link UserCredentialsEntity#toString()}
   *   <li>{@link UserCredentialsEntity#getActivateToken()}
   *   <li>{@link UserCredentialsEntity#getActivateTokenExpTime()}
   *   <li>{@link UserCredentialsEntity#getAdditionalInfo()}
   *   <li>{@link UserCredentialsEntity#getFailedLoginAttempts()}
   *   <li>{@link UserCredentialsEntity#getLastLoginTs()}
   *   <li>{@link UserCredentialsEntity#getPassword()}
   *   <li>{@link UserCredentialsEntity#getResetToken()}
   *   <li>{@link UserCredentialsEntity#getResetTokenExpTime()}
   *   <li>{@link UserCredentialsEntity#getUserId()}
   *   <li>{@link UserCredentialsEntity#isEnabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserCredentialsEntity.<init>()", "String UserCredentialsEntity.getActivateToken()",
      "Long UserCredentialsEntity.getActivateTokenExpTime()", "JsonNode UserCredentialsEntity.getAdditionalInfo()",
      "Integer UserCredentialsEntity.getFailedLoginAttempts()", "Long UserCredentialsEntity.getLastLoginTs()",
      "String UserCredentialsEntity.getPassword()", "String UserCredentialsEntity.getResetToken()",
      "Long UserCredentialsEntity.getResetTokenExpTime()", "UUID UserCredentialsEntity.getUserId()",
      "boolean UserCredentialsEntity.isEnabled()", "void UserCredentialsEntity.setActivateToken(String)",
      "void UserCredentialsEntity.setActivateTokenExpTime(Long)",
      "void UserCredentialsEntity.setAdditionalInfo(JsonNode)", "void UserCredentialsEntity.setEnabled(boolean)",
      "void UserCredentialsEntity.setFailedLoginAttempts(Integer)", "void UserCredentialsEntity.setLastLoginTs(Long)",
      "void UserCredentialsEntity.setPassword(String)", "void UserCredentialsEntity.setResetToken(String)",
      "void UserCredentialsEntity.setResetTokenExpTime(Long)", "void UserCredentialsEntity.setUserId(UUID)",
      "String UserCredentialsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    UserCredentialsEntity actualUserCredentialsEntity = new UserCredentialsEntity();
    actualUserCredentialsEntity.setActivateToken("ABC123");
    actualUserCredentialsEntity.setActivateTokenExpTime(1L);
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserCredentialsEntity.setAdditionalInfo(additionalInfo);
    actualUserCredentialsEntity.setEnabled(true);
    actualUserCredentialsEntity.setFailedLoginAttempts(1);
    actualUserCredentialsEntity.setLastLoginTs(1L);
    actualUserCredentialsEntity.setPassword("iloveyou");
    actualUserCredentialsEntity.setResetToken("ABC123");
    actualUserCredentialsEntity.setResetTokenExpTime(1L);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserCredentialsEntity.setUserId(userId);
    String actualToStringResult = actualUserCredentialsEntity.toString();
    String actualActivateToken = actualUserCredentialsEntity.getActivateToken();
    Long actualActivateTokenExpTime = actualUserCredentialsEntity.getActivateTokenExpTime();
    JsonNode actualAdditionalInfo = actualUserCredentialsEntity.getAdditionalInfo();
    Integer actualFailedLoginAttempts = actualUserCredentialsEntity.getFailedLoginAttempts();
    Long actualLastLoginTs = actualUserCredentialsEntity.getLastLoginTs();
    String actualPassword = actualUserCredentialsEntity.getPassword();
    String actualResetToken = actualUserCredentialsEntity.getResetToken();
    Long actualResetTokenExpTime = actualUserCredentialsEntity.getResetTokenExpTime();
    UUID actualUserId = actualUserCredentialsEntity.getUserId();
    boolean actualIsEnabledResult = actualUserCredentialsEntity.isEnabled();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("ABC123", actualActivateToken);
    assertEquals("ABC123", actualResetToken);
    assertEquals("UserCredentialsEntity(userId=784f394c-42b6-435a-983c-b7beff2784f9, enabled=true, password=iloveyou,"
        + " activateToken=ABC123, activateTokenExpTime=1, resetToken=ABC123, resetTokenExpTime=1, additionalInfo"
        + "={\"isPublic\":true}, lastLoginTs=1, failedLoginAttempts=1)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertNull(actualUserCredentialsEntity.getId());
    assertNull(actualUserCredentialsEntity.getUuid());
    assertEquals(0L, actualUserCredentialsEntity.getCreatedTime());
    assertEquals(1, actualFailedLoginAttempts.intValue());
    assertEquals(1L, actualActivateTokenExpTime.longValue());
    assertEquals(1L, actualLastLoginTs.longValue());
    assertEquals(1L, actualResetTokenExpTime.longValue());
    assertTrue(actualIsEnabledResult);
    assertSame(userId, actualUserId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
