package org.thingsboard.server.common.data.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2mInstanceDiffblueTest {
  /**
   * Test {@link LwM2mInstance#equals(Object)}, and
   * {@link LwM2mInstance#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance2);
    int expectedHashCodeResult = lwM2mInstance.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mInstance2.hashCode());
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}, and
   * {@link LwM2mInstance#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance);
    int expectedHashCodeResult = lwM2mInstance.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mInstance.hashCode());
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(2);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(2, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{mock(LwM2mResourceObserve.class)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, null);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, "Different type to LwM2mInstance");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mInstance}
   *   <li>{@link LwM2mInstance#setId(int)}
   *   <li>{@link LwM2mInstance#setResources(LwM2mResourceObserve[])}
   *   <li>{@link LwM2mInstance#toString()}
   *   <li>{@link LwM2mInstance#getId()}
   *   <li>{@link LwM2mInstance#getResources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mInstance actualLwM2mInstance = new LwM2mInstance();
    actualLwM2mInstance.setId(1);
    LwM2mResourceObserve[] resources = new LwM2mResourceObserve[]{
        new LwM2mResourceObserve(1, "Name", true, true, true)};
    actualLwM2mInstance.setResources(resources);
    String actualToStringResult = actualLwM2mInstance.toString();
    int actualId = actualLwM2mInstance.getId();

    // Assert that nothing has changed
    assertEquals("LwM2mInstance(id=1, resources=[LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true,"
        + " telemetry=true, keyName=name)])", actualToStringResult);
    assertEquals(1, actualId);
    assertSame(resources, actualLwM2mInstance.getResources());
  }
}
