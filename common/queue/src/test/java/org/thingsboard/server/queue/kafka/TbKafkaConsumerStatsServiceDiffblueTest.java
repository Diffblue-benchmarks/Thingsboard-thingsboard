package org.thingsboard.server.queue.kafka;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TbProperty;

class TbKafkaConsumerStatsServiceDiffblueTest {
  /**
   * Test {@link TbKafkaConsumerStatsService#init()}.
   * <ul>
   *   <li>Given {@link TbProperty} {@link TbProperty#setKey(String)} does
   * nothing.</li>
   *   <li>Then calls {@link TbProperty#setKey(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaConsumerStatsService#init()}
   */
  @Test
  @DisplayName("Test init(); given TbProperty setKey(String) does nothing; then calls setKey(String)")
  void testInit_givenTbPropertySetKeyDoesNothing_thenCallsSetKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = mock(TbProperty.class);
    doNothing().when(tbProperty).setKey(Mockito.<String>any());
    doNothing().when(tbProperty).setValue(Mockito.<String>any());
    tbProperty.setKey("kafka-consumer-stats");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    kafkaSettings.setOther(other);
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(kafkaSettings, statsConfig)).init();

    // Assert that nothing has changed
    verify(tbProperty).setKey(eq("kafka-consumer-stats"));
    verify(tbProperty).setValue(eq("42"));
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * <ul>
   *   <li>Given {@link TbKafkaConsumerStatisticConfig}
   * {@link TbKafkaConsumerStatisticConfig#getEnabled()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); given TbKafkaConsumerStatisticConfig getEnabled() return 'false'")
  void testRegisterClientGroup_givenTbKafkaConsumerStatisticConfigGetEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("42");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * <ul>
   *   <li>Given {@link TbKafkaConsumerStatisticConfig}
   * {@link TbKafkaConsumerStatisticConfig#getEnabled()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); given TbKafkaConsumerStatisticConfig getEnabled() return 'true'")
  void testRegisterClientGroup_givenTbKafkaConsumerStatisticConfigGetEnabledReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("42");

    // Assert
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when empty string")
  void testRegisterClientGroup_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String)")
  void testUnregisterClientGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("42");

    // Assert
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String)")
  void testUnregisterClientGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("42");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when empty string")
  void testUnregisterClientGroup_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }
}
