package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TbOriginatorTypeFilterNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbOriginatorTypeFilterNodeConfiguration TbOriginatorTypeFilterNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    List<EntityType> originatorTypes =
        new TbOriginatorTypeFilterNodeConfiguration().defaultConfiguration().getOriginatorTypes();
    assertEquals(1, originatorTypes.size());
    assertEquals(EntityType.DEVICE, originatorTypes.get(0));
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbOriginatorTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration2 =
        new TbOriginatorTypeFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbOriginatorTypeFilterNodeConfiguration, tbOriginatorTypeFilterNodeConfiguration2);
    assertEquals(
        tbOriginatorTypeFilterNodeConfiguration.hashCode(),
        tbOriginatorTypeFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbOriginatorTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();
    tbOriginatorTypeFilterNodeConfiguration.setOriginatorTypes(new ArrayList<>());

    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration2 =
        new TbOriginatorTypeFilterNodeConfiguration();
    tbOriginatorTypeFilterNodeConfiguration2.setOriginatorTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(tbOriginatorTypeFilterNodeConfiguration, tbOriginatorTypeFilterNodeConfiguration2);
    assertEquals(
        tbOriginatorTypeFilterNodeConfiguration.hashCode(),
        tbOriginatorTypeFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}, and {@link
   * TbOriginatorTypeFilterNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbOriginatorTypeFilterNodeConfiguration, tbOriginatorTypeFilterNodeConfiguration);
    int expectedHashCodeResult = tbOriginatorTypeFilterNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbOriginatorTypeFilterNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbOriginatorTypeFilterNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();
    tbOriginatorTypeFilterNodeConfiguration.setOriginatorTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        tbOriginatorTypeFilterNodeConfiguration, new TbOriginatorTypeFilterNodeConfiguration());
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();

    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration2 =
        new TbOriginatorTypeFilterNodeConfiguration();
    tbOriginatorTypeFilterNodeConfiguration2.setOriginatorTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        tbOriginatorTypeFilterNodeConfiguration, tbOriginatorTypeFilterNodeConfiguration2);
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbOriginatorTypeFilterNodeConfiguration(), null);
  }

  /**
   * Test {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbOriginatorTypeFilterNodeConfiguration.equals(Object)",
    "int TbOriginatorTypeFilterNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbOriginatorTypeFilterNodeConfiguration(),
        "Different type to TbOriginatorTypeFilterNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbOriginatorTypeFilterNodeConfiguration}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#setOriginatorTypes(List)}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#toString()}
   *   <li>{@link TbOriginatorTypeFilterNodeConfiguration#getOriginatorTypes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbOriginatorTypeFilterNodeConfiguration.<init>()",
    "List TbOriginatorTypeFilterNodeConfiguration.getOriginatorTypes()",
    "void TbOriginatorTypeFilterNodeConfiguration.setOriginatorTypes(List)",
    "String TbOriginatorTypeFilterNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbOriginatorTypeFilterNodeConfiguration actualTbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();
    ArrayList<EntityType> originatorTypes = new ArrayList<>();
    actualTbOriginatorTypeFilterNodeConfiguration.setOriginatorTypes(originatorTypes);
    String actualToStringResult = actualTbOriginatorTypeFilterNodeConfiguration.toString();
    List<EntityType> actualOriginatorTypes =
        actualTbOriginatorTypeFilterNodeConfiguration.getOriginatorTypes();

    // Assert
    assertEquals(
        "TbOriginatorTypeFilterNodeConfiguration(originatorTypes=[])", actualToStringResult);
    assertTrue(actualOriginatorTypes.isEmpty());
    assertSame(originatorTypes, actualOriginatorTypes);
  }
}
