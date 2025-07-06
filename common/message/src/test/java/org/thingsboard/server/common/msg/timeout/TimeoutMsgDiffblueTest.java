package org.thingsboard.server.common.msg.timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimeoutMsgDiffblueTest {
  /**
   * Test {@link TimeoutMsg#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DeviceActorServerSideRpcTimeoutMsg(1, 10L).canEqual("Other"));
  }

  /**
   * Test {@link TimeoutMsg#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TimeoutMsg}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TimeoutMsg; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.canEqual(Object)"})
  void testCanEqual_whenTimeoutMsg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeviceActorServerSideRpcTimeoutMsg(1, 10L).canEqual(mock(TimeoutMsg.class)));
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}, and {@link TimeoutMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(1, 10L);
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg2 =
        new DeviceActorServerSideRpcTimeoutMsg(1, 10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg2);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg2.hashCode());
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}, and {@link TimeoutMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(null, 10L);
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg2 =
        new DeviceActorServerSideRpcTimeoutMsg(null, 10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg2);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg2.hashCode());
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}, and {@link TimeoutMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeoutMsg#equals(Object)}
   *   <li>{@link TimeoutMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(1, 10L);

    // Act and Assert
    assertEquals(deviceActorServerSideRpcTimeoutMsg, deviceActorServerSideRpcTimeoutMsg);
    int expectedHashCodeResult = deviceActorServerSideRpcTimeoutMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceActorServerSideRpcTimeoutMsg.hashCode());
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(2, 10L);

    // Act and Assert
    assertNotEquals(
        deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(null, 10L);

    // Act and Assert
    assertNotEquals(
        deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceActorServerSideRpcTimeoutMsg deviceActorServerSideRpcTimeoutMsg =
        new DeviceActorServerSideRpcTimeoutMsg(1, 1L);

    // Act and Assert
    assertNotEquals(
        deviceActorServerSideRpcTimeoutMsg, new DeviceActorServerSideRpcTimeoutMsg(1, 10L));
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceActorServerSideRpcTimeoutMsg(1, 10L), null);
  }

  /**
   * Test {@link TimeoutMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimeoutMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TimeoutMsg.equals(Object)", "int TimeoutMsg.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceActorServerSideRpcTimeoutMsg(1, 10L), "Different type to TimeoutMsg");
  }

  /**
   * Test {@link TimeoutMsg#getId()}.
   *
   * <p>Method under test: {@link TimeoutMsg#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TimeoutMsg.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(1, new DeviceActorServerSideRpcTimeoutMsg(1, 10L).getId().intValue());
  }

  /**
   * Test {@link TimeoutMsg#getTimeout()}.
   *
   * <p>Method under test: {@link TimeoutMsg#getTimeout()}
   */
  @Test
  @DisplayName("Test getTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TimeoutMsg.getTimeout()"})
  void testGetTimeout() {
    // Arrange, Act and Assert
    assertEquals(10L, new DeviceActorServerSideRpcTimeoutMsg(1, 10L).getTimeout());
  }

  /**
   * Test {@link TimeoutMsg#toString()}.
   *
   * <p>Method under test: {@link TimeoutMsg#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TimeoutMsg.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "TimeoutMsg(id=1, timeout=10)", new DeviceActorServerSideRpcTimeoutMsg(1, 10L).toString());
  }
}
