package org.thingsboard.server.dao.model.sqlts.latest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvLatestCompositeKeyDiffblueTest {
  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and
   * {@link TsKvLatestCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    TsKvLatestCompositeKey tsKvLatestCompositeKey2 = new TsKvLatestCompositeKey();

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and
   * {@link TsKvLatestCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey(ModelConstants.NULL_UUID, 1);
    TsKvLatestCompositeKey tsKvLatestCompositeKey2 = new TsKvLatestCompositeKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and
   * {@link TsKvLatestCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, new TsKvLatestCompositeKey());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    tsKvLatestCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, new TsKvLatestCompositeKey());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();

    TsKvLatestCompositeKey tsKvLatestCompositeKey2 = new TsKvLatestCompositeKey();
    tsKvLatestCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestCompositeKey(), null);
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestCompositeKey(), "Different type to TsKvLatestCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#TsKvLatestCompositeKey()}
   *   <li>{@link TsKvLatestCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvLatestCompositeKey#setKey(int)}
   *   <li>{@link TsKvLatestCompositeKey#toString()}
   *   <li>{@link TsKvLatestCompositeKey#getEntityId()}
   *   <li>{@link TsKvLatestCompositeKey#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TsKvLatestCompositeKey actualTsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvLatestCompositeKey.setEntityId(entityId);
    actualTsKvLatestCompositeKey.setKey(1);
    String actualToStringResult = actualTsKvLatestCompositeKey.toString();
    UUID actualEntityId = actualTsKvLatestCompositeKey.getEntityId();
    int actualKey = actualTsKvLatestCompositeKey.getKey();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TsKvLatestCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1)", actualToStringResult);
    assertEquals(1, actualKey);
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
   *   <li>{@link TsKvLatestCompositeKey#TsKvLatestCompositeKey(UUID, int)}
   *   <li>{@link TsKvLatestCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvLatestCompositeKey#setKey(int)}
   *   <li>{@link TsKvLatestCompositeKey#toString()}
   *   <li>{@link TsKvLatestCompositeKey#getEntityId()}
   *   <li>{@link TsKvLatestCompositeKey#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    TsKvLatestCompositeKey actualTsKvLatestCompositeKey = new TsKvLatestCompositeKey(ModelConstants.NULL_UUID, 1);
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvLatestCompositeKey.setEntityId(entityId);
    actualTsKvLatestCompositeKey.setKey(1);
    String actualToStringResult = actualTsKvLatestCompositeKey.toString();
    UUID actualEntityId = actualTsKvLatestCompositeKey.getEntityId();
    int actualKey = actualTsKvLatestCompositeKey.getKey();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TsKvLatestCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1)", actualToStringResult);
    assertEquals(1, actualKey);
    assertSame(entityId, actualEntityId);
  }
}
