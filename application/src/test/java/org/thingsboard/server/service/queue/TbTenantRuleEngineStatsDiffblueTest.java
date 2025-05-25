package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbTenantRuleEngineStats.class, UUID.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TbTenantRuleEngineStatsDiffblueTest {
  @Autowired
  private TbTenantRuleEngineStats tbTenantRuleEngineStats;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link TbTenantRuleEngineStats#TbTenantRuleEngineStats(UUID)}.
   * <ul>
   *   <li>Then return Counters size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#TbTenantRuleEngineStats(UUID)}
   */
  @Test
  @DisplayName("Test new TbTenantRuleEngineStats(UUID); then return Counters size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.<init>(UUID)"})
  void testNewTbTenantRuleEngineStats_thenReturnCountersSizeIsSix() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbTenantRuleEngineStats actualTbTenantRuleEngineStats = new TbTenantRuleEngineStats(tenantId);

    // Assert
    Map<String, AtomicInteger> counters = actualTbTenantRuleEngineStats.getCounters();
    assertEquals(6, counters.size());
    AtomicInteger successMsgCounter = actualTbTenantRuleEngineStats.getSuccessMsgCounter();
    assertEquals(0, successMsgCounter.getAndDecrement());
    assertEquals(-1, successMsgCounter.getAndIncrement());
    assertSame(tenantId, actualTbTenantRuleEngineStats.getTenantId());
    AtomicInteger timeoutMsgCounter = actualTbTenantRuleEngineStats.getTimeoutMsgCounter();
    assertEquals(0, timeoutMsgCounter.get());
    AtomicInteger tmpFailedMsgCounter = actualTbTenantRuleEngineStats.getTmpFailedMsgCounter();
    assertEquals(0, tmpFailedMsgCounter.get());
    AtomicInteger tmpTimeoutMsgCounter = actualTbTenantRuleEngineStats.getTmpTimeoutMsgCounter();
    assertEquals(0, tmpTimeoutMsgCounter.get());
    AtomicInteger totalMsgCounter = actualTbTenantRuleEngineStats.getTotalMsgCounter();
    assertEquals(0, totalMsgCounter.get());
    assertSame(totalMsgCounter, counters.get(EdgeConsumerStats.TOTAL_MSGS));
    assertSame(successMsgCounter, counters.get(TbRuleEngineConsumerStats.SUCCESSFUL_MSGS));
    assertSame(tmpFailedMsgCounter, counters.get(TbRuleEngineConsumerStats.TMP_FAILED));
    assertSame(tmpTimeoutMsgCounter, counters.get(TbRuleEngineConsumerStats.TMP_TIMEOUT));
    assertSame(timeoutMsgCounter, counters.get(TbRuleEngineConsumerStats.TIMEOUT_MSGS));
  }

  /**
   * Test {@link TbTenantRuleEngineStats#logSuccess()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logSuccess()}
   */
  @Test
  @DisplayName("Test logSuccess()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.logSuccess()"})
  void testLogSuccess() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbTenantRuleEngineStats.logSuccess();

    // Assert
    AtomicInteger successMsgCounter = tbTenantRuleEngineStats.getSuccessMsgCounter();
    assertEquals(1, successMsgCounter.get());
    assertEquals(1, successMsgCounter.getAndDecrement());
    assertEquals(0, successMsgCounter.getAndIncrement());
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#logFailed()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logFailed()}
   */
  @Test
  @DisplayName("Test logFailed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.logFailed()"})
  void testLogFailed() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbTenantRuleEngineStats.logFailed();

    // Assert
    AtomicInteger failedMsgCounter = tbTenantRuleEngineStats.getFailedMsgCounter();
    assertEquals(1, failedMsgCounter.get());
    assertEquals(1, failedMsgCounter.getAndDecrement());
    assertEquals(0, failedMsgCounter.getAndIncrement());
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#logTimeout()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logTimeout()}
   */
  @Test
  @DisplayName("Test logTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.logTimeout()"})
  void testLogTimeout() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbTenantRuleEngineStats.logTimeout();

    // Assert
    AtomicInteger timeoutMsgCounter = tbTenantRuleEngineStats.getTimeoutMsgCounter();
    assertEquals(1, timeoutMsgCounter.get());
    assertEquals(1, timeoutMsgCounter.getAndDecrement());
    assertEquals(0, timeoutMsgCounter.getAndIncrement());
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#logTmpFailed()}.
   * <p>
   * Method under test: {@link TbTenantRuleEngineStats#logTmpFailed()}
   */
  @Test
  @DisplayName("Test logTmpFailed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.logTmpFailed()"})
  void testLogTmpFailed() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTenantRuleEngineStats.logTmpTimeout()"})
  void testLogTmpTimeout() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbTenantRuleEngineStats.logTmpTimeout();

    // Assert
    assertEquals(1, tbTenantRuleEngineStats.getTmpTimeoutMsgCounter().get());
    assertEquals(1, tbTenantRuleEngineStats.getTotalMsgCounter().get());
  }

  /**
   * Test {@link TbTenantRuleEngineStats#equals(Object)}, and {@link TbTenantRuleEngineStats#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats,
        new TbTenantRuleEngineStats(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats,
        new TbTenantRuleEngineStats(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(null);

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats,
        new TbTenantRuleEngineStats(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(null);

    // Act and Assert
    assertNotEquals(tbTenantRuleEngineStats, new TbTenantRuleEngineStats(null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTenantRuleEngineStats(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTenantRuleEngineStats.equals(Object)", "int TbTenantRuleEngineStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTenantRuleEngineStats(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        "Different type to TbTenantRuleEngineStats");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTenantRuleEngineStats#toString()}
   *   <li>{@link TbTenantRuleEngineStats#getCounters()}
   *   <li>{@link TbTenantRuleEngineStats#getFailedMsgCounter()}
   *   <li>{@link TbTenantRuleEngineStats#getSuccessMsgCounter()}
   *   <li>{@link TbTenantRuleEngineStats#getTenantId()}
   *   <li>{@link TbTenantRuleEngineStats#getTimeoutMsgCounter()}
   *   <li>{@link TbTenantRuleEngineStats#getTmpFailedMsgCounter()}
   *   <li>{@link TbTenantRuleEngineStats#getTmpTimeoutMsgCounter()}
   *   <li>{@link TbTenantRuleEngineStats#getTotalMsgCounter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbTenantRuleEngineStats.getCounters()",
      "AtomicInteger TbTenantRuleEngineStats.getFailedMsgCounter()",
      "AtomicInteger TbTenantRuleEngineStats.getSuccessMsgCounter()", "UUID TbTenantRuleEngineStats.getTenantId()",
      "AtomicInteger TbTenantRuleEngineStats.getTimeoutMsgCounter()",
      "AtomicInteger TbTenantRuleEngineStats.getTmpFailedMsgCounter()",
      "AtomicInteger TbTenantRuleEngineStats.getTmpTimeoutMsgCounter()",
      "AtomicInteger TbTenantRuleEngineStats.getTotalMsgCounter()", "String TbTenantRuleEngineStats.toString()"})
  void testGettersAndSetters() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbTenantRuleEngineStats tbTenantRuleEngineStats = new TbTenantRuleEngineStats(tenantId);

    // Act
    String actualToStringResult = tbTenantRuleEngineStats.toString();
    Map<String, AtomicInteger> actualCounters = tbTenantRuleEngineStats.getCounters();
    AtomicInteger actualFailedMsgCounter = tbTenantRuleEngineStats.getFailedMsgCounter();
    AtomicInteger actualSuccessMsgCounter = tbTenantRuleEngineStats.getSuccessMsgCounter();
    UUID actualTenantId = tbTenantRuleEngineStats.getTenantId();
    AtomicInteger actualTimeoutMsgCounter = tbTenantRuleEngineStats.getTimeoutMsgCounter();
    AtomicInteger actualTmpFailedMsgCounter = tbTenantRuleEngineStats.getTmpFailedMsgCounter();
    AtomicInteger actualTmpTimeoutMsgCounter = tbTenantRuleEngineStats.getTmpTimeoutMsgCounter();
    AtomicInteger actualTotalMsgCounter = tbTenantRuleEngineStats.getTotalMsgCounter();

    // Assert
    int actualSizeResult = actualCounters.size();
    AtomicInteger getResult = actualCounters.get(EdgeConsumerStats.TOTAL_MSGS);
    AtomicInteger getResult2 = actualCounters.get(TbRuleEngineConsumerStats.SUCCESSFUL_MSGS);
    AtomicInteger getResult3 = actualCounters.get(TbRuleEngineConsumerStats.FAILED_MSGS);
    AtomicInteger getResult4 = actualCounters.get(TbRuleEngineConsumerStats.TMP_FAILED);
    AtomicInteger getResult5 = actualCounters.get(TbRuleEngineConsumerStats.TMP_TIMEOUT);
    AtomicInteger getResult6 = actualCounters.get(TbRuleEngineConsumerStats.TIMEOUT_MSGS);
    int actualGetResult = getResult.get();
    int actualAndDecrement = getResult.getAndDecrement();
    int actualAndIncrement = getResult.getAndIncrement();
    int actualGetResult2 = getResult2.get();
    int actualAndDecrement2 = getResult2.getAndDecrement();
    int actualAndIncrement2 = getResult2.getAndIncrement();
    int actualGetResult3 = getResult3.get();
    int actualAndDecrement3 = getResult3.getAndDecrement();
    int actualAndIncrement3 = getResult3.getAndIncrement();
    int actualGetResult4 = getResult4.get();
    int actualAndDecrement4 = getResult4.getAndDecrement();
    int actualAndIncrement4 = getResult4.getAndIncrement();
    int actualGetResult5 = getResult5.get();
    int actualAndDecrement5 = getResult5.getAndDecrement();
    int actualAndIncrement5 = getResult5.getAndIncrement();
    int actualGetResult6 = getResult6.get();
    int actualAndDecrement6 = getResult6.getAndDecrement();
    int actualAndIncrement6 = getResult6.getAndIncrement();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "TbTenantRuleEngineStats(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, totalMsgCounter=0, successMsgCounter"
            + "=0, tmpTimeoutMsgCounter=0, tmpFailedMsgCounter=0, timeoutMsgCounter=0, failedMsgCounter=0,"
            + " counters={totalMsgs=0, successfulMsgs=0, failedMsgs=0, tmpFailed=0, tmpTimeout=0, timeoutMsgs=0})",
        actualToStringResult);
    assertEquals(6, actualSizeResult);
    assertEquals(-1, actualAndIncrement);
    assertEquals(-1, actualAndIncrement3);
    assertEquals(-1, actualAndIncrement2);
    assertEquals(-1, actualAndIncrement6);
    assertEquals(-1, actualAndIncrement4);
    assertEquals(-1, actualAndIncrement5);
    assertEquals(0, actualGetResult);
    assertEquals(0, actualGetResult3);
    assertEquals(0, actualGetResult2);
    assertEquals(0, actualGetResult6);
    assertEquals(0, actualGetResult4);
    assertEquals(0, actualGetResult5);
    assertEquals(0, actualAndDecrement);
    assertEquals(0, actualAndDecrement3);
    assertEquals(0, actualAndDecrement2);
    assertEquals(0, actualAndDecrement6);
    assertEquals(0, actualAndDecrement4);
    assertEquals(0, actualAndDecrement5);
    assertSame(getResult, actualTotalMsgCounter);
    assertSame(getResult3, actualFailedMsgCounter);
    assertSame(getResult2, actualSuccessMsgCounter);
    assertSame(getResult6, actualTimeoutMsgCounter);
    assertSame(getResult4, actualTmpFailedMsgCounter);
    assertSame(getResult5, actualTmpTimeoutMsgCounter);
    assertSame(tenantId, actualTenantId);
  }
}
