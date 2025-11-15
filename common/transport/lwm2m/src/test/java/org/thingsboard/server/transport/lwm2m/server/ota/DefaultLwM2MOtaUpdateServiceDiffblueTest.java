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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.eclipse.leshan.core.request.WriteRequest;
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
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.OtherConfiguration;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.DownlinkRequestCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MSoftwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientOtaInfoStore;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class DefaultLwM2MOtaUpdateServiceDiffblueTest {
  @InjectMocks
  private DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService;

  @Mock
  private TbLwM2MClientOtaInfoStore tbLwM2MClientOtaInfoStore;

  @Mock
  private LwM2mClientContext lwM2mClientContext;

  @Mock
  private LwM2mDownlinkMsgHandler lwM2mDownlinkMsgHandler;

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient2() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01",
        "2020-03-01", "Default Object IDVer");
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   * <ul>
   *   <li>Then calls {@link OtherConfiguration#getFwUpdateResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getFwUpdateResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetFwUpdateResource() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateResource()).thenThrow(new CodecException("An error occurred"));
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   * <ul>
   *   <li>Then calls {@link OtherConfiguration#getSwUpdateResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getSwUpdateResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetSwUpdateResource() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenThrow(new CodecException("An error occurred"));
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.init(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   * <ul>
   *   <li>Then calls {@link Lwm2mDeviceProfileTransportConfiguration#setClientLwM2mSettings(OtherConfiguration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls setClientLwM2mSettings(OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsSetClientLwM2mSettings() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = mock(
        Lwm2mDeviceProfileTransportConfiguration.class);
    doNothing().when(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(Mockito.<OtherConfiguration>any());
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    OtherConfiguration otherConfiguration = mock(OtherConfiguration.class);
    doNothing().when(otherConfiguration).setSwUpdateStrategy(Mockito.<Integer>any());
    otherConfiguration.setSwUpdateStrategy(1);
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService.init(client));
    verify(lwm2mDeviceProfileTransportConfiguration).setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(otherConfiguration).setSwUpdateStrategy(eq(1));
    verify(client).getEndpoint();
    verify(client).getProfileId();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate3() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    doNothing().when(lwM2mDownlinkMsgHandler)
        .sendWriteReplaceRequest(Mockito.<LwM2mClient>any(), Mockito.<TbLwM2MWriteReplaceRequest>any(),
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
    defaultLwM2MOtaUpdateService.forceFirmwareUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2mDownlinkMsgHandler).sendWriteReplaceRequest(isA(LwM2mClient.class),
        isA(TbLwM2MWriteReplaceRequest.class), isA(DownlinkRequestCallback.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareNameUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareNameUpdate_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(client, "Name");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then calls setCurrentName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareNameUpdate_thenCallsSetCurrentName() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareNameUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareNameUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareNameUpdate_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(client, "Name");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then calls setCurrentName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareNameUpdate_thenCallsSetCurrentName() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareNameUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareNameUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"})
  void testOnFirmwareStrategyUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, new OtherConfiguration()));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getProfileId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"})
  void testOnFirmwareStrategyUpdate_thenCallsGetProfileId() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client,
        new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01", "2020-03-01", "Default Object IDVer"));

    // Assert
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"})
  void testOnCurrentSoftwareStrategyUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, new OtherConfiguration()));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getProfileId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"})
  void testOnCurrentSoftwareStrategyUpdate_thenCallsGetProfileId() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client,
        new OtherConfiguration(1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01", "2020-03-01", "Default Object IDVer"));

    // Assert
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersion3Update() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersion3Update_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentVersion3(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then calls setCurrentVersion3(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersion3Update_thenCallsSetCurrentVersion3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersion3Update_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersionUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersionUpdate_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentVersion(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then calls setCurrentVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersionUpdate_thenCallsSetCurrentVersion() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentFirmwareVersionUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"})
  void testOnCurrentFirmwareDeliveryMethodUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenReturn(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"})
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setDeliveryMethod(Mockito.<Integer>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(client, 42L);

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then calls setDeliveryMethod(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"})
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenCallsSetDeliveryMethod() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setDeliveryMethod(Mockito.<Integer>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"})
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentFirmwareDeliveryMethodUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersion3Update() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersion3Update_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentVersion3(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then calls setCurrentVersion3(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersion3Update_thenCallsSetCurrentVersion3() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersion3Update_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersion3Update(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersionUpdate() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(new LwM2MClientSwOtaInfo(
        "https://config.us-east-2.amazonaws.com", "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersionUpdate_thenCallsGetEndpoint() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(client, "1.0.2");

    // Assert
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then calls {@link LwM2MClientOtaInfo#setCurrentVersion(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then calls setCurrentVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersionUpdate_thenCallsSetCurrentVersion() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link CodecException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"})
  void testOnCurrentSoftwareVersionUpdate_thenThrowCodecException() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(CodecException.class, () -> defaultLwM2MOtaUpdateService
        .onCurrentSoftwareVersionUpdate(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}.
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isOtaDownloading(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultLwM2MOtaUpdateService.isOtaDownloading(LwM2mClient)"})
  void testIsOtaDownloading() {
    // Arrange, Act and Assert
    assertFalse(
        defaultLwM2MOtaUpdateService.isOtaDownloading(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.</li>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isOtaDownloading(LwM2mClient); given 'https://config.us-east-2.amazonaws.com'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with {@code softwareUpdateResult}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code DOWNLOADING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'DOWNLOADING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"})
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsDownloading() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals(OtaPackageUpdateStatus.DOWNLOADING, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with {@code softwareUpdateResult}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'FAILED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"})
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsFailed() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.NOT_ENOUGH_STORAGE);

    // Assert
    assertEquals(OtaPackageUpdateStatus.FAILED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with {@code softwareUpdateResult}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code UPDATED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'UPDATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"})
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsUpdated() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.SUCCESSFULLY_INSTALLED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.UPDATED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with {@code softwareUpdateResult}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code VERIFIED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return get() is 'VERIFIED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"})
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnGetIsVerified() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.SUCCESSFULLY_DOWNLOADED_VERIFIED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.VERIFIED, actualToOtaPackageUpdateStatusResult.get());
    assertTrue(actualToOtaPackageUpdateStatusResult.isPresent());
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)} with {@code softwareUpdateResult}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2MOtaUpdateService#toOtaPackageUpdateStatus(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test toOtaPackageUpdateStatus(SoftwareUpdateResult) with 'softwareUpdateResult'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional DefaultLwM2MOtaUpdateService.toOtaPackageUpdateStatus(SoftwareUpdateResult)"})
  void testToOtaPackageUpdateStatusWithSoftwareUpdateResult_thenReturnNotPresent() {
    // Arrange and Act
    Optional<OtaPackageUpdateStatus> actualToOtaPackageUpdateStatusResult = DefaultLwM2MOtaUpdateService
        .toOtaPackageUpdateStatus(SoftwareUpdateResult.INITIAL);

    // Assert
    assertFalse(actualToOtaPackageUpdateStatusResult.isPresent());
  }
}
