package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class ComplexVersionCreateRequestDiffblueTest {
  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}, and
   * {@link ComplexVersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComplexVersionCreateRequest#equals(Object)}
   *   <li>{@link ComplexVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
    int expectedHashCodeResult = complexVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, complexVersionCreateRequest2.hashCode());
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}, and
   * {@link ComplexVersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComplexVersionCreateRequest#equals(Object)}
   *   <li>{@link ComplexVersionCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest);
    int expectedHashCodeResult = complexVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, complexVersionCreateRequest.hashCode());
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("1.0.2");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.put(EntityType.TENANT, entityTypeVersionCreateConfig);

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(entityTypes);
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));
    entityTypes.put(EntityType.TENANT, entityTypeVersionCreateConfig);

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(entityTypes);
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(null);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.OVERWRITE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, null);
  }

  /**
   * Test {@link ComplexVersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexVersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, "Different type to ComplexVersionCreateRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ComplexVersionCreateRequest}
   *   <li>{@link ComplexVersionCreateRequest#setEntityTypes(Map)}
   *   <li>{@link ComplexVersionCreateRequest#setSyncStrategy(SyncStrategy)}
   *   <li>{@link ComplexVersionCreateRequest#toString()}
   *   <li>{@link ComplexVersionCreateRequest#getEntityTypes()}
   *   <li>{@link ComplexVersionCreateRequest#getSyncStrategy()}
   *   <li>{@link ComplexVersionCreateRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ComplexVersionCreateRequest actualComplexVersionCreateRequest = new ComplexVersionCreateRequest();
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    actualComplexVersionCreateRequest.setEntityTypes(entityTypes);
    actualComplexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    String actualToStringResult = actualComplexVersionCreateRequest.toString();
    Map<EntityType, EntityTypeVersionCreateConfig> actualEntityTypes = actualComplexVersionCreateRequest
        .getEntityTypes();
    SyncStrategy actualSyncStrategy = actualComplexVersionCreateRequest.getSyncStrategy();

    // Assert that nothing has changed
    assertEquals("ComplexVersionCreateRequest(syncStrategy=MERGE, entityTypes={})", actualToStringResult);
    assertEquals(SyncStrategy.MERGE, actualSyncStrategy);
    assertEquals(VersionCreateRequestType.COMPLEX, actualComplexVersionCreateRequest.getType());
    assertTrue(actualEntityTypes.isEmpty());
    assertSame(entityTypes, actualEntityTypes);
  }
}
