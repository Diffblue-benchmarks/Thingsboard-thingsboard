package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.script.api.js.NashornJsInvokeService;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

@ExtendWith(MockitoExtension.class)
class AbstractScriptInvokeServiceDiffblueTest {
  @Mock
  private TbApiUsageReportClient tbApiUsageReportClient;

  /**
   * Test {@link AbstractScriptInvokeService#getMaxEvalRequestsTimeout()}.
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#getMaxEvalRequestsTimeout()}
   */
  @Test
  @DisplayName("Test getMaxEvalRequestsTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AbstractScriptInvokeService.getMaxEvalRequestsTimeout()"})
  void testGetMaxEvalRequestsTimeout() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);

    // Act and Assert
    assertEquals(0L,
        (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getMaxEvalRequestsTimeout());
  }

  /**
   * Test {@link AbstractScriptInvokeService#eval(TenantId, ScriptType, String, String[])}.
   * <ul>
   *   <li>Given {@link ApiUsageState} {@link ApiUsageState#isJsExecEnabled()} return {@code false}.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#eval(TenantId, ScriptType, String, String[])}
   */
  @Test
  @DisplayName("Test eval(TenantId, ScriptType, String, String[]); given ApiUsageState isJsExecEnabled() return 'false'; then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AbstractScriptInvokeService.eval(TenantId, ScriptType, String, String[])"})
  void testEval_givenApiUsageStateIsJsExecEnabledReturnFalse_thenReturnDone() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.isJsExecEnabled()).thenReturn(false);
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(apiUsageState);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    ListenableFuture<UUID> actualEvalResult = nashornJsInvokeService.eval(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ScriptType.RULE_NODE_SCRIPT,
        "Not all who wander are lost", "Arg Names");

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualEvalResult.isDone());
  }

  /**
   * Test {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}.
   * <ul>
   *   <li>Given {@link TbApiUsageStateClient} {@link TbApiUsageStateClient#getApiUsageState(TenantId)} return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}
   */
  @Test
  @DisplayName("Test invokeScript(TenantId, CustomerId, UUID, Object[]); given TbApiUsageStateClient getApiUsageState(TenantId) return ApiUsageState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AbstractScriptInvokeService.invokeScript(TenantId, CustomerId, UUID, Object[])"})
  void testInvokeScript_givenTbApiUsageStateClientGetApiUsageStateReturnApiUsageState() {
    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(new ApiUsageState());
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Object> actualInvokeScriptResult = nashornJsInvokeService.invokeScript(tenantId, customerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Args");

    // Assert
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualInvokeScriptResult.isDone());
  }

  /**
   * Test {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#isJsExecEnabled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#invokeScript(TenantId, CustomerId, UUID, Object[])}
   */
  @Test
  @DisplayName("Test invokeScript(TenantId, CustomerId, UUID, Object[]); then calls isJsExecEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AbstractScriptInvokeService.invokeScript(TenantId, CustomerId, UUID, Object[])"})
  void testInvokeScript_thenCallsIsJsExecEnabled() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.isJsExecEnabled()).thenReturn(false);
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(apiUsageState);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Object> actualInvokeScriptResult = nashornJsInvokeService.invokeScript(tenantId, customerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Args");

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualInvokeScriptResult.isDone());
  }

  /**
   * Test {@link AbstractScriptInvokeService#release(UUID)}.
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractScriptInvokeService#release(UUID)}
   */
  @Test
  @DisplayName("Test release(UUID); when fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AbstractScriptInvokeService.release(UUID)"})
  void testRelease_whenFromString784f394c42b6435a983cB7beff2784f9_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    ListenableFuture<Void> actualReleaseResult = nashornJsInvokeService
        .release(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertNull(actualReleaseResult.get());
    assertTrue(actualReleaseResult.isDone());
  }
}
