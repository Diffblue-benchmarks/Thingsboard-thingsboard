package org.thingsboard.server.service.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
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
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;

@ContextConfiguration(classes = {DefaultJsInvokeStats.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultJsInvokeStatsDiffblueTest {
  @Autowired
  private DefaultJsInvokeStats defaultJsInvokeStats;

  @MockBean
  private StatsFactory statsFactory;

  /**
   * Test {@link DefaultJsInvokeStats#init()}.
   * <p>
   * Method under test: {@link DefaultJsInvokeStats#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultJsInvokeStats.init()"})
  void testInit() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));

    // Act
    defaultJsInvokeStats.init();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("jsInvoke"), Mockito.<String>any(), isA(String[].class));
    assertEquals(1, defaultJsInvokeStats.getFailures());
    assertEquals(1, defaultJsInvokeStats.getRequests());
    assertEquals(1, defaultJsInvokeStats.getResponses());
  }
}
