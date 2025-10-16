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
package org.thingsboard.server.transport.lwm2m.server.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.eclipse.leshan.core.request.ExecuteRequest;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.response.ExecuteResponse;
import org.eclipse.leshan.core.response.WriteResponse;
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
import org.thingsboard.server.cache.ota.OtaPackageDataCache;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.OtherConfiguration;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.DownlinkRequestCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MExecuteRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MSoftwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientOtaInfoStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultLwM2MOtaUpdateServiceDiffblueTest {
  @InjectMocks private DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService;

  @Mock private LwM2MTelemetryLogService lwM2MTelemetryLogService;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private LwM2mDownlinkMsgHandler lwM2mDownlinkMsgHandler;

  @Mock private LwM2mTransportServerHelper lwM2mTransportServerHelper;

  @Mock private TbLwM2MClientOtaInfoStore tbLwM2MClientOtaInfoStore;

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient3() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.init(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient4() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenThrow(new CodecException("An error occurred"));
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient5() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientSwOtaInfo)
        .setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setStrategy(LwM2MSoftwareUpdateStrategy.BINARY);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient6() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Given {@link CodecException#CodecException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test init(LwM2mClient) with 'LwM2mClient'; given CodecException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_givenCodecExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        mock(Lwm2mDeviceProfileTransportConfiguration.class);
    doNothing()
        .when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.init(client));
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(client).getEndpoint();
    verify(client).getProfileId();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Then calls {@link Lwm2mDeviceProfileTransportConfiguration#getClientLwM2mSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getClientLwM2mSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetClientLwM2mSettings() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    OtherConfiguration otherConfiguration = mock(OtherConfiguration.class);
    when(otherConfiguration.getSwUpdateResource())
        .thenThrow(new CodecException("An error occurred"));
    when(otherConfiguration.getSwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateResource()).thenReturn("2020-03-01");

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        mock(Lwm2mDeviceProfileTransportConfiguration.class);
    when(lwm2mDeviceProfileTransportConfiguration.getClientLwM2mSettings())
        .thenReturn(otherConfiguration);
    doNothing()
        .when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwm2mDeviceProfileTransportConfiguration, atLeast(1)).getClientLwM2mSettings();
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(otherConfiguration, atLeast(1)).getFwUpdateResource();
    verify(otherConfiguration, atLeast(1)).getFwUpdateStrategy();
    verify(otherConfiguration).getSwUpdateResource();
    verify(otherConfiguration).getSwUpdateStrategy();
    verify(lwM2mClientContext, atLeast(1)).getProfile((UUID) isNull());
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setStrategy(LwM2MSoftwareUpdateStrategy.BINARY);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Then calls {@link Lwm2mDeviceProfileTransportConfiguration#getClientLwM2mSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getClientLwM2mSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetClientLwM2mSettings2() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    OtherConfiguration otherConfiguration = mock(OtherConfiguration.class);
    when(otherConfiguration.getSwUpdateResource())
        .thenThrow(new CodecException("An error occurred"));
    when(otherConfiguration.getSwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateResource()).thenReturn("2020-03-01");

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        mock(Lwm2mDeviceProfileTransportConfiguration.class);
    when(lwm2mDeviceProfileTransportConfiguration.getClientLwM2mSettings())
        .thenReturn(otherConfiguration);
    doNothing()
        .when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.init(client));
    verify(lwm2mDeviceProfileTransportConfiguration, atLeast(1)).getClientLwM2mSettings();
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(otherConfiguration, atLeast(1)).getFwUpdateResource();
    verify(otherConfiguration, atLeast(1)).getFwUpdateStrategy();
    verify(otherConfiguration).getSwUpdateResource();
    verify(otherConfiguration).getSwUpdateStrategy();
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getProfileId();
    verify(lwM2mClientContext, atLeast(1)).getProfile(isA(UUID.class));
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setStrategy(LwM2MSoftwareUpdateStrategy.BINARY);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#isSupported()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls isSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsIsSupported() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);
    clientLwM2mSettings.setFwUpdateStrategy(3);

    OtherConfiguration otherConfiguration = mock(OtherConfiguration.class);
    when(otherConfiguration.getSwUpdateResource())
        .thenThrow(new CodecException("An error occurred"));
    when(otherConfiguration.getSwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateStrategy()).thenReturn(1);
    when(otherConfiguration.getFwUpdateResource()).thenReturn("2020-03-01");

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        mock(Lwm2mDeviceProfileTransportConfiguration.class);
    when(lwm2mDeviceProfileTransportConfiguration.getClientLwM2mSettings())
        .thenReturn(otherConfiguration);
    doNothing()
        .when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.init(client));
    verify(lwm2mDeviceProfileTransportConfiguration).getClientLwM2mSettings();
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(otherConfiguration).getFwUpdateResource();
    verify(otherConfiguration).getFwUpdateStrategy();
    verify(otherConfiguration).getSwUpdateResource();
    verify(otherConfiguration).getSwUpdateStrategy();
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setBaseUrl("2020-03-01");
    verify(lwM2MClientFwOtaInfo).setStrategy(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    verify(lwM2MClientSwOtaInfo).setStrategy(LwM2MSoftwareUpdateStrategy.BINARY);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#getExecutorSize()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLwM2MOtaUpdateService.getExecutorSize()"})
  void testGetExecutorSize_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);

    DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService =
        new DefaultLwM2MOtaUpdateService(
            transportService,
            clientContext,
            new LwM2MTransportServerConfig(),
            mock(LwM2mUplinkMsgHandler.class),
            mock(LwM2mDownlinkMsgHandler.class),
            mock(OtaPackageDataCache.class),
            mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class),
            mock(TbLwM2MClientOtaInfoStore.class));

    // Act and Assert
    assertEquals(0, defaultLwM2MOtaUpdateService.getExecutorSize());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientFwOtaInfo)
        .setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate5() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate7() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.NOT_ENOUGH);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MTelemetryLogService)
        .log(isA(LwM2mClient.class), eq("Previous update firmware failed. Result: NOT_ENOUGH"));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getResult()} return {@code
   *       INITIAL}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); given LwM2MClientFwOtaInfo getResult() return 'INITIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_givenLwM2MClientFwOtaInfoGetResultReturnInitial() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(client).getEndpoint();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getTargetUrl()} return
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); given LwM2MClientFwOtaInfo getTargetUrl() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_givenLwM2MClientFwOtaInfoGetTargetUrlReturnEmptyString() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getTargetUrl()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); given LwM2MClientFwOtaInfo getTargetUrl() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_givenLwM2MClientFwOtaInfoGetTargetUrlReturnNull() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTelemetryLogService} {@link LwM2MTelemetryLogService#log(LwM2mClient,
   *       String)} does nothing.
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); given LwM2MTelemetryLogService log(LwM2mClient, String) does nothing; then calls log(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_givenLwM2MTelemetryLogServiceLogDoesNothing_thenCallsLog() {
    // Arrange
    doNothing()
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.NOT_ENOUGH);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MTelemetryLogService)
        .log(isA(LwM2mClient.class), eq("Previous update firmware failed. Result: NOT_ENOUGH"));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getSupportedObjectVersion(Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); then calls getSupportedObjectVersion(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_thenCallsGetSupportedObjectVersion() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#isAssigned()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient); then calls isAssigned()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_thenCallsIsAssigned() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class, () -> defaultLwM2MOtaUpdateService.forceFirmwareUpdate(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   *       SessionInfoProto, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test forceFirmwareUpdate(LwM2mClient); then calls sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate_thenCallsSendParametersOnThingsboardTelemetry() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate2() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate3() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any()))
        .thenThrow(new CodecException("An error occurred"));
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate7() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate8() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate9() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate10() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.NOT_ENOUGH);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MTelemetryLogService)
        .log(isA(LwM2mClient.class), eq("Previous update firmware failed. Result: NOT_ENOUGH"));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given Default.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenDefault() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getResult()} return {@code
   *       INITIAL}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2MClientFwOtaInfo getResult() return 'INITIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenLwM2MClientFwOtaInfoGetResultReturnInitial() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client).getEndpoint();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getResult()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2MClientFwOtaInfo getResult() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenLwM2MClientFwOtaInfoGetResultReturnNull() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(null);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getTargetUrl()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2MClientFwOtaInfo getTargetUrl() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenLwM2MClientFwOtaInfoGetTargetUrlReturnNull() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTelemetryLogService} {@link LwM2MTelemetryLogService#log(LwM2mClient,
   *       String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2MTelemetryLogService log(LwM2mClient, String) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenLwM2MTelemetryLogServiceLogDoesNothing() {
    // Arrange
    doNothing()
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.NOT_ENOUGH);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
        client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MTelemetryLogService)
        .log(isA(LwM2mClient.class), eq("Previous update firmware failed. Result: NOT_ENOUGH"));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link
   *       LwM2mClientContext#getRequestTimeout(LwM2mClient)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2mClientContext getRequestTimeout(LwM2mClient) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_givenLwM2mClientContextGetRequestTimeoutReturnNull() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#isAssigned()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetFirmwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional); then calls isAssigned()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetFirmwareUpdate_thenCallsIsAssigned() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing()
        .when(lwM2MClientFwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newFirmwareUrl = Optional.of("foo");
    Optional<String> newFirmwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetFirmwareUpdate(
                client, "Dr", "1.0.2", newFirmwareUrl, newFirmwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareNameUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareNameUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(client, "Name"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareNameUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareNameUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareNameUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(client, "Name"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareNameUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_givenOne() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    OtherConfiguration configuration = new OtherConfiguration();
    configuration.setFwUpdateStrategy(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_givenOne() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    OtherConfiguration configuration = new OtherConfiguration();
    configuration.setSwUpdateStrategy(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersion3Update() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersion3Update_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(client, "1.0.2"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersion3Update_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersionUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersionUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(client, "1.0.2"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersionUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate2() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate3() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate4() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate5() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.DOWNLOADED);
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.DOWNLOADED);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(mock(LwM2MClientFwOtaInfo.class));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate7() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getStatus()).thenThrow(new CodecException("An error occurred"));
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.IDLE);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate8() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetPackageId())
        .thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.DOWNLOADING);
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).getTargetPackageId();
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.IDLE);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getStatus()} return {@code
   *       QUEUED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); given LwM2MClientFwOtaInfo getStatus() return 'QUEUED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_givenLwM2MClientFwOtaInfoGetStatusReturnQueued() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.QUEUED);
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.IDLE);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_thenCallsGetProfileId() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(client).getSession();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getSupportedObjectVersion(Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); then calls getSupportedObjectVersion(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_thenCallsGetSupportedObjectVersion() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(5);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.DOWNLOADED);
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.DOWNLOADED);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   *       SessionInfoProto, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); then calls sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_thenCallsSendParametersOnThingsboardTelemetry() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setFailedPackageId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); then calls setFailedPackageId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_thenCallsSetFailedPackageId() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetPackageId()).thenReturn("42");
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.DOWNLOADING);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).getTargetPackageId();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId("42");
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.FAILED);
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.IDLE);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setStatus(OtaPackageUpdateStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); then calls setStatus(OtaPackageUpdateStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_thenCallsSetStatus() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.DOWNLOADING);
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.DOWNLOADING);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setStatus(OtaPackageUpdateStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareStateUpdate(LwM2mClient, Long); when three; then calls setStatus(OtaPackageUpdateStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareStateUpdate_whenThree_thenCallsSetStatus() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    doNothing().when(lwM2MClientFwOtaInfo).setUpdateState(Mockito.<FirmwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareStateUpdate(client, 3L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.UPDATING);
    verify(lwM2MClientFwOtaInfo).setUpdateState(FirmwareUpdateState.UPDATING);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate2() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate3() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate4() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientFwOtaInfo)
        .setStatus(Mockito.<OtaPackageUpdateStatus>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.UPDATED);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate6() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientFwOtaInfo)
        .setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.UPDATING);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_thenCallsGetProfileId() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(client).getSession();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_thenCallsGetType() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.UPDATED);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   *       SessionInfoProto, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); then calls sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_thenCallsSendParametersOnThingsboardTelemetry() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setFailedPackageId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); then calls setFailedPackageId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_thenCallsSetFailedPackageId() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setFailedPackageId(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setRetryAttempts(anyInt());
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.UPDATING);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(null);
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(0);
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.UPDATED);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); then calls update(FirmwareUpdateResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_thenCallsUpdate() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getStatus()).thenReturn(OtaPackageUpdateStatus.QUEUED);
    doNothing().when(lwM2MClientFwOtaInfo).update(Mockito.<FirmwareUpdateResult>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getStatus();
    verify(lwM2MClientFwOtaInfo).update(FirmwareUpdateResult.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareResultUpdate(LwM2mClient, Long); when two; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareResultUpdate_whenTwo_thenCallsGetType() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientFwOtaInfo).setStatus(Mockito.<OtaPackageUpdateStatus>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareResultUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientFwOtaInfo).setStatus(OtaPackageUpdateStatus.FAILED);
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient,
   * Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientFwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient,
   * Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(client, 42L));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient,
   * Long)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L));
    verify(tbLwM2MClientOtaInfoStore).getFw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersion3Update() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersion3Update_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(client, "1.0.2"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersion3Update_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersionUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersionUpdate_thenCallsGetEndpoint() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(client, "1.0.2"));
    verify(client, atLeast(1)).getEndpoint();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersionUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate2() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate3() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate4() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate5() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientSwOtaInfo)
        .setUpdateState(Mockito.<SoftwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.DOWNLOAD_STARTED);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 3L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.DELIVERED);
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate7() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(mock(LwM2MClientSwOtaInfo.class));

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 3L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate8() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate9() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate10() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate11() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate12() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INSTALLED);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate13() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate14() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate15() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.NOT_ENOUGH_STORAGE);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MTelemetryLogService)
        .log(
            isA(LwM2mClient.class),
            eq("Previous update software failed. Result: NOT_ENOUGH_STORAGE"));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientSwOtaInfo} {@link LwM2MClientSwOtaInfo#getResult()} return {@code
   *       INITIAL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); given LwM2MClientSwOtaInfo getResult() return 'INITIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_givenLwM2MClientSwOtaInfoGetResultReturnInitial() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientSwOtaInfo} {@link LwM2MClientSwOtaInfo#getResult()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); given LwM2MClientSwOtaInfo getResult() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_givenLwM2MClientSwOtaInfoGetResultReturnNull() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(null);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientSwOtaInfo} {@link LwM2MClientSwOtaInfo#getTargetUrl()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); given LwM2MClientSwOtaInfo getTargetUrl() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_givenLwM2MClientSwOtaInfoGetTargetUrlReturnNull() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTelemetryLogService} {@link LwM2MTelemetryLogService#log(LwM2mClient,
   *       String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); given LwM2MTelemetryLogService log(LwM2mClient, String) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_givenLwM2MTelemetryLogServiceLogDoesNothing() {
    // Arrange
    doNothing()
        .when(lwM2MTelemetryLogService)
        .log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.NOT_ENOUGH_STORAGE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MTelemetryLogService)
        .log(
            isA(LwM2mClient.class),
            eq("Previous update software failed. Result: NOT_ENOUGH_STORAGE"));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientOtaInfoStore} {@link
   *       TbLwM2MClientOtaInfoStore#putSw(LwM2MClientSwOtaInfo)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); given TbLwM2MClientOtaInfoStore putSw(LwM2MClientSwOtaInfo) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_givenTbLwM2MClientOtaInfoStorePutSwDoesNothing() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); then calls getProfile(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_thenCallsGetProfile() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setSwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#isAssigned()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); then calls isAssigned()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_thenCallsIsAssigned() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 0L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mDownlinkMsgHandler#sendExecuteRequest(LwM2mClient,
   *       TbLwM2MExecuteRequest, DownlinkRequestCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); then calls sendExecuteRequest(LwM2mClient, TbLwM2MExecuteRequest, DownlinkRequestCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_thenCallsSendExecuteRequest() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MExecuteRequest>any(),
            Mockito.<DownlinkRequestCallback<ExecuteRequest, ExecuteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 3L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendExecuteRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MExecuteRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.DELIVERED);
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then calls {@link TbLwM2MClientOtaInfoStore#putSw(LwM2MClientSwOtaInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); when four; then calls putSw(LwM2MClientSwOtaInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_whenFour_thenCallsPutSw() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 4L));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.INSTALLED);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#setUpdateState(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); when one; then calls setUpdateState(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_whenOne_thenCallsSetUpdateState() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.DOWNLOAD_STARTED);
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#setUpdateState(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStateUpdate(LwM2mClient, Long); when two; then calls setUpdateState(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareStateUpdate_whenTwo_thenCallsSetUpdateState() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(lwM2MClientSwOtaInfo).setUpdateState(Mockito.<SoftwareUpdateState>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStateUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).setUpdateState(SoftwareUpdateState.DOWNLOADED);
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate2() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate3() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate4() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate5() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate6() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientSwOtaInfo)
        .update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L));
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(SoftwareUpdateResult.DOWNLOADING);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long); then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate_thenCallsGetSession() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 1L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareResultUpdate(LwM2mClient, Long); then calls update(SoftwareUpdateResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate_thenCallsUpdate() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 1L);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(lwM2MClientSwOtaInfo).update(SoftwareUpdateResult.DOWNLOADING);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareResultUpdate(LwM2mClient, Long); when three; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate_whenThree_thenCallsGetSession() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 3L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then calls {@link LwM2mClient#getSession()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareResultUpdate(LwM2mClient, Long); when two; then calls getSession()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate_whenTwo_thenCallsGetSession() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 2L));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareResultUpdate(LwM2mClient, Long); when zero; then calls update(SoftwareUpdateResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentSoftwareResultUpdate_whenZero_thenCallsUpdate() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).update(Mockito.<SoftwareUpdateResult>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareResultUpdate(client, 0L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).update(SoftwareUpdateResult.INITIAL);
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate2() {
    // Arrange
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate3() {
    // Arrange
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any()))
        .thenReturn(
            new LwM2MClientSwOtaInfo(
                "https://config.us-east-2.amazonaws.com",
                "https://example.org/example",
                LwM2MSoftwareUpdateStrategy.BINARY));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate4() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate5() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any()))
        .thenThrow(new CodecException("An error occurred"));
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate7() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate8() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());
    doNothing()
        .when(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(
            Mockito.<List<KeyValueProto>>any(),
            Mockito.<SessionInfoProto>any(),
            Mockito.<Map<String, AtomicLong>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(lwM2mTransportServerHelper)
        .sendParametersOnThingsboardTelemetry(isA(List.class), isNull(), isA(Map.class));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate9() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given Default.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional); given Default")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate_givenDefault() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing()
        .when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            Mockito.<LwM2mClient>any(),
            Mockito.<TbLwM2MWriteReplaceRequest>any(),
            Mockito.<DownlinkRequestCallback<WriteRequest, WriteResponse>>any());

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act
    defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
        client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(
            isA(LwM2mClient.class),
            isA(TbLwM2MWriteReplaceRequest.class),
            isA(DownlinkRequestCallback.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientSwOtaInfo} {@link LwM2MClientSwOtaInfo#getTargetUrl()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2MClientSwOtaInfo getTargetUrl() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate_givenLwM2MClientSwOtaInfoGetTargetUrlReturnNull() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient, String, String,
   * Optional, Optional)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link
   *       LwM2mClientContext#getRequestTimeout(LwM2mClient)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onTargetSoftwareUpdate(LwM2mClient,
   * String, String, Optional, Optional)}
   */
  @Test
  @DisplayName(
      "Test onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional); given LwM2mClientContext getRequestTimeout(LwM2mClient) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(LwM2mClient, String, String, Optional, Optional)"
  })
  void testOnTargetSoftwareUpdate_givenLwM2mClientContextGetRequestTimeoutReturnNull() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);

    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing()
        .when(lwM2MClientSwOtaInfo)
        .updateTarget(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Optional<String>>any(),
            Mockito.<Optional<String>>any());
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    Optional<String> newSoftwareUrl = Optional.of("foo");
    Optional<String> newSoftwareTag = Optional.of("foo");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onTargetSoftwareUpdate(
                client, "Dr", "1.0.2", newSoftwareUrl, newSoftwareTag));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(9);
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo)
        .updateTarget(eq("Dr"), eq("1.0.2"), isA(Optional.class), isA(Optional.class));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw("https://config.us-east-2.amazonaws.com");
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isOtaDownloading(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultLwM2MOtaUpdateService.isOtaDownloading(LwM2mClient)"})
  void testIsOtaDownloading() {
    // Arrange, Act and Assert
    assertFalse(
        defaultLwM2MOtaUpdateService.isOtaDownloading(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test isOtaDownloading(LwM2mClient); given 'https://config.us-east-2.amazonaws.com'; then calls getEndpoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultLwM2MOtaUpdateService.isOtaDownloading(LwM2mClient)"})
  void testIsOtaDownloading_givenHttpsConfigUsEast2AmazonawsCom_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    boolean actualIsOtaDownloadingResult = defaultLwM2MOtaUpdateService.isOtaDownloading(client);

    // Assert
    verify(client).getEndpoint();
    assertFalse(actualIsOtaDownloadingResult);
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with
   * {@code softwareUpdateResult}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code DOWNLOADING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName(
      "Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'DOWNLOADING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"
  })
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsDownloading() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult =
        DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals(OtaPackageUpdateStatus.DOWNLOADING, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with
   * {@code softwareUpdateResult}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code FAILED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName(
      "Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'FAILED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"
  })
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsFailed() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult =
        DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(
            SoftwareUpdateResult.NOT_ENOUGH_STORAGE);

    // Assert
    assertEquals(OtaPackageUpdateStatus.FAILED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with
   * {@code softwareUpdateResult}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code UPDATED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName(
      "Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'UPDATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"
  })
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsUpdated() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult =
        DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(
            SoftwareUpdateResult.SUCCESSFULLY_INSTALLED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.UPDATED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with
   * {@code softwareUpdateResult}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code VERIFIED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName(
      "Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'VERIFIED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"
  })
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsVerified() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult =
        DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(
            SoftwareUpdateResult.SUCCESSFULLY_DOWNLOADED_VERIFIED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.VERIFIED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with
   * {@code softwareUpdateResult}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName(
      "Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"
  })
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnNotPresent() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult =
        DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult.INITIAL);

    // Assert
    assertFalse(actualToOtaPackageUpdateStatusResult.isPresent());
  }
}
