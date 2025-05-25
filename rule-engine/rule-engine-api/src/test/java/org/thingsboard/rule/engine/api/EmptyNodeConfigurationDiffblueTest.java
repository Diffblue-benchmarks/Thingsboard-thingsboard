package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyNodeConfigurationDiffblueTest {
  /**
   * Test {@link EmptyNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link EmptyNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EmptyNodeConfiguration EmptyNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();

    // Act and Assert
    assertEquals(emptyNodeConfiguration, emptyNodeConfiguration.defaultConfiguration());
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}, and {@link EmptyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyNodeConfiguration#equals(Object)}
   *   <li>{@link EmptyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    EmptyNodeConfiguration emptyNodeConfiguration2 = new EmptyNodeConfiguration();

    // Act and Assert
    assertEquals(emptyNodeConfiguration, emptyNodeConfiguration2);
    int expectedHashCodeResult = emptyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, emptyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}, and {@link EmptyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyNodeConfiguration#equals(Object)}
   *   <li>{@link EmptyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();

    // Act and Assert
    assertEquals(emptyNodeConfiguration, emptyNodeConfiguration);
    int expectedHashCodeResult = emptyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, emptyNodeConfiguration.hashCode());
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyNodeConfiguration(), 1);
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    emptyNodeConfiguration.setVersion(1);

    // Act and Assert
    assertNotEquals(emptyNodeConfiguration, new EmptyNodeConfiguration());
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyNodeConfiguration(), null);
  }

  /**
   * Test {@link EmptyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmptyNodeConfiguration.equals(Object)", "int EmptyNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyNodeConfiguration(), "Different type to EmptyNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyNodeConfiguration}
   *   <li>{@link EmptyNodeConfiguration#setVersion(int)}
   *   <li>{@link EmptyNodeConfiguration#toString()}
   *   <li>{@link EmptyNodeConfiguration#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EmptyNodeConfiguration.<init>()", "int EmptyNodeConfiguration.getVersion()",
      "void EmptyNodeConfiguration.setVersion(int)", "String EmptyNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyNodeConfiguration actualEmptyNodeConfiguration = new EmptyNodeConfiguration();
    actualEmptyNodeConfiguration.setVersion(1);
    String actualToStringResult = actualEmptyNodeConfiguration.toString();

    // Assert
    assertEquals("EmptyNodeConfiguration(version=1)", actualToStringResult);
    assertEquals(1, actualEmptyNodeConfiguration.getVersion());
  }
}
