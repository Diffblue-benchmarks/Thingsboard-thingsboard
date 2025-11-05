package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbCreateRelationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbCreateRelationNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCreateRelationNodeConfiguration TbCreateRelationNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbCreateRelationNodeConfiguration actualDefaultConfigurationResult =
        new TbCreateRelationNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getEntityNamePattern());
    assertEquals("Contains", actualDefaultConfigurationResult.getRelationType());
    assertNull(actualDefaultConfigurationResult.getEntityTypePattern());
    assertNull(actualDefaultConfigurationResult.getEntityType());
    assertEquals(EntitySearchDirection.FROM, actualDefaultConfigurationResult.getDirection());
    assertFalse(actualDefaultConfigurationResult.isChangeOriginatorToRelatedEntity());
    assertFalse(actualDefaultConfigurationResult.isCreateEntityIfNotExists());
    assertFalse(actualDefaultConfigurationResult.isRemoveCurrentRelations());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCreateRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        new TbCreateRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
    assertEquals(
        tbCreateRelationNodeConfiguration.hashCode(),
        tbCreateRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}, and {@link
   * TbCreateRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCreateRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbCreateRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration);
    int expectedHashCodeResult = tbCreateRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCreateRelationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateRelationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setCreateEntityIfNotExists(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, new TbCreateRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setChangeOriginatorToRelatedEntity(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, new TbCreateRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setRemoveCurrentRelations(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, new TbCreateRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, new TbCreateRelationNodeConfiguration());
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateRelationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbCreateRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCreateRelationNodeConfiguration.equals(Object)",
    "int TbCreateRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCreateRelationNodeConfiguration(),
        "Different type to TbCreateRelationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCreateRelationNodeConfiguration}
   *   <li>{@link TbCreateRelationNodeConfiguration#setChangeOriginatorToRelatedEntity(boolean)}
   *   <li>{@link TbCreateRelationNodeConfiguration#setCreateEntityIfNotExists(boolean)}
   *   <li>{@link TbCreateRelationNodeConfiguration#setRemoveCurrentRelations(boolean)}
   *   <li>{@link TbCreateRelationNodeConfiguration#toString()}
   *   <li>{@link TbCreateRelationNodeConfiguration#isChangeOriginatorToRelatedEntity()}
   *   <li>{@link TbCreateRelationNodeConfiguration#isCreateEntityIfNotExists()}
   *   <li>{@link TbCreateRelationNodeConfiguration#isRemoveCurrentRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCreateRelationNodeConfiguration.<init>()",
    "boolean TbCreateRelationNodeConfiguration.isChangeOriginatorToRelatedEntity()",
    "boolean TbCreateRelationNodeConfiguration.isCreateEntityIfNotExists()",
    "boolean TbCreateRelationNodeConfiguration.isRemoveCurrentRelations()",
    "void TbCreateRelationNodeConfiguration.setChangeOriginatorToRelatedEntity(boolean)",
    "void TbCreateRelationNodeConfiguration.setCreateEntityIfNotExists(boolean)",
    "void TbCreateRelationNodeConfiguration.setRemoveCurrentRelations(boolean)",
    "String TbCreateRelationNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCreateRelationNodeConfiguration actualTbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    actualTbCreateRelationNodeConfiguration.setChangeOriginatorToRelatedEntity(true);
    actualTbCreateRelationNodeConfiguration.setCreateEntityIfNotExists(true);
    actualTbCreateRelationNodeConfiguration.setRemoveCurrentRelations(true);
    String actualToStringResult = actualTbCreateRelationNodeConfiguration.toString();
    boolean actualIsChangeOriginatorToRelatedEntityResult =
        actualTbCreateRelationNodeConfiguration.isChangeOriginatorToRelatedEntity();
    boolean actualIsCreateEntityIfNotExistsResult =
        actualTbCreateRelationNodeConfiguration.isCreateEntityIfNotExists();
    boolean actualIsRemoveCurrentRelationsResult =
        actualTbCreateRelationNodeConfiguration.isRemoveCurrentRelations();

    // Assert
    assertEquals(
        "TbCreateRelationNodeConfiguration(createEntityIfNotExists=true, changeOriginatorToRelatedEntity=true,"
            + " removeCurrentRelations=true)",
        actualToStringResult);
    assertNull(actualTbCreateRelationNodeConfiguration.getEntityNamePattern());
    assertNull(actualTbCreateRelationNodeConfiguration.getEntityTypePattern());
    assertNull(actualTbCreateRelationNodeConfiguration.getRelationType());
    assertNull(actualTbCreateRelationNodeConfiguration.getEntityType());
    assertNull(actualTbCreateRelationNodeConfiguration.getDirection());
    assertTrue(actualIsChangeOriginatorToRelatedEntityResult);
    assertTrue(actualIsCreateEntityIfNotExistsResult);
    assertTrue(actualIsRemoveCurrentRelationsResult);
  }
}
