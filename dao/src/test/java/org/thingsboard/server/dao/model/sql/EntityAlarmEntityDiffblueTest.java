package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.model.ModelConstants;

class EntityAlarmEntityDiffblueTest {
  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(null);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(null);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType(null);
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType(null);
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity);
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(null);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Entity Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType(null);
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(0L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(null);
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(null);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Alarm Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType(null);
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(null);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, null);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmEntity, "Different type to EntityAlarmEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#EntityAlarmEntity()}
   *   <li>{@link EntityAlarmEntity#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmEntity#setAlarmType(String)}
   *   <li>{@link EntityAlarmEntity#setCreatedTime(long)}
   *   <li>{@link EntityAlarmEntity#setCustomerId(UUID)}
   *   <li>{@link EntityAlarmEntity#setEntityId(UUID)}
   *   <li>{@link EntityAlarmEntity#setEntityType(String)}
   *   <li>{@link EntityAlarmEntity#setTenantId(UUID)}
   *   <li>{@link EntityAlarmEntity#toString()}
   *   <li>{@link EntityAlarmEntity#getAlarmId()}
   *   <li>{@link EntityAlarmEntity#getAlarmType()}
   *   <li>{@link EntityAlarmEntity#getCreatedTime()}
   *   <li>{@link EntityAlarmEntity#getCustomerId()}
   *   <li>{@link EntityAlarmEntity#getEntityId()}
   *   <li>{@link EntityAlarmEntity#getEntityType()}
   *   <li>{@link EntityAlarmEntity#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityAlarmEntity.<init>()",
    "UUID EntityAlarmEntity.getAlarmId()",
    "String EntityAlarmEntity.getAlarmType()",
    "long EntityAlarmEntity.getCreatedTime()",
    "UUID EntityAlarmEntity.getCustomerId()",
    "UUID EntityAlarmEntity.getEntityId()",
    "String EntityAlarmEntity.getEntityType()",
    "UUID EntityAlarmEntity.getTenantId()",
    "void EntityAlarmEntity.setAlarmId(UUID)",
    "void EntityAlarmEntity.setAlarmType(String)",
    "void EntityAlarmEntity.setCreatedTime(long)",
    "void EntityAlarmEntity.setCustomerId(UUID)",
    "void EntityAlarmEntity.setEntityId(UUID)",
    "void EntityAlarmEntity.setEntityType(String)",
    "void EntityAlarmEntity.setTenantId(UUID)",
    "String EntityAlarmEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarmEntity actualEntityAlarmEntity = new EntityAlarmEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmEntity.setAlarmId(alarmId);
    actualEntityAlarmEntity.setAlarmType("Alarm Type");
    actualEntityAlarmEntity.setCreatedTime(1L);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmEntity.setCustomerId(customerId);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmEntity.setEntityId(entityId);
    actualEntityAlarmEntity.setEntityType("Entity Type");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmEntity.setTenantId(tenantId);
    String actualToStringResult = actualEntityAlarmEntity.toString();
    UUID actualAlarmId = actualEntityAlarmEntity.getAlarmId();
    String actualAlarmType = actualEntityAlarmEntity.getAlarmType();
    long actualCreatedTime = actualEntityAlarmEntity.getCreatedTime();
    UUID actualCustomerId = actualEntityAlarmEntity.getCustomerId();
    UUID actualEntityId = actualEntityAlarmEntity.getEntityId();
    String actualEntityType = actualEntityAlarmEntity.getEntityType();
    UUID actualTenantId = actualEntityAlarmEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualAlarmId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualCustomerId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(
        "EntityAlarmEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, entityType=Entity Type, entityId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, alarmId=784f394c-42b6-435a-983c-b7beff2784f9, createdTime=1,"
            + " alarmType=Alarm Type, customerId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals(1L, actualCreatedTime);
    assertSame(alarmId, actualAlarmId);
    assertSame(customerId, actualCustomerId);
    assertSame(entityId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
