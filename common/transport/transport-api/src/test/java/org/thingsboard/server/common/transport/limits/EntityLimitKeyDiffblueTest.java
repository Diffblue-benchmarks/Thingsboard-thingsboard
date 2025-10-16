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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntityLimitKeyDiffblueTest {
  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    assertEquals(entityLimitKey.hashCode(), entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, null);
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(null, null);

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    assertEquals(entityLimitKey.hashCode(), entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(new TenantId(null), "Device Name");
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(new TenantId(null), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    assertEquals(entityLimitKey.hashCode(), entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name");

    // Act and Assert
    assertNotEquals(
        entityLimitKey, new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertNotEquals(
        entityLimitKey, new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, null);

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(null, "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(null, "org.thingsboard.server.common.transport.limits.EntityLimitKey");

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(null, "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), null);
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"),
        "Different type to EntityLimitKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#EntityLimitKey(TenantId, String)}
   *   <li>{@link EntityLimitKey#toString()}
   *   <li>{@link EntityLimitKey#getDeviceName()}
   *   <li>{@link EntityLimitKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityLimitKey.<init>(TenantId, String)",
    "String EntityLimitKey.getDeviceName()",
    "TenantId EntityLimitKey.getTenantId()",
    "String EntityLimitKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EntityLimitKey actualEntityLimitKey = new EntityLimitKey(tenantId, "Device Name");
    actualEntityLimitKey.toString();
    String actualDeviceName = actualEntityLimitKey.getDeviceName();

    // Assert
    assertEquals("Device Name", actualDeviceName);
    assertSame(tenantId, actualEntityLimitKey.getTenantId());
  }
}
