package org.thingsboard.server.service.ws.telemetry.cmd.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.ws.WsCmdType;

@ContextConfiguration(classes = {TimeseriesSubscriptionCmd.class})
@ExtendWith(SpringExtension.class)
class TimeseriesSubscriptionCmdDiffblueTest {
  @Autowired
  private TimeseriesSubscriptionCmd timeseriesSubscriptionCmd;

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}, and {@link TimeseriesSubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeseriesSubscriptionCmd#equals(Object)}
   *   <li>{@link TimeseriesSubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd2 = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(timeseriesSubscriptionCmd, timeseriesSubscriptionCmd2);
    int expectedHashCodeResult = timeseriesSubscriptionCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeseriesSubscriptionCmd2.hashCode());
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}, and {@link TimeseriesSubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeseriesSubscriptionCmd#equals(Object)}
   *   <li>{@link TimeseriesSubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, null);
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd2 = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, null);

    // Act and Assert
    assertEquals(timeseriesSubscriptionCmd, timeseriesSubscriptionCmd2);
    int expectedHashCodeResult = timeseriesSubscriptionCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeseriesSubscriptionCmd2.hashCode());
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}, and {@link TimeseriesSubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeseriesSubscriptionCmd#equals(Object)}
   *   <li>{@link TimeseriesSubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(timeseriesSubscriptionCmd, timeseriesSubscriptionCmd);
    int expectedHashCodeResult = timeseriesSubscriptionCmd.hashCode();
    assertEquals(expectedHashCodeResult, timeseriesSubscriptionCmd.hashCode());
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(3L, 10L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 1L, 1, "Agg");

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 3, "Agg");

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, null);

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1,
        "org.thingsboard.server.service.ws.telemetry.cmd.v1.TimeseriesSubscriptionCmd");

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg");
    timeseriesSubscriptionCmd.setCmdId(1);

    // Act and Assert
    assertNotEquals(timeseriesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"), null);
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeseriesSubscriptionCmd.equals(Object)", "int TimeseriesSubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"),
        "Different type to TimeseriesSubscriptionCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeseriesSubscriptionCmd#TimeseriesSubscriptionCmd()}
   *   <li>{@link TimeseriesSubscriptionCmd#setAgg(String)}
   *   <li>{@link TimeseriesSubscriptionCmd#setInterval(long)}
   *   <li>{@link TimeseriesSubscriptionCmd#setLimit(int)}
   *   <li>{@link TimeseriesSubscriptionCmd#setStartTs(long)}
   *   <li>{@link TimeseriesSubscriptionCmd#setTimeWindow(long)}
   *   <li>{@link TimeseriesSubscriptionCmd#toString()}
   *   <li>{@link TimeseriesSubscriptionCmd#getAgg()}
   *   <li>{@link TimeseriesSubscriptionCmd#getInterval()}
   *   <li>{@link TimeseriesSubscriptionCmd#getLimit()}
   *   <li>{@link TimeseriesSubscriptionCmd#getStartTs()}
   *   <li>{@link TimeseriesSubscriptionCmd#getTimeWindow()}
   *   <li>{@link TimeseriesSubscriptionCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeseriesSubscriptionCmd.<init>()", "String TimeseriesSubscriptionCmd.getAgg()",
      "long TimeseriesSubscriptionCmd.getInterval()", "int TimeseriesSubscriptionCmd.getLimit()",
      "long TimeseriesSubscriptionCmd.getStartTs()", "long TimeseriesSubscriptionCmd.getTimeWindow()",
      "WsCmdType TimeseriesSubscriptionCmd.getType()", "void TimeseriesSubscriptionCmd.setAgg(String)",
      "void TimeseriesSubscriptionCmd.setInterval(long)", "void TimeseriesSubscriptionCmd.setLimit(int)",
      "void TimeseriesSubscriptionCmd.setStartTs(long)", "void TimeseriesSubscriptionCmd.setTimeWindow(long)",
      "String TimeseriesSubscriptionCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TimeseriesSubscriptionCmd actualTimeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd();
    actualTimeseriesSubscriptionCmd.setAgg("Agg");
    actualTimeseriesSubscriptionCmd.setInterval(42L);
    actualTimeseriesSubscriptionCmd.setLimit(1);
    actualTimeseriesSubscriptionCmd.setStartTs(1L);
    actualTimeseriesSubscriptionCmd.setTimeWindow(10L);
    String actualToStringResult = actualTimeseriesSubscriptionCmd.toString();
    String actualAgg = actualTimeseriesSubscriptionCmd.getAgg();
    long actualInterval = actualTimeseriesSubscriptionCmd.getInterval();
    int actualLimit = actualTimeseriesSubscriptionCmd.getLimit();
    long actualStartTs = actualTimeseriesSubscriptionCmd.getStartTs();
    long actualTimeWindow = actualTimeseriesSubscriptionCmd.getTimeWindow();
    WsCmdType actualType = actualTimeseriesSubscriptionCmd.getType();

    // Assert
    assertEquals("Agg", actualAgg);
    assertEquals("TimeseriesSubscriptionCmd(startTs=1, timeWindow=10, interval=42, limit=1, agg=Agg)",
        actualToStringResult);
    assertNull(actualTimeseriesSubscriptionCmd.getEntityId());
    assertNull(actualTimeseriesSubscriptionCmd.getEntityType());
    assertNull(actualTimeseriesSubscriptionCmd.getKeys());
    assertNull(actualTimeseriesSubscriptionCmd.getScope());
    assertEquals(0, actualTimeseriesSubscriptionCmd.getCmdId());
    assertEquals(1, actualLimit);
    assertEquals(10L, actualTimeWindow);
    assertEquals(1L, actualStartTs);
    assertEquals(42L, actualInterval);
    assertEquals(WsCmdType.TIMESERIES, actualType);
    assertFalse(actualTimeseriesSubscriptionCmd.isUnsubscribe());
  }

  /**
   * Test {@link TimeseriesSubscriptionCmd#TimeseriesSubscriptionCmd(long, long, long, int, String)}.
   * <p>
   * Method under test: {@link TimeseriesSubscriptionCmd#TimeseriesSubscriptionCmd(long, long, long, int, String)}
   */
  @Test
  @DisplayName("Test new TimeseriesSubscriptionCmd(long, long, long, int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeseriesSubscriptionCmd.<init>(long, long, long, int, String)"})
  void testNewTimeseriesSubscriptionCmd() {
    // Arrange and Act
    TimeseriesSubscriptionCmd actualTimeseriesSubscriptionCmd = new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg");

    // Assert
    assertEquals("Agg", actualTimeseriesSubscriptionCmd.getAgg());
    assertNull(actualTimeseriesSubscriptionCmd.getEntityId());
    assertNull(actualTimeseriesSubscriptionCmd.getEntityType());
    assertNull(actualTimeseriesSubscriptionCmd.getKeys());
    assertNull(actualTimeseriesSubscriptionCmd.getScope());
    assertEquals(0, actualTimeseriesSubscriptionCmd.getCmdId());
    assertEquals(1, actualTimeseriesSubscriptionCmd.getLimit());
    assertEquals(10L, actualTimeseriesSubscriptionCmd.getTimeWindow());
    assertEquals(1L, actualTimeseriesSubscriptionCmd.getStartTs());
    assertEquals(42L, actualTimeseriesSubscriptionCmd.getInterval());
    assertEquals(WsCmdType.TIMESERIES, actualTimeseriesSubscriptionCmd.getType());
    assertFalse(actualTimeseriesSubscriptionCmd.isUnsubscribe());
  }
}
