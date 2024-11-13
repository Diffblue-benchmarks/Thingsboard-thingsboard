package org.thingsboard.server.dao.model.sqlts.timescale.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class TimescaleTsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and
   * {@link TimescaleTsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and
   * {@link TimescaleTsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1,
        1L);
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1,
        1L);

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and
   * {@link TimescaleTsKvCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID, 1,
        1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), null);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), "Different type to TimescaleTsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    UUID entityId = ModelConstants.NULL_UUID;
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();
    long actualTs = actualTimescaleTsKvCompositeKey.getTs();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TimescaleTsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
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
   *   <li>
   * {@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey(ModelConstants.NULL_UUID,
        1, 1L);
    UUID entityId = ModelConstants.NULL_UUID;
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();
    long actualTs = actualTimescaleTsKvCompositeKey.getTs();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("TimescaleTsKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
    assertSame(entityId, actualEntityId);
  }
}
