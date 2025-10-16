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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class VersionedEntityInfoDiffblueTest {
  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and {@link VersionedEntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    assertEquals(versionedEntityInfo.hashCode(), versionedEntityInfo2.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and {@link VersionedEntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    assertEquals(versionedEntityInfo.hashCode(), versionedEntityInfo2.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and {@link VersionedEntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo(TenantId.SYS_TENANT_ID));
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), null);
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionedEntityInfo.equals(Object)",
    "int VersionedEntityInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), "Different type to VersionedEntityInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo()}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VersionedEntityInfo.<init>()",
    "void VersionedEntityInfo.<init>(EntityId)",
    "EntityId VersionedEntityInfo.getExternalId()",
    "void VersionedEntityInfo.setExternalId(EntityId)",
    "String VersionedEntityInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo();
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert
    assertEquals(
        "VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo(EntityId)}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VersionedEntityInfo.<init>()",
    "void VersionedEntityInfo.<init>(EntityId)",
    "EntityId VersionedEntityInfo.getExternalId()",
    "void VersionedEntityInfo.setExternalId(EntityId)",
    "String VersionedEntityInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert
    assertEquals(
        "VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }
}
