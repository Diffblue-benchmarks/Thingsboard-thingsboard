package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

@ContextConfiguration(classes = {DefaultTbelInvokeService.class})
@ExtendWith(SpringExtension.class)
class DefaultTbelInvokeServiceDiffblueTest {
  @Autowired private DefaultTbelInvokeService defaultTbelInvokeService;

  /**
   * Test {@link DefaultTbelInvokeService#isScriptPresent(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbelInvokeService#isScriptPresent(UUID)}
   */
  @Test
  @DisplayName("Test isScriptPresent(UUID); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbelInvokeService.isScriptPresent(UUID)"})
  void testIsScriptPresent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        defaultTbelInvokeService.isScriptPresent(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DefaultTbelInvokeService#isExecEnabled(TenantId)}.
   *
   * <p>Method under test: {@link DefaultTbelInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbelInvokeService.isExecEnabled(TenantId)"})
  void testIsExecEnabled() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.empty();
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    DefaultTbelInvokeService defaultTbelInvokeService =
        new DefaultTbelInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    boolean actualIsExecEnabledResult =
        defaultTbelInvokeService.isExecEnabled(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertTrue(actualIsExecEnabledResult);
  }

  /**
   * Test {@link DefaultTbelInvokeService#reportExecution(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbelInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test reportExecution(TenantId, CustomerId); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbelInvokeService.reportExecution(TenantId, CustomerId)"})
  void testReportExecution_thenDoesNotThrow() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.empty();

    DefaultTbelInvokeService defaultTbelInvokeService =
        new DefaultTbelInvokeService(apiUsageStateClient, apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertDoesNotThrow(
        () ->
            defaultTbelInvokeService.reportExecution(
                tenantId, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultTbelInvokeService#hash(String, String[])}.
   *
   * <p>Method under test: {@link DefaultTbelInvokeService#hash(String, String[])}
   */
  @Test
  @DisplayName("Test hash(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbelInvokeService.hash(String, String[])"})
  void testHash() {
    // Arrange and Act
    String actualHashResult =
        defaultTbelInvokeService.hash("Not all who wander are lost", new String[] {"Arg Names"});

    // Assert
    assertEquals("1b8a6ff4c69cac08c99116fccd3605ae", actualHashResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DefaultTbelInvokeService.getMaxBlackListDurationSec()",
    "int DefaultTbelInvokeService.getMaxErrors()",
    "long DefaultTbelInvokeService.getMaxInvokeRequestsTimeout()",
    "long DefaultTbelInvokeService.getMaxResultSize()",
    "long DefaultTbelInvokeService.getMaxScriptBodySize()",
    "long DefaultTbelInvokeService.getMaxTotalArgsSize()",
    "String DefaultTbelInvokeService.getStatsName()",
    "boolean DefaultTbelInvokeService.isStatsEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    DefaultTbelInvokeService defaultTbelInvokeService =
        new DefaultTbelInvokeService(apiUsageStateClient, apiUsageReportClient);

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
