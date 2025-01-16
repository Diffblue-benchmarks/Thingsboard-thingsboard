package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbGetOriginatorFieldsConfigurationDiffblueTest {
  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetOriginatorFieldsConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testDefaultConfiguration_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.computeIfPresent("foo", mock(BiFunction.class));

    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();
    tbGetOriginatorFieldsConfiguration.setDataMapping(dataMapping);

    // Act
    TbGetOriginatorFieldsConfiguration actualDefaultConfigurationResult = tbGetOriginatorFieldsConfiguration
        .defaultConfiguration();

    // Assert
    Map<String, String> dataMapping2 = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(2, dataMapping2.size());
    assertEquals("originatorName", dataMapping2.get("name"));
    assertEquals("originatorType", dataMapping2.get("type"));
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
    assertFalse(actualDefaultConfigurationResult.isIgnoreNullStrings());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link TbGetOriginatorFieldsConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetOriginatorFieldsConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given TbGetOriginatorFieldsConfiguration (default constructor)")
  void testDefaultConfiguration_givenTbGetOriginatorFieldsConfiguration() {
    // Arrange and Act
    TbGetOriginatorFieldsConfiguration actualDefaultConfigurationResult = (new TbGetOriginatorFieldsConfiguration())
        .defaultConfiguration();

    // Assert
    Map<String, String> dataMapping = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(2, dataMapping.size());
    assertEquals("originatorName", dataMapping.get("name"));
    assertEquals("originatorType", dataMapping.get("type"));
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
    assertFalse(actualDefaultConfigurationResult.isIgnoreNullStrings());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}, and
   * {@link TbGetOriginatorFieldsConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   *   <li>{@link TbGetOriginatorFieldsConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();
    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration2 = new TbGetOriginatorFieldsConfiguration();

    // Act and Assert
    assertEquals(tbGetOriginatorFieldsConfiguration, tbGetOriginatorFieldsConfiguration2);
    int expectedHashCodeResult = tbGetOriginatorFieldsConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetOriginatorFieldsConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}, and
   * {@link TbGetOriginatorFieldsConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   *   <li>{@link TbGetOriginatorFieldsConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();

    // Act and Assert
    assertEquals(tbGetOriginatorFieldsConfiguration, tbGetOriginatorFieldsConfiguration);
    int expectedHashCodeResult = tbGetOriginatorFieldsConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetOriginatorFieldsConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetOriginatorFieldsConfiguration(), 1);
    assertNotEquals(new TbGetOriginatorFieldsConfiguration(), mock(TbGetEntityDataNodeConfiguration.class));
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();
    tbGetOriginatorFieldsConfiguration.setIgnoreNullStrings(true);

    // Act and Assert
    assertNotEquals(tbGetOriginatorFieldsConfiguration, new TbGetOriginatorFieldsConfiguration());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetOriginatorFieldsConfiguration tbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();
    tbGetOriginatorFieldsConfiguration.setDataMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbGetOriginatorFieldsConfiguration, new TbGetOriginatorFieldsConfiguration());
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetOriginatorFieldsConfiguration(), null);
  }

  /**
   * Test {@link TbGetOriginatorFieldsConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetOriginatorFieldsConfiguration(), "Different type to TbGetOriginatorFieldsConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbGetOriginatorFieldsConfiguration}
   *   <li>{@link TbGetOriginatorFieldsConfiguration#setIgnoreNullStrings(boolean)}
   *   <li>{@link TbGetOriginatorFieldsConfiguration#toString()}
   *   <li>{@link TbGetOriginatorFieldsConfiguration#isIgnoreNullStrings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetOriginatorFieldsConfiguration actualTbGetOriginatorFieldsConfiguration = new TbGetOriginatorFieldsConfiguration();
    actualTbGetOriginatorFieldsConfiguration.setIgnoreNullStrings(true);
    String actualToStringResult = actualTbGetOriginatorFieldsConfiguration.toString();

    // Assert that nothing has changed
    assertEquals("TbGetOriginatorFieldsConfiguration(ignoreNullStrings=true)", actualToStringResult);
    assertTrue(actualTbGetOriginatorFieldsConfiguration.isIgnoreNullStrings());
  }
}
