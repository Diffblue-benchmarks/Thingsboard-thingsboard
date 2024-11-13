package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityTypeVersionLoadRequestDiffblueTest {
  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}, and
   * {@link EntityTypeVersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadRequest#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
    int expectedHashCodeResult = entityTypeVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadRequest2.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}, and
   * {@link EntityTypeVersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadRequest#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest);
    int expectedHashCodeResult = entityTypeVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadRequest.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.put(EntityType.TENANT, entityTypeVersionLoadConfig);

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));
    entityTypes.put(EntityType.TENANT, entityTypeVersionLoadConfig);

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(false);
    entityTypeVersionLoadRequest.setVersionId("42");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("1.0.2");

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, null);
  }

  /**
   * Test {@link EntityTypeVersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(new HashMap<>());
    entityTypeVersionLoadRequest.setRollbackOnError(true);
    entityTypeVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, "Different type to EntityTypeVersionLoadRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityTypeVersionLoadRequest}
   *   <li>{@link EntityTypeVersionLoadRequest#setEntityTypes(Map)}
   *   <li>{@link EntityTypeVersionLoadRequest#setRollbackOnError(boolean)}
   *   <li>{@link EntityTypeVersionLoadRequest#toString()}
   *   <li>{@link EntityTypeVersionLoadRequest#getEntityTypes()}
   *   <li>{@link EntityTypeVersionLoadRequest#getType()}
   *   <li>{@link EntityTypeVersionLoadRequest#isRollbackOnError()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionLoadRequest actualEntityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    actualEntityTypeVersionLoadRequest.setEntityTypes(entityTypes);
    actualEntityTypeVersionLoadRequest.setRollbackOnError(true);
    String actualToStringResult = actualEntityTypeVersionLoadRequest.toString();
    Map<EntityType, EntityTypeVersionLoadConfig> actualEntityTypes = actualEntityTypeVersionLoadRequest
        .getEntityTypes();
    VersionLoadRequestType actualType = actualEntityTypeVersionLoadRequest.getType();
    boolean actualIsRollbackOnErrorResult = actualEntityTypeVersionLoadRequest.isRollbackOnError();

    // Assert that nothing has changed
    assertEquals("EntityTypeVersionLoadRequest(entityTypes={}, rollbackOnError=true)", actualToStringResult);
    assertEquals(VersionLoadRequestType.ENTITY_TYPE, actualType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsRollbackOnErrorResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
