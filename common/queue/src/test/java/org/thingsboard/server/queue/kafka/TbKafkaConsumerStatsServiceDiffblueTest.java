package org.thingsboard.server.queue.kafka;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.TbProperty;
import org.thingsboard.server.queue.discovery.PartitionService;

@ContextConfiguration(classes = {TbKafkaConsumerStatsService.class, TbKafkaSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbKafkaConsumerStatsServiceDiffblueTest {
  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;

  @Autowired
  private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  @Autowired
  private TbKafkaSettings tbKafkaSettings;

  /**
   * Test {@link TbKafkaConsumerStatsService#init()}.
   * <p>
   * Method under test: {@link TbKafkaConsumerStatsService#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.kafka;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6914 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbKafkaConsumerStatsService.init();
  }

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
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String)")
  @Disabled("TODO: Complete this test")
  void testRegisterClientGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.kafka;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6917 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbKafkaConsumerStatsService.registerClientGroup("42");
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
   * <p>
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String)")
  @Disabled("TODO: Complete this test")
  void testUnregisterClientGroup3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.kafka;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7436 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbKafkaConsumerStatsService.unregisterClientGroup("42");
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

  /**
   * Test {@link TbKafkaConsumerStatsService#destroy()}.
   * <p>
   * Method under test: {@link TbKafkaConsumerStatsService#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Disabled("TODO: Complete this test")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.kafka;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6911 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbKafkaConsumerStatsService.destroy();
  }
}
