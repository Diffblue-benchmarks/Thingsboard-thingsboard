package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbSaveToCustomCassandraTableNodeConfigurationDiffblueTest {
  /**
   * Test
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testDefaultConfiguration_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> fieldsMapping = new HashMap<>();
    fieldsMapping.computeIfPresent("foo", mock(BiFunction.class));

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(fieldsMapping);

    // Act
    TbSaveToCustomCassandraTableNodeConfiguration actualDefaultConfigurationResult = tbSaveToCustomCassandraTableNodeConfiguration
        .defaultConfiguration();

    // Assert
    Map<String, String> fieldsMapping2 = actualDefaultConfigurationResult.getFieldsMapping();
    assertEquals(1, fieldsMapping2.size());
    assertEquals("", fieldsMapping2.get(""));
    assertEquals("", actualDefaultConfigurationResult.getTableName());
  }

  /**
   * Test
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link TbSaveToCustomCassandraTableNodeConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given TbSaveToCustomCassandraTableNodeConfiguration (default constructor)")
  void testDefaultConfiguration_givenTbSaveToCustomCassandraTableNodeConfiguration() {
    // Arrange and Act
    TbSaveToCustomCassandraTableNodeConfiguration actualDefaultConfigurationResult = (new TbSaveToCustomCassandraTableNodeConfiguration())
        .defaultConfiguration();

    // Assert
    Map<String, String> fieldsMapping = actualDefaultConfigurationResult.getFieldsMapping();
    assertEquals(1, fieldsMapping.size());
    assertEquals("", fieldsMapping.get(""));
    assertEquals("", actualDefaultConfigurationResult.getTableName());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)},
   * and {@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 = new TbSaveToCustomCassandraTableNodeConfiguration();

    // Act and Assert
    assertEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)},
   * and {@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setTableName("Table Name");

    // Act and Assert
    assertEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)},
   * and {@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)},
   * and {@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();

    // Act and Assert
    assertEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSaveToCustomCassandraTableNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");

    // Act and Assert
    assertNotEquals(tbSaveToCustomCassandraTableNodeConfiguration, new TbSaveToCustomCassandraTableNodeConfiguration());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbSaveToCustomCassandraTableNodeConfiguration, new TbSaveToCustomCassandraTableNodeConfiguration());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setTableName("Table Name");

    // Act and Assert
    assertNotEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration2);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbSaveToCustomCassandraTableNodeConfiguration, tbSaveToCustomCassandraTableNodeConfiguration2);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashMap<String, String> fieldsMapping = new HashMap<>();
    fieldsMapping.computeIfPresent("foo", mock(BiFunction.class));

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(fieldsMapping);

    // Act and Assert
    assertNotEquals(tbSaveToCustomCassandraTableNodeConfiguration, new TbSaveToCustomCassandraTableNodeConfiguration());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSaveToCustomCassandraTableNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSaveToCustomCassandraTableNodeConfiguration(),
        "Different type to TbSaveToCustomCassandraTableNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbSaveToCustomCassandraTableNodeConfiguration}
   *   <li>
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#setFieldsMapping(Map)}
   *   <li>
   * {@link TbSaveToCustomCassandraTableNodeConfiguration#setTableName(String)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#toString()}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#getFieldsMapping()}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#getTableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSaveToCustomCassandraTableNodeConfiguration actualTbSaveToCustomCassandraTableNodeConfiguration = new TbSaveToCustomCassandraTableNodeConfiguration();
    HashMap<String, String> fieldsMapping = new HashMap<>();
    actualTbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(fieldsMapping);
    actualTbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");
    String actualToStringResult = actualTbSaveToCustomCassandraTableNodeConfiguration.toString();
    Map<String, String> actualFieldsMapping = actualTbSaveToCustomCassandraTableNodeConfiguration.getFieldsMapping();

    // Assert that nothing has changed
    assertEquals("Table Name", actualTbSaveToCustomCassandraTableNodeConfiguration.getTableName());
    assertEquals("TbSaveToCustomCassandraTableNodeConfiguration(tableName=Table Name, fieldsMapping={})",
        actualToStringResult);
    assertTrue(actualFieldsMapping.isEmpty());
    assertSame(fieldsMapping, actualFieldsMapping);
  }
}
