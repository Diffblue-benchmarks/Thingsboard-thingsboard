package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

@ContextConfiguration(classes = {DefaultTbelInvokeService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultTbelInvokeServiceDiffblueTest {
  @Autowired
  private DefaultTbelInvokeService defaultTbelInvokeService;

  @MockBean
  private TbApiUsageReportClient tbApiUsageReportClient;

  @MockBean
  private TbApiUsageStateClient tbApiUsageStateClient;

  /**
   * Test {@link DefaultTbelInvokeService#getCallbackExecutor()}.
   * <p>
   * Method under test: {@link DefaultTbelInvokeService#getCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getCallbackExecutor()")
  void testGetCallbackExecutor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act
    Executor actualCallbackExecutor = (new DefaultTbelInvokeService(apiUsageStateClient, apiUsageReportClient))
        .getCallbackExecutor();
    Runnable runnable = mock(Runnable.class);
    doNothing().when(runnable).run();
    actualCallbackExecutor.execute(runnable);

    // Assert that nothing has changed
    verify(runnable).run();
  }

  /**
   * Test {@link DefaultTbelInvokeService#isScriptPresent(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbelInvokeService#isScriptPresent(UUID)}
   */
  @Test
  @DisplayName("Test isScriptPresent(UUID); when randomUUID; then return 'false'")
  void testIsScriptPresent_whenRandomUUID_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultTbelInvokeService.isScriptPresent(UUID.randomUUID()));
  }

  /**
   * Test {@link DefaultTbelInvokeService#hash(String, String[])}.
   * <p>
   * Method under test: {@link DefaultTbelInvokeService#hash(String, String[])}
   */
  @Test
  @DisplayName("Test hash(String, String[])")
  void testHash() {
    // Arrange, Act and Assert
    assertEquals("1b8a6ff4c69cac08c99116fccd3605ae",
        defaultTbelInvokeService.hash("Not all who wander are lost", new String[]{"Arg Names"}));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbelInvokeService#getMaxBlackListDurationSec()}
   *   <li>{@link DefaultTbelInvokeService#getMaxErrors()}
   *   <li>{@link DefaultTbelInvokeService#getMaxInvokeRequestsTimeout()}
   *   <li>{@link DefaultTbelInvokeService#getMaxResultSize()}
   *   <li>{@link DefaultTbelInvokeService#getMaxScriptBodySize()}
   *   <li>{@link DefaultTbelInvokeService#getMaxTotalArgsSize()}
   *   <li>{@link DefaultTbelInvokeService#getStatsName()}
   *   <li>{@link DefaultTbelInvokeService#isStatsEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    DefaultTbelInvokeService defaultTbelInvokeService = new DefaultTbelInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    int actualMaxBlackListDurationSec = defaultTbelInvokeService.getMaxBlackListDurationSec();
    int actualMaxErrors = defaultTbelInvokeService.getMaxErrors();
    long actualMaxInvokeRequestsTimeout = defaultTbelInvokeService.getMaxInvokeRequestsTimeout();
    long actualMaxResultSize = defaultTbelInvokeService.getMaxResultSize();
    long actualMaxScriptBodySize = defaultTbelInvokeService.getMaxScriptBodySize();
    long actualMaxTotalArgsSize = defaultTbelInvokeService.getMaxTotalArgsSize();
    String actualStatsName = defaultTbelInvokeService.getStatsName();

    // Assert
    assertEquals("TBEL Scripts Stats", actualStatsName);
    assertEquals(0, actualMaxBlackListDurationSec);
    assertEquals(0, actualMaxErrors);
    assertEquals(0L, actualMaxInvokeRequestsTimeout);
    assertEquals(0L, actualMaxResultSize);
    assertEquals(0L, actualMaxScriptBodySize);
    assertEquals(0L, actualMaxTotalArgsSize);
    assertFalse(defaultTbelInvokeService.isStatsEnabled());
  }
}
