package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmStatusDiffblueTest {
  /**
   * Test {@link AlarmStatus#isAck()}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE_UNACK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isAck()}
   */
  @Test
  @DisplayName("Test isAck(); given 'ACTIVE_UNACK'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isAck()"})
  void testIsAck_givenActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatus.ACTIVE_UNACK.isAck());
  }

  /**
   * Test {@link AlarmStatus#isAck()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#ACTIVE_ACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isAck()}
   */
  @Test
  @DisplayName("Test isAck(); given ACTIVE_ACK; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isAck()"})
  void testIsAck_givenActive_ack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatus.ACTIVE_ACK.isAck());
  }

  /**
   * Test {@link AlarmStatus#isAck()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_ACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isAck()}
   */
  @Test
  @DisplayName("Test isAck(); given CLEARED_ACK; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isAck()"})
  void testIsAck_givenCleared_ack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatus.CLEARED_ACK.isAck());
  }

  /**
   * Test {@link AlarmStatus#isCleared()}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE_UNACK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isCleared()}
   */
  @Test
  @DisplayName("Test isCleared(); given 'ACTIVE_UNACK'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isCleared()"})
  void testIsCleared_givenActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatus.ACTIVE_UNACK.isCleared());
  }

  /**
   * Test {@link AlarmStatus#isCleared()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_ACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isCleared()}
   */
  @Test
  @DisplayName("Test isCleared(); given CLEARED_ACK; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isCleared()"})
  void testIsCleared_givenCleared_ack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatus.CLEARED_ACK.isCleared());
  }

  /**
   * Test {@link AlarmStatus#isCleared()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_UNACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#isCleared()}
   */
  @Test
  @DisplayName("Test isCleared(); given CLEARED_UNACK; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmStatus.isCleared()"})
  void testIsCleared_givenCleared_unack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatus.CLEARED_UNACK.isCleared());
  }

  /**
   * Test {@link AlarmStatus#getClearSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE_UNACK}.
   *   <li>Then return {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getClearSearchStatus()}
   */
  @Test
  @DisplayName("Test getClearSearchStatus(); given 'ACTIVE_UNACK'; then return 'ACTIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getClearSearchStatus()"})
  void testGetClearSearchStatus_givenActiveUnack_thenReturnActive() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK.getClearSearchStatus());
  }

  /**
   * Test {@link AlarmStatus#getClearSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_ACK}.
   *   <li>Then return {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getClearSearchStatus()}
   */
  @Test
  @DisplayName("Test getClearSearchStatus(); given CLEARED_ACK; then return 'CLEARED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getClearSearchStatus()"})
  void testGetClearSearchStatus_givenCleared_ack_thenReturnCleared() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.CLEARED, AlarmStatus.CLEARED_ACK.getClearSearchStatus());
  }

  /**
   * Test {@link AlarmStatus#getClearSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_UNACK}.
   *   <li>Then return {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getClearSearchStatus()}
   */
  @Test
  @DisplayName("Test getClearSearchStatus(); given CLEARED_UNACK; then return 'CLEARED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getClearSearchStatus()"})
  void testGetClearSearchStatus_givenCleared_unack_thenReturnCleared() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.CLEARED, AlarmStatus.CLEARED_UNACK.getClearSearchStatus());
  }

  /**
   * Test {@link AlarmStatus#getAckSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE_UNACK}.
   *   <li>Then return {@code UNACK}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getAckSearchStatus()}
   */
  @Test
  @DisplayName("Test getAckSearchStatus(); given 'ACTIVE_UNACK'; then return 'UNACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getAckSearchStatus()"})
  void testGetAckSearchStatus_givenActiveUnack_thenReturnUnack() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.UNACK, AlarmStatus.ACTIVE_UNACK.getAckSearchStatus());
  }

  /**
   * Test {@link AlarmStatus#getAckSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#ACTIVE_ACK}.
   *   <li>Then return {@code ACK}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getAckSearchStatus()}
   */
  @Test
  @DisplayName("Test getAckSearchStatus(); given ACTIVE_ACK; then return 'ACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getAckSearchStatus()"})
  void testGetAckSearchStatus_givenActive_ack_thenReturnAck() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_ACK.getAckSearchStatus());
  }

  /**
   * Test {@link AlarmStatus#getAckSearchStatus()}.
   *
   * <ul>
   *   <li>Given {@link AlarmStatus#CLEARED_ACK}.
   *   <li>Then return {@code ACK}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatus#getAckSearchStatus()}
   */
  @Test
  @DisplayName("Test getAckSearchStatus(); given CLEARED_ACK; then return 'ACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSearchStatus AlarmStatus.getAckSearchStatus()"})
  void testGetAckSearchStatus_givenCleared_ack_thenReturnAck() {
    // Arrange, Act and Assert
    assertEquals(AlarmSearchStatus.ACK, AlarmStatus.CLEARED_ACK.getAckSearchStatus());
  }
}
