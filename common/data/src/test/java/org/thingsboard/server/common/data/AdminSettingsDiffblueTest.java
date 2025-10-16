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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AdminSettingsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSettings.<init>()",
    "void AdminSettings.<init>(AdminSettingsId)",
    "JsonNode AdminSettings.getJsonValue()",
    "String AdminSettings.getKey()",
    "TenantId AdminSettings.getTenantId()",
    "void AdminSettings.setJsonValue(JsonNode)",
    "void AdminSettings.setKey(String)",
    "void AdminSettings.setTenantId(TenantId)",
    "String AdminSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AdminSettings actualAdminSettings = new AdminSettings();
    DoubleNode jsonValue = DoubleNode.valueOf(10.0d);
    actualAdminSettings.setJsonValue(jsonValue);
    actualAdminSettings.setKey("Key");
    actualAdminSettings.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualAdminSettings.toString();
    JsonNode actualJsonValue = actualAdminSettings.getJsonValue();
    String actualKey = actualAdminSettings.getKey();
    TenantId actualTenantId = actualAdminSettings.getTenantId();

    // Assert
    assertEquals(
        "AdminSettings [key=Key, jsonValue=10.0, createdTime=0, id=null]", actualToStringResult);
    assertEquals("Key", actualKey);
    assertNull(actualAdminSettings.getId());
    assertEquals(0L, actualAdminSettings.getCreatedTime());
    assertSame(jsonValue, actualJsonValue);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSettings.<init>()",
    "void AdminSettings.<init>(AdminSettingsId)",
    "JsonNode AdminSettings.getJsonValue()",
    "String AdminSettings.getKey()",
    "TenantId AdminSettings.getTenantId()",
    "void AdminSettings.setJsonValue(JsonNode)",
    "void AdminSettings.setKey(String)",
    "void AdminSettings.setTenantId(TenantId)",
    "String AdminSettings.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    AdminSettingsId id = new AdminSettingsId(EntityId.NULL_UUID);

    // Act
    AdminSettings actualAdminSettings = new AdminSettings(id);
    DoubleNode jsonValue = DoubleNode.valueOf(10.0d);
    actualAdminSettings.setJsonValue(jsonValue);
    actualAdminSettings.setKey("Key");
    actualAdminSettings.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualAdminSettings.toString();
    JsonNode actualJsonValue = actualAdminSettings.getJsonValue();
    String actualKey = actualAdminSettings.getKey();
    TenantId actualTenantId = actualAdminSettings.getTenantId();

    // Assert
    assertEquals(
        "AdminSettings [key=Key, jsonValue=10.0, createdTime=0, id=13814000-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(0L, actualAdminSettings.getCreatedTime());
    assertSame(id, actualAdminSettings.getId());
    assertSame(jsonValue, actualJsonValue);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link AdminSettings#AdminSettings(AdminSettings)}.
   *
   * <p>Method under test: {@link AdminSettings#AdminSettings(AdminSettings)}
   */
  @Test
  @DisplayName("Test new AdminSettings(AdminSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettings.<init>(AdminSettings)"})
  void testNewAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act
    AdminSettings actualAdminSettings = new AdminSettings(adminSettings);

    // Assert
    assertEquals(adminSettings, actualAdminSettings);
  }

  /**
   * Test {@link AdminSettings#getCreatedTime()}.
   *
   * <p>Method under test: {@link AdminSettings#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AdminSettings.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new AdminSettings().getCreatedTime());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}, and {@link AdminSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    AdminSettings adminSettings2 = new AdminSettings();

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    assertEquals(adminSettings.hashCode(), adminSettings2.hashCode());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}, and {@link AdminSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setKey("Key");

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    assertEquals(adminSettings.hashCode(), adminSettings2.hashCode());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}, and {@link AdminSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(DoubleNode.valueOf(10.0d));

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setJsonValue(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(adminSettings, adminSettings2);
    assertEquals(adminSettings.hashCode(), adminSettings2.hashCode());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}, and {@link AdminSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSettings#equals(Object)}
   *   <li>{@link AdminSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act and Assert
    assertEquals(adminSettings, adminSettings);
    int expectedHashCodeResult = adminSettings.hashCode();
    assertEquals(expectedHashCodeResult, adminSettings.hashCode());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettingsId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(adminSettings, new AdminSettings());
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setKey("Key");

    // Act and Assert
    assertNotEquals(adminSettings, adminSettings2);
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    AdminSettings adminSettings2 = new AdminSettings();
    adminSettings2.setJsonValue(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(adminSettings, adminSettings2);
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdminSettings(), null);
  }

  /**
   * Test {@link AdminSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminSettings.equals(Object)", "int AdminSettings.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdminSettings(), "Different type to AdminSettings");
  }
}
