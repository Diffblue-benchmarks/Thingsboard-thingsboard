package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbCopyKeysNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbCopyKeysNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCopyKeysNodeConfiguration TbCopyKeysNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbCopyKeysNodeConfiguration actualDefaultConfigurationResult =
        new TbCopyKeysNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getCopyFrom());
    assertTrue(actualDefaultConfigurationResult.getKeys().isEmpty());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}, and {@link
   * TbCopyKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCopyKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbCopyKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration2 = new TbCopyKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration2);
    assertEquals(tbCopyKeysNodeConfiguration.hashCode(), tbCopyKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}, and {@link
   * TbCopyKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCopyKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbCopyKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration.setCopyFrom(TbMsgSource.DATA);

    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration2 = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration2.setCopyFrom(TbMsgSource.DATA);

    // Act and Assert
    assertEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration2);
    assertEquals(tbCopyKeysNodeConfiguration.hashCode(), tbCopyKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}, and {@link
   * TbCopyKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCopyKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbCopyKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration.setKeys(new HashSet<>());

    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration2 = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration2);
    assertEquals(tbCopyKeysNodeConfiguration.hashCode(), tbCopyKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}, and {@link
   * TbCopyKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCopyKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbCopyKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration);
    int expectedHashCodeResult = tbCopyKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCopyKeysNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCopyKeysNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration.setCopyFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbCopyKeysNodeConfiguration, new TbCopyKeysNodeConfiguration());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbCopyKeysNodeConfiguration, new TbCopyKeysNodeConfiguration());
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();

    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration2 = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration2.setCopyFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration = new TbCopyKeysNodeConfiguration();

    TbCopyKeysNodeConfiguration tbCopyKeysNodeConfiguration2 = new TbCopyKeysNodeConfiguration();
    tbCopyKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbCopyKeysNodeConfiguration, tbCopyKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCopyKeysNodeConfiguration(), null);
  }

  /**
   * Test {@link TbCopyKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCopyKeysNodeConfiguration.equals(Object)",
    "int TbCopyKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCopyKeysNodeConfiguration(), "Different type to TbCopyKeysNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbCopyKeysNodeConfiguration}
   *   <li>{@link TbCopyKeysNodeConfiguration#setCopyFrom(TbMsgSource)}
   *   <li>{@link TbCopyKeysNodeConfiguration#setKeys(Set)}
   *   <li>{@link TbCopyKeysNodeConfiguration#toString()}
   *   <li>{@link TbCopyKeysNodeConfiguration#getCopyFrom()}
   *   <li>{@link TbCopyKeysNodeConfiguration#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCopyKeysNodeConfiguration.<init>()",
    "TbMsgSource TbCopyKeysNodeConfiguration.getCopyFrom()",
    "Set TbCopyKeysNodeConfiguration.getKeys()",
    "void TbCopyKeysNodeConfiguration.setCopyFrom(TbMsgSource)",
    "void TbCopyKeysNodeConfiguration.setKeys(Set)",
    "String TbCopyKeysNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCopyKeysNodeConfiguration actualTbCopyKeysNodeConfiguration =
        new TbCopyKeysNodeConfiguration();
    actualTbCopyKeysNodeConfiguration.setCopyFrom(TbMsgSource.DATA);
    HashSet<String> keys = new HashSet<>();
    actualTbCopyKeysNodeConfiguration.setKeys(keys);
    String actualToStringResult = actualTbCopyKeysNodeConfiguration.toString();
    TbMsgSource actualCopyFrom = actualTbCopyKeysNodeConfiguration.getCopyFrom();
    Set<String> actualKeys = actualTbCopyKeysNodeConfiguration.getKeys();

    // Assert
    assertEquals("TbCopyKeysNodeConfiguration(copyFrom=DATA, keys=[])", actualToStringResult);
    assertEquals(TbMsgSource.DATA, actualCopyFrom);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
