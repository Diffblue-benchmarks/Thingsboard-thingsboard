package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CassandraToSqlColumnData.class, String.class})
@ExtendWith(SpringExtension.class)
class CassandraToSqlColumnDataDiffblueTest {
  @Autowired
  private CassandraToSqlColumnData cassandraToSqlColumnData;

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}, and
   * {@link CassandraToSqlColumnData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumnData#equals(Object)}
   *   <li>{@link CassandraToSqlColumnData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("42");
    CassandraToSqlColumnData cassandraToSqlColumnData2 = new CassandraToSqlColumnData("42");

    // Act and Assert
    assertEquals(cassandraToSqlColumnData, cassandraToSqlColumnData2);
    int expectedHashCodeResult = cassandraToSqlColumnData.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlColumnData2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}, and
   * {@link CassandraToSqlColumnData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumnData#equals(Object)}
   *   <li>{@link CassandraToSqlColumnData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData(null);
    CassandraToSqlColumnData cassandraToSqlColumnData2 = new CassandraToSqlColumnData(null);

    // Act and Assert
    assertEquals(cassandraToSqlColumnData, cassandraToSqlColumnData2);
    int expectedHashCodeResult = cassandraToSqlColumnData.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlColumnData2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}, and
   * {@link CassandraToSqlColumnData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumnData#equals(Object)}
   *   <li>{@link CassandraToSqlColumnData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("42");

    // Act and Assert
    assertEquals(cassandraToSqlColumnData, cassandraToSqlColumnData);
    int expectedHashCodeResult = cassandraToSqlColumnData.hashCode();
    assertEquals(expectedHashCodeResult, cassandraToSqlColumnData.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("Value");

    // Act and Assert
    assertNotEquals(cassandraToSqlColumnData, new CassandraToSqlColumnData("42"));
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData(null);

    // Act and Assert
    assertNotEquals(cassandraToSqlColumnData, new CassandraToSqlColumnData("42"));
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("42");
    cassandraToSqlColumnData.setConstraintCounter(3);

    // Act and Assert
    assertNotEquals(cassandraToSqlColumnData, new CassandraToSqlColumnData("42"));
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData("Value");
    cassandraToSqlColumnData.setValue("42");

    // Act and Assert
    assertNotEquals(cassandraToSqlColumnData, new CassandraToSqlColumnData("42"));
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraToSqlColumnData cassandraToSqlColumnData = new CassandraToSqlColumnData(null);
    cassandraToSqlColumnData.setValue("42");

    // Act and Assert
    assertNotEquals(cassandraToSqlColumnData, new CassandraToSqlColumnData("42"));
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraToSqlColumnData("42"), null);
  }

  /**
   * Test {@link CassandraToSqlColumnData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraToSqlColumnData("42"), "Different type to CassandraToSqlColumnData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraToSqlColumnData#CassandraToSqlColumnData(String)}
   *   <li>{@link CassandraToSqlColumnData#setConstraintCounter(int)}
   *   <li>{@link CassandraToSqlColumnData#setOriginalValue(String)}
   *   <li>{@link CassandraToSqlColumnData#setValue(String)}
   *   <li>{@link CassandraToSqlColumnData#nextContraintCounter()}
   *   <li>{@link CassandraToSqlColumnData#toString()}
   *   <li>{@link CassandraToSqlColumnData#getConstraintCounter()}
   *   <li>{@link CassandraToSqlColumnData#getOriginalValue()}
   *   <li>{@link CassandraToSqlColumnData#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CassandraToSqlColumnData actualCassandraToSqlColumnData = new CassandraToSqlColumnData("42");
    actualCassandraToSqlColumnData.setConstraintCounter(3);
    actualCassandraToSqlColumnData.setOriginalValue("42");
    actualCassandraToSqlColumnData.setValue("42");
    int actualNextContraintCounterResult = actualCassandraToSqlColumnData.nextContraintCounter();
    String actualToStringResult = actualCassandraToSqlColumnData.toString();
    int actualConstraintCounter = actualCassandraToSqlColumnData.getConstraintCounter();
    String actualOriginalValue = actualCassandraToSqlColumnData.getOriginalValue();

    // Assert that nothing has changed
    assertEquals("42", actualOriginalValue);
    assertEquals("42", actualCassandraToSqlColumnData.getValue());
    assertEquals("CassandraToSqlColumnData(value=42, originalValue=42, constraintCounter=4)", actualToStringResult);
    assertEquals(4, actualConstraintCounter);
    assertEquals(4, actualNextContraintCounterResult);
  }

  /**
   * Test
   * {@link CassandraToSqlColumnData#getNextConstraintStringValue(CassandraToSqlColumn)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraToSqlColumnData#getNextConstraintStringValue(CassandraToSqlColumn)}
   */
  @Test
  @DisplayName("Test getNextConstraintStringValue(CassandraToSqlColumn); given three; then return '1'")
  void testGetNextConstraintStringValue_givenThree_thenReturn1() {
    // Arrange
    CassandraToSqlColumn column = mock(CassandraToSqlColumn.class);
    when(column.getSize()).thenReturn(3);

    // Act
    String actualNextConstraintStringValue = cassandraToSqlColumnData.getNextConstraintStringValue(column);

    // Assert
    verify(column).getSize();
    assertEquals("1", actualNextConstraintStringValue);
    assertEquals(1, cassandraToSqlColumnData.getConstraintCounter());
  }

  /**
   * Test {@link CassandraToSqlColumnData#getLogValue()}.
   * <p>
   * Method under test: {@link CassandraToSqlColumnData#getLogValue()}
   */
  @Test
  @DisplayName("Test getLogValue()")
  void testGetLogValue() {
    // Arrange, Act and Assert
    assertEquals("", cassandraToSqlColumnData.getLogValue());
  }
}
