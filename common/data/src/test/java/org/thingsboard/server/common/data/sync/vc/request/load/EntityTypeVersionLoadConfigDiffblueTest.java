package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTypeVersionLoadConfigDiffblueTest {
  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}, and {@link EntityTypeVersionLoadConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
    int expectedHashCodeResult = entityTypeVersionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadConfig2.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}, and {@link EntityTypeVersionLoadConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig);
    int expectedHashCodeResult = entityTypeVersionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadConfig.hashCode());
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(false);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(false);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(false);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, null);
  }

  /**
   * Test {@link EntityTypeVersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityTypeVersionLoadConfig.equals(Object)",
      "int EntityTypeVersionLoadConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, "Different type to EntityTypeVersionLoadConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityTypeVersionLoadConfig}
   *   <li>{@link EntityTypeVersionLoadConfig#setFindExistingEntityByName(boolean)}
   *   <li>{@link EntityTypeVersionLoadConfig#setRemoveOtherEntities(boolean)}
   *   <li>{@link EntityTypeVersionLoadConfig#toString()}
   *   <li>{@link EntityTypeVersionLoadConfig#isFindExistingEntityByName()}
   *   <li>{@link EntityTypeVersionLoadConfig#isRemoveOtherEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityTypeVersionLoadConfig.<init>()",
      "boolean EntityTypeVersionLoadConfig.isFindExistingEntityByName()",
      "boolean EntityTypeVersionLoadConfig.isRemoveOtherEntities()",
      "void EntityTypeVersionLoadConfig.setFindExistingEntityByName(boolean)",
      "void EntityTypeVersionLoadConfig.setRemoveOtherEntities(boolean)",
      "String EntityTypeVersionLoadConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionLoadConfig actualEntityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    actualEntityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    actualEntityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    String actualToStringResult = actualEntityTypeVersionLoadConfig.toString();
    boolean actualIsFindExistingEntityByNameResult = actualEntityTypeVersionLoadConfig.isFindExistingEntityByName();
    boolean actualIsRemoveOtherEntitiesResult = actualEntityTypeVersionLoadConfig.isRemoveOtherEntities();

    // Assert
    assertEquals("EntityTypeVersionLoadConfig(removeOtherEntities=true, findExistingEntityByName=true)",
        actualToStringResult);
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadAttributes());
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadCredentials());
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadRelations());
    assertTrue(actualIsFindExistingEntityByNameResult);
    assertTrue(actualIsRemoveOtherEntitiesResult);
  }
}
