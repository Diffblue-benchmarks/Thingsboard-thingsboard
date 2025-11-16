/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AdminSettingsEntityDiffblueTest {
  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and {@link AdminSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
    assertEquals(adminSettingsEntity.hashCode(), adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and {@link AdminSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
    assertEquals(adminSettingsEntity.hashCode(), adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and {@link AdminSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
    assertEquals(adminSettingsEntity.hashCode(), adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and {@link AdminSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    adminSettingsEntity2.setTenantId(null);
    adminSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(adminSettingsEntity, adminSettingsEntity2);
    assertEquals(adminSettingsEntity.hashCode(), adminSettingsEntity2.hashCode());
  }

  /**
   * Test {@link AdminSettingsEntity#equals(Object)}, and {@link AdminSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettingsEntity#equals(Object)}
   *   <li>{@link AdminSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(DoubleNode.valueOf(10.0d));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsEntity.equals(Object)",
    "int AdminSettingsEntity.hashCode()"
  })
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSettingsEntity.<init>()",
    "JsonNode AdminSettingsEntity.getJsonValue()",
    "String AdminSettingsEntity.getKey()",
    "UUID AdminSettingsEntity.getTenantId()",
    "void AdminSettingsEntity.setJsonValue(JsonNode)",
    "void AdminSettingsEntity.setKey(String)",
    "void AdminSettingsEntity.setTenantId(UUID)",
    "String AdminSettingsEntity.toString()"
  })
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals(
        "AdminSettingsEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, key=Key, jsonValue={\"isPublic"
            + "\":true})",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertNull(actualAdminSettingsEntity.getId());
    assertNull(actualAdminSettingsEntity.getUuid());
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
    assertSame(jsonValue, actualJsonValue);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}.
   *
   * <p>Method under test: {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsEntity.<init>(AdminSettings)"})
  public void testNewAdminSettingsEntity() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(ModelConstants.NULL_UUID));
    adminSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity(adminSettings);

    // Assert
    UUID id = actualAdminSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAdminSettingsEntity.getTenantId().toString());
    assertNull(actualAdminSettingsEntity.getJsonValue());
    assertNull(actualAdminSettingsEntity.getKey());
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
    assertSame(id, actualAdminSettingsEntity.getUuid());
  }

  /**
   * Test {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsEntity.<init>(AdminSettings)"})
  public void testNewAdminSettingsEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setTenantId(ModelConstants.SYSTEM_TENANT);
    adminSettings.setCreatedTime(1L);

    // Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity(adminSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAdminSettingsEntity.getTenantId().toString());
    assertNull(actualAdminSettingsEntity.getJsonValue());
    assertNull(actualAdminSettingsEntity.getKey());
    assertNull(actualAdminSettingsEntity.getId());
    assertNull(actualAdminSettingsEntity.getUuid());
    assertEquals(1L, actualAdminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#AdminSettingsEntity(AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsEntity.<init>(AdminSettings)"})
  public void testNewAdminSettingsEntity_givenSystem_tenant_thenReturnIdIsNull() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity(adminSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAdminSettingsEntity.getTenantId().toString());
    assertNull(actualAdminSettingsEntity.getJsonValue());
    assertNull(actualAdminSettingsEntity.getKey());
    assertNull(actualAdminSettingsEntity.getId());
    assertNull(actualAdminSettingsEntity.getUuid());
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link AdminSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsEntity#AdminSettingsEntity()}.
   *   <li>Then return TenantId Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminSettingsEntity.toData()"})
  public void testToData_givenAdminSettingsEntity_thenReturnTenantIdIdIsNull() {
    // Arrange and Act
    AdminSettings actualToDataResult = new AdminSettingsEntity().toData();

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
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminSettingsEntity.toData()"})
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
