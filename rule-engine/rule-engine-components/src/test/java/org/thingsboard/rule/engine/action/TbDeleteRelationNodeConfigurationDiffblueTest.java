package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbDeleteRelationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeleteRelationNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbDeleteRelationNodeConfiguration TbDeleteRelationNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbDeleteRelationNodeConfiguration actualDefaultConfigurationResult = (new TbDeleteRelationNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getEntityNamePattern());
    assertEquals("Contains", actualDefaultConfigurationResult.getRelationType());
    assertNull(actualDefaultConfigurationResult.getEntityTypePattern());
    assertNull(actualDefaultConfigurationResult.getEntityType());
    assertEquals(EntitySearchDirection.FROM, actualDefaultConfigurationResult.getDirection());
    assertFalse(actualDefaultConfigurationResult.isDeleteForSingleEntity());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}, and {@link TbDeleteRelationNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration = new TbDeleteRelationNodeConfiguration();
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration2 = new TbDeleteRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteRelationNodeConfiguration, tbDeleteRelationNodeConfiguration2);
    int expectedHashCodeResult = tbDeleteRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}, and {@link TbDeleteRelationNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration = new TbDeleteRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteRelationNodeConfiguration, tbDeleteRelationNodeConfiguration);
    int expectedHashCodeResult = tbDeleteRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteRelationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteRelationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration = new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);

    // Act and Assert
    assertNotEquals(tbDeleteRelationNodeConfiguration, new TbDeleteRelationNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration = new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    // Act and Assert
    assertNotEquals(tbDeleteRelationNodeConfiguration, new TbDeleteRelationNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteRelationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNodeConfiguration.equals(Object)",
      "int TbDeleteRelationNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteRelationNodeConfiguration(), "Different type to TbDeleteRelationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteRelationNodeConfiguration}
   *   <li>{@link TbDeleteRelationNodeConfiguration#setDeleteForSingleEntity(boolean)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#toString()}
   *   <li>{@link TbDeleteRelationNodeConfiguration#isDeleteForSingleEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeleteRelationNodeConfiguration.<init>()",
      "boolean TbDeleteRelationNodeConfiguration.isDeleteForSingleEntity()",
      "void TbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(boolean)",
      "String TbDeleteRelationNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteRelationNodeConfiguration actualTbDeleteRelationNodeConfiguration = new TbDeleteRelationNodeConfiguration();
    actualTbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);
    String actualToStringResult = actualTbDeleteRelationNodeConfiguration.toString();
    boolean actualIsDeleteForSingleEntityResult = actualTbDeleteRelationNodeConfiguration.isDeleteForSingleEntity();

    // Assert
    assertEquals("TbDeleteRelationNodeConfiguration(deleteForSingleEntity=true)", actualToStringResult);
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityNamePattern());
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityTypePattern());
    assertNull(actualTbDeleteRelationNodeConfiguration.getRelationType());
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityType());
    assertNull(actualTbDeleteRelationNodeConfiguration.getDirection());
    assertTrue(actualIsDeleteForSingleEntityResult);
  }
}
