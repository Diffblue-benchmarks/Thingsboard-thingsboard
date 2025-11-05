package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.event.LifecycleEvent;
import org.thingsboard.server.common.data.event.LifecycleEvent.LifecycleEventBuilder;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.dao.model.ModelConstants;

class LifecycleEventEntityDiffblueTest {
  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and {@link LifecycleEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity2);
    assertEquals(lifecycleEventEntity.hashCode(), lifecycleEventEntity2.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and {@link LifecycleEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError(null);
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError(null);
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity2);
    assertEquals(lifecycleEventEntity.hashCode(), lifecycleEventEntity2.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and {@link LifecycleEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType(null);
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType(null);
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity2);
    assertEquals(lifecycleEventEntity.hashCode(), lifecycleEventEntity2.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}, and {@link LifecycleEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LifecycleEventEntity#equals(Object)}
   *   <li>{@link LifecycleEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(lifecycleEventEntity, lifecycleEventEntity);
    int expectedHashCodeResult = lifecycleEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, lifecycleEventEntity.hashCode());
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("42");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError(null);
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("42");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType(null);
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(false);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    LifecycleEventEntity lifecycleEventEntity2 = new LifecycleEventEntity();
    lifecycleEventEntity2.setCreatedTime(1L);
    lifecycleEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setError("An error occurred");
    lifecycleEventEntity2.setEventType("Event Type");
    lifecycleEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setServiceId("42");
    lifecycleEventEntity2.setSuccess(true);
    lifecycleEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity2.setTs(1L);
    lifecycleEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, lifecycleEventEntity2);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, null);
  }

  /**
   * Test {@link LifecycleEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LifecycleEventEntity.equals(Object)",
    "int LifecycleEventEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(lifecycleEventEntity, "Different type to LifecycleEventEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LifecycleEventEntity#LifecycleEventEntity()}
   *   <li>{@link LifecycleEventEntity#setError(String)}
   *   <li>{@link LifecycleEventEntity#setEventType(String)}
   *   <li>{@link LifecycleEventEntity#setSuccess(boolean)}
   *   <li>{@link LifecycleEventEntity#toString()}
   *   <li>{@link LifecycleEventEntity#getError()}
   *   <li>{@link LifecycleEventEntity#getEventType()}
   *   <li>{@link LifecycleEventEntity#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventEntity.<init>()",
    "String LifecycleEventEntity.getError()",
    "String LifecycleEventEntity.getEventType()",
    "boolean LifecycleEventEntity.isSuccess()",
    "void LifecycleEventEntity.setError(String)",
    "void LifecycleEventEntity.setEventType(String)",
    "void LifecycleEventEntity.setSuccess(boolean)",
    "String LifecycleEventEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity();
    actualLifecycleEventEntity.setError("An error occurred");
    actualLifecycleEventEntity.setEventType("Event Type");
    actualLifecycleEventEntity.setSuccess(true);
    String actualToStringResult = actualLifecycleEventEntity.toString();
    String actualError = actualLifecycleEventEntity.getError();
    String actualEventType = actualLifecycleEventEntity.getEventType();
    boolean actualIsSuccessResult = actualLifecycleEventEntity.isSuccess();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Event Type", actualEventType);
    assertEquals(
        "LifecycleEventEntity(eventType=Event Type, success=true, error=An error occurred)",
        actualToStringResult);
    assertNull(actualLifecycleEventEntity.getServiceId());
    assertNull(actualLifecycleEventEntity.getEntityId());
    assertNull(actualLifecycleEventEntity.getId());
    assertNull(actualLifecycleEventEntity.getTenantId());
    assertNull(actualLifecycleEventEntity.getUuid());
    assertEquals(0L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(0L, actualLifecycleEventEntity.getTs());
    assertTrue(actualIsSuccessResult);
  }

  /**
   * Test {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}.
   *
   * <p>Method under test: {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}
   */
  @Test
  @DisplayName("Test new LifecycleEventEntity(LifecycleEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LifecycleEventEntity.<init>(LifecycleEvent)"})
  void testNewLifecycleEventEntity() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifecycleEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    LifecycleEvent event =
        errorResult
            .id(id)
            .lcEventType("Lc Event Type")
            .serviceId("42")
            .success(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity(event);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualLifecycleEventEntity.getTenantId().toString());
    assertEquals("42", actualLifecycleEventEntity.getServiceId());
    UUID entityId2 = actualLifecycleEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID id2 = actualLifecycleEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualLifecycleEventEntity.getError());
    assertEquals("Lc Event Type", actualLifecycleEventEntity.getEventType());
    assertEquals(1L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(1L, actualLifecycleEventEntity.getTs());
    assertTrue(actualLifecycleEventEntity.isSuccess());
    assertSame(entityId, entityId2);
    assertSame(id, id2);
    assertSame(id, actualLifecycleEventEntity.getUuid());
  }

  /**
   * Test {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link LifecycleEvent#getCreatedTime()}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#LifecycleEventEntity(LifecycleEvent)}
   */
  @Test
  @DisplayName(
      "Test new LifecycleEventEntity(LifecycleEvent); given SYSTEM_TENANT; then calls getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LifecycleEventEntity.<init>(LifecycleEvent)"})
  void testNewLifecycleEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    LifecycleEvent event = mock(LifecycleEvent.class);
    when(event.isSuccess()).thenReturn(true);
    when(event.getServiceId()).thenReturn("42");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getLcEventType()).thenReturn("Lc Event Type");
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getEntityId()).thenReturn(fromStringResult);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getId()).thenReturn(new EventId(id));

    // Act
    LifecycleEventEntity actualLifecycleEventEntity = new LifecycleEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getError();
    verify(event).getLcEventType();
    verify(event).isSuccess();
    verify(event).getId();
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualLifecycleEventEntity.getTenantId().toString());
    assertEquals("42", actualLifecycleEventEntity.getServiceId());
    UUID entityId = actualLifecycleEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.toString());
    UUID id2 = actualLifecycleEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualLifecycleEventEntity.getError());
    assertEquals("Lc Event Type", actualLifecycleEventEntity.getEventType());
    assertEquals(1L, actualLifecycleEventEntity.getCreatedTime());
    assertEquals(1L, actualLifecycleEventEntity.getTs());
    assertTrue(actualLifecycleEventEntity.isSuccess());
    assertSame(fromStringResult, entityId);
    assertSame(id, id2);
    assertSame(id, actualLifecycleEventEntity.getUuid());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link LifecycleEventEntity#LifecycleEventEntity()}.
   *   <li>Then return ServiceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given LifecycleEventEntity(); then return ServiceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleEvent LifecycleEventEntity.toData()"})
  void testToData_givenLifecycleEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    LifecycleEvent actualToDataResult = new LifecycleEventEntity().toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getLcEventType());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isSuccess());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleEvent LifecycleEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    lifecycleEventEntity.setEntityId(entityId);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    UUID tenantId = UUID.randomUUID();
    lifecycleEventEntity.setTenantId(tenantId);
    lifecycleEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    lifecycleEventEntity.setUuid(id);

    // Act
    LifecycleEvent actualToDataResult = lifecycleEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Event Type", actualToDataResult.getLcEventType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isSuccess());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }

  /**
   * Test {@link LifecycleEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleEvent LifecycleEventEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    lifecycleEventEntity.setEntityId(entityId);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    lifecycleEventEntity.setUuid(id);

    // Act
    LifecycleEvent actualToDataResult = lifecycleEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        actualToDataResult.getTenantId().getId().toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Event Type", actualToDataResult.getLcEventType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isSuccess());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
