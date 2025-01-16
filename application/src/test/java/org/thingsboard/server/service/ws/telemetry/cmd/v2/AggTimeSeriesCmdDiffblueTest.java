package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.Aggregation;

class AggTimeSeriesCmdDiffblueTest {
  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}, and
   * {@link AggTimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggTimeSeriesCmd#equals(Object)}
   *   <li>{@link AggTimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    AggTimeSeriesCmd aggTimeSeriesCmd2 = new AggTimeSeriesCmd();
    aggTimeSeriesCmd2.setKeys(new ArrayList<>());
    aggTimeSeriesCmd2.setStartTs(1L);
    aggTimeSeriesCmd2.setTimeWindow(10L);

    // Act and Assert
    assertEquals(aggTimeSeriesCmd, aggTimeSeriesCmd2);
    int expectedHashCodeResult = aggTimeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, aggTimeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}, and
   * {@link AggTimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggTimeSeriesCmd#equals(Object)}
   *   <li>{@link AggTimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    // Act and Assert
    assertEquals(aggTimeSeriesCmd, aggTimeSeriesCmd);
    int expectedHashCodeResult = aggTimeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, aggTimeSeriesCmd.hashCode());
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    ArrayList<AggKey> keys = new ArrayList<>();
    keys.add(aggKey);

    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(keys);
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    AggTimeSeriesCmd aggTimeSeriesCmd2 = new AggTimeSeriesCmd();
    aggTimeSeriesCmd2.setKeys(new ArrayList<>());
    aggTimeSeriesCmd2.setStartTs(1L);
    aggTimeSeriesCmd2.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, aggTimeSeriesCmd2);
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(3L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    AggTimeSeriesCmd aggTimeSeriesCmd2 = new AggTimeSeriesCmd();
    aggTimeSeriesCmd2.setKeys(new ArrayList<>());
    aggTimeSeriesCmd2.setStartTs(1L);
    aggTimeSeriesCmd2.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, aggTimeSeriesCmd2);
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(1L);

    AggTimeSeriesCmd aggTimeSeriesCmd2 = new AggTimeSeriesCmd();
    aggTimeSeriesCmd2.setKeys(new ArrayList<>());
    aggTimeSeriesCmd2.setStartTs(1L);
    aggTimeSeriesCmd2.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, aggTimeSeriesCmd2);
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AggKey aggKey = mock(AggKey.class);
    doNothing().when(aggKey).setAgg(Mockito.<Aggregation>any());
    doNothing().when(aggKey).setId(anyInt());
    doNothing().when(aggKey).setKey(Mockito.<String>any());
    doNothing().when(aggKey).setPreviousEndTs(Mockito.<Long>any());
    doNothing().when(aggKey).setPreviousStartTs(Mockito.<Long>any());
    doNothing().when(aggKey).setPreviousValueOnly(Mockito.<Boolean>any());
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    ArrayList<AggKey> keys = new ArrayList<>();
    keys.add(aggKey);

    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(keys);
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    AggTimeSeriesCmd aggTimeSeriesCmd2 = new AggTimeSeriesCmd();
    aggTimeSeriesCmd2.setKeys(new ArrayList<>());
    aggTimeSeriesCmd2.setStartTs(1L);
    aggTimeSeriesCmd2.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, aggTimeSeriesCmd2);
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, null);
  }

  /**
   * Test {@link AggTimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggTimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AggTimeSeriesCmd aggTimeSeriesCmd = new AggTimeSeriesCmd();
    aggTimeSeriesCmd.setKeys(new ArrayList<>());
    aggTimeSeriesCmd.setStartTs(1L);
    aggTimeSeriesCmd.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(aggTimeSeriesCmd, "Different type to AggTimeSeriesCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AggTimeSeriesCmd}
   *   <li>{@link AggTimeSeriesCmd#setKeys(List)}
   *   <li>{@link AggTimeSeriesCmd#setStartTs(long)}
   *   <li>{@link AggTimeSeriesCmd#setTimeWindow(long)}
   *   <li>{@link AggTimeSeriesCmd#toString()}
   *   <li>{@link AggTimeSeriesCmd#getKeys()}
   *   <li>{@link AggTimeSeriesCmd#getStartTs()}
   *   <li>{@link AggTimeSeriesCmd#getTimeWindow()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AggTimeSeriesCmd actualAggTimeSeriesCmd = new AggTimeSeriesCmd();
    ArrayList<AggKey> keys = new ArrayList<>();
    actualAggTimeSeriesCmd.setKeys(keys);
    actualAggTimeSeriesCmd.setStartTs(1L);
    actualAggTimeSeriesCmd.setTimeWindow(10L);
    String actualToStringResult = actualAggTimeSeriesCmd.toString();
    List<AggKey> actualKeys = actualAggTimeSeriesCmd.getKeys();
    long actualStartTs = actualAggTimeSeriesCmd.getStartTs();

    // Assert that nothing has changed
    assertEquals("AggTimeSeriesCmd(keys=[], startTs=1, timeWindow=10)", actualToStringResult);
    assertEquals(10L, actualAggTimeSeriesCmd.getTimeWindow());
    assertEquals(1L, actualStartTs);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
