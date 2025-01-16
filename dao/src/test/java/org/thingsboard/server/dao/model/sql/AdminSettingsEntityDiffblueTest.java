package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AdminSettingsEntityDiffblueTest {
  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and
   * {@link AdminSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(adminSettingsEntity, adminSettingsEntity2);
    int expectedHashCodeResult = adminSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and
   * {@link AdminSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(null);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(null);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(adminSettingsEntity, adminSettingsEntity2);
    int expectedHashCodeResult = adminSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and
   * {@link AdminSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey(null);
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey(null);
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(adminSettingsEntity, adminSettingsEntity2);
    int expectedHashCodeResult = adminSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and
   * {@link AdminSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(adminSettingsEntity, adminSettingsEntity);
    int expectedHashCodeResult = adminSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, adminSettingsEntity.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(3L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(MissingNode.getInstance());
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(null);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(mock(JsonNode.class));
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey(null);
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("org.thingsboard.server.dao.model.sql.AdminSettingsEntity");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(UUID.randomUUID());
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(null);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    AdminSettingsEntity adminSettingsEntity2 = new AdminSettingsEntity();
    adminSettingsEntity2.setCreatedTime(1L);
    adminSettingsEntity2.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity2.setKey("Key");
    adminSettingsEntity2.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, adminSettingsEntity2);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, null);
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(adminSettingsEntity, "Different type to AdminSettingsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#AdminSettingsEntity()}
   *   <li>{@link AdminSettingsEntity#setJsonValue(JsonNode)}
   *   <li>{@link AdminSettingsEntity#setKey(String)}
   *   <li>{@link AdminSettingsEntity#setTenantId(UUID)}
   *   <li>{@link AdminSettingsEntity#toString()}
   *   <li>{@link AdminSettingsEntity#getJsonValue()}
   *   <li>{@link AdminSettingsEntity#getKey()}
   *   <li>{@link AdminSettingsEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity();
    JsonNode jsonValue = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualAdminSettingsEntity.setJsonValue(jsonValue);
    actualAdminSettingsEntity.setKey("Key");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualAdminSettingsEntity.setTenantId(tenantId);
    String actualToStringResult = actualAdminSettingsEntity.toString();
    JsonNode actualJsonValue = actualAdminSettingsEntity.getJsonValue();
    String actualKey = actualAdminSettingsEntity.getKey();
    UUID actualTenantId = actualAdminSettingsEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("AdminSettingsEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, key=Key, jsonValue={\"isPublic"
        + "\":true})", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
    assertSame(jsonValue, actualJsonValue);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}.
   * <p>
   * Method under test:
   * {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}
   */
  @Test
  public void testNewAdminSettingsEntity() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity(adminSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAdminSettingsEntity.getTenantId().toString());
    assertNull(actualAdminSettingsEntity.getJsonValue());
    assertNull(actualAdminSettingsEntity.getKey());
    assertNull(actualAdminSettingsEntity.getId());
    assertNull(actualAdminSettingsEntity.getUuid());
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link AdminSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.</li>
   *   <li>Then return TenantId Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenAdminSettingsEntity_thenReturnTenantIdIdIsNull() {
    // Arrange and Act
    AdminSettings actualToDataResult = (new AdminSettingsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getJsonValue());
    assertNull(actualToDataResult.getKey());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AdminSettingsEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    UUID tenantId = UUID.randomUUID();
    adminSettingsEntity.setTenantId(tenantId);

    // Act
    AdminSettings actualToDataResult = adminSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getJsonValue());
    assertNull(actualToDataResult.getKey());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }
}
