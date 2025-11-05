package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.MeterRegistry.Config;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.distribution.pause.NoPauseDetector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultStatsFactory.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultStatsFactoryDiffblueTest {
  @Autowired private DefaultStatsFactory defaultStatsFactory;

  @MockBean private MeterRegistry meterRegistry;

  /**
   * Test {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return Name is {@code Stats Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createStatsCounter(String, String, String[]); when 'Key'; then return Name is 'Stats Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StatsCounter DefaultStatsFactory.createStatsCounter(String, String, String[])"
  })
  void testCreateStatsCounter_whenKey_thenReturnNameIsStatsName() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult =
        defaultStatsFactory.createStatsCounter("Key", "Stats Name");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Other Tags}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createStatsCounter(String, String, String[]); when 'Other Tags'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StatsCounter DefaultStatsFactory.createStatsCounter(String, String, String[])"
  })
  void testCreateStatsCounter_whenOtherTags_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultStatsFactory.createStatsCounter("Key", "Stats Name", "Other Tags"));
  }

  /**
   * Test {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code statsName} and {@code Invalid tags array size}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createStatsCounter(String, String, String[]); when 'statsName' and 'Invalid tags array size'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StatsCounter DefaultStatsFactory.createStatsCounter(String, String, String[])"
  })
  void testCreateStatsCounter_whenStatsNameAndInvalidTagsArraySize() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult =
        defaultStatsFactory.createStatsCounter(
            "Key", "Stats Name", "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.
   *
   * <ul>
   *   <li>When {@code statsName}.
   *   <li>Then return Name is {@code Stats Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createStatsCounter(String, String, String[]); when 'statsName'; then return Name is 'Stats Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StatsCounter DefaultStatsFactory.createStatsCounter(String, String, String[])"
  })
  void testCreateStatsCounter_whenStatsName_thenReturnNameIsStatsName() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult =
        defaultStatsFactory.createStatsCounter(
            "statsName", "Stats Name", "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Test {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.
   *
   * <p>Method under test: {@link DefaultStatsFactory#createDefaultCounter(String, String[])}
   */
  @Test
  @DisplayName("Test createDefaultCounter(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.stats.DefaultCounter DefaultStatsFactory.createDefaultCounter(String, String[])"
  })
  void testCreateDefaultCounter() {
    // Arrange, Act and Assert
    assertEquals(0, defaultStatsFactory.createDefaultCounter("Key", "Tags").get());
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   *
   * <ul>
   *   <li>Given {@link MeterRegistry} {@link MeterRegistry#gauge(String, Iterable, Number)} return
   *       one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName(
      "Test createGauge(String, Number, String[]); given MeterRegistry gauge(String, Iterable, Number) return one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number DefaultStatsFactory.createGauge(String, Number, String[])"})
  void testCreateGauge_givenMeterRegistryGaugeReturnOne_thenReturnIntValueIsOne() {
    // Arrange
    when(meterRegistry.gauge(
            Mockito.<String>any(),
            Mockito.<Iterable<io.micrometer.core.instrument.Tag>>any(),
            Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult);

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertEquals(1, actualCreateGaugeResult.intValue());
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName("Test createGauge(String, Number, String[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number DefaultStatsFactory.createGauge(String, Number, String[])"})
  void testCreateGauge_thenThrowIllegalArgumentException() {
    // Arrange
    when(meterRegistry.gauge(
            Mockito.<String>any(),
            Mockito.<Iterable<io.micrometer.core.instrument.Tag>>any(),
            Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultStatsFactory.createGauge("Key", Integer.valueOf(1), null));
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName(
      "Test createGauge(String, Number, String[]); when 'null'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number DefaultStatsFactory.createGauge(String, Number, String[])"})
  void testCreateGauge_whenNull_thenReturnIntValueIsOne() {
    // Arrange
    when(meterRegistry.gauge(
            Mockito.<String>any(),
            Mockito.<Iterable<io.micrometer.core.instrument.Tag>>any(),
            Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult, null);

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertEquals(1, actualCreateGaugeResult.intValue());
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName(
      "Test createGauge(String, Number, String[]); when 'null'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number DefaultStatsFactory.createGauge(String, Number, String[])"})
  void testCreateGauge_whenNull_thenReturnIntValueIsOne2() {
    // Arrange
    when(meterRegistry.gauge(
            Mockito.<String>any(),
            Mockito.<Iterable<io.micrometer.core.instrument.Tag>>any(),
            Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult, null);

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertEquals(1, actualCreateGaugeResult.intValue());
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   *
   * <ul>
   *   <li>When {@code Tags} and {@code ,}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  @DisplayName(
      "Test createGauge(String, Number, String[]); when 'Tags' and ','; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Number DefaultStatsFactory.createGauge(String, Number, String[])"})
  void testCreateGauge_whenTagsAndComma_thenReturnIntValueIsOne() {
    // Arrange
    when(meterRegistry.gauge(
            Mockito.<String>any(),
            Mockito.<Iterable<io.micrometer.core.instrument.Tag>>any(),
            Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult =
        defaultStatsFactory.createGauge("Key", valueOfResult, "Tags", ",");

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertEquals(1, actualCreateGaugeResult.intValue());
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createMessagesStats(String)}.
   *
   * <p>Method under test: {@link DefaultStatsFactory#createMessagesStats(String)}
   */
  @Test
  @DisplayName("Test createMessagesStats(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessagesStats DefaultStatsFactory.createMessagesStats(String)"})
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
   * Test {@link DefaultStatsFactory#createTimer(String, String[])} with {@code key}, {@code tags}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  @DisplayName("Test createTimer(String, String[]) with 'key', 'tags'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timer DefaultStatsFactory.createTimer(String, String[])"})
  void testCreateTimerWithKeyTags_thenReturnNull() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(String, String[])} with {@code key}, {@code tags}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(String, String[]) with 'key', 'tags'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timer DefaultStatsFactory.createTimer(String, String[])"})
  void testCreateTimerWithKeyTags_thenThrowIllegalArgumentException() {
    // Arrange
    when(meterRegistry.config()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultStatsFactory.createTimer("Key"));
    verify(meterRegistry).config();
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(String, String[])} with {@code key}, {@code tags}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(String, String[]) with 'key', 'tags'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timer DefaultStatsFactory.createTimer(String, String[])"})
  void testCreateTimerWithKeyTags_whenNull_thenReturnNull() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key", null);

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(String, String[])} with {@code key}, {@code tags}.
   *
   * <ul>
   *   <li>When {@code Tags} and {@code ,}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(String, String[]) with 'key', 'tags'; when 'Tags' and ','; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timer DefaultStatsFactory.createTimer(String, String[])"})
  void testCreateTimerWithKeyTags_whenTagsAndComma_thenReturnNull() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key", "Tags", ",");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])} with {@code type},
   * {@code name}, {@code tags}.
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName("Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatsTimer DefaultStatsFactory.createTimer(StatsType, String, String[])"})
  void testCreateTimerWithTypeNameTags() {
    // Arrange
    when(meterRegistry.config()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name"));
    verify(meterRegistry).config();
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])} with {@code type},
   * {@code name}, {@code tags}.
   *
   * <ul>
   *   <li>Given {@link MeterRegistry}.
   *   <li>When {@code Tags}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'; given MeterRegistry; when 'Tags'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatsTimer DefaultStatsFactory.createTimer(StatsType, String, String[])"})
  void testCreateTimerWithTypeNameTags_givenMeterRegistry_whenTags() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name", "Tags"));
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])} with {@code type},
   * {@code name}, {@code tags}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatsTimer DefaultStatsFactory.createTimer(StatsType, String, String[])"})
  void testCreateTimerWithTypeNameTags_thenReturnName() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult =
        defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])} with {@code type},
   * {@code name}, {@code tags}.
   *
   * <ul>
   *   <li>When {@code statsName} and {@code Invalid tags array size}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'; when 'statsName' and 'Invalid tags array size'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatsTimer DefaultStatsFactory.createTimer(StatsType, String, String[])"})
  void testCreateTimerWithTypeNameTags_whenStatsNameAndInvalidTagsArraySize() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult =
        defaultStatsFactory.createTimer(
            StatsType.RULE_ENGINE, "Name", "statsName", "Invalid tags array size");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }

  /**
   * Test {@link DefaultStatsFactory#createTimer(StatsType, String, String[])} with {@code type},
   * {@code name}, {@code tags}.
   *
   * <ul>
   *   <li>When {@code Tags} and {@code Invalid tags array size}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  @DisplayName(
      "Test createTimer(StatsType, String, String[]) with 'type', 'name', 'tags'; when 'Tags' and 'Invalid tags array size'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatsTimer DefaultStatsFactory.createTimer(StatsType, String, String[])"})
  void testCreateTimerWithTypeNameTags_whenTagsAndInvalidTagsArraySize_thenReturnName() {
    // Arrange
    Config config = mock(Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult =
        defaultStatsFactory.createTimer(
            StatsType.RULE_ENGINE, "Name", "Tags", "Invalid tags array size");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }
}
