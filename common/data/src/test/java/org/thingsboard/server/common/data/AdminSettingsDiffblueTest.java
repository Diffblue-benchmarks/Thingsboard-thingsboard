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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AdminSettingsDiffblueTest {
  /**
   * Method under test: {@link AdminSettings#getId()}
   */
  @Test
  void testGetId() {
    // Arrange
    AdminSettingsId adminSettingsId = mock(AdminSettingsId.class);
    when(adminSettingsId.getId()).thenReturn(EntityId.NULL_UUID);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(adminSettingsId);

    // Act
    adminSettings.getId().getId();

    // Assert
    verify(adminSettingsId).getId();
  }

  /**
   * Method under test: {@link AdminSettings#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AdminSettings()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    AdminSettings adminSettings2 = new AdminSettings();

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    int expectedHashCodeResult = adminSettings.hashCode();
    assertEquals(expectedHashCodeResult, adminSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setKey("Key");

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    int expectedHashCodeResult = adminSettings.hashCode();
    assertEquals(expectedHashCodeResult, adminSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(MissingNode.getInstance());

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    int expectedHashCodeResult = adminSettings.hashCode();
    assertEquals(expectedHashCodeResult, adminSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act and Assert
    assertEquals(adminSettings, adminSettings);
    int expectedHashCodeResult = adminSettings.hashCode();
    assertEquals(expectedHashCodeResult, adminSettings.hashCode());
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettingsId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AdminSettings(), mock(ApiUsageState.class));
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setKey("Key");

    // Act and Assert
    assertNotEquals(adminSettings, adminSettings2);
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setJsonValue(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(adminSettings, adminSettings2);
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdminSettings(), null);
  }

  /**
   * Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdminSettings(), "Different type to AdminSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#AdminSettings()}
   *   <li>{@link AdminSettings#setJsonValue(JsonNode)}
   *   <li>{@link AdminSettings#setKey(String)}
   *   <li>{@link AdminSettings#setTenantId(TenantId)}
   *   <li>{@link AdminSettings#toString()}
   *   <li>{@link AdminSettings#getJsonValue()}
   *   <li>{@link AdminSettings#getKey()}
   *   <li>{@link AdminSettings#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AdminSettings actualAdminSettings = new AdminSettings();
    MissingNode jsonValue = MissingNode.getInstance();
    actualAdminSettings.setJsonValue(jsonValue);
    actualAdminSettings.setKey("Key");
    actualAdminSettings.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualAdminSettings.toString();
    JsonNode actualJsonValue = actualAdminSettings.getJsonValue();
    String actualKey = actualAdminSettings.getKey();
    TenantId actualTenantId = actualAdminSettings.getTenantId();

    // Assert that nothing has changed
    assertEquals("AdminSettings [key=Key, jsonValue=, createdTime=0, id=null]", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(0L, actualAdminSettings.getCreatedTime());
    assertSame(jsonValue, actualJsonValue);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettings#AdminSettings(AdminSettingsId)}
   *   <li>{@link AdminSettings#setJsonValue(JsonNode)}
   *   <li>{@link AdminSettings#setKey(String)}
   *   <li>{@link AdminSettings#setTenantId(TenantId)}
   *   <li>{@link AdminSettings#toString()}
   *   <li>{@link AdminSettings#getJsonValue()}
   *   <li>{@link AdminSettings#getKey()}
   *   <li>{@link AdminSettings#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    AdminSettingsId id = new AdminSettingsId(EntityId.NULL_UUID);

    // Act
    AdminSettings actualAdminSettings = new AdminSettings(id);
    MissingNode jsonValue = MissingNode.getInstance();
    actualAdminSettings.setJsonValue(jsonValue);
    actualAdminSettings.setKey("Key");
    actualAdminSettings.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualAdminSettings.toString();
    JsonNode actualJsonValue = actualAdminSettings.getJsonValue();
    String actualKey = actualAdminSettings.getKey();
    TenantId actualTenantId = actualAdminSettings.getTenantId();

    // Assert that nothing has changed
    assertEquals("AdminSettings [key=Key, jsonValue=, createdTime=0, id=13814000-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(0L, actualAdminSettings.getCreatedTime());
    assertSame(id, actualAdminSettings.getId());
    assertSame(jsonValue, actualJsonValue);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link AdminSettings#AdminSettings(AdminSettings)}
   */
  @Test
  void testNewAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act and Assert
    assertEquals(adminSettings, new AdminSettings(adminSettings));
  }
}
