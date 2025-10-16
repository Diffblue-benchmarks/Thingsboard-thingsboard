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
package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.server.registration.Registration;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.session.LwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2mUplinkMsgHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler;

  @Mock private LwM2MAttributesService lwM2MAttributesService;

  @Mock private LwM2mClientContext lwM2mClientContext;

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLwM2mUplinkMsgHandler.getExecutorSize()"})
  void testGetExecutorSize_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);

    DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler =
        new DefaultLwM2mUplinkMsgHandler(
            transportService,
            context,
            attributesService,
            sessionManager,
            otaService,
            new LwM2MTransportServerConfig(),
            mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class),
            mock(TbLwM2MDtlsSessionStore.class),
            mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class),
            mock(LwM2mVersionedModelProvider.class),
            mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class),
            mock(LwM2MModelConfigService.class));

    // Act and Assert
    assertEquals(0, defaultLwM2mUplinkMsgHandler.getExecutorSize());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenThrow(new RuntimeException());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile2() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile3() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientList.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_givenArrayListAddNull() {
    // Arrange
    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(null);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getLwM2mClients()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getLwM2mClients()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetLwM2mClients() {
    // Arrange
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClientContext).getLwM2mClients();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(SessionInfoProto,
   * DeviceProfile)} with {@code sessionInfo}, {@code deviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#onDeviceProfileUpdate(TransportProtos.SessionInfoProto,
   * DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test onDeviceProfileUpdate(SessionInfoProto, DeviceProfile) with 'sessionInfo', 'deviceProfile'; then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)"
  })
  void testOnDeviceProfileUpdateWithSessionInfoDeviceProfile_thenCallsGetProfileId() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getProfileId()).thenReturn(UUID.randomUUID());

    ArrayList<LwM2mClient> lwM2mClientList = new ArrayList<>();
    lwM2mClientList.add(lwM2mClient);
    when(lwM2mClientContext.getLwM2mClients()).thenReturn(lwM2mClientList);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2mUplinkMsgHandler.onDeviceProfileUpdate(sessionInfo, new DeviceProfile());

    // Assert
    verify(lwM2mClient, atLeast(1)).getProfileId();
    verify(lwM2mClientContext).getLwM2mClients();
  }

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    ArrayList<LwM2mObjectInstance> lwM2mObjectInstanceList = new ArrayList<>();
    lwM2mObjectInstanceList.add(new LwM2mObjectInstance(new ArrayList<>()));
    lwM2mObjectInstanceList.add(new LwM2mObjectInstance(new ArrayList<>()));

    CreateRequest request = mock(CreateRequest.class);
    when(request.getObjectInstances()).thenReturn(lwM2mObjectInstanceList);

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(request, atLeast(1)).getObjectInstances();
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String,
   * CreateRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link CreateRequest#getObjectInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient,
   * String, CreateRequest)}
   */
  @Test
  @DisplayName(
      "Test onCreateResponseOk(LwM2mClient, String, CreateRequest); given ArrayList(); then calls getObjectInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk_givenArrayList_thenCallsGetObjectInstances() {
    // Arrange
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    CreateRequest request = mock(CreateRequest.class);
    when(request.getObjectInstances()).thenReturn(new ArrayList<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(request, atLeast(1)).getObjectInstances();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"
  })
  void testOnCreateResponseOk_whenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    CreateRequest request = new CreateRequest(1, new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path", request);

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(Registration)"
  })
  void testGetSessionInfoOrCloseSession() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    SessionInfoProto actualSessionInfoOrCloseSession =
        defaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2mUplinkMsgHandler#getSessionInfoOrCloseSession(Registration)}
   */
  @Test
  @DisplayName("Test getSessionInfoOrCloseSession(Registration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(Registration)"
  })
  void testGetSessionInfoOrCloseSession2() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(null);

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    SessionInfoProto actualSessionInfoOrCloseSession =
        defaultLwM2mUplinkMsgHandler.getSessionInfoOrCloseSession(registration);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint("https://config.us-east-2.amazonaws.com");
    assertNull(actualSessionInfoOrCloseSession);
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Given randomUUID.
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName(
      "Test initAttributes(LwM2mClient, boolean); given randomUUID; then calls getProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_givenRandomUUID_thenCallsGetProfileId() {
    // Arrange
    SettableFuture<List<TsKvProto>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<TsKvProto>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(lwM2MAttributesService.getSharedAttributes(
            Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("foo", "foo");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getProfileId()).thenReturn(UUID.randomUUID());

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(lwM2MClient, true);

    // Assert
    verify(lwM2MAttributesService)
        .getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(lwM2MClient).getProfileId();
    verify(lwM2mClientContext).getProfile(isA(UUID.class));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetProfile() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MAttributesService#getSharedAttributes(LwM2mClient, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName(
      "Test initAttributes(LwM2mClient, boolean); then calls getSharedAttributes(LwM2mClient, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetSharedAttributes() {
    // Arrange
    SettableFuture<List<TsKvProto>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<TsKvProto>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(lwM2MAttributesService.getSharedAttributes(
            Mockito.<LwM2mClient>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    HashMap<String, String> keyName = new HashMap<>();
    keyName.put("foo", "foo");
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    TelemetryMappingConfiguration observeAttr =
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2MAttributesService)
        .getSharedAttributes(isA(LwM2mClient.class), isA(Collection.class));
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }
}
