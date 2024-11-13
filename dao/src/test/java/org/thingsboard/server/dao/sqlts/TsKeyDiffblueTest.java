package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKeyDiffblueTest {
  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 1);
    TsKey tsKey2 = new TsKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);
    TsKey tsKey2 = new TsKey(null, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKey tsKey = new TsKey(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 3);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(ModelConstants.NULL_UUID, 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(ModelConstants.NULL_UUID, 1), null);
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(ModelConstants.NULL_UUID, 1), "Different type to TsKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#TsKey(UUID, int)}
   *   <li>{@link TsKey#toString()}
   *   <li>{@link TsKey#getEntityId()}
   *   <li>{@link TsKey#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    TsKey actualTsKey = new TsKey(entityId, 1);
    String actualToStringResult = actualTsKey.toString();
    UUID actualEntityId = actualTsKey.getEntityId();
    int actualKey = actualTsKey.getKey();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TsKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1)", actualToStringResult);
    assertEquals(1, actualKey);
    assertSame(entityId, actualEntityId);
  }
}
