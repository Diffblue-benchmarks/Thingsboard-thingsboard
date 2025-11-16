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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityViewInfoDiffblueTest {
  /**
   * Test {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}.
   *
   * <ul>
   *   <li>Then return CustomerTitle is {@code Mr}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EntityViewInfo(EntityView, String, boolean); then return CustomerTitle is 'Mr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfo.<init>(EntityView, String, boolean)"})
  void testNewEntityViewInfo_thenReturnCustomerTitleIsMr() {
    // Arrange
    EntityViewInfo entityView = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act
    EntityViewInfo actualEntityViewInfo = new EntityViewInfo(entityView, "Mr", true);

    // Assert
    assertTrue(actualEntityViewInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Mr", actualEntityViewInfo.getCustomerTitle());
    assertNull(actualEntityViewInfo.getVersion());
    assertNull(actualEntityViewInfo.getName());
    assertNull(actualEntityViewInfo.getType());
    assertNull(actualEntityViewInfo.getUuidId());
    assertNull(actualEntityViewInfo.getCustomerId());
    assertNull(actualEntityViewInfo.getEntityId());
    assertNull(actualEntityViewInfo.getExternalId());
    assertNull(actualEntityViewInfo.getId());
    assertNull(actualEntityViewInfo.getTenantId());
    assertNull(actualEntityViewInfo.getKeys());
    assertEquals(0L, actualEntityViewInfo.getCreatedTime());
    assertEquals(0L, actualEntityViewInfo.getEndTimeMs());
    assertEquals(0L, actualEntityViewInfo.getStartTimeMs());
    assertEquals(0L, actualEntityViewInfo.createdTime);
    assertTrue(actualEntityViewInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.
   *   <li>Then return CustomerTitle is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EntityViewInfo(EntityView, String, boolean); when EntityView(); then return CustomerTitle is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewInfo.<init>(EntityView, String, boolean)"})
  void testNewEntityViewInfo_whenEntityView_thenReturnCustomerTitleIsDr() {
    // Arrange and Act
    EntityViewInfo actualEntityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);

    // Assert
    assertTrue(actualEntityViewInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("Dr", actualEntityViewInfo.getCustomerTitle());
    assertNull(actualEntityViewInfo.getVersion());
    assertNull(actualEntityViewInfo.getName());
    assertNull(actualEntityViewInfo.getType());
    assertNull(actualEntityViewInfo.getUuidId());
    assertNull(actualEntityViewInfo.getCustomerId());
    assertNull(actualEntityViewInfo.getEntityId());
    assertNull(actualEntityViewInfo.getExternalId());
    assertNull(actualEntityViewInfo.getId());
    assertNull(actualEntityViewInfo.getTenantId());
    assertNull(actualEntityViewInfo.getKeys());
    assertEquals(0L, actualEntityViewInfo.getCreatedTime());
    assertEquals(0L, actualEntityViewInfo.getEndTimeMs());
    assertEquals(0L, actualEntityViewInfo.getStartTimeMs());
    assertEquals(0L, actualEntityViewInfo.createdTime);
    assertTrue(actualEntityViewInfo.isCustomerIsPublic());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}, and {@link EntityViewInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    EntityViewInfo entityViewInfo2 = new EntityViewInfo();

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo2);
    assertEquals(entityViewInfo.hashCode(), entityViewInfo2.hashCode());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}, and {@link EntityViewInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);
    EntityViewInfo entityViewInfo2 = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo2);
    assertNotEquals(entityViewInfo.hashCode(), entityViewInfo2.hashCode());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}, and {@link EntityViewInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo);
    int expectedHashCodeResult = entityViewInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfo.hashCode());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    EntityViewInfo entityViewInfo2 = new EntityViewInfo();
    entityViewInfo2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfo(), null);
  }

  /**
   * Test {@link EntityViewInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewInfo.equals(Object)", "int EntityViewInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfo(), "Different type to EntityViewInfo");
  }
}
