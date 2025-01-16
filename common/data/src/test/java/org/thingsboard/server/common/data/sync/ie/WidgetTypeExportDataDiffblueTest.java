package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;

class WidgetTypeExportDataDiffblueTest {
  /**
   * Test {@link WidgetTypeExportData#equals(Object)}, and
   * {@link WidgetTypeExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeExportData#equals(Object)}
   *   <li>{@link WidgetTypeExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeExportData widgetTypeExportData = new WidgetTypeExportData();
    WidgetTypeExportData widgetTypeExportData2 = new WidgetTypeExportData();

    // Act and Assert
    assertEquals(widgetTypeExportData, widgetTypeExportData2);
    int expectedHashCodeResult = widgetTypeExportData.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeExportData2.hashCode());
  }

  /**
   * Test {@link WidgetTypeExportData#equals(Object)}, and
   * {@link WidgetTypeExportData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeExportData#equals(Object)}
   *   <li>{@link WidgetTypeExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeExportData widgetTypeExportData = new WidgetTypeExportData();

    // Act and Assert
    assertEquals(widgetTypeExportData, widgetTypeExportData);
    int expectedHashCodeResult = widgetTypeExportData.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeExportData.hashCode());
  }

  /**
   * Test {@link WidgetTypeExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeExportData(), 1);
    assertNotEquals(new WidgetTypeExportData(), mock(DeviceExportData.class));
  }

  /**
   * Test {@link WidgetTypeExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeExportData widgetTypeExportData = new WidgetTypeExportData();
    widgetTypeExportData.setEntity(new WidgetTypeDetails());

    // Act and Assert
    assertNotEquals(widgetTypeExportData, new WidgetTypeExportData());
  }

  /**
   * Test {@link WidgetTypeExportData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeExportData(), null);
  }

  /**
   * Test {@link WidgetTypeExportData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeExportData(), "Different type to WidgetTypeExportData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetTypeExportData}
   *   <li>{@link WidgetTypeExportData#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeExportData actualWidgetTypeExportData = new WidgetTypeExportData();

    // Assert
    assertEquals("WidgetTypeExportData()", actualWidgetTypeExportData.toString());
    assertNull(actualWidgetTypeExportData.getRelations());
    assertNull(actualWidgetTypeExportData.getAttributes());
    assertNull(actualWidgetTypeExportData.getEntityType());
    assertNull(actualWidgetTypeExportData.getEntity());
  }
}
