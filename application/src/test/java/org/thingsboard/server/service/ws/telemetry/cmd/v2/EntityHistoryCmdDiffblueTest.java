package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.IntervalType;

class EntityHistoryCmdDiffblueTest {
  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd2);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd2.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setKeys(new ArrayList<>());

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd2);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd2.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setIntervalType(IntervalType.MILLISECONDS);

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd2);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd2.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setTimeZoneId("UTC");

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setTimeZoneId("UTC");

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd2);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd2.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setAgg(Aggregation.MIN);

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setAgg(Aggregation.MIN);

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd2);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd2.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}, and {@link EntityHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityHistoryCmd#equals(Object)}
   *   <li>{@link EntityHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();

    // Act and Assert
    assertEquals(entityHistoryCmd, entityHistoryCmd);
    int expectedHashCodeResult = entityHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityHistoryCmd.hashCode());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityHistoryCmd(), 1);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setStartTs(1L);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setEndTs(1L);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setInterval(42L);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setTimeZoneId("UTC");

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setLimit(1);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setAgg(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();
    entityHistoryCmd.setFetchLatestPreviousPoint(true);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, new EntityHistoryCmd());
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setKeys(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityHistoryCmd, entityHistoryCmd2);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setIntervalType(IntervalType.MILLISECONDS);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, entityHistoryCmd2);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setTimeZoneId("UTC");

    // Act and Assert
    assertNotEquals(entityHistoryCmd, entityHistoryCmd2);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityHistoryCmd entityHistoryCmd = new EntityHistoryCmd();

    EntityHistoryCmd entityHistoryCmd2 = new EntityHistoryCmd();
    entityHistoryCmd2.setAgg(Aggregation.MIN);

    // Act and Assert
    assertNotEquals(entityHistoryCmd, entityHistoryCmd2);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityHistoryCmd(), null);
  }

  /**
   * Test {@link EntityHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityHistoryCmd.equals(Object)", "int EntityHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityHistoryCmd(), "Different type to EntityHistoryCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityHistoryCmd}
   *   <li>{@link EntityHistoryCmd#setAgg(Aggregation)}
   *   <li>{@link EntityHistoryCmd#setEndTs(long)}
   *   <li>{@link EntityHistoryCmd#setFetchLatestPreviousPoint(boolean)}
   *   <li>{@link EntityHistoryCmd#setInterval(long)}
   *   <li>{@link EntityHistoryCmd#setIntervalType(IntervalType)}
   *   <li>{@link EntityHistoryCmd#setKeys(List)}
   *   <li>{@link EntityHistoryCmd#setLimit(int)}
   *   <li>{@link EntityHistoryCmd#setStartTs(long)}
   *   <li>{@link EntityHistoryCmd#setTimeZoneId(String)}
   *   <li>{@link EntityHistoryCmd#toString()}
   *   <li>{@link EntityHistoryCmd#getAgg()}
   *   <li>{@link EntityHistoryCmd#getEndTs()}
   *   <li>{@link EntityHistoryCmd#getInterval()}
   *   <li>{@link EntityHistoryCmd#getIntervalType()}
   *   <li>{@link EntityHistoryCmd#getKeys()}
   *   <li>{@link EntityHistoryCmd#getLimit()}
   *   <li>{@link EntityHistoryCmd#getStartTs()}
   *   <li>{@link EntityHistoryCmd#getTimeZoneId()}
   *   <li>{@link EntityHistoryCmd#isFetchLatestPreviousPoint()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityHistoryCmd.<init>()", "Aggregation EntityHistoryCmd.getAgg()",
      "long EntityHistoryCmd.getEndTs()", "long EntityHistoryCmd.getInterval()",
      "IntervalType EntityHistoryCmd.getIntervalType()", "List EntityHistoryCmd.getKeys()",
      "int EntityHistoryCmd.getLimit()", "long EntityHistoryCmd.getStartTs()",
      "String EntityHistoryCmd.getTimeZoneId()", "boolean EntityHistoryCmd.isFetchLatestPreviousPoint()",
      "void EntityHistoryCmd.setAgg(Aggregation)", "void EntityHistoryCmd.setEndTs(long)",
      "void EntityHistoryCmd.setFetchLatestPreviousPoint(boolean)", "void EntityHistoryCmd.setInterval(long)",
      "void EntityHistoryCmd.setIntervalType(IntervalType)", "void EntityHistoryCmd.setKeys(List)",
      "void EntityHistoryCmd.setLimit(int)", "void EntityHistoryCmd.setStartTs(long)",
      "void EntityHistoryCmd.setTimeZoneId(String)", "String EntityHistoryCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityHistoryCmd actualEntityHistoryCmd = new EntityHistoryCmd();
    actualEntityHistoryCmd.setAgg(Aggregation.MIN);
    actualEntityHistoryCmd.setEndTs(1L);
    actualEntityHistoryCmd.setFetchLatestPreviousPoint(true);
    actualEntityHistoryCmd.setInterval(42L);
    actualEntityHistoryCmd.setIntervalType(IntervalType.MILLISECONDS);
    ArrayList<String> keys = new ArrayList<>();
    actualEntityHistoryCmd.setKeys(keys);
    actualEntityHistoryCmd.setLimit(1);
    actualEntityHistoryCmd.setStartTs(1L);
    actualEntityHistoryCmd.setTimeZoneId("UTC");
    String actualToStringResult = actualEntityHistoryCmd.toString();
    Aggregation actualAgg = actualEntityHistoryCmd.getAgg();
    long actualEndTs = actualEntityHistoryCmd.getEndTs();
    long actualInterval = actualEntityHistoryCmd.getInterval();
    IntervalType actualIntervalType = actualEntityHistoryCmd.getIntervalType();
    List<String> actualKeys = actualEntityHistoryCmd.getKeys();
    int actualLimit = actualEntityHistoryCmd.getLimit();
    long actualStartTs = actualEntityHistoryCmd.getStartTs();
    String actualTimeZoneId = actualEntityHistoryCmd.getTimeZoneId();
    boolean actualIsFetchLatestPreviousPointResult = actualEntityHistoryCmd.isFetchLatestPreviousPoint();

    // Assert
    assertEquals("EntityHistoryCmd(keys=[], startTs=1, endTs=1, intervalType=MILLISECONDS, interval=42, timeZoneId=UTC,"
        + " limit=1, agg=MIN, fetchLatestPreviousPoint=true)", actualToStringResult);
    assertEquals("UTC", actualTimeZoneId);
    assertEquals(1, actualLimit);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, actualStartTs);
    assertEquals(42L, actualInterval);
    assertEquals(Aggregation.MIN, actualAgg);
    assertEquals(IntervalType.MILLISECONDS, actualIntervalType);
    assertTrue(actualKeys.isEmpty());
    assertTrue(actualIsFetchLatestPreviousPointResult);
    assertSame(keys, actualKeys);
  }
}
