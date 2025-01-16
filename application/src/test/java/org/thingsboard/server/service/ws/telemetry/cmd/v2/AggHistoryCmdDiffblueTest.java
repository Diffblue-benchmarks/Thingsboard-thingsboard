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

class AggHistoryCmdDiffblueTest {
  /**
   * Test {@link AggHistoryCmd#equals(Object)}, and
   * {@link AggHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggHistoryCmd#equals(Object)}
   *   <li>{@link AggHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    AggHistoryCmd aggHistoryCmd2 = new AggHistoryCmd();
    aggHistoryCmd2.setEndTs(1L);
    aggHistoryCmd2.setKeys(new ArrayList<>());
    aggHistoryCmd2.setStartTs(1L);

    // Act and Assert
    assertEquals(aggHistoryCmd, aggHistoryCmd2);
    int expectedHashCodeResult = aggHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, aggHistoryCmd2.hashCode());
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}, and
   * {@link AggHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggHistoryCmd#equals(Object)}
   *   <li>{@link AggHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    // Act and Assert
    assertEquals(aggHistoryCmd, aggHistoryCmd);
    int expectedHashCodeResult = aggHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, aggHistoryCmd.hashCode());
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(3L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    AggHistoryCmd aggHistoryCmd2 = new AggHistoryCmd();
    aggHistoryCmd2.setEndTs(1L);
    aggHistoryCmd2.setKeys(new ArrayList<>());
    aggHistoryCmd2.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, aggHistoryCmd2);
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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

    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(keys);
    aggHistoryCmd.setStartTs(1L);

    AggHistoryCmd aggHistoryCmd2 = new AggHistoryCmd();
    aggHistoryCmd2.setEndTs(1L);
    aggHistoryCmd2.setKeys(new ArrayList<>());
    aggHistoryCmd2.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, aggHistoryCmd2);
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(3L);

    AggHistoryCmd aggHistoryCmd2 = new AggHistoryCmd();
    aggHistoryCmd2.setEndTs(1L);
    aggHistoryCmd2.setKeys(new ArrayList<>());
    aggHistoryCmd2.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, aggHistoryCmd2);
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
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

    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(keys);
    aggHistoryCmd.setStartTs(1L);

    AggHistoryCmd aggHistoryCmd2 = new AggHistoryCmd();
    aggHistoryCmd2.setEndTs(1L);
    aggHistoryCmd2.setKeys(new ArrayList<>());
    aggHistoryCmd2.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, aggHistoryCmd2);
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, null);
  }

  /**
   * Test {@link AggHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AggHistoryCmd aggHistoryCmd = new AggHistoryCmd();
    aggHistoryCmd.setEndTs(1L);
    aggHistoryCmd.setKeys(new ArrayList<>());
    aggHistoryCmd.setStartTs(1L);

    // Act and Assert
    assertNotEquals(aggHistoryCmd, "Different type to AggHistoryCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AggHistoryCmd}
   *   <li>{@link AggHistoryCmd#setEndTs(long)}
   *   <li>{@link AggHistoryCmd#setKeys(List)}
   *   <li>{@link AggHistoryCmd#setStartTs(long)}
   *   <li>{@link AggHistoryCmd#toString()}
   *   <li>{@link AggHistoryCmd#getEndTs()}
   *   <li>{@link AggHistoryCmd#getKeys()}
   *   <li>{@link AggHistoryCmd#getStartTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AggHistoryCmd actualAggHistoryCmd = new AggHistoryCmd();
    actualAggHistoryCmd.setEndTs(1L);
    ArrayList<AggKey> keys = new ArrayList<>();
    actualAggHistoryCmd.setKeys(keys);
    actualAggHistoryCmd.setStartTs(1L);
    String actualToStringResult = actualAggHistoryCmd.toString();
    long actualEndTs = actualAggHistoryCmd.getEndTs();
    List<AggKey> actualKeys = actualAggHistoryCmd.getKeys();

    // Assert that nothing has changed
    assertEquals("AggHistoryCmd(keys=[], startTs=1, endTs=1)", actualToStringResult);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, actualAggHistoryCmd.getStartTs());
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
