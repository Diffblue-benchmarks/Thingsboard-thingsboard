package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.service.queue.ruleengine.TbRuleEngineConsumerContext;

@ExtendWith(MockitoExtension.class)
class DefaultTbRuleEngineConsumerServiceDiffblueTest {
  @InjectMocks
  private DefaultTbRuleEngineConsumerService defaultTbRuleEngineConsumerService;

  @Mock
  private TbRuleEngineConsumerContext tbRuleEngineConsumerContext;

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbRuleEngineConsumerService.getNotificationPollDuration()"})
  void testGetNotificationPollDuration_thenReturnOne() {
    // Arrange
    when(tbRuleEngineConsumerContext.getPollDuration()).thenReturn(1L);

    // Act
    long actualNotificationPollDuration = defaultTbRuleEngineConsumerService.getNotificationPollDuration();

    // Assert
    verify(tbRuleEngineConsumerContext).getPollDuration();
    assertEquals(1L, actualNotificationPollDuration);
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbRuleEngineConsumerService.getNotificationPollDuration()"})
  void testGetNotificationPollDuration_thenThrowRuntimeException() {
    // Arrange
    when(tbRuleEngineConsumerContext.getPollDuration()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbRuleEngineConsumerService.getNotificationPollDuration());
    verify(tbRuleEngineConsumerContext).getPollDuration();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbRuleEngineConsumerService.getNotificationPackProcessingTimeout()"})
  void testGetNotificationPackProcessingTimeout_thenReturnOne() {
    // Arrange
    when(tbRuleEngineConsumerContext.getPackProcessingTimeout()).thenReturn(1L);

    // Act
    long actualNotificationPackProcessingTimeout = defaultTbRuleEngineConsumerService
        .getNotificationPackProcessingTimeout();

    // Assert
    verify(tbRuleEngineConsumerContext).getPackProcessingTimeout();
    assertEquals(1L, actualNotificationPackProcessingTimeout);
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DefaultTbRuleEngineConsumerService.getNotificationPackProcessingTimeout()"})
  void testGetNotificationPackProcessingTimeout_thenThrowRuntimeException() {
    // Arrange
    when(tbRuleEngineConsumerContext.getPackProcessingTimeout()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbRuleEngineConsumerService.getNotificationPackProcessingTimeout());
    verify(tbRuleEngineConsumerContext).getPackProcessingTimeout();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize(); then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefaultTbRuleEngineConsumerService.getMgmtThreadPoolSize()"})
  void testGetMgmtThreadPoolSize_thenReturnThree() {
    // Arrange
    when(tbRuleEngineConsumerContext.getMgmtThreadPoolSize()).thenReturn(3);

    // Act
    int actualMgmtThreadPoolSize = defaultTbRuleEngineConsumerService.getMgmtThreadPoolSize();

    // Assert
    verify(tbRuleEngineConsumerContext).getMgmtThreadPoolSize();
    assertEquals(3, actualMgmtThreadPoolSize);
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefaultTbRuleEngineConsumerService.getMgmtThreadPoolSize()"})
  void testGetMgmtThreadPoolSize_thenThrowRuntimeException() {
    // Arrange
    when(tbRuleEngineConsumerContext.getMgmtThreadPoolSize()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbRuleEngineConsumerService.getMgmtThreadPoolSize());
    verify(tbRuleEngineConsumerContext).getMgmtThreadPoolSize();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Given {@link TbRuleEngineConsumerContext} {@link TbRuleEngineConsumerContext#isStatsEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given TbRuleEngineConsumerContext isStatsEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbRuleEngineConsumerService.printStats()"})
  void testPrintStats_givenTbRuleEngineConsumerContextIsStatsEnabledReturnFalse() {
    // Arrange
    when(tbRuleEngineConsumerContext.isStatsEnabled()).thenReturn(false);

    // Act
    defaultTbRuleEngineConsumerService.printStats();

    // Assert
    verify(tbRuleEngineConsumerContext).isStatsEnabled();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Given {@link TbRuleEngineConsumerContext} {@link TbRuleEngineConsumerContext#isStatsEnabled()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given TbRuleEngineConsumerContext isStatsEnabled() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbRuleEngineConsumerService.printStats()"})
  void testPrintStats_givenTbRuleEngineConsumerContextIsStatsEnabledReturnTrue() {
    // Arrange
    when(tbRuleEngineConsumerContext.isStatsEnabled()).thenReturn(true);

    // Act
    defaultTbRuleEngineConsumerService.printStats();

    // Assert
    verify(tbRuleEngineConsumerContext).isStatsEnabled();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbRuleEngineConsumerService.printStats()"})
  void testPrintStats_thenThrowRuntimeException() {
    // Arrange
    when(tbRuleEngineConsumerContext.isStatsEnabled()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbRuleEngineConsumerService.printStats());
    verify(tbRuleEngineConsumerContext).isStatsEnabled();
  }
}
