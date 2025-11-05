package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;

class TbCoapClientStateDiffblueTest {
  /**
   * Test {@link TbCoapClientState#lock()}.
   *
   * <ul>
   *   <li>Then {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       Lock {@link ReentrantLock}.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#lock()}
   */
  @Test
  @DisplayName(
      "Test lock(); then TbCoapClientState(DeviceId) with deviceId is 'null' Lock ReentrantLock")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapClientState.lock()"})
  void testLock_thenTbCoapClientStateWithDeviceIdIsNullLockReentrantLock() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act
    tbCoapClientState.lock();

    // Assert
    Lock lock = tbCoapClientState.getLock();
    assertTrue(lock instanceof ReentrantLock);
    assertTrue(((ReentrantLock) lock).isLocked());
  }

  /**
   * Test {@link TbCoapClientState#updateLastUplinkTime(long)}.
   *
   * <p>Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  @DisplayName("Test updateLastUplinkTime(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbCoapClientState.updateLastUplinkTime(long)"})
  void testUpdateLastUplinkTime() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setLastUplinkTime(1L);

    // Act
    long actualUpdateLastUplinkTimeResult = tbCoapClientState.updateLastUplinkTime(1L);

    // Assert
    assertEquals(1L, tbCoapClientState.getLastUplinkTime());
    assertEquals(1L, actualUpdateLastUplinkTimeResult);
  }

  /**
   * Test {@link TbCoapClientState#updateLastUplinkTime(long)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  @DisplayName(
      "Test updateLastUplinkTime(long); given TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbCoapClientState.updateLastUplinkTime(long)"})
  void testUpdateLastUplinkTime_givenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act
    long actualUpdateLastUplinkTimeResult = tbCoapClientState.updateLastUplinkTime(1L);

    // Assert
    assertEquals(1L, tbCoapClientState.getLastUplinkTime());
    assertEquals(1L, actualUpdateLastUplinkTimeResult);
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbCoapClientState tbCoapClientState = new TbCoapClientState(deviceId);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapClientState(null), 1);
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbCoapClientState tbCoapClientState = new TbCoapClientState(deviceId);
    DeviceId deviceId2 = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(deviceId2));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setContentFormat(1);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setEdrxCycle(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setPagingTransmissionWindow(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setLastUplinkTime(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    tbCoapClientState.setAsleep(true);

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(null));
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    TbCoapClientState tbCoapClientState2 = new TbCoapClientState(null);
    tbCoapClientState2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, tbCoapClientState2);
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    TbCoapClientState tbCoapClientState2 = new TbCoapClientState(null);
    tbCoapClientState2.setEdrxCycle(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, tbCoapClientState2);
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    TbCoapClientState tbCoapClientState2 = new TbCoapClientState(null);
    tbCoapClientState2.setPagingTransmissionWindow(1L);

    // Act and Assert
    assertNotEquals(tbCoapClientState, tbCoapClientState2);
  }

  /**
   * Test {@link TbCoapClientState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapClientState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapClientState.equals(Object)",
    "int TbCoapClientState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbCoapClientState, new TbCoapClientState(deviceId));
  }
}
