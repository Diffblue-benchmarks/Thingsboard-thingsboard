package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.IntervalType;

@ContextConfiguration(classes = {TimeSeriesCmd.class})
@ExtendWith(SpringExtension.class)
class TimeSeriesCmdDiffblueTest {
  @Autowired
  private TimeSeriesCmd timeSeriesCmd;

  /**
   * Test {@link TimeSeriesCmd#getEndTs()}.
   * <p>
   * Method under test: {@link TimeSeriesCmd#getEndTs()}
   */
  @Test
  @DisplayName("Test getEndTs()")
  void testGetEndTs() {
    // Arrange, Act and Assert
    assertEquals(0L, timeSeriesCmd.getEndTs());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd2);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setKeys(new ArrayList<>());

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd2);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setIntervalType(IntervalType.MILLISECONDS);

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd2);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setTimeZoneId("UTC");

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setTimeZoneId("UTC");

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd2);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setAgg(Aggregation.MIN);

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setAgg(Aggregation.MIN);

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd2);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd2.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}, and
   * {@link TimeSeriesCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSeriesCmd#equals(Object)}
   *   <li>{@link TimeSeriesCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();

    // Act and Assert
    assertEquals(timeSeriesCmd, timeSeriesCmd);
    int expectedHashCodeResult = timeSeriesCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeSeriesCmd.hashCode());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimeSeriesCmd(), 1);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setStartTs(1L);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setInterval(42L);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setTimeZoneId("UTC");

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setLimit(1);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setAgg(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();
    timeSeriesCmd.setFetchLatestPreviousPoint(true);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, new TimeSeriesCmd());
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(timeSeriesCmd, timeSeriesCmd2);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, timeSeriesCmd2);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setTimeZoneId("UTC");

    // Act and Assert
    assertNotEquals(timeSeriesCmd, timeSeriesCmd2);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TimeSeriesCmd timeSeriesCmd = new TimeSeriesCmd();

    TimeSeriesCmd timeSeriesCmd2 = new TimeSeriesCmd();
    timeSeriesCmd2.setAgg(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(timeSeriesCmd, timeSeriesCmd2);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimeSeriesCmd(), null);
  }

  /**
   * Test {@link TimeSeriesCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSeriesCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimeSeriesCmd(), "Different type to TimeSeriesCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TimeSeriesCmd}
   *   <li>{@link TimeSeriesCmd#setAgg(Aggregation)}
   *   <li>{@link TimeSeriesCmd#setFetchLatestPreviousPoint(boolean)}
   *   <li>{@link TimeSeriesCmd#setInterval(long)}
   *   <li>{@link TimeSeriesCmd#setIntervalType(IntervalType)}
   *   <li>{@link TimeSeriesCmd#setKeys(List)}
   *   <li>{@link TimeSeriesCmd#setLimit(int)}
   *   <li>{@link TimeSeriesCmd#setStartTs(long)}
   *   <li>{@link TimeSeriesCmd#setTimeWindow(long)}
   *   <li>{@link TimeSeriesCmd#setTimeZoneId(String)}
   *   <li>{@link TimeSeriesCmd#toString()}
   *   <li>{@link TimeSeriesCmd#getAgg()}
   *   <li>{@link TimeSeriesCmd#getInterval()}
   *   <li>{@link TimeSeriesCmd#getIntervalType()}
   *   <li>{@link TimeSeriesCmd#getKeys()}
   *   <li>{@link TimeSeriesCmd#getLimit()}
   *   <li>{@link TimeSeriesCmd#getStartTs()}
   *   <li>{@link TimeSeriesCmd#getTimeWindow()}
   *   <li>{@link TimeSeriesCmd#getTimeZoneId()}
   *   <li>{@link TimeSeriesCmd#isFetchLatestPreviousPoint()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TimeSeriesCmd actualTimeSeriesCmd = new TimeSeriesCmd();
    actualTimeSeriesCmd.setAgg(Aggregation.MIN);
    actualTimeSeriesCmd.setFetchLatestPreviousPoint(true);
    actualTimeSeriesCmd.setInterval(42L);
    actualTimeSeriesCmd.setIntervalType(IntervalType.MILLISECONDS);
    ArrayList<String> keys = new ArrayList<>();
    actualTimeSeriesCmd.setKeys(keys);
    actualTimeSeriesCmd.setLimit(1);
    actualTimeSeriesCmd.setStartTs(1L);
    actualTimeSeriesCmd.setTimeWindow(10L);
    actualTimeSeriesCmd.setTimeZoneId("UTC");
    String actualToStringResult = actualTimeSeriesCmd.toString();
    Aggregation actualAgg = actualTimeSeriesCmd.getAgg();
    long actualInterval = actualTimeSeriesCmd.getInterval();
    IntervalType actualIntervalType = actualTimeSeriesCmd.getIntervalType();
    List<String> actualKeys = actualTimeSeriesCmd.getKeys();
    int actualLimit = actualTimeSeriesCmd.getLimit();
    long actualStartTs = actualTimeSeriesCmd.getStartTs();
    long actualTimeWindow = actualTimeSeriesCmd.getTimeWindow();
    String actualTimeZoneId = actualTimeSeriesCmd.getTimeZoneId();
    boolean actualIsFetchLatestPreviousPointResult = actualTimeSeriesCmd.isFetchLatestPreviousPoint();

    // Assert that nothing has changed
    assertEquals(
        "TimeSeriesCmd(keys=[], startTs=1, timeWindow=10, intervalType=MILLISECONDS, interval=42, timeZoneId=UTC,"
            + " limit=1, agg=MIN, fetchLatestPreviousPoint=true)",
        actualToStringResult);
    assertEquals("UTC", actualTimeZoneId);
    assertEquals(1, actualLimit);
    assertEquals(10L, actualTimeWindow);
    assertEquals(1L, actualStartTs);
    assertEquals(42L, actualInterval);
    assertEquals(Aggregation.MIN, actualAgg);
    assertEquals(IntervalType.MILLISECONDS, actualIntervalType);
    assertTrue(actualKeys.isEmpty());
    assertTrue(actualIsFetchLatestPreviousPointResult);
    assertSame(keys, actualKeys);
  }
}
