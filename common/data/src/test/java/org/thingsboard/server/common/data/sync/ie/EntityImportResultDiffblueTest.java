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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.ThrowingRunnable;

class EntityImportResultDiffblueTest {
  /**
   * Test {@link EntityImportResult#addSaveReferencesCallback(ThrowingRunnable)}.
   *
   * <ul>
   *   <li>Then calls {@link ThrowingRunnable#andThen(ThrowingRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#addSaveReferencesCallback(ThrowingRunnable)}
   */
  @Test
  @DisplayName(
      "Test addSaveReferencesCallback(ThrowingRunnable); then calls andThen(ThrowingRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityImportResult.addSaveReferencesCallback(ThrowingRunnable)"})
  void testAddSaveReferencesCallback_thenCallsAndThen() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);

    // Act
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Assert
    verify(saveReferencesCallback).andThen(isA(ThrowingRunnable.class));
  }

  /**
   * Test {@link EntityImportResult#addSendEventsCallback(ThrowingRunnable)}.
   *
   * <ul>
   *   <li>Then calls {@link ThrowingRunnable#andThen(ThrowingRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#addSendEventsCallback(ThrowingRunnable)}
   */
  @Test
  @DisplayName("Test addSendEventsCallback(ThrowingRunnable); then calls andThen(ThrowingRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityImportResult.addSendEventsCallback(ThrowingRunnable)"})
  void testAddSendEventsCallback_thenCallsAndThen() {
    // Arrange
    ThrowingRunnable sendEventsCallback = mock(ThrowingRunnable.class);
    when(sendEventsCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSendEventsCallback(sendEventsCallback);

    // Act
    entityImportResult.addSendEventsCallback(mock(ThrowingRunnable.class));

    // Assert
    verify(sendEventsCallback).andThen(isA(ThrowingRunnable.class));
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}, and {@link EntityImportResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityImportResult#equals(Object)}
   *   <li>{@link EntityImportResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();

    // Act and Assert
    assertEquals(entityImportResult, entityImportResult2);
    assertEquals(entityImportResult.hashCode(), entityImportResult2.hashCode());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}, and {@link EntityImportResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityImportResult#equals(Object)}
   *   <li>{@link EntityImportResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();

    // Act and Assert
    assertEquals(entityImportResult, entityImportResult);
    int expectedHashCodeResult = entityImportResult.hashCode();
    assertEquals(expectedHashCodeResult, entityImportResult.hashCode());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSavedEntity(new Customer());
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setOldEntity(new Customer());
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setEntityType(EntityType.TENANT);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setCreated(true);
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setUpdated(true);
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setUpdatedRelatedEntities(true);
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    // Act and Assert
    assertNotEquals(entityImportResult, new EntityImportResult<>());
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setSavedEntity(new Customer());

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setOldEntity(new Customer());

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setSavedEntity(new Customer());
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setSavedEntity(new Customer());

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setOldEntity(new Customer());
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setOldEntity(new Customer());

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    when(saveReferencesCallback.andThen(Mockito.<ThrowingRunnable>any()))
        .thenReturn(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();
    entityImportResult.setEntityType(EntityType.TENANT);
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    entityImportResult.addSaveReferencesCallback(mock(ThrowingRunnable.class));

    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult2 =
        new EntityImportResult<>();
    entityImportResult2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityImportResult, entityImportResult2);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();

    // Act and Assert
    assertNotEquals(entityImportResult, null);
  }

  /**
   * Test {@link EntityImportResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityImportResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityImportResult.equals(Object)",
    "int EntityImportResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();

    // Act and Assert
    assertNotEquals(entityImportResult, "Different type to EntityImportResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityImportResult#setCreated(boolean)}
   *   <li>{@link EntityImportResult#setEntityType(EntityType)}
   *   <li>{@link EntityImportResult#setOldEntity(ExportableEntity)}
   *   <li>{@link EntityImportResult#setSaveReferencesCallback(ThrowingRunnable)}
   *   <li>{@link EntityImportResult#setSavedEntity(ExportableEntity)}
   *   <li>{@link EntityImportResult#setSendEventsCallback(ThrowingRunnable)}
   *   <li>{@link EntityImportResult#setUpdated(boolean)}
   *   <li>{@link EntityImportResult#setUpdatedAllExternalIds(boolean)}
   *   <li>{@link EntityImportResult#setUpdatedRelatedEntities(boolean)}
   *   <li>{@link EntityImportResult#toString()}
   *   <li>{@link EntityImportResult#getEntityType()}
   *   <li>{@link EntityImportResult#getOldEntity()}
   *   <li>{@link EntityImportResult#getSaveReferencesCallback()}
   *   <li>{@link EntityImportResult#getSavedEntity()}
   *   <li>{@link EntityImportResult#getSendEventsCallback()}
   *   <li>{@link EntityImportResult#isCreated()}
   *   <li>{@link EntityImportResult#isUpdated()}
   *   <li>{@link EntityImportResult#isUpdatedAllExternalIds()}
   *   <li>{@link EntityImportResult#isUpdatedRelatedEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityType EntityImportResult.getEntityType()",
    "ExportableEntity EntityImportResult.getOldEntity()",
    "ThrowingRunnable EntityImportResult.getSaveReferencesCallback()",
    "ExportableEntity EntityImportResult.getSavedEntity()",
    "ThrowingRunnable EntityImportResult.getSendEventsCallback()",
    "boolean EntityImportResult.isCreated()",
    "boolean EntityImportResult.isUpdated()",
    "boolean EntityImportResult.isUpdatedAllExternalIds()",
    "boolean EntityImportResult.isUpdatedRelatedEntities()",
    "void EntityImportResult.setCreated(boolean)",
    "void EntityImportResult.setEntityType(EntityType)",
    "void EntityImportResult.setOldEntity(ExportableEntity)",
    "void EntityImportResult.setSaveReferencesCallback(ThrowingRunnable)",
    "void EntityImportResult.setSavedEntity(ExportableEntity)",
    "void EntityImportResult.setSendEventsCallback(ThrowingRunnable)",
    "void EntityImportResult.setUpdated(boolean)",
    "void EntityImportResult.setUpdatedAllExternalIds(boolean)",
    "void EntityImportResult.setUpdatedRelatedEntities(boolean)",
    "java.lang.String EntityImportResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityImportResult<ExportableEntity<? extends EntityId>> entityImportResult =
        new EntityImportResult<>();

    // Act
    entityImportResult.setCreated(true);
    entityImportResult.setEntityType(EntityType.TENANT);
    Customer customer = new Customer();
    entityImportResult.setOldEntity(customer);
    ThrowingRunnable saveReferencesCallback = mock(ThrowingRunnable.class);
    entityImportResult.setSaveReferencesCallback(saveReferencesCallback);
    Customer customer2 = new Customer();
    entityImportResult.setSavedEntity(customer2);
    ThrowingRunnable sendEventsCallback = mock(ThrowingRunnable.class);
    entityImportResult.setSendEventsCallback(sendEventsCallback);
    entityImportResult.setUpdated(true);
    entityImportResult.setUpdatedAllExternalIds(true);
    entityImportResult.setUpdatedRelatedEntities(true);
    entityImportResult.toString();
    EntityType actualEntityType = entityImportResult.getEntityType();
    ExportableEntity<? extends EntityId> actualOldEntity = entityImportResult.getOldEntity();
    ThrowingRunnable actualSaveReferencesCallback = entityImportResult.getSaveReferencesCallback();
    ExportableEntity<? extends EntityId> actualSavedEntity = entityImportResult.getSavedEntity();
    ThrowingRunnable actualSendEventsCallback = entityImportResult.getSendEventsCallback();
    boolean actualIsCreatedResult = entityImportResult.isCreated();
    boolean actualIsUpdatedResult = entityImportResult.isUpdated();
    boolean actualIsUpdatedAllExternalIdsResult = entityImportResult.isUpdatedAllExternalIds();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualIsCreatedResult);
    assertTrue(actualIsUpdatedResult);
    assertTrue(actualIsUpdatedAllExternalIdsResult);
    assertTrue(entityImportResult.isUpdatedRelatedEntities());
    assertSame(customer, actualOldEntity);
    assertSame(customer2, actualSavedEntity);
    assertSame(saveReferencesCallback, actualSaveReferencesCallback);
    assertSame(sendEventsCallback, actualSendEventsCallback);
  }

  /**
   * Test new {@link EntityImportResult} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntityImportResult}
   */
  @Test
  @DisplayName("Test new EntityImportResult (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityImportResult.<init>()"})
  void testNewEntityImportResult() {
    // Arrange and Act
    EntityImportResult<ExportableEntity<? extends EntityId>> actualEntityImportResult =
        new EntityImportResult<>();

    // Assert
    assertNull(actualEntityImportResult.getEntityType());
    assertNull(actualEntityImportResult.getOldEntity());
    assertNull(actualEntityImportResult.getSavedEntity());
    assertFalse(actualEntityImportResult.isCreated());
    assertFalse(actualEntityImportResult.isUpdated());
    assertFalse(actualEntityImportResult.isUpdatedRelatedEntities());
    assertTrue(actualEntityImportResult.isUpdatedAllExternalIds());
  }
}
