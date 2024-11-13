package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.widget.WidgetsBundle;

class WidgetsBundleExportDataDiffblueTest {
  /**
   * Test {@link WidgetsBundleExportData#addFqn(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#addFqn(String)}
   */
  @Test
  @DisplayName("Test addFqn(String); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testAddFqn_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.setAttributes(attributes);

    // Act
    widgetsBundleExportData.addFqn("Fqn");

    // Assert
    List<String> fqns = widgetsBundleExportData.getFqns();
    assertEquals(1, fqns.size());
    assertEquals("Fqn", fqns.get(0));
  }

  /**
   * Test {@link WidgetsBundleExportData#addFqn(String)}.
   * <ul>
   *   <li>Given {@link WidgetsBundleExportData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#addFqn(String)}
   */
  @Test
  @DisplayName("Test addFqn(String); given WidgetsBundleExportData (default constructor)")
  void testAddFqn_givenWidgetsBundleExportData() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();

    // Act
    widgetsBundleExportData.addFqn("Fqn");

    // Assert
    List<String> fqns = widgetsBundleExportData.getFqns();
    assertEquals(1, fqns.size());
    assertEquals("Fqn", fqns.get(0));
  }

  /**
   * Test {@link WidgetsBundleExportData#addFqn(String)}.
   * <ul>
   *   <li>Then {@link WidgetsBundleExportData} (default constructor) Fqns is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#addFqn(String)}
   */
  @Test
  @DisplayName("Test addFqn(String); then WidgetsBundleExportData (default constructor) Fqns is ArrayList()")
  void testAddFqn_thenWidgetsBundleExportDataFqnsIsArrayList() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    ArrayList<String> fqns = new ArrayList<>();
    widgetsBundleExportData.setFqns(fqns);

    // Act
    widgetsBundleExportData.addFqn("Fqn");

    // Assert
    List<String> fqns2 = widgetsBundleExportData.getFqns();
    assertEquals(1, fqns2.size());
    assertEquals("Fqn", fqns2.get(0));
    assertSame(fqns, fqns2);
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}, and
   * {@link WidgetsBundleExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleExportData#equals(Object)}
   *   <li>{@link WidgetsBundleExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    WidgetsBundleExportData widgetsBundleExportData2 = new WidgetsBundleExportData();

    // Act and Assert
    assertEquals(widgetsBundleExportData, widgetsBundleExportData2);
    int expectedHashCodeResult = widgetsBundleExportData.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleExportData2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}, and
   * {@link WidgetsBundleExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleExportData#equals(Object)}
   *   <li>{@link WidgetsBundleExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.addFqn("Fqn");

    WidgetsBundleExportData widgetsBundleExportData2 = new WidgetsBundleExportData();
    widgetsBundleExportData2.addFqn("Fqn");

    // Act and Assert
    assertEquals(widgetsBundleExportData, widgetsBundleExportData2);
    int expectedHashCodeResult = widgetsBundleExportData.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleExportData2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}, and
   * {@link WidgetsBundleExportData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleExportData#equals(Object)}
   *   <li>{@link WidgetsBundleExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();

    // Act and Assert
    assertEquals(widgetsBundleExportData, widgetsBundleExportData);
    int expectedHashCodeResult = widgetsBundleExportData.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleExportData.hashCode());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.addFqn("Fqn");

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, new WidgetsBundleExportData());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.setWidgets(new ArrayList<>());
    widgetsBundleExportData.addFqn("Fqn");

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, new WidgetsBundleExportData());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.setEntity(new WidgetsBundle());
    widgetsBundleExportData.addFqn("Fqn");

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, new WidgetsBundleExportData());
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleExportData(), mock(DeviceExportData.class));
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();

    WidgetsBundleExportData widgetsBundleExportData2 = new WidgetsBundleExportData();
    widgetsBundleExportData2.addFqn("Fqn");

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, widgetsBundleExportData2);
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();

    WidgetsBundleExportData widgetsBundleExportData2 = new WidgetsBundleExportData();
    widgetsBundleExportData2.setWidgets(new ArrayList<>());
    widgetsBundleExportData2.addFqn("Fqn");

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, widgetsBundleExportData2);
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetsBundleExportData widgetsBundleExportData = new WidgetsBundleExportData();
    widgetsBundleExportData.setWidgets(new ArrayList<>());
    widgetsBundleExportData.addFqn("Fqn");

    WidgetsBundleExportData widgetsBundleExportData2 = new WidgetsBundleExportData();
    widgetsBundleExportData2.setWidgets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(widgetsBundleExportData, widgetsBundleExportData2);
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleExportData(), null);
  }

  /**
   * Test {@link WidgetsBundleExportData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleExportData(), "Different type to WidgetsBundleExportData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetsBundleExportData}
   *   <li>{@link WidgetsBundleExportData#setFqns(List)}
   *   <li>{@link WidgetsBundleExportData#setWidgets(List)}
   *   <li>{@link WidgetsBundleExportData#toString()}
   *   <li>{@link WidgetsBundleExportData#getFqns()}
   *   <li>{@link WidgetsBundleExportData#getWidgets()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleExportData actualWidgetsBundleExportData = new WidgetsBundleExportData();
    ArrayList<String> fqns = new ArrayList<>();
    actualWidgetsBundleExportData.setFqns(fqns);
    ArrayList<ObjectNode> widgets = new ArrayList<>();
    actualWidgetsBundleExportData.setWidgets(widgets);
    String actualToStringResult = actualWidgetsBundleExportData.toString();
    List<String> actualFqns = actualWidgetsBundleExportData.getFqns();
    List<ObjectNode> actualWidgets = actualWidgetsBundleExportData.getWidgets();

    // Assert that nothing has changed
    assertEquals("WidgetsBundleExportData(widgets=[], fqns=[])", actualToStringResult);
    assertTrue(actualFqns.isEmpty());
    assertTrue(actualWidgets.isEmpty());
    assertSame(fqns, actualFqns);
    assertSame(widgets, actualWidgets);
  }
}
