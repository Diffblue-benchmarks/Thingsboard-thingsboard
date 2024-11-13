package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleWidgetCompositeKeyDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and
   * {@link WidgetsBundleWidgetCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 = new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and
   * {@link WidgetsBundleWidgetCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 = new WidgetsBundleWidgetCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and
   * {@link WidgetsBundleWidgetCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey,
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();

    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 = new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey2.setWidgetTypeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidgetCompositeKey(), null);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidgetCompositeKey(), "Different type to WidgetsBundleWidgetCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey();
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals("WidgetsBundleWidgetCompositeKey(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId"
        + "=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey(UUID, UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey = new WidgetsBundleWidgetCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals("WidgetsBundleWidgetCompositeKey(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId"
        + "=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleId);
  }
}
