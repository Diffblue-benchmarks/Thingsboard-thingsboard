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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class VersionedEntityInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo.hashCode());
  }

  /**
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo());
  }

  /**
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo(TenantId.SYS_TENANT_ID));
  }

  /**
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(mock(EntityId.class));

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo());
  }

  /**
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), null);
  }

  /**
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), "Different type to VersionedEntityInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo()}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo();
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert that nothing has changed
    assertEquals("VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo(EntityId)}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert that nothing has changed
    assertEquals("VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }
}
