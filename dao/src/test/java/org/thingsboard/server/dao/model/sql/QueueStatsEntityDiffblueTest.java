package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.model.ModelConstants;

class QueueStatsEntityDiffblueTest {
  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and {@link QueueStatsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity2);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity2.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and {@link QueueStatsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName(null);
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName(null);
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity2);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity2.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and {@link QueueStatsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId(null);
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId(null);
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity2);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity2.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and {@link QueueStatsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(null);
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(null);
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity2);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity2.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and {@link QueueStatsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(3L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("42");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName(null);
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("Queue Name");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId(null);
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(null);
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, null);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueStatsEntity.equals(Object)", "int QueueStatsEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(queueStatsEntity, "Different type to QueueStatsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueStatsEntity#QueueStatsEntity()}
   *   <li>{@link QueueStatsEntity#setQueueName(String)}
   *   <li>{@link QueueStatsEntity#setServiceId(String)}
   *   <li>{@link QueueStatsEntity#setTenantId(UUID)}
   *   <li>{@link QueueStatsEntity#toString()}
   *   <li>{@link QueueStatsEntity#getQueueName()}
   *   <li>{@link QueueStatsEntity#getServiceId()}
   *   <li>{@link QueueStatsEntity#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void QueueStatsEntity.<init>()",
    "String QueueStatsEntity.getQueueName()",
    "String QueueStatsEntity.getServiceId()",
    "UUID QueueStatsEntity.getTenantId()",
    "void QueueStatsEntity.setQueueName(String)",
    "void QueueStatsEntity.setServiceId(String)",
    "void QueueStatsEntity.setTenantId(UUID)",
    "String QueueStatsEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity();
    actualQueueStatsEntity.setQueueName("Queue Name");
    actualQueueStatsEntity.setServiceId("42");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualQueueStatsEntity.setTenantId(tenantId);
    String actualToStringResult = actualQueueStatsEntity.toString();
    String actualQueueName = actualQueueStatsEntity.getQueueName();
    String actualServiceId = actualQueueStatsEntity.getServiceId();
    UUID actualTenantId = actualQueueStatsEntity.getTenantId();

    // Assert
    assertEquals("42", actualServiceId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Queue Name", actualQueueName);
    assertEquals(
        "QueueStatsEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, queueName=Queue Name, serviceId=42)",
        actualToStringResult);
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   *
   * <p>Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  @DisplayName("Test new QueueStatsEntity(QueueStats)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueStatsEntity.<init>(QueueStats)"})
  void testNewQueueStatsEntity() {
    // Arrange
    QueueStats queueStats = new QueueStats(null);
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualQueueStatsEntity.getTenantId().toString());
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  @DisplayName("Test new QueueStatsEntity(QueueStats); given one; then return CreatedTime is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueStatsEntity.<init>(QueueStats)"})
  void testNewQueueStatsEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setCreatedTime(1L);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertNull(actualQueueStatsEntity.getTenantId());
    assertEquals(1L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  @DisplayName(
      "Test new QueueStatsEntity(QueueStats); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueStatsEntity.<init>(QueueStats)"})
  void testNewQueueStatsEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    QueueStats queueStats = new QueueStats(new QueueStatsId(id));
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    UUID id2 = actualQueueStatsEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualQueueStatsEntity.getUuid());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   *
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  @DisplayName(
      "Test new QueueStatsEntity(QueueStats); when QueueStats(); then return TenantId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueStatsEntity.<init>(QueueStats)"})
  void testNewQueueStatsEntity_whenQueueStats_thenReturnTenantIdIsNull() {
    // Arrange and Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(new QueueStats());

    // Assert
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertNull(actualQueueStatsEntity.getTenantId());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#toData()}.
   *
   * <p>Method under test: {@link QueueStatsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QueueStats QueueStatsEntity.toData()"})
  void testToData() {
    // Arrange and Act
    QueueStats actualToDataResult = new QueueStatsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getQueueName());
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getUuidId());
    QueueStatsId id = actualToDataResult.getId();
    assertNull(id.getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
