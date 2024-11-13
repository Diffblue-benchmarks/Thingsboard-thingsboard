package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.script.api.js.NashornJsInvokeService;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

class AbstractScriptInvokeServiceDiffblueTest {
  /**
   * Test {@link AbstractScriptInvokeService#getMaxEvalRequestsTimeout()}.
   * <p>
   * Method under test:
   * {@link AbstractScriptInvokeService#getMaxEvalRequestsTimeout()}
   */
  @Test
  @DisplayName("Test getMaxEvalRequestsTimeout()")
  void testGetMaxEvalRequestsTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act and Assert
    assertEquals(0L,
        (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getMaxEvalRequestsTimeout());
  }

  /**
   * Test
   * {@link AbstractScriptInvokeService#eval(TenantId, ScriptType, String, String[])}.
   * <ul>
   *   <li>Given {@link ApiUsageState} {@link ApiUsageState#isJsExecEnabled()}
   * return {@code false}.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractScriptInvokeService#eval(TenantId, ScriptType, String, String[])}
   */
  @Test
  @DisplayName("Test eval(TenantId, ScriptType, String, String[]); given ApiUsageState isJsExecEnabled() return 'false'; then return Done")
  void testEval_givenApiUsageStateIsJsExecEnabledReturnFalse_thenReturnDone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.isJsExecEnabled()).thenReturn(false);
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(apiUsageState);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    ListenableFuture<UUID> actualEvalResult = nashornJsInvokeService.eval(new TenantId(UUID.randomUUID()),
        ScriptType.RULE_NODE_SCRIPT, "Not all who wander are lost", "Arg Names");

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualEvalResult.isDone());
  }

  /**
   * Test
   * {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}.
   * <ul>
   *   <li>Given {@link TbApiUsageStateClient}
   * {@link TbApiUsageStateClient#getApiUsageState(TenantId)} return
   * {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}
   */
  @Test
  @DisplayName("Test invokeScript(TenantId, CustomerId, UUID, Object[]); given TbApiUsageStateClient getApiUsageState(TenantId) return ApiUsageState()")
  void testInvokeScript_givenTbApiUsageStateClientGetApiUsageStateReturnApiUsageState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(new ApiUsageState());
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    ListenableFuture<Object> actualInvokeScriptResult = nashornJsInvokeService.invokeScript(tenantId, customerId,
        UUID.randomUUID(), "Args");

    // Assert
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualInvokeScriptResult.isDone());
  }

  /**
   * Test
   * {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#isJsExecEnabled()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}
   */
  @Test
  @DisplayName("Test invokeScript(TenantId, CustomerId, UUID, Object[]); then calls isJsExecEnabled()")
  void testInvokeScript_thenCallsIsJsExecEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.isJsExecEnabled()).thenReturn(false);
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(apiUsageState);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    ListenableFuture<Object> actualInvokeScriptResult = nashornJsInvokeService.invokeScript(tenantId, customerId,
        UUID.randomUUID(), "Args");

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualInvokeScriptResult.isDone());
  }

  /**
   * Test {@link AbstractScriptInvokeService#release(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#release(UUID)}
   */
  @Test
  @DisplayName("Test release(UUID); when randomUUID; then return get() is 'null'")
  void testRelease_whenRandomUUID_thenReturnGetIsNull() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    ListenableFuture<Void> actualReleaseResult = nashornJsInvokeService.release(UUID.randomUUID());

    // Assert
    assertNull(actualReleaseResult.get());
    assertTrue(actualReleaseResult.isDone());
  }
}
