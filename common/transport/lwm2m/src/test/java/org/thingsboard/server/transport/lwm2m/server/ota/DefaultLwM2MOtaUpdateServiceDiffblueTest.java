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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
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
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.DownlinkRequestCallback;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteReplaceRequest;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MSoftwareUpdateStrategy;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.software.SoftwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientOtaInfoStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultLwM2MOtaUpdateServiceDiffblueTest {
  @InjectMocks private DefaultLwM2MOtaUpdateService defaultLwM2MOtaUpdateService;

  @Mock private LwM2mClientContext lwM2mClientContext;

  @Mock private LwM2mDownlinkMsgHandler lwM2mDownlinkMsgHandler;

  @Mock private TbLwM2MClientOtaInfoStore tbLwM2MClientOtaInfoStore;

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient3() {
    // Arrange
    OtherConfiguration clientLwM2mSettings =
        new OtherConfiguration(
            1, 1, 1, PowerMode.PSM, 1L, 1L, 1L, "2020-03-01", "2020-03-01", "Default Object IDVer");
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient4() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource())
        .thenThrow(new CodecException("An error occurred"));
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
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
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient5() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setSwUpdateStrategy(1);
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
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
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
    verify(lwm2mDeviceProfileTransportConfiguration, atLeast(1)).getClientLwM2mSettings();
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Given {@link OtherConfiguration#OtherConfiguration()} FwUpdateStrategy is two.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test init(LwM2mClient) with 'LwM2mClient'; given OtherConfiguration() FwUpdateStrategy is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_givenOtherConfigurationFwUpdateStrategyIsTwo() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    OtherConfiguration otherConfiguration = new OtherConfiguration();
    otherConfiguration.setFwUpdateStrategy(2);
    otherConfiguration.setSwUpdateStrategy(1);
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
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
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
    verify(lwm2mDeviceProfileTransportConfiguration, atLeast(1)).getClientLwM2mSettings();
    verify(lwm2mDeviceProfileTransportConfiguration)
        .setClientLwM2mSettings(isA(OtherConfiguration.class));
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext, atLeast(1)).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Then calls {@link OtherConfiguration#getFwUpdateResource()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getFwUpdateResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetFwUpdateResource() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateResource())
        .thenThrow(new CodecException("An error occurred"));
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.init(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
    verify(clientLwM2mSettings).getFwUpdateResource();
    verify(clientLwM2mSettings).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)} with {@code LwM2mClient}.
   *
   * <ul>
   *   <li>Then calls {@link OtherConfiguration#getSwUpdateStrategy()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#init(LwM2mClient)}
   */
  @Test
  @DisplayName("Test init(LwM2mClient) with 'LwM2mClient'; then calls getSwUpdateStrategy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.init(LwM2mClient)"})
  void testInitWithLwM2mClient_thenCallsGetSwUpdateStrategy() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    when(clientLwM2mSettings.getSwUpdateStrategy())
        .thenThrow(new CodecException("An error occurred"));
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(3);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
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
    verify(clientLwM2mSettings).getSwUpdateResource();
    verify(clientLwM2mSettings).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(3));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate3() {
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
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#forceFirmwareUpdate(LwM2mClient)}
   */
  @Test
  @DisplayName("Test forceFirmwareUpdate(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2MOtaUpdateService.forceFirmwareUpdate(LwM2mClient)"})
  void testForceFirmwareUpdate4() {
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
    verify(lwM2MClientFwOtaInfo).setFailedPackageId(isNull());
    verify(lwM2MClientFwOtaInfo).setRetryAttempts(eq(0));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareNameUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setCurrentName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareNameUpdate(LwM2mClient, String); then calls setCurrentName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareNameUpdate_thenCallsSetCurrentName() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareNameUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareNameUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#setCurrentName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareNameUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareNameUpdate(LwM2mClient, String); then calls setCurrentName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareNameUpdate_thenCallsSetCurrentName() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentName(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareNameUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Name");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentName(eq("Name"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate() {
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate3() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doThrow(new CodecException("An error occurred"))
        .when(tbLwM2MClientOtaInfoStore)
        .putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putFw(isA(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate4() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getFwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getFwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putFw(Mockito.<LwM2MClientFwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(
        client,
        new OtherConfiguration(
            1,
            1,
            1,
            PowerMode.PSM,
            1L,
            1L,
            1L,
            "2020-03-01",
            "2020-03-01",
            "Default Object IDVer"));

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
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate5() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration));
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
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
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(5));
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
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MClientFwOtaInfo} {@link LwM2MClientFwOtaInfo#getTargetUrl()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); given LwM2MClientFwOtaInfo getTargetUrl() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_givenLwM2MClientFwOtaInfoGetTargetUrlReturnNull() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration));
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link
   *       LwM2mClientContext#getRequestTimeout(LwM2mClient)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); given LwM2mClientContext getRequestTimeout(LwM2mClient) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_givenLwM2mClientContextGetRequestTimeoutReturnNull() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientFwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientFwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration));
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(5));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientFwOtaInfo).getTargetName();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientFwOtaInfo).getTargetVersion();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#getResult()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_thenCallsGetResult() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientFwOtaInfo.getResult()).thenReturn(FirmwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).isUpdateRequired();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#isAssigned()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls isAssigned()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_thenCallsIsAssigned() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    when(lwM2MClientFwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientFwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientFwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration));
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientFwOtaInfo).isAssigned();
    verify(lwM2MClientFwOtaInfo).isSupported();
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(lwM2MClientFwOtaInfo, atLeast(1)).getType();
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient,
   *       TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#onFirmwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnFirmwareStrategyUpdate_thenCallsSendWriteReplaceRequest() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setFwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setFwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
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
    doNothing().when(lwM2MClientFwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientFwOtaInfo).setStrategy(Mockito.<LwM2MFirmwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getFwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getFwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onFirmwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getFwUpdateResource();
    verify(configuration, atLeast(1)).getFwUpdateStrategy();
    verify(clientLwM2mSettings).setFwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(5));
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
    verify(lwM2MClientFwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientFwOtaInfo).setStrategy(eq(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate() {
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate3() {
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
    when(client.getProfileId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(
                client, new OtherConfiguration()));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientOtaInfoStore).putSw(isA(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate4() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    when(clientLwM2mSettings.getSwUpdateStrategy()).thenReturn(1);
    when(clientLwM2mSettings.getSwUpdateResource()).thenReturn("2020-03-01");
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);
    doNothing().when(tbLwM2MClientOtaInfoStore).putSw(Mockito.<LwM2MClientSwOtaInfo>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(null);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(
        client,
        new OtherConfiguration(
            1,
            1,
            1,
            PowerMode.PSM,
            1L,
            1L,
            1L,
            "2020-03-01",
            "2020-03-01",
            "Default Object IDVer"));

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
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate5() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.getType()).thenThrow(new CodecException("An error occurred"));
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate6() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
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
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any()))
        .thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
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
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate7() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn("https://example.org/example");
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate8() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INITIAL);
    when(lwM2MClientSwOtaInfo.getTargetName()).thenReturn("Target Name");
    when(lwM2MClientSwOtaInfo.getTargetUrl()).thenReturn(null);
    when(lwM2MClientSwOtaInfo.getTargetVersion()).thenReturn("1.0.2");
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).getTargetName();
    verify(lwM2MClientSwOtaInfo).getTargetUrl();
    verify(lwM2MClientSwOtaInfo).getTargetVersion();
    verify(lwM2MClientSwOtaInfo).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate9() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(null);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getUpdateState()).thenReturn(SoftwareUpdateState.INSTALLED);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(true);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSession();
    verify(client).getSupportedObjectVersion(eq(9));
    verify(lwM2mClientContext).getRequestTimeout(isA(LwM2mClient.class));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getUpdateState();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#getResult()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls getResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_thenCallsGetResult() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isUpdateRequired()).thenReturn(false);
    when(lwM2MClientSwOtaInfo.getResult()).thenReturn(SoftwareUpdateResult.INITIAL);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getResult();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).isUpdateRequired();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#isAssigned()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls isAssigned()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_thenCallsIsAssigned() {
    // Arrange
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    when(lwM2MClientSwOtaInfo.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(lwM2MClientSwOtaInfo.isAssigned()).thenReturn(true);
    when(lwM2MClientSwOtaInfo.isSupported()).thenReturn(false);
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new CodecException("An error occurred"));
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration));
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(lwM2MClientSwOtaInfo).isAssigned();
    verify(lwM2MClientSwOtaInfo).isSupported();
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(lwM2MClientSwOtaInfo, atLeast(1)).getType();
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient,
   * OtherConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mDownlinkMsgHandler#sendWriteReplaceRequest(LwM2mClient,
   *       TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration); then calls sendWriteReplaceRequest(LwM2mClient, TbLwM2MWriteReplaceRequest, DownlinkRequestCallback)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(LwM2mClient, OtherConfiguration)"
  })
  void testOnCurrentSoftwareStrategyUpdate_thenCallsSendWriteReplaceRequest() {
    // Arrange
    when(lwM2mClientContext.getRequestTimeout(Mockito.<LwM2mClient>any())).thenReturn(1L);
    OtherConfiguration clientLwM2mSettings = mock(OtherConfiguration.class);
    doNothing().when(clientLwM2mSettings).setSwUpdateStrategy(Mockito.<Integer>any());
    clientLwM2mSettings.setSwUpdateStrategy(1);
    new Lwm2mDeviceProfileTransportConfiguration().setClientLwM2mSettings(clientLwM2mSettings);
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
    doNothing().when(lwM2MClientSwOtaInfo).setBaseUrl(Mockito.<String>any());
    doNothing().when(lwM2MClientSwOtaInfo).setStrategy(Mockito.<LwM2MSoftwareUpdateStrategy>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSupportedObjectVersion(Mockito.<Integer>any())).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    OtherConfiguration configuration = mock(OtherConfiguration.class);
    when(configuration.getSwUpdateResource()).thenReturn("2020-03-01");
    when(configuration.getSwUpdateStrategy()).thenReturn(1);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareStrategyUpdate(client, configuration);

    // Assert
    verify(configuration).getSwUpdateResource();
    verify(configuration, atLeast(1)).getSwUpdateStrategy();
    verify(clientLwM2mSettings).setSwUpdateStrategy(eq(1));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getSupportedObjectVersion(eq(9));
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
    verify(lwM2MClientSwOtaInfo).setBaseUrl(eq("2020-03-01"));
    verify(lwM2MClientSwOtaInfo).setStrategy(eq(LwM2MSoftwareUpdateStrategy.BINARY));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersion3Update(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setCurrentVersion3(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareVersion3Update(LwM2mClient, String); then calls setCurrentVersion3(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersion3Update_thenCallsSetCurrentVersion3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersion3Update(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareVersionUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setCurrentVersion(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareVersionUpdate(LwM2mClient, String); then calls setCurrentVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentFirmwareVersionUpdate_thenCallsSetCurrentVersion() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareVersionUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientFwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareStateUpdate(LwM2mClient, Long)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentFirmwareResultUpdate(LwM2mClient, Long)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate2() {
    // Arrange
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any()))
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doThrow(new CodecException("An error occurred"))
        .when(lwM2MClientFwOtaInfo)
        .setDeliveryMethod(Mockito.<Integer>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L));
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
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
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient,
   * Long)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName(
      "Test onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long); then calls setDeliveryMethod(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(LwM2mClient, Long)"
  })
  void testOnCurrentFirmwareDeliveryMethodUpdate_thenCallsSetDeliveryMethod() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = mock(LwM2MClientFwOtaInfo.class);
    doNothing().when(lwM2MClientFwOtaInfo).setDeliveryMethod(Mockito.<Integer>any());
    when(tbLwM2MClientOtaInfoStore.getFw(Mockito.<String>any())).thenReturn(lwM2MClientFwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentFirmwareDeliveryMethodUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), 42L);

    // Assert
    verify(lwM2MClientFwOtaInfo).setDeliveryMethod(eq(42));
    verify(tbLwM2MClientOtaInfoStore).getFw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersion3Update(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#setCurrentVersion3(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersion3Update(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareVersion3Update(LwM2mClient, String); then calls setCurrentVersion3(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersion3Update_thenCallsSetCurrentVersion3() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion3(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersion3Update(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion3(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareVersionUpdate(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link LwM2MClientSwOtaInfo#setCurrentVersion(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareVersionUpdate(LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test onCurrentSoftwareVersionUpdate(LwM2mClient, String); then calls setCurrentVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(LwM2mClient, String)"
  })
  void testOnCurrentSoftwareVersionUpdate_thenCallsSetCurrentVersion() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = mock(LwM2MClientSwOtaInfo.class);
    doNothing().when(lwM2MClientSwOtaInfo).setCurrentVersion(Mockito.<String>any());
    when(tbLwM2MClientOtaInfoStore.getSw(Mockito.<String>any())).thenReturn(lwM2MClientSwOtaInfo);

    // Act
    defaultLwM2MOtaUpdateService.onCurrentSoftwareVersionUpdate(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "1.0.2");

    // Assert
    verify(lwM2MClientSwOtaInfo).setCurrentVersion(eq("1.0.2"));
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareStateUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareStateUpdate(LwM2mClient, Long)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MOtaUpdateService#onCurrentSoftwareResultUpdate(LwM2mClient, Long)}
   */
  @Test
  @DisplayName("Test onCurrentSoftwareResultUpdate(LwM2mClient, Long)")
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
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
  @Tag("MaintainedByDiffblue")
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
    verify(tbLwM2MClientOtaInfoStore).getSw(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}.
   *
   * <p>Method under test: {@link DefaultLwM2MOtaUpdateService#isOtaDownloading(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isOtaDownloading(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
