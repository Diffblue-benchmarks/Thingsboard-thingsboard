package org.thingsboard.server.queue.kafka;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbKafkaConsumerStatsServiceDiffblueTest {
  @Mock private TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;

  @InjectMocks private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  /**
   * Test {@link TbKafkaConsumerStatsService#init()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaConsumerStatisticConfig#getEnabled()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.init()"})
  void testInit_thenCallsGetEnabled() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.init();

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaConsumerStatisticConfig} {@link
   *       TbKafkaConsumerStatisticConfig#getEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName(
      "Test registerClientGroup(String); given TbKafkaConsumerStatisticConfig getEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_givenTbKafkaConsumerStatisticConfigGetEnabledReturnFalse() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_when42() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_whenEmptyString() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_whenNull() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup(null);

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_when42() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_whenEmptyString() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_whenNull() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup(null);

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }
}
