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

class TbCheckMessageNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbCheckMessageNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCheckMessageNodeConfiguration TbCheckMessageNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbCheckMessageNodeConfiguration actualDefaultConfigurationResult =
        new TbCheckMessageNodeConfiguration().defaultConfiguration();

    // Assert
    List<String> messageNames = actualDefaultConfigurationResult.getMessageNames();
    assertTrue(messageNames.isEmpty());
    assertTrue(actualDefaultConfigurationResult.isCheckAllKeys());
    assertSame(messageNames, actualDefaultConfigurationResult.getMetadataNames());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}, and {@link
   * TbCheckMessageNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckMessageNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckMessageNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration2 =
        new TbCheckMessageNodeConfiguration();

    // Act and Assert
    assertEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration2);
    assertEquals(
        tbCheckMessageNodeConfiguration.hashCode(), tbCheckMessageNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}, and {@link
   * TbCheckMessageNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckMessageNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckMessageNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration.setMessageNames(new ArrayList<>());

    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration2 =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration2.setMessageNames(new ArrayList<>());

    // Act and Assert
    assertEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration2);
    assertEquals(
        tbCheckMessageNodeConfiguration.hashCode(), tbCheckMessageNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}, and {@link
   * TbCheckMessageNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckMessageNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckMessageNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration.setMetadataNames(new ArrayList<>());

    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration2 =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration2.setMetadataNames(new ArrayList<>());

    // Act and Assert
    assertEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration2);
    assertEquals(
        tbCheckMessageNodeConfiguration.hashCode(), tbCheckMessageNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}, and {@link
   * TbCheckMessageNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCheckMessageNodeConfiguration#equals(Object)}
   *   <li>{@link TbCheckMessageNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();

    // Act and Assert
    assertEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration);
    int expectedHashCodeResult = tbCheckMessageNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCheckMessageNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckMessageNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration.setMessageNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckMessageNodeConfiguration, new TbCheckMessageNodeConfiguration());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration.setMetadataNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckMessageNodeConfiguration, new TbCheckMessageNodeConfiguration());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration.setCheckAllKeys(true);

    // Act and Assert
    assertNotEquals(tbCheckMessageNodeConfiguration, new TbCheckMessageNodeConfiguration());
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();

    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration2 =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration2.setMessageNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();

    TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration2 =
        new TbCheckMessageNodeConfiguration();
    tbCheckMessageNodeConfiguration2.setMetadataNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbCheckMessageNodeConfiguration, tbCheckMessageNodeConfiguration2);
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCheckMessageNodeConfiguration(), null);
  }

  /**
   * Test {@link TbCheckMessageNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCheckMessageNodeConfiguration.equals(Object)",
    "int TbCheckMessageNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCheckMessageNodeConfiguration(), "Different type to TbCheckMessageNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCheckMessageNodeConfiguration}
   *   <li>{@link TbCheckMessageNodeConfiguration#setCheckAllKeys(boolean)}
   *   <li>{@link TbCheckMessageNodeConfiguration#setMessageNames(List)}
   *   <li>{@link TbCheckMessageNodeConfiguration#setMetadataNames(List)}
   *   <li>{@link TbCheckMessageNodeConfiguration#toString()}
   *   <li>{@link TbCheckMessageNodeConfiguration#getMessageNames()}
   *   <li>{@link TbCheckMessageNodeConfiguration#getMetadataNames()}
   *   <li>{@link TbCheckMessageNodeConfiguration#isCheckAllKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCheckMessageNodeConfiguration.<init>()",
    "List TbCheckMessageNodeConfiguration.getMessageNames()",
    "List TbCheckMessageNodeConfiguration.getMetadataNames()",
    "boolean TbCheckMessageNodeConfiguration.isCheckAllKeys()",
    "void TbCheckMessageNodeConfiguration.setCheckAllKeys(boolean)",
    "void TbCheckMessageNodeConfiguration.setMessageNames(List)",
    "void TbCheckMessageNodeConfiguration.setMetadataNames(List)",
    "String TbCheckMessageNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCheckMessageNodeConfiguration actualTbCheckMessageNodeConfiguration =
        new TbCheckMessageNodeConfiguration();
    actualTbCheckMessageNodeConfiguration.setCheckAllKeys(true);
    ArrayList<String> messageNames = new ArrayList<>();
    actualTbCheckMessageNodeConfiguration.setMessageNames(messageNames);
    ArrayList<String> metadataNames = new ArrayList<>();
    actualTbCheckMessageNodeConfiguration.setMetadataNames(metadataNames);
    String actualToStringResult = actualTbCheckMessageNodeConfiguration.toString();
    List<String> actualMessageNames = actualTbCheckMessageNodeConfiguration.getMessageNames();
    List<String> actualMetadataNames = actualTbCheckMessageNodeConfiguration.getMetadataNames();
    boolean actualIsCheckAllKeysResult = actualTbCheckMessageNodeConfiguration.isCheckAllKeys();

    // Assert
    assertEquals(
        "TbCheckMessageNodeConfiguration(messageNames=[], metadataNames=[], checkAllKeys=true)",
        actualToStringResult);
    assertTrue(actualMessageNames.isEmpty());
    assertTrue(actualMetadataNames.isEmpty());
    assertTrue(actualIsCheckAllKeysResult);
    assertSame(messageNames, actualMessageNames);
    assertSame(metadataNames, actualMetadataNames);
  }
}
