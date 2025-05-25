package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbDeleteKeysNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeleteKeysNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbDeleteKeysNodeConfiguration TbDeleteKeysNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbDeleteKeysNodeConfiguration actualDefaultConfigurationResult = (new TbDeleteKeysNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getDeleteFrom());
    assertTrue(actualDefaultConfigurationResult.getKeys().isEmpty());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link TbDeleteKeysNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 = new TbDeleteKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    int expectedHashCodeResult = tbDeleteKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link TbDeleteKeysNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    int expectedHashCodeResult = tbDeleteKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link TbDeleteKeysNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setKeys(new HashSet<>());

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    int expectedHashCodeResult = tbDeleteKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link TbDeleteKeysNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration);
    int expectedHashCodeResult = tbDeleteKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteKeysNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteKeysNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, new TbDeleteKeysNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, new TbDeleteKeysNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 = new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteKeysNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteKeysNodeConfiguration.equals(Object)",
      "int TbDeleteKeysNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteKeysNodeConfiguration(), "Different type to TbDeleteKeysNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNodeConfiguration}
   *   <li>{@link TbDeleteKeysNodeConfiguration#setDeleteFrom(TbMsgSource)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#setKeys(Set)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#toString()}
   *   <li>{@link TbDeleteKeysNodeConfiguration#getDeleteFrom()}
   *   <li>{@link TbDeleteKeysNodeConfiguration#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeleteKeysNodeConfiguration.<init>()",
      "TbMsgSource TbDeleteKeysNodeConfiguration.getDeleteFrom()", "Set TbDeleteKeysNodeConfiguration.getKeys()",
      "void TbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource)",
      "void TbDeleteKeysNodeConfiguration.setKeys(Set)", "String TbDeleteKeysNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNodeConfiguration actualTbDeleteKeysNodeConfiguration = new TbDeleteKeysNodeConfiguration();
    actualTbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);
    HashSet<String> keys = new HashSet<>();
    actualTbDeleteKeysNodeConfiguration.setKeys(keys);
    String actualToStringResult = actualTbDeleteKeysNodeConfiguration.toString();
    TbMsgSource actualDeleteFrom = actualTbDeleteKeysNodeConfiguration.getDeleteFrom();
    Set<String> actualKeys = actualTbDeleteKeysNodeConfiguration.getKeys();

    // Assert
    assertEquals("TbDeleteKeysNodeConfiguration(deleteFrom=DATA, keys=[])", actualToStringResult);
    assertEquals(TbMsgSource.DATA, actualDeleteFrom);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
