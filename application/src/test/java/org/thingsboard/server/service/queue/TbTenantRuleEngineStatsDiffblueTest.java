package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbTenantRuleEngineStatsDiffblueTest {
  /**
   * Test {@link TbTenantRuleEngineStats#logTmpFailed()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logTmpFailed()}
   */
  @Test
  @DisplayName("Test logTmpFailed()")
  void testLogTmpFailed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(UUID.randomUUID());

    // Act
    tbTenantRuleEngineStats.logTmpFailed();

    // Assert
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#logTmpTimeout()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logTmpTimeout()}
   */
  @Test
  @DisplayName("Test logTmpTimeout()")
  void testLogTmpTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(UUID.randomUUID());

    // Act
    tbTenantRuleEngineStats.logTmpTimeout();

    // Assert
    assertEquals(1, tbTenantRuleEngineStats.getTmpTimeoutMsgCounter().get());
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}, and
   * {@link TbTenantRuleEngineStats#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTenantRuleEngineStats#equals(Object)}
   *   <li>{@link TbTenantRuleEngineStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(UUID.randomUUID());

    // Act and Assert
    assertEquals(tbTenantRuleEngineStats, tbTenantRuleEngineStats);
    int expectedHashCodeResult = tbTenantRuleEngineStats.hashCode();
    assertEquals(expectedHashCodeResult, tbTenantRuleEngineStats.hashCode());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats, new TbTenantRuleEngineStats(UUID.randomUUID()));
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(null);

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats, new TbTenantRuleEngineStats(UUID.randomUUID()));
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(null);

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats, new TbTenantRuleEngineStats(null));
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(new UUID(1L, 1L));

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats, new TbTenantRuleEngineStats(new UUID(1L, 1L)));
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTenantRuleEngineStats(UUID.randomUUID()), null);
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTenantRuleEngineStats(UUID.randomUUID()), "Different type to TbTenantRuleEngineStats");
  }
}
