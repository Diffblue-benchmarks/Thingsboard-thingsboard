package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultStatsFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultStatsFactoryDiffblueTest {
  @Autowired
  private DefaultStatsFactory defaultStatsFactory;

  @MockBean
  private MeterRegistry meterRegistry;

  /**
   * Test
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return Name is {@code Stats Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName("Test createStatsCounter(String, String, String[]); when 'Key'; then return Name is 'Stats Name'")
  void testCreateStatsCounter_whenKey_thenReturnNameIsStatsName() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("Key", "Stats Name");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   * <ul>
   *   <li>When {@code Other Tags}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName("Test createStatsCounter(String, String, String[]); when 'Other Tags'; then throw IllegalArgumentException")
  void testCreateStatsCounter_whenOtherTags_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultStatsFactory.createStatsCounter("Key", "Stats Name", "Other Tags"));
  }

  /**
   * Test
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   * <ul>
   *   <li>When {@code statsName} and {@code Invalid tags array size}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName("Test createStatsCounter(String, String, String[]); when 'statsName' and 'Invalid tags array size'")
  void testCreateStatsCounter_whenStatsNameAndInvalidTagsArraySize() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("Key", "Stats Name",
        "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   * <ul>
   *   <li>When {@code statsName}.</li>
   *   <li>Then return Name is {@code Stats Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName("Test createStatsCounter(String, String, String[]); when 'statsName'; then return Name is 'Stats Name'")
  void testCreateStatsCounter_whenStatsName_thenReturnNameIsStatsName() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("statsName", "Stats Name",
        "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createDefaultCounter(String, String[])}
   */
  @Test
  @DisplayName("Test createDefaultCounter(String, String[])")
  void testCreateDefaultCounter() {
    // Arrange, Act and Assert
    assertEquals(0, defaultStatsFactory.createDefaultCounter("Key", "Tags").get());
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * <ul>
   *   <li>Given {@link MeterRegistry}
   * {@link MeterRegistry#gauge(String, Iterable, Number)} return one.</li>
   *   <li>Then return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName("Test createGauge(String, Number, String[]); given MeterRegistry gauge(String, Iterable, Number) return one; then return valueOf one")
  void testCreateGauge_givenMeterRegistryGaugeReturnOne_thenReturnValueOfOne() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult);

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName("Test createGauge(String, Number, String[]); then throw IllegalArgumentException")
  void testCreateGauge_thenThrowIllegalArgumentException() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultStatsFactory.createGauge("Key", Integer.valueOf(1)));
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * <ul>
   *   <li>When {@code Tags} and {@code ,}.</li>
   *   <li>Then return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName("Test createGauge(String, Number, String[]); when 'Tags' and ','; then return valueOf one")
  void testCreateGauge_whenTagsAndComma_thenReturnValueOfOne() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult, "Tags", ",");

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createMessagesStats(String)}.
   * <p>
   * Method under test: {@link DefaultStatsFactory#createMessagesStats(String)}
   */
  @Test
  @DisplayName("Test createMessagesStats(String)")
  void testCreateMessagesStats() {
    // Arrange and Act
    MessagesStats actualCreateMessagesStatsResult = defaultStatsFactory.createMessagesStats("Key");

    // Assert
    assertTrue(actualCreateMessagesStatsResult instanceof DefaultMessagesStats);
    assertEquals(0, actualCreateMessagesStatsResult.getFailed());
    assertEquals(0, actualCreateMessagesStatsResult.getSuccessful());
    assertEquals(0, actualCreateMessagesStatsResult.getTotal());
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   * with {@code type}, {@code name}, {@code tags}.
   * <ul>
   *   <li>When {@code Tags}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName("Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'; when 'Tags'; then throw IllegalArgumentException")
  void testCreateTimerWithTypeNameTags_whenTags_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DefaultStatsFactory()).createTimer(StatsType.RULE_ENGINE, "Name", "Tags"));
  }
}
