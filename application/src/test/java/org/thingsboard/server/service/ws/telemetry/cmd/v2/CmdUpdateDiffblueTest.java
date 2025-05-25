package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CmdUpdateDiffblueTest {
  /**
   * Test {@link CmdUpdate#canEqual(Object)}.
   * <ul>
   *   <li>When {@link AlarmCountUpdate#AlarmCountUpdate(int, int)} with cmdId is one and count is three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when AlarmCountUpdate(int, int) with cmdId is one and count is three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.canEqual(Object)"})
  void testCanEqual_whenAlarmCountUpdateWithCmdIdIsOneAndCountIsThree_thenReturnTrue() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);

    // Act and Assert
    assertTrue(alarmCountUpdate.canEqual(new AlarmCountUpdate(1, 3)));
  }

  /**
   * Test {@link CmdUpdate#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmCountUpdate(1, 3)).canEqual("Other"));
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}, and {@link CmdUpdate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CmdUpdate#equals(Object)}
   *   <li>{@link CmdUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);
    AlarmCountUpdate alarmCountUpdate2 = new AlarmCountUpdate(1, 3);

    // Act and Assert
    assertEquals(alarmCountUpdate, alarmCountUpdate2);
    int expectedHashCodeResult = alarmCountUpdate.hashCode();
    assertEquals(expectedHashCodeResult, alarmCountUpdate2.hashCode());
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}, and {@link CmdUpdate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CmdUpdate#equals(Object)}
   *   <li>{@link CmdUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, -1, "An error occurred");
    AlarmDataUpdate alarmDataUpdate = mock(AlarmDataUpdate.class);
    when(alarmDataUpdate.getErrorCode()).thenReturn(-1);
    when(alarmDataUpdate.getErrorMsg()).thenReturn("An error occurred");
    when(alarmDataUpdate.getCmdId()).thenReturn(1);
    when(alarmDataUpdate.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCountUpdate, alarmDataUpdate);
    int notExpectedHashCodeResult = alarmCountUpdate.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmDataUpdate.hashCode());
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}, and {@link CmdUpdate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CmdUpdate#equals(Object)}
   *   <li>{@link CmdUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);

    // Act and Assert
    assertEquals(alarmCountUpdate, alarmCountUpdate);
    int expectedHashCodeResult = alarmCountUpdate.hashCode();
    assertEquals(expectedHashCodeResult, alarmCountUpdate.hashCode());
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(2, 3);

    // Act and Assert
    assertNotEquals(alarmCountUpdate, new AlarmCountUpdate(1, 3));
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, -1, "An error occurred");

    // Act and Assert
    assertNotEquals(alarmCountUpdate, new AlarmCountUpdate(1, 3));
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);
    AlarmDataUpdate alarmDataUpdate = mock(AlarmDataUpdate.class);
    when(alarmDataUpdate.getErrorCode()).thenReturn(-1);
    when(alarmDataUpdate.getErrorMsg()).thenReturn("An error occurred");
    when(alarmDataUpdate.getCmdId()).thenReturn(1);
    when(alarmDataUpdate.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCountUpdate, alarmDataUpdate);
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);
    AlarmDataUpdate alarmDataUpdate = mock(AlarmDataUpdate.class);
    when(alarmDataUpdate.getErrorCode()).thenReturn(0);
    when(alarmDataUpdate.getErrorMsg()).thenReturn("An error occurred");
    when(alarmDataUpdate.getCmdId()).thenReturn(1);
    when(alarmDataUpdate.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCountUpdate, alarmDataUpdate);
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, 3);
    AlarmDataUpdate alarmDataUpdate = mock(AlarmDataUpdate.class);
    when(alarmDataUpdate.getErrorCode()).thenReturn(-1);
    when(alarmDataUpdate.getErrorMsg()).thenReturn("An error occurred");
    when(alarmDataUpdate.getCmdId()).thenReturn(1);
    when(alarmDataUpdate.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(alarmCountUpdate, alarmDataUpdate);
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCountUpdate alarmCountUpdate = new AlarmCountUpdate(1, -1, "Error Msg");
    AlarmDataUpdate alarmDataUpdate = mock(AlarmDataUpdate.class);
    when(alarmDataUpdate.getErrorCode()).thenReturn(-1);
    when(alarmDataUpdate.getErrorMsg()).thenReturn("An error occurred");
    when(alarmDataUpdate.getCmdId()).thenReturn(1);
    when(alarmDataUpdate.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCountUpdate, alarmDataUpdate);
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCountUpdate(1, 3), null);
  }

  /**
   * Test {@link CmdUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CmdUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CmdUpdate.equals(Object)", "int CmdUpdate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCountUpdate(1, 3), "Different type to CmdUpdate");
  }

  /**
   * Test {@link CmdUpdate#getCmdId()}.
   * <p>
   * Method under test: {@link CmdUpdate#getCmdId()}
   */
  @Test
  @DisplayName("Test getCmdId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CmdUpdate.getCmdId()"})
  void testGetCmdId() {
    // Arrange, Act and Assert
    assertEquals(1, (new AlarmCountUpdate(1, 3)).getCmdId());
  }

  /**
   * Test {@link CmdUpdate#getErrorCode()}.
   * <p>
   * Method under test: {@link CmdUpdate#getErrorCode()}
   */
  @Test
  @DisplayName("Test getErrorCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CmdUpdate.getErrorCode()"})
  void testGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(0, (new AlarmCountUpdate(1, 3)).getErrorCode());
  }

  /**
   * Test {@link CmdUpdate#getErrorMsg()}.
   * <p>
   * Method under test: {@link CmdUpdate#getErrorMsg()}
   */
  @Test
  @DisplayName("Test getErrorMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CmdUpdate.getErrorMsg()"})
  void testGetErrorMsg() {
    // Arrange, Act and Assert
    assertNull((new AlarmCountUpdate(1, 3)).getErrorMsg());
  }

  /**
   * Test {@link CmdUpdate#toString()}.
   * <p>
   * Method under test: {@link CmdUpdate#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CmdUpdate.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmCountUpdate(count=3)", (new AlarmCountUpdate(1, 3)).toString());
  }
}
