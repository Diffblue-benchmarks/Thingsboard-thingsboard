package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityTypeVersionCreateConfigDiffblueTest {
  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}, and
   * {@link EntityTypeVersionCreateConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionCreateConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
    int expectedHashCodeResult = entityTypeVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionCreateConfig2.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}, and
   * {@link EntityTypeVersionCreateConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionCreateConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig);
    int expectedHashCodeResult = entityTypeVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionCreateConfig.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(false);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(entityIds);
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(false);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(null);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.OVERWRITE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, null);
  }

  /**
   * Test {@link EntityTypeVersionCreateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, "Different type to EntityTypeVersionCreateConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityTypeVersionCreateConfig}
   *   <li>{@link EntityTypeVersionCreateConfig#setAllEntities(boolean)}
   *   <li>{@link EntityTypeVersionCreateConfig#setEntityIds(List)}
   *   <li>{@link EntityTypeVersionCreateConfig#setSyncStrategy(SyncStrategy)}
   *   <li>{@link EntityTypeVersionCreateConfig#toString()}
   *   <li>{@link EntityTypeVersionCreateConfig#getEntityIds()}
   *   <li>{@link EntityTypeVersionCreateConfig#getSyncStrategy()}
   *   <li>{@link EntityTypeVersionCreateConfig#isAllEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionCreateConfig actualEntityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    actualEntityTypeVersionCreateConfig.setAllEntities(true);
    ArrayList<UUID> entityIds = new ArrayList<>();
    actualEntityTypeVersionCreateConfig.setEntityIds(entityIds);
    actualEntityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);
    String actualToStringResult = actualEntityTypeVersionCreateConfig.toString();
    List<UUID> actualEntityIds = actualEntityTypeVersionCreateConfig.getEntityIds();
    SyncStrategy actualSyncStrategy = actualEntityTypeVersionCreateConfig.getSyncStrategy();
    boolean actualIsAllEntitiesResult = actualEntityTypeVersionCreateConfig.isAllEntities();

    // Assert that nothing has changed
    assertEquals("EntityTypeVersionCreateConfig(syncStrategy=MERGE, entityIds=[], allEntities=true)",
        actualToStringResult);
    assertEquals(SyncStrategy.MERGE, actualSyncStrategy);
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveAttributes());
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveCredentials());
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveRelations());
    assertTrue(actualEntityIds.isEmpty());
    assertTrue(actualIsAllEntitiesResult);
    assertSame(entityIds, actualEntityIds);
  }
}
