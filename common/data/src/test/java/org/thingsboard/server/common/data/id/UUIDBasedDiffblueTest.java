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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UUIDBasedDiffblueTest {
  /**
   * Test {@link UUIDBased#getId()}.
   * <p>
   * Method under test: {@link UUIDBased#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID UUIDBased.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", (new AdminSettingsId(EntityId.NULL_UUID)).getId().toString());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(EntityId.NULL_UUID);
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}, and {@link UUIDBased#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId.hashCode());
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, 1);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantId(UUID.randomUUID()), TenantId.SYS_TENANT_ID);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantId(null), TenantId.SYS_TENANT_ID);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, null);
  }

  /**
   * Test {@link UUIDBased#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UUIDBased.equals(Object)", "int UUIDBased.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, "Different type to UUIDBased");
  }

  /**
   * Test {@link UUIDBased#toString()}.
   * <p>
   * Method under test: {@link UUIDBased#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String UUIDBased.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", (new AdminSettingsId(EntityId.NULL_UUID)).toString());
  }
}
