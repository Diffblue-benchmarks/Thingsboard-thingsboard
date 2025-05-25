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
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class UserEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEntity#UserEntity()}
   *   <li>{@link UserEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link UserEntity#setAuthority(Authority)}
   *   <li>{@link UserEntity#setCustomerId(UUID)}
   *   <li>{@link UserEntity#setEmail(String)}
   *   <li>{@link UserEntity#setFirstName(String)}
   *   <li>{@link UserEntity#setLastName(String)}
   *   <li>{@link UserEntity#setPhone(String)}
   *   <li>{@link UserEntity#setTenantId(UUID)}
   *   <li>{@link UserEntity#toString()}
   *   <li>{@link UserEntity#getAdditionalInfo()}
   *   <li>{@link UserEntity#getAuthority()}
   *   <li>{@link UserEntity#getCustomerId()}
   *   <li>{@link UserEntity#getEmail()}
   *   <li>{@link UserEntity#getFirstName()}
   *   <li>{@link UserEntity#getLastName()}
   *   <li>{@link UserEntity#getPhone()}
   *   <li>{@link UserEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserEntity.<init>()", "JsonNode UserEntity.getAdditionalInfo()",
      "Authority UserEntity.getAuthority()", "UUID UserEntity.getCustomerId()", "String UserEntity.getEmail()",
      "String UserEntity.getFirstName()", "String UserEntity.getLastName()", "String UserEntity.getPhone()",
      "UUID UserEntity.getTenantId()", "void UserEntity.setAdditionalInfo(JsonNode)",
      "void UserEntity.setAuthority(Authority)", "void UserEntity.setCustomerId(UUID)",
      "void UserEntity.setEmail(String)", "void UserEntity.setFirstName(String)", "void UserEntity.setLastName(String)",
      "void UserEntity.setPhone(String)", "void UserEntity.setTenantId(UUID)", "String UserEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    UserEntity actualUserEntity = new UserEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserEntity.setAdditionalInfo(additionalInfo);
    actualUserEntity.setAuthority(Authority.SYS_ADMIN);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserEntity.setCustomerId(customerId);
    actualUserEntity.setEmail("jane.doe@example.org");
    actualUserEntity.setFirstName("Jane");
    actualUserEntity.setLastName("Doe");
    actualUserEntity.setPhone("6625550144");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserEntity.setTenantId(tenantId);
    String actualToStringResult = actualUserEntity.toString();
    JsonNode actualAdditionalInfo = actualUserEntity.getAdditionalInfo();
    Authority actualAuthority = actualUserEntity.getAuthority();
    UUID actualCustomerId = actualUserEntity.getCustomerId();
    String actualEmail = actualUserEntity.getEmail();
    String actualFirstName = actualUserEntity.getFirstName();
    String actualLastName = actualUserEntity.getLastName();
    String actualPhone = actualUserEntity.getPhone();
    UUID actualTenantId = actualUserEntity.getTenantId();

    // Assert
    assertEquals("6625550144", actualPhone);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualCustomerId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals(
        "UserEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, customerId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " authority=SYS_ADMIN, email=jane.doe@example.org, firstName=Jane, lastName=Doe, phone=6625550144,"
            + " additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualUserEntity.getVersion());
    assertNull(actualUserEntity.getId());
    assertNull(actualUserEntity.getUuid());
    assertEquals(0L, actualUserEntity.getCreatedTime());
    assertEquals(Authority.SYS_ADMIN, actualAuthority);
    assertSame(customerId, actualCustomerId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
