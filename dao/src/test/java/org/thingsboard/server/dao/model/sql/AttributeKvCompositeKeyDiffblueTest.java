package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class AttributeKvCompositeKeyDiffblueTest {
  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and
   * {@link AttributeKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    int expectedHashCodeResult = attributeKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and
   * {@link AttributeKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(null);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    int expectedHashCodeResult = attributeKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and
   * {@link AttributeKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey);
    int expectedHashCodeResult = attributeKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvCompositeKey.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(3);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(3);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.randomUUID());

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, null);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, "Different type to AttributeKvCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey()}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey = new AttributeKvCompositeKey();
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = ModelConstants.NULL_UUID;
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, attributeType=1," + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey(UUID, int, int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey = new AttributeKvCompositeKey(ModelConstants.NULL_UUID, 1, 1);
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = ModelConstants.NULL_UUID;
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, attributeType=1," + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
  }
}
