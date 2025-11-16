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
package org.thingsboard.server.transport.mqtt.gateway;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.msg.gateway.metrics.GatewayMetadata;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.transport.mqtt.gateway.metrics.GatewayMetricsState;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class GatewayMetricsServiceDiffblueTest {
  @InjectMocks private GatewayMetricsService gatewayMetricsService;

  @Mock private Map<DeviceId, GatewayMetricsState> map;

  /**
   * Test {@link GatewayMetricsService#process(SessionInfoProto, DeviceId, List, long)}.
   *
   * <p>Method under test: {@link GatewayMetricsService#process(TransportProtos.SessionInfoProto,
   * DeviceId, List, long)}
   */
  @Test
  @DisplayName("Test process(SessionInfoProto, DeviceId, List, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewayMetricsService.process(TransportProtos.SessionInfoProto, DeviceId, List, long)"
  })
  void testProcess() {
    // Arrange
    GatewayMetricsState gatewayMetricsState = mock(GatewayMetricsState.class);
    doNothing().when(gatewayMetricsState).update(Mockito.<List<GatewayMetadata>>any(), anyLong());
    when(map.computeIfAbsent(
            Mockito.<DeviceId>any(), Mockito.<Function<DeviceId, GatewayMetricsState>>any()))
        .thenReturn(gatewayMetricsState);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    ArrayList<GatewayMetadata> data = new ArrayList<>();
    data.add(new GatewayMetadata("Connector", 1L, 1L));

    // Act
    gatewayMetricsService.process(sessionInfo, null, data, 1L);

    // Assert
    verify(map).computeIfAbsent(isNull(), isA(Function.class));
    verify(gatewayMetricsState).update(isA(List.class), eq(1L));
  }

  /**
   * Test {@link GatewayMetricsService#process(SessionInfoProto, DeviceId, List, long)}.
   *
   * <p>Method under test: {@link GatewayMetricsService#process(TransportProtos.SessionInfoProto,
   * DeviceId, List, long)}
   */
  @Test
  @DisplayName("Test process(SessionInfoProto, DeviceId, List, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewayMetricsService.process(TransportProtos.SessionInfoProto, DeviceId, List, long)"
  })
  void testProcess2() {
    // Arrange
    GatewayMetricsState gatewayMetricsState = mock(GatewayMetricsState.class);
    doNothing().when(gatewayMetricsState).update(Mockito.<List<GatewayMetadata>>any(), anyLong());
    when(map.computeIfAbsent(
            Mockito.<DeviceId>any(), Mockito.<Function<DeviceId, GatewayMetricsState>>any()))
        .thenReturn(gatewayMetricsState);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    ArrayList<GatewayMetadata> data = new ArrayList<>();
    data.add(new GatewayMetadata("Connector", 1L, 1L));
    data.add(new GatewayMetadata("Connector", 1L, 1L));

    // Act
    gatewayMetricsService.process(sessionInfo, null, data, 1L);

    // Assert
    verify(map).computeIfAbsent(isNull(), isA(Function.class));
    verify(gatewayMetricsState).update(isA(List.class), eq(1L));
  }

  /**
   * Test {@link GatewayMetricsService#process(SessionInfoProto, DeviceId, List, long)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Map#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link GatewayMetricsService#process(TransportProtos.SessionInfoProto,
   * DeviceId, List, long)}
   */
  @Test
  @DisplayName(
      "Test process(SessionInfoProto, DeviceId, List, long); when ArrayList(); then calls computeIfAbsent(Object, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewayMetricsService.process(TransportProtos.SessionInfoProto, DeviceId, List, long)"
  })
  void testProcess_whenArrayList_thenCallsComputeIfAbsent() {
    // Arrange
    GatewayMetricsState gatewayMetricsState = mock(GatewayMetricsState.class);
    doNothing().when(gatewayMetricsState).update(Mockito.<List<GatewayMetadata>>any(), anyLong());
    when(map.computeIfAbsent(
            Mockito.<DeviceId>any(), Mockito.<Function<DeviceId, GatewayMetricsState>>any()))
        .thenReturn(gatewayMetricsState);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    gatewayMetricsService.process(sessionInfo, null, new ArrayList<>(), 1L);

    // Assert
    verify(map).computeIfAbsent(isNull(), isA(Function.class));
    verify(gatewayMetricsState).update(isA(List.class), eq(1L));
  }

  /**
   * Test {@link GatewayMetricsService#onDeviceUpdate(SessionInfoProto, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Map#get(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GatewayMetricsService#onDeviceUpdate(TransportProtos.SessionInfoProto, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, DeviceId); given Map get(Object) return 'null'; when 'null'; then calls get(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewayMetricsService.onDeviceUpdate(TransportProtos.SessionInfoProto, DeviceId)"
  })
  void testOnDeviceUpdate_givenMapGetReturnNull_whenNull_thenCallsGet() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);

    // Act
    gatewayMetricsService.onDeviceUpdate(SessionInfoProto.getDefaultInstance(), null);

    // Assert
    verify(map).get(isNull());
  }

  /**
   * Test {@link GatewayMetricsService#onDeviceUpdate(SessionInfoProto, DeviceId)}.
   *
   * <ul>
   *   <li>Then calls {@link GatewayMetricsState#updateSessionInfo(SessionInfoProto)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GatewayMetricsService#onDeviceUpdate(TransportProtos.SessionInfoProto, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test onDeviceUpdate(SessionInfoProto, DeviceId); then calls updateSessionInfo(SessionInfoProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GatewayMetricsService.onDeviceUpdate(TransportProtos.SessionInfoProto, DeviceId)"
  })
  void testOnDeviceUpdate_thenCallsUpdateSessionInfo() {
    // Arrange
    GatewayMetricsState gatewayMetricsState = mock(GatewayMetricsState.class);
    doNothing().when(gatewayMetricsState).updateSessionInfo(Mockito.<SessionInfoProto>any());
    when(map.get(Mockito.<Object>any())).thenReturn(gatewayMetricsState);

    // Act
    gatewayMetricsService.onDeviceUpdate(SessionInfoProto.getDefaultInstance(), null);

    // Assert
    verify(map).get(isNull());
    verify(gatewayMetricsState).updateSessionInfo(isA(SessionInfoProto.class));
  }

  /**
   * Test {@link GatewayMetricsService#onDeviceDelete(DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#remove(Object)} return {@code null}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Map#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link GatewayMetricsService#onDeviceDelete(DeviceId)}
   */
  @Test
  @DisplayName(
      "Test onDeviceDelete(DeviceId); given Map remove(Object) return 'null'; when 'null'; then calls remove(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GatewayMetricsService.onDeviceDelete(DeviceId)"})
  void testOnDeviceDelete_givenMapRemoveReturnNull_whenNull_thenCallsRemove() {
    // Arrange
    when(map.remove(Mockito.<Object>any())).thenReturn(null);

    // Act
    gatewayMetricsService.onDeviceDelete(null);

    // Assert
    verify(map).remove(isNull());
  }

  /**
   * Test {@link GatewayMetricsService#reportMetrics()}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#isEmpty()} return {@code false}.
   *   <li>Then calls {@link Map#forEach(BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link GatewayMetricsService#reportMetrics()}
   */
  @Test
  @DisplayName(
      "Test reportMetrics(); given Map isEmpty() return 'false'; then calls forEach(BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GatewayMetricsService.reportMetrics()"})
  void testReportMetrics_givenMapIsEmptyReturnFalse_thenCallsForEach() {
    // Arrange
    when(map.isEmpty()).thenReturn(false);
    doNothing().when(map).forEach(Mockito.<BiConsumer<DeviceId, GatewayMetricsState>>any());

    // Act
    gatewayMetricsService.reportMetrics();

    // Assert
    verify(map).forEach(isA(BiConsumer.class));
    verify(map).isEmpty();
  }

  /**
   * Test {@link GatewayMetricsService#reportMetrics()}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#isEmpty()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GatewayMetricsService#reportMetrics()}
   */
  @Test
  @DisplayName("Test reportMetrics(); given Map isEmpty() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GatewayMetricsService.reportMetrics()"})
  void testReportMetrics_givenMapIsEmptyReturnTrue() {
    // Arrange
    when(map.isEmpty()).thenReturn(true);

    // Act
    gatewayMetricsService.reportMetrics();

    // Assert
    verify(map).isEmpty();
  }
}
