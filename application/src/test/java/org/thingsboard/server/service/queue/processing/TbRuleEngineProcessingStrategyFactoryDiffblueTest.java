package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;

@ContextConfiguration(classes = {TbRuleEngineProcessingStrategyFactory.class})
@ExtendWith(SpringExtension.class)
class TbRuleEngineProcessingStrategyFactoryDiffblueTest {
  @Autowired
  private TbRuleEngineProcessingStrategyFactory tbRuleEngineProcessingStrategyFactory;

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_ALL}.</li>
   *   <li>When {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code RETRY_ALL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_ALL'; when ProcessingStrategy getType() return 'RETRY_ALL'")
  void testNewInstance_givenRetryAll_whenProcessingStrategyGetTypeReturnRetryAll() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getFailurePercentage()).thenReturn(10.0d);
    when(processingStrategy.getRetries()).thenReturn(1);
    when(processingStrategy.getMaxPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_ALL);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getFailurePercentage();
    verify(processingStrategy).getMaxPauseBetweenRetries();
    verify(processingStrategy).getPauseBetweenRetries();
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_ALL}.</li>
   *   <li>When {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code RETRY_ALL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_ALL'; when ProcessingStrategy getType() return 'RETRY_ALL'")
  void testNewInstance_givenRetryAll_whenProcessingStrategyGetTypeReturnRetryAll2() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new RuntimeException("foo"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_ALL);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_FAILED_AND_TIMED_OUT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_FAILED_AND_TIMED_OUT'")
  void testNewInstance_givenRetryFailedAndTimedOut() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getFailurePercentage()).thenReturn(10.0d);
    when(processingStrategy.getRetries()).thenReturn(1);
    when(processingStrategy.getMaxPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_FAILED_AND_TIMED_OUT);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getFailurePercentage();
    verify(processingStrategy).getMaxPauseBetweenRetries();
    verify(processingStrategy).getPauseBetweenRetries();
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_FAILED_AND_TIMED_OUT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_FAILED_AND_TIMED_OUT'")
  void testNewInstance_givenRetryFailedAndTimedOut2() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new RuntimeException("foo"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_FAILED_AND_TIMED_OUT);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_FAILED}.</li>
   *   <li>When {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code RETRY_FAILED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_FAILED'; when ProcessingStrategy getType() return 'RETRY_FAILED'")
  void testNewInstance_givenRetryFailed_whenProcessingStrategyGetTypeReturnRetryFailed() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getFailurePercentage()).thenReturn(10.0d);
    when(processingStrategy.getRetries()).thenReturn(1);
    when(processingStrategy.getMaxPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_FAILED);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getFailurePercentage();
    verify(processingStrategy).getMaxPauseBetweenRetries();
    verify(processingStrategy).getPauseBetweenRetries();
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_FAILED}.</li>
   *   <li>When {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code RETRY_FAILED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_FAILED'; when ProcessingStrategy getType() return 'RETRY_FAILED'")
  void testNewInstance_givenRetryFailed_whenProcessingStrategyGetTypeReturnRetryFailed2() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new RuntimeException("foo"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_FAILED);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_TIMED_OUT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_TIMED_OUT'")
  void testNewInstance_givenRetryTimedOut() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getFailurePercentage()).thenReturn(10.0d);
    when(processingStrategy.getRetries()).thenReturn(1);
    when(processingStrategy.getMaxPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getPauseBetweenRetries()).thenReturn(1L);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_TIMED_OUT);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getFailurePercentage();
    verify(processingStrategy).getMaxPauseBetweenRetries();
    verify(processingStrategy).getPauseBetweenRetries();
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code RETRY_TIMED_OUT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'RETRY_TIMED_OUT'")
  void testNewInstance_givenRetryTimedOut2() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new RuntimeException("foo"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.RETRY_TIMED_OUT);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>Given {@code SKIP_ALL_FAILURES_AND_TIMED_OUT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); given 'SKIP_ALL_FAILURES_AND_TIMED_OUT'")
  void testNewInstance_givenSkipAllFailuresAndTimedOut() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.SKIP_ALL_FAILURES_AND_TIMED_OUT);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}.
   * <ul>
   *   <li>When {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code SKIP_ALL_FAILURES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingStrategyFactory#newInstance(String, ProcessingStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, ProcessingStrategy); when ProcessingStrategy getType() return 'SKIP_ALL_FAILURES'")
  void testNewInstance_whenProcessingStrategyGetTypeReturnSkipAllFailures() {
    // Arrange
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.SKIP_ALL_FAILURES);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act
    tbRuleEngineProcessingStrategyFactory.newInstance("Name", processingStrategy);

    // Assert
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
  }
}
