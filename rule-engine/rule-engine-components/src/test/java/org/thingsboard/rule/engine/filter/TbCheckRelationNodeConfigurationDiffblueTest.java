package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCheckRelationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbCheckRelationNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCheckRelationNodeConfiguration TbCheckRelationNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbCheckRelationNodeConfiguration actualDefaultConfigurationResult =
        new TbCheckRelationNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("Contains", actualDefaultConfigurationResult.getRelationType());
    assertEquals("FROM", actualDefaultConfigurationResult.getDirection());
    assertNull(actualDefaultConfigurationResult.getEntityId());
    assertNull(actualDefaultConfigurationResult.getEntityType());
    assertTrue(actualDefaultConfigurationResult.isCheckForSingleEntity());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
    assertEquals(
        tbCheckRelationNodeConfiguration.hashCode(), tbCheckRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setDirection("Direction");

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setDirection("Direction");

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
    assertEquals(
        tbCheckRelationNodeConfiguration.hashCode(), tbCheckRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setEntityId("42");

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setEntityId("42");

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
    assertEquals(
        tbCheckRelationNodeConfiguration.hashCode(), tbCheckRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setEntityType("Entity Type");

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setEntityType("Entity Type");

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
    assertEquals(
        tbCheckRelationNodeConfiguration.hashCode(), tbCheckRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setRelationType("Relation Type");

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
    assertEquals(
        tbCheckRelationNodeConfiguration.hashCode(), tbCheckRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCheckRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration);
    int expectedHashCodeResult = tbCheckRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCheckRelationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckRelationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setDirection("Direction");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, new TbCheckRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setEntityId("42");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, new TbCheckRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setEntityType("Entity Type");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, new TbCheckRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, new TbCheckRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration.setCheckForSingleEntity(true);

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, new TbCheckRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setDirection("Direction");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setEntityId("42");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setEntityType("Entity Type");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration2 =
        new TbCheckRelationNodeConfiguration();
    tbCheckRelationNodeConfiguration2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(tbCheckRelationNodeConfiguration, tbCheckRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckRelationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbCheckRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckRelationNodeConfiguration.equals(Object)",
    "int TbCheckRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCheckRelationNodeConfiguration(),
        "Different type to TbCheckRelationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCheckRelationNodeConfiguration}
   *   <li>{@link TbCheckRelationNodeConfiguration#setCheckForSingleEntity(boolean)}
   *   <li>{@link TbCheckRelationNodeConfiguration#setDirection(String)}
   *   <li>{@link TbCheckRelationNodeConfiguration#setEntityId(String)}
   *   <li>{@link TbCheckRelationNodeConfiguration#setEntityType(String)}
   *   <li>{@link TbCheckRelationNodeConfiguration#setRelationType(String)}
   *   <li>{@link TbCheckRelationNodeConfiguration#toString()}
   *   <li>{@link TbCheckRelationNodeConfiguration#getDirection()}
   *   <li>{@link TbCheckRelationNodeConfiguration#getEntityId()}
   *   <li>{@link TbCheckRelationNodeConfiguration#getEntityType()}
   *   <li>{@link TbCheckRelationNodeConfiguration#getRelationType()}
   *   <li>{@link TbCheckRelationNodeConfiguration#isCheckForSingleEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCheckRelationNodeConfiguration.<init>()",
    "String TbCheckRelationNodeConfiguration.getDirection()",
    "String TbCheckRelationNodeConfiguration.getEntityId()",
    "String TbCheckRelationNodeConfiguration.getEntityType()",
    "String TbCheckRelationNodeConfiguration.getRelationType()",
    "boolean TbCheckRelationNodeConfiguration.isCheckForSingleEntity()",
    "void TbCheckRelationNodeConfiguration.setCheckForSingleEntity(boolean)",
    "void TbCheckRelationNodeConfiguration.setDirection(String)",
    "void TbCheckRelationNodeConfiguration.setEntityId(String)",
    "void TbCheckRelationNodeConfiguration.setEntityType(String)",
    "void TbCheckRelationNodeConfiguration.setRelationType(String)",
    "String TbCheckRelationNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCheckRelationNodeConfiguration actualTbCheckRelationNodeConfiguration =
        new TbCheckRelationNodeConfiguration();
    actualTbCheckRelationNodeConfiguration.setCheckForSingleEntity(true);
    actualTbCheckRelationNodeConfiguration.setDirection("Direction");
    actualTbCheckRelationNodeConfiguration.setEntityId("42");
    actualTbCheckRelationNodeConfiguration.setEntityType("Entity Type");
    actualTbCheckRelationNodeConfiguration.setRelationType("Relation Type");
    String actualToStringResult = actualTbCheckRelationNodeConfiguration.toString();
    String actualDirection = actualTbCheckRelationNodeConfiguration.getDirection();
    String actualEntityId = actualTbCheckRelationNodeConfiguration.getEntityId();
    String actualEntityType = actualTbCheckRelationNodeConfiguration.getEntityType();
    String actualRelationType = actualTbCheckRelationNodeConfiguration.getRelationType();

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("Direction", actualDirection);
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "TbCheckRelationNodeConfiguration(direction=Direction, entityId=42, entityType=Entity Type, relationType"
            + "=Relation Type, checkForSingleEntity=true)",
        actualToStringResult);
    assertTrue(actualTbCheckRelationNodeConfiguration.isCheckForSingleEntity());
  }
}
