package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class TenantProfileEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEntity#TenantProfileEntity()}
   *   <li>{@link TenantProfileEntity#setDefault(boolean)}
   *   <li>{@link TenantProfileEntity#setDescription(String)}
   *   <li>{@link TenantProfileEntity#setIsolatedTbRuleEngine(boolean)}
   *   <li>{@link TenantProfileEntity#setName(String)}
   *   <li>{@link TenantProfileEntity#setProfileData(JsonNode)}
   *   <li>{@link TenantProfileEntity#toString()}
   *   <li>{@link TenantProfileEntity#getDescription()}
   *   <li>{@link TenantProfileEntity#getName()}
   *   <li>{@link TenantProfileEntity#getProfileData()}
   *   <li>{@link TenantProfileEntity#isDefault()}
   *   <li>{@link TenantProfileEntity#isIsolatedTbRuleEngine()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantProfileEntity.<init>()", "String TenantProfileEntity.getDescription()",
      "String TenantProfileEntity.getName()", "JsonNode TenantProfileEntity.getProfileData()",
      "boolean TenantProfileEntity.isDefault()", "boolean TenantProfileEntity.isIsolatedTbRuleEngine()",
      "void TenantProfileEntity.setDefault(boolean)", "void TenantProfileEntity.setDescription(String)",
      "void TenantProfileEntity.setIsolatedTbRuleEngine(boolean)", "void TenantProfileEntity.setName(String)",
      "void TenantProfileEntity.setProfileData(JsonNode)", "String TenantProfileEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity();
    actualTenantProfileEntity.setDefault(true);
    actualTenantProfileEntity.setDescription("The characteristics of someone or something");
    actualTenantProfileEntity.setIsolatedTbRuleEngine(true);
    actualTenantProfileEntity.setName("Name");
    JsonNode profileData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTenantProfileEntity.setProfileData(profileData);
    String actualToStringResult = actualTenantProfileEntity.toString();
    String actualDescription = actualTenantProfileEntity.getDescription();
    String actualName = actualTenantProfileEntity.getName();
    JsonNode actualProfileData = actualTenantProfileEntity.getProfileData();
    boolean actualIsDefaultResult = actualTenantProfileEntity.isDefault();
    boolean actualIsIsolatedTbRuleEngineResult = actualTenantProfileEntity.isIsolatedTbRuleEngine();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "TenantProfileEntity(name=Name, description=The characteristics of someone or something, isDefault=true,"
            + " isolatedTbRuleEngine=true, profileData={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualTenantProfileEntity.getId());
    assertNull(actualTenantProfileEntity.getUuid());
    assertEquals(0L, actualTenantProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertTrue(actualIsIsolatedTbRuleEngineResult);
    assertSame(profileData, actualProfileData);
  }
}
