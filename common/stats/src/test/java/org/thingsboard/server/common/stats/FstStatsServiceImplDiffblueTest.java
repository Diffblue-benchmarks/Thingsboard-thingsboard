package org.thingsboard.server.common.stats;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopTimer;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FstStatsServiceImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FstStatsServiceImplDiffblueTest {
  @Autowired
  private FstStatsServiceImpl fstStatsServiceImpl;

  @MockBean
  private StatsFactory statsFactory;

  /**
   * Test {@link FstStatsServiceImpl#incrementEncode(Class)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls {@link StatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#incrementEncode(Class)}
   */
  @Test
  @DisplayName("Test incrementEncode(Class); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.incrementEncode(Class)"})
  void testIncrementEncode_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementEncode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_encode"), eq("Object"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#incrementEncode(Class)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   *   <li>Then calls {@link StatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#incrementEncode(Class)}
   */
  @Test
  @DisplayName("Test incrementEncode(Class); given AtomicInteger(int) with zero; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.incrementEncode(Class)"})
  void testIncrementEncode_givenAtomicIntegerWithZero_thenCallsCreateStatsCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementEncode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_encode"), eq("Object"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#incrementDecode(Class)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls {@link StatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#incrementDecode(Class)}
   */
  @Test
  @DisplayName("Test incrementDecode(Class); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.incrementDecode(Class)"})
  void testIncrementDecode_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementDecode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_decode"), eq("Object"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#incrementDecode(Class)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   *   <li>Then calls {@link StatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#incrementDecode(Class)}
   */
  @Test
  @DisplayName("Test incrementDecode(Class); given AtomicInteger(int) with zero; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.incrementDecode(Class)"})
  void testIncrementDecode_givenAtomicIntegerWithZero_thenCallsCreateStatsCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementDecode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_decode"), eq("Object"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}.
   * <p>
   * Method under test: {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}
   */
  @Test
  @DisplayName("Test recordEncodeTime(Class, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.recordEncodeTime(Class, long)"})
  void testRecordEncodeTime() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Id("fst_encode_time", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordEncodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_encode_time"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}.
   * <ul>
   *   <li>Then calls {@link StatsFactory#createTimer(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}
   */
  @Test
  @DisplayName("Test recordEncodeTime(Class, long); then calls createTimer(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.recordEncodeTime(Class, long)"})
  void testRecordEncodeTime_thenCallsCreateTimer() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class))).thenReturn(new NoopTimer(
        new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordEncodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_encode_time"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}.
   * <p>
   * Method under test: {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}
   */
  @Test
  @DisplayName("Test recordDecodeTime(Class, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.recordDecodeTime(Class, long)"})
  void testRecordDecodeTime() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Id("fst_decode_time", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordDecodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_decode_time"), isA(String[].class));
  }

  /**
   * Test {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}.
   * <ul>
   *   <li>Then calls {@link StatsFactory#createTimer(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}
   */
  @Test
  @DisplayName("Test recordDecodeTime(Class, long); then calls createTimer(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FstStatsServiceImpl.recordDecodeTime(Class, long)"})
  void testRecordDecodeTime_thenCallsCreateTimer() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class))).thenReturn(new NoopTimer(
        new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordDecodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_decode_time"), isA(String[].class));
  }
}
