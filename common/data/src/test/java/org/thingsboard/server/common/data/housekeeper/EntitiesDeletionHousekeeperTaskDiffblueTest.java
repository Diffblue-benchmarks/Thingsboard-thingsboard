package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link EntitiesDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link EntitiesDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link EntitiesDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitiesDeletionHousekeeperTask.equals(Object)",
      "int EntitiesDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), "Different type to EntitiesDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#setEntities(List)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#setEntityType(EntityType)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#toString()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#getEntities()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>()",
      "List EntitiesDeletionHousekeeperTask.getEntities()",
      "EntityType EntitiesDeletionHousekeeperTask.getEntityType()",
      "void EntitiesDeletionHousekeeperTask.setEntities(List)",
      "void EntitiesDeletionHousekeeperTask.setEntityType(EntityType)",
      "String EntitiesDeletionHousekeeperTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    ArrayList<UUID> entities = new ArrayList<>();
    actualEntitiesDeletionHousekeeperTask.setEntities(entities);
    actualEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntitiesDeletionHousekeeperTask.toString();
    List<UUID> actualEntities = actualEntitiesDeletionHousekeeperTask.getEntities();
    EntityType actualEntityType = actualEntitiesDeletionHousekeeperTask.getEntityType();

    // Assert
    assertEquals("EntitiesDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), entityType=TENANT, entities=[])", actualToStringResult);
    assertNull(actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertNull(actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertNull(actualEntitiesDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualEntitiesDeletionHousekeeperTask.getTs());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualEntities.isEmpty());
    assertSame(entities, actualEntities);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}.
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName("Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask() {
    // Arrange
    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, entities);

    // Assert
    assertEquals("tenants deletion ([784f394c-42b6-435a-983c-b7beff2784f9])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertSame(entities, actualEntitiesDeletionHousekeeperTask.getEntities());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}.
   * <ul>
   *   <li>Then return Description is {@code tenants deletion ([])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName("Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List); then return Description is 'tenants deletion ([])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask_thenReturnDescriptionIsTenantsDeletion() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        tenantId, EntityType.TENANT, new ArrayList<>());

    // Assert
    assertEquals("tenants deletion ([])", actualEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_ENTITIES, actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertTrue(actualEntitiesDeletionHousekeeperTask.getEntities().isEmpty());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}.
   * <ul>
   *   <li>Then return Entities size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName("Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List); then return Entities size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask_thenReturnEntitiesSizeIsTwo() {
    // Arrange
    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    entities.add(fromStringResult);

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, entities);

    // Assert
    List<UUID> entities2 = actualEntitiesDeletionHousekeeperTask.getEntities();
    assertEquals(2, entities2.size());
    UUID getResult = entities2.get(1);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    assertEquals("tenants deletion ([784f394c-42b6-435a-983c-b7beff2784f9, 784f394c-42b6-435a-983c-b7beff2784f9])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertSame(fromStringResult, getResult);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#getDescription()}.
   * <ul>
   *   <li>Then return {@code tenants deletion (null)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'tenants deletion (null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntitiesDeletionHousekeeperTask.getDescription()"})
  void testGetDescription_thenReturnTenantsDeletionNull() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals("tenants deletion (null)", entitiesDeletionHousekeeperTask.getDescription());
  }
}
