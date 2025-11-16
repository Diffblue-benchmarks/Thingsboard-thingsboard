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
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityInfoDiffblueTest {
  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");
    EntityInfo entityInfo2 = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    assertEquals(entityInfo.hashCode(), entityInfo2.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    DeviceProfileInfo deviceProfileInfo = mock(DeviceProfileInfo.class);
    when(deviceProfileInfo.getName()).thenReturn("Name");
    when(deviceProfileInfo.getId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(deviceProfileInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityInfo, deviceProfileInfo);
    assertNotEquals(entityInfo.hashCode(), deviceProfileInfo.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");

    DeviceProfileInfo deviceProfileInfo = mock(DeviceProfileInfo.class);
    when(deviceProfileInfo.getName()).thenReturn("Name");
    when(deviceProfileInfo.getId()).thenReturn(null);
    when(deviceProfileInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityInfo, deviceProfileInfo);
    assertNotEquals(entityInfo.hashCode(), deviceProfileInfo.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(new AlarmId(EntityId.NULL_UUID), "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, null);

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityInfo entityInfo =
        new EntityInfo(TenantId.SYS_TENANT_ID, "org.thingsboard.server.common.data.EntityInfo");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), null);
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInfo.equals(Object)", "int EntityInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), "Different type to EntityInfo");
  }

  /**
   * Test {@link EntityInfo#getId()}.
   *
   * <p>Method under test: {@link EntityInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityInfo.getId()"})
  void testGetId() {
    // Arrange and Act
    EntityId actualId = new EntityInfo(TenantId.SYS_TENANT_ID, "Name").getId();

    // Assert
    assertSame(((TenantId) actualId).SYS_TENANT_ID, actualId);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityInfo#EntityInfo(EntityId, String)}
   *   <li>{@link EntityInfo#toString()}
   *   <li>{@link EntityInfo#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityInfo.<init>(EntityId, String)",
    "String EntityInfo.getName()",
    "String EntityInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityInfo actualEntityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");
    String actualToStringResult = actualEntityInfo.toString();

    // Assert
    assertEquals(
        "EntityInfo(id=13814000-1dd2-11b2-8080-808080808080, name=Name)", actualToStringResult);
    assertEquals("Name", actualEntityInfo.getName());
    assertSame(TenantId.SYS_TENANT_ID, actualEntityInfo.getId());
  }
}
