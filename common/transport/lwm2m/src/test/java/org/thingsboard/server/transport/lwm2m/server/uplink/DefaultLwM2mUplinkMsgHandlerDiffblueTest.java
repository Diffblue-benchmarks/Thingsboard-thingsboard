package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2mUplinkMsgHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler;

  @Mock private LwM2mClientContext lwM2mClientContext;

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#awake(LwM2mClient)} return
   *       {@code true}.
   *   <li>Then calls {@link Registration#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}
   */
  @Test
  @DisplayName(
      "Test onAwakeDev(Registration); given LwM2mClientContext awake(LwM2mClient) return 'true'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onAwakeDev(Registration)"})
  void testOnAwakeDev_givenLwM2mClientContextAwakeReturnTrue_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onAwakeDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mObjectInstance lwM2mObjectInstance = new LwM2mObjectInstance(new ArrayList<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(
        client,
        "Path",
        new CreateRequest(1, lwM2mObjectInstance, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <ul>
   *   <li>When {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with resources is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName(
      "Test onCreateResponseOk(LwM2mClient, String, CreateRequest); when LwM2mObjectInstance(Collection) with resources is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk_whenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(
        client, "Path", new CreateRequest(1, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); then calls getProfile(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetProfile() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }
}
