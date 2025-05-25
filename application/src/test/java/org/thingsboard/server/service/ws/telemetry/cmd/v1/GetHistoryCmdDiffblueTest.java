package org.thingsboard.server.service.ws.telemetry.cmd.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.ws.WsCmdType;

@ContextConfiguration(classes = {GetHistoryCmd.class})
@ExtendWith(SpringExtension.class)
class GetHistoryCmdDiffblueTest {
  @Autowired
  private GetHistoryCmd getHistoryCmd;

  /**
   * Test {@link GetHistoryCmd#equals(Object)}, and {@link GetHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetHistoryCmd#equals(Object)}
   *   <li>{@link GetHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg");
    GetHistoryCmd getHistoryCmd2 = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(getHistoryCmd, getHistoryCmd2);
    int expectedHashCodeResult = getHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, getHistoryCmd2.hashCode());
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}, and {@link GetHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetHistoryCmd#equals(Object)}
   *   <li>{@link GetHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, null, "42", "Keys", 1L, 1L, 42L, 1, "Agg");
    GetHistoryCmd getHistoryCmd2 = new GetHistoryCmd(1, null, "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(getHistoryCmd, getHistoryCmd2);
    int expectedHashCodeResult = getHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, getHistoryCmd2.hashCode());
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}, and {@link GetHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetHistoryCmd#equals(Object)}
   *   <li>{@link GetHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", null, "Keys", 1L, 1L, 42L, 1, "Agg");
    GetHistoryCmd getHistoryCmd2 = new GetHistoryCmd(1, "Entity Type", null, "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(getHistoryCmd, getHistoryCmd2);
    int expectedHashCodeResult = getHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, getHistoryCmd2.hashCode());
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}, and {@link GetHistoryCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetHistoryCmd#equals(Object)}
   *   <li>{@link GetHistoryCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertEquals(getHistoryCmd, getHistoryCmd);
    int expectedHashCodeResult = getHistoryCmd.hashCode();
    assertEquals(expectedHashCodeResult, getHistoryCmd.hashCode());
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(2, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "42", "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, null, "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "Entity Type", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", null, "Keys", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Entity Type", 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", null, 1L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 3L, 1L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 3L, 42L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 1L, 1, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 3, "Agg");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Entity Type");

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    GetHistoryCmd getHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, null);

    // Act and Assert
    assertNotEquals(getHistoryCmd, new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"), null);
  }

  /**
   * Test {@link GetHistoryCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetHistoryCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetHistoryCmd.equals(Object)", "int GetHistoryCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg"),
        "Different type to GetHistoryCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetHistoryCmd#GetHistoryCmd()}
   *   <li>{@link GetHistoryCmd#setAgg(String)}
   *   <li>{@link GetHistoryCmd#setCmdId(int)}
   *   <li>{@link GetHistoryCmd#setEndTs(long)}
   *   <li>{@link GetHistoryCmd#setEntityId(String)}
   *   <li>{@link GetHistoryCmd#setEntityType(String)}
   *   <li>{@link GetHistoryCmd#setInterval(long)}
   *   <li>{@link GetHistoryCmd#setKeys(String)}
   *   <li>{@link GetHistoryCmd#setLimit(int)}
   *   <li>{@link GetHistoryCmd#setStartTs(long)}
   *   <li>{@link GetHistoryCmd#toString()}
   *   <li>{@link GetHistoryCmd#getAgg()}
   *   <li>{@link GetHistoryCmd#getCmdId()}
   *   <li>{@link GetHistoryCmd#getEndTs()}
   *   <li>{@link GetHistoryCmd#getEntityId()}
   *   <li>{@link GetHistoryCmd#getEntityType()}
   *   <li>{@link GetHistoryCmd#getInterval()}
   *   <li>{@link GetHistoryCmd#getKeys()}
   *   <li>{@link GetHistoryCmd#getLimit()}
   *   <li>{@link GetHistoryCmd#getStartTs()}
   *   <li>{@link GetHistoryCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetHistoryCmd.<init>()", "String GetHistoryCmd.getAgg()", "int GetHistoryCmd.getCmdId()",
      "long GetHistoryCmd.getEndTs()", "String GetHistoryCmd.getEntityId()", "String GetHistoryCmd.getEntityType()",
      "long GetHistoryCmd.getInterval()", "String GetHistoryCmd.getKeys()", "int GetHistoryCmd.getLimit()",
      "long GetHistoryCmd.getStartTs()", "WsCmdType GetHistoryCmd.getType()", "void GetHistoryCmd.setAgg(String)",
      "void GetHistoryCmd.setCmdId(int)", "void GetHistoryCmd.setEndTs(long)", "void GetHistoryCmd.setEntityId(String)",
      "void GetHistoryCmd.setEntityType(String)", "void GetHistoryCmd.setInterval(long)",
      "void GetHistoryCmd.setKeys(String)", "void GetHistoryCmd.setLimit(int)", "void GetHistoryCmd.setStartTs(long)",
      "String GetHistoryCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetHistoryCmd actualGetHistoryCmd = new GetHistoryCmd();
    actualGetHistoryCmd.setAgg("Agg");
    actualGetHistoryCmd.setCmdId(1);
    actualGetHistoryCmd.setEndTs(1L);
    actualGetHistoryCmd.setEntityId("42");
    actualGetHistoryCmd.setEntityType("Entity Type");
    actualGetHistoryCmd.setInterval(42L);
    actualGetHistoryCmd.setKeys("Keys");
    actualGetHistoryCmd.setLimit(1);
    actualGetHistoryCmd.setStartTs(1L);
    String actualToStringResult = actualGetHistoryCmd.toString();
    String actualAgg = actualGetHistoryCmd.getAgg();
    int actualCmdId = actualGetHistoryCmd.getCmdId();
    long actualEndTs = actualGetHistoryCmd.getEndTs();
    String actualEntityId = actualGetHistoryCmd.getEntityId();
    String actualEntityType = actualGetHistoryCmd.getEntityType();
    long actualInterval = actualGetHistoryCmd.getInterval();
    String actualKeys = actualGetHistoryCmd.getKeys();
    int actualLimit = actualGetHistoryCmd.getLimit();
    long actualStartTs = actualGetHistoryCmd.getStartTs();

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("Agg", actualAgg);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(
        "GetHistoryCmd(cmdId=1, entityType=Entity Type, entityId=42, keys=Keys, startTs=1, endTs=1, interval=42,"
            + " limit=1, agg=Agg)",
        actualToStringResult);
    assertEquals("Keys", actualKeys);
    assertEquals(1, actualCmdId);
    assertEquals(1, actualLimit);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, actualStartTs);
    assertEquals(42L, actualInterval);
    assertEquals(WsCmdType.TIMESERIES_HISTORY, actualGetHistoryCmd.getType());
  }

  /**
   * Test {@link GetHistoryCmd#GetHistoryCmd(int, String, String, String, long, long, long, int, String)}.
   * <p>
   * Method under test: {@link GetHistoryCmd#GetHistoryCmd(int, String, String, String, long, long, long, int, String)}
   */
  @Test
  @DisplayName("Test new GetHistoryCmd(int, String, String, String, long, long, long, int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetHistoryCmd.<init>(int, String, String, String, long, long, long, int, String)"})
  void testNewGetHistoryCmd() {
    // Arrange and Act
    GetHistoryCmd actualGetHistoryCmd = new GetHistoryCmd(1, "Entity Type", "42", "Keys", 1L, 1L, 42L, 1, "Agg");

    // Assert
    assertEquals("42", actualGetHistoryCmd.getEntityId());
    assertEquals("Agg", actualGetHistoryCmd.getAgg());
    assertEquals("Entity Type", actualGetHistoryCmd.getEntityType());
    assertEquals("Keys", actualGetHistoryCmd.getKeys());
    assertEquals(1, actualGetHistoryCmd.getCmdId());
    assertEquals(1, actualGetHistoryCmd.getLimit());
    assertEquals(1L, actualGetHistoryCmd.getEndTs());
    assertEquals(1L, actualGetHistoryCmd.getStartTs());
    assertEquals(42L, actualGetHistoryCmd.getInterval());
    assertEquals(WsCmdType.TIMESERIES_HISTORY, actualGetHistoryCmd.getType());
  }
}
