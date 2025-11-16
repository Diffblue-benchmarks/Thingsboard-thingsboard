/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#isScriptPresent(UUID)}
   */
  @Test
  @DisplayName("Test isScriptPresent(UUID); when randomUUID; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractJsInvokeService.isScriptPresent(UUID)"})
  void testIsScriptPresent_whenRandomUUID_thenReturnFalse() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act and Assert
    assertFalse(nashornJsInvokeService.isScriptPresent(UUID.randomUUID()));
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   *
   * <p>Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractJsInvokeService.isExecEnabled(TenantId)"})
  void testIsExecEnabled() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.empty();
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    boolean actualIsExecEnabledResult =
        nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID()));

    // Assert
    assertTrue(actualIsExecEnabledResult);
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState} {@link ApiUsageState#isJsExecEnabled()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName(
      "Test isExecEnabled(TenantId); given ApiUsageState isJsExecEnabled() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractJsInvokeService.isExecEnabled(TenantId)"})
  void testIsExecEnabled_givenApiUsageStateIsJsExecEnabledReturnFalse_thenReturnFalse() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.isJsExecEnabled()).thenReturn(false);

    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(apiUsageState);
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    boolean actualIsExecEnabledResult =
        nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID()));

    // Assert
    verify(apiUsageState).isJsExecEnabled();
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertFalse(actualIsExecEnabledResult);
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link TbApiUsageStateClient} {@link
   *       TbApiUsageStateClient#getApiUsageState(TenantId)} return {@link
   *       ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName(
      "Test isExecEnabled(TenantId); given TbApiUsageStateClient getApiUsageState(TenantId) return ApiUsageState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractJsInvokeService.isExecEnabled(TenantId)"})
  void testIsExecEnabled_givenTbApiUsageStateClientGetApiUsageStateReturnApiUsageState() {
    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any()))
        .thenReturn(new ApiUsageState());
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    boolean actualIsExecEnabledResult =
        nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID()));

    // Assert
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
    assertTrue(actualIsExecEnabledResult);
  }

  /**
   * Test {@link AbstractJsInvokeService#isExecEnabled(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#isExecEnabled(TenantId)}
   */
  @Test
  @DisplayName("Test isExecEnabled(TenantId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractJsInvokeService.isExecEnabled(TenantId)"})
  void testIsExecEnabled_thenThrowRuntimeException() {
    // Arrange
    TbApiUsageStateClient tbApiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(tbApiUsageStateClient.getApiUsageState(Mockito.<TenantId>any()))
        .thenThrow(new RuntimeException());
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(tbApiUsageStateClient);
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> nashornJsInvokeService.isExecEnabled(new TenantId(UUID.randomUUID())));
    verify(tbApiUsageStateClient).getApiUsageState(isA(TenantId.class));
  }

  /**
   * Test {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link TbApiUsageReportClient} {@link TbApiUsageReportClient#report(TenantId,
   *       CustomerId, ApiUsageRecordKey, long)} does nothing.
   *   <li>Then calls {@link TbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey,
   *       long)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test reportExecution(TenantId, CustomerId); given TbApiUsageReportClient report(TenantId, CustomerId, ApiUsageRecordKey, long) does nothing; then calls report(TenantId, CustomerId, ApiUsageRecordKey, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractJsInvokeService.reportExecution(TenantId, CustomerId)"})
  void testReportExecution_givenTbApiUsageReportClientReportDoesNothing_thenCallsReport() {
    // Arrange
    TbApiUsageReportClient tbApiUsageReportClient = mock(TbApiUsageReportClient.class);
    doNothing()
        .when(tbApiUsageReportClient)
        .report(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<ApiUsageRecordKey>any(),
            anyLong());
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    nashornJsInvokeService.reportExecution(tenantId, new CustomerId(UUID.randomUUID()));

    // Assert
    verify(tbApiUsageReportClient)
        .report(
            isA(TenantId.class),
            isA(CustomerId.class),
            eq(ApiUsageRecordKey.JS_EXEC_COUNT),
            eq(1L));
  }

  /**
   * Test {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test reportExecution(TenantId, CustomerId); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractJsInvokeService.reportExecution(TenantId, CustomerId)"})
  void testReportExecution_thenDoesNotThrow() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.empty();

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertDoesNotThrow(
        () -> nashornJsInvokeService.reportExecution(tenantId, new CustomerId(UUID.randomUUID())));
  }

  /**
   * Test {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsInvokeService#reportExecution(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test reportExecution(TenantId, CustomerId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractJsInvokeService.reportExecution(TenantId, CustomerId)"})
  void testReportExecution_thenThrowRuntimeException() {
    // Arrange
    TbApiUsageReportClient tbApiUsageReportClient = mock(TbApiUsageReportClient.class);
    doThrow(new RuntimeException())
        .when(tbApiUsageReportClient)
        .report(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<ApiUsageRecordKey>any(),
            anyLong());
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> nashornJsInvokeService.reportExecution(tenantId, new CustomerId(UUID.randomUUID())));
    verify(tbApiUsageReportClient)
        .report(
            isA(TenantId.class),
            isA(CustomerId.class),
            eq(ApiUsageRecordKey.JS_EXEC_COUNT),
            eq(1L));
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxResultSize()}.
   *
   * <p>Method under test: {@link AbstractJsInvokeService#getMaxResultSize()}
   */
  @Test
  @DisplayName("Test getMaxResultSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractJsInvokeService.getMaxResultSize()"})
  void testGetMaxResultSize() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act and Assert
    assertEquals(0L, nashornJsInvokeService.getMaxResultSize());
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxScriptBodySize()}.
   *
   * <p>Method under test: {@link AbstractJsInvokeService#getMaxScriptBodySize()}
   */
  @Test
  @DisplayName("Test getMaxScriptBodySize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractJsInvokeService.getMaxScriptBodySize()"})
  void testGetMaxScriptBodySize() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act and Assert
    assertEquals(0L, nashornJsInvokeService.getMaxScriptBodySize());
  }

  /**
   * Test {@link AbstractJsInvokeService#getMaxTotalArgsSize()}.
   *
   * <p>Method under test: {@link AbstractJsInvokeService#getMaxTotalArgsSize()}
   */
  @Test
  @DisplayName("Test getMaxTotalArgsSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractJsInvokeService.getMaxTotalArgsSize()"})
  void testGetMaxTotalArgsSize() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act and Assert
    assertEquals(0L, nashornJsInvokeService.getMaxTotalArgsSize());
  }
}
