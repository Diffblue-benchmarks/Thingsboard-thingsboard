package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

class AbstractJsInvokeServiceDiffblueTest {
  /**
   * Test {@link AbstractJsInvokeService#isScriptPresent(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsInvokeService#isScriptPresent(UUID)}
   */
  @Test
  @DisplayName("Test isScriptPresent(UUID); when randomUUID; then return 'false'")
  void testIsScriptPresent_whenRandomUUID_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act and Assert
    assertFalse(nashornJsInvokeService.isScriptPresent(UUID.randomUUID()));
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   * <p>
   * Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId)")
  void testIsExecEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.empty();
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act and Assert
    assertTrue(nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   * <ul>
   *   <li>Given {@link ApiUsageState} {@link ApiUsageState#isJsExecEnabled()}
   * return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId); given ApiUsageState isJsExecEnabled() return 'false'; then return 'false'")
  void testIsExecEnabled_givenApiUsageStateIsJsExecEnabledReturnFalse_thenReturnFalse() {
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
    boolean actualIsExecEnabledResult = nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID()));

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertFalse(actualIsExecEnabledResult);
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   * <ul>
   *   <li>Given {@link TbApiUsageStateClient}
   * {@link TbApiUsageStateClient#getApiUsageState(TenantId)} return
   * {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId); given TbApiUsageStateClient getApiUsageState(TenantId) return ApiUsageState()")
  void testIsExecEnabled_givenTbApiUsageStateClientGetApiUsageStateReturnApiUsageState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(new ApiUsageState());
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act
    boolean actualIsExecEnabledResult = nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID()));

    // Assert
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualIsExecEnabledResult);
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId); then throw RuntimeException")
  void testIsExecEnabled_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenThrow(new RuntimeException("foo"));
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID())));
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
  }

  /**
   * Test {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}.
   * <ul>
   *   <li>Given {@link TbApiUsageReportClient}
   * {@link TbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}
   * does nothing.</li>
   *   <li>Then calls
   * {@link TbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test reportExecution(TenantId, CustomerId); given TbApiUsageReportClient report(TenantId, CustomerId, ApiUsageRecordKey, long) does nothing; then calls report(TenantId, CustomerId, ApiUsageRecordKey, long)")
  void testReportExecution_givenTbApiUsageReportClientReportDoesNothing_thenCallsReport() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbApiUsageReportClient tbApiUsageReportClient = mock(TbApiUsageReportClient.class);
    doNothing().when(tbApiUsageReportClient)
        .report(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<ApiUsageRecordKey>any(), anyLong());
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    nashornJsInvokeService.reportExecution(tenantId, new CustomerId(UUID.randomUUID()));

    // Assert
    verify(tbApiUsageReportClient).report(isA(TenantId.class), isA(CustomerId.class),
        eq(ApiUsageRecordKey.JS_EXEC_COUNT), eq(1L));
  }

  /**
   * Test {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test reportExecution(TenantId, CustomerId); then throw RuntimeException")
  void testReportExecution_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbApiUsageReportClient tbApiUsageReportClient = mock(TbApiUsageReportClient.class);
    doThrow(new RuntimeException("foo")).when(tbApiUsageReportClient)
        .report(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<ApiUsageRecordKey>any(), anyLong());
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    NashornJsInvokeService nashornJsInvokeService = new NashornJsInvokeService(apiUsageStateClient,
        apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> nashornJsInvokeService.reportExecution(tenantId, new CustomerId(UUID.randomUUID())));
    verify(tbApiUsageReportClient).report(isA(TenantId.class), isA(CustomerId.class),
        eq(ApiUsageRecordKey.JS_EXEC_COUNT), eq(1L));
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxResultSize()}.
   * <p>
   * Method under test: {@link AbstractJsInvokeService#getMaxResultSize()}
   */
  @Test
  @DisplayName("Test getMaxResultSize()")
  void testGetMaxResultSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act and Assert
    assertEquals(0L, (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getMaxResultSize());
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxScriptBodySize()}.
   * <p>
   * Method under test: {@link AbstractJsInvokeService#getMaxScriptBodySize()}
   */
  @Test
  @DisplayName("Test getMaxScriptBodySize()")
  void testGetMaxScriptBodySize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act and Assert
    assertEquals(0L, (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getMaxScriptBodySize());
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxTotalArgsSize()}.
   * <p>
   * Method under test: {@link AbstractJsInvokeService#getMaxTotalArgsSize()}
   */
  @Test
  @DisplayName("Test getMaxTotalArgsSize()")
  void testGetMaxTotalArgsSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act and Assert
    assertEquals(0L, (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getMaxTotalArgsSize());
  }
}
