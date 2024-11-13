package org.thingsboard.server.dao.model.sqlts.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and
   * {@link TsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and
   * {@link TsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and
   * {@link TsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();
    tsKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, tsKvCompositeKey2);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), null);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), "Different type to TsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey()}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey = new TsKvCompositeKey();
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();
    long actualTs = actualTsKvCompositeKey.getTs();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)", actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
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
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey = new TsKvCompositeKey(ModelConstants.NULL_UUID, 1, 1L);
    UUID entityId = ModelConstants.NULL_UUID;
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();
    long actualTs = actualTsKvCompositeKey.getTs();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)", actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
    assertSame(entityId, actualEntityId);
  }
}
