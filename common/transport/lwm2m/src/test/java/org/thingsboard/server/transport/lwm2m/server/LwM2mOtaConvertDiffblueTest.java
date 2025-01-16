package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.eclipse.leshan.core.model.ResourceModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2mOtaConvertDiffblueTest {
  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and
   * {@link LwM2mOtaConvert#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and
   * {@link LwM2mOtaConvert#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(null);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(null);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and
   * {@link LwM2mOtaConvert#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue(null);

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and
   * {@link LwM2mOtaConvert#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(null);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.STRING);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue(lwM2mOtaConvert);

    LwM2mOtaConvert lwM2mOtaConvert3 = new LwM2mOtaConvert();
    lwM2mOtaConvert3.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert3.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert2, lwM2mOtaConvert3);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, null);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, "Different type to LwM2mOtaConvert");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mOtaConvert}
   *   <li>{@link LwM2mOtaConvert#setCurrentType(ResourceModel.Type)}
   *   <li>{@link LwM2mOtaConvert#setValue(Object)}
   *   <li>{@link LwM2mOtaConvert#toString()}
   *   <li>{@link LwM2mOtaConvert#getCurrentType()}
   *   <li>{@link LwM2mOtaConvert#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mOtaConvert actualLwM2mOtaConvert = new LwM2mOtaConvert();
    actualLwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    actualLwM2mOtaConvert.setValue("Value");
    String actualToStringResult = actualLwM2mOtaConvert.toString();
    ResourceModel.Type actualCurrentType = actualLwM2mOtaConvert.getCurrentType();

    // Assert that nothing has changed
    assertEquals("LwM2mOtaConvert(currentType=NONE, value=Value)", actualToStringResult);
    assertEquals("Value", actualLwM2mOtaConvert.getValue());
    assertEquals(ResourceModel.Type.NONE, actualCurrentType);
  }
}
