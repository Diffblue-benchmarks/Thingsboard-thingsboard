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
package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.EditableBootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.InMemoryBootstrapConfigStore;
import org.eclipse.leshan.server.security.SecurityInfo;
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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MBootstrapClientCredential;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MBootstrapServerCredential;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2MBootstrapSecurityStoreDiffblueTest {
  @Mock private EditableBootstrapConfigStore editableBootstrapConfigStore;

  @InjectMocks private LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore;

  @Mock private LwM2mCredentialsSecurityInfoValidator lwM2mCredentialsSecurityInfoValidator;

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getAllByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator LwM2MBootstrapSecurityStore.getAllByEndpoint(String)"})
  void testGetAllByEndpoint() {
    // Arrange
    when(lwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
            Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.getAllByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mCredentialsSecurityInfoValidator)
        .getEndpointSecurityInfoByCredentialsId(
            "https://config.us-east-2.amazonaws.com", LwM2mTypeServer.BOOTSTRAP);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       LwM2mCredentialsSecurityInfoValidator#getEndpointSecurityInfoByCredentialsId(String,
   *       LwM2mTypeServer)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName(
      "Test getByIdentity(String); then calls getEndpointSecurityInfoByCredentialsId(String, LwM2mTypeServer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo LwM2MBootstrapSecurityStore.getByIdentity(String)"})
  void testGetByIdentity_thenCallsGetEndpointSecurityInfoByCredentialsId() {
    // Arrange
    when(lwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
            Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenThrow(new LwM2MAuthException());

    // Act
    SecurityInfo actualByIdentity = lwM2MBootstrapSecurityStore.getByIdentity("Identity");

    // Assert
    verify(lwM2mCredentialsSecurityInfoValidator)
        .getEndpointSecurityInfoByCredentialsId("Identity", LwM2mTypeServer.BOOTSTRAP);
    assertNull(actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getTransportService()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); then calls getTransportService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo LwM2MBootstrapSecurityStore.getByIdentity(String)"})
  void testGetByIdentity_thenCallsGetTransportService() {
    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenThrow(new LwM2MAuthException());
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    // Act
    SecurityInfo actualByIdentity = lwM2MBootstrapSecurityStore.getByIdentity("Identity");

    // Assert
    verify(context).getTransportService();
    assertNull(actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.getByOscoreIdentity(OscoreIdentity)"
  })
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.getByOscoreIdentity(
            new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getX509ByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbLwM2MSecurityInfo LwM2MBootstrapSecurityStore.getX509ByEndpoint(String)"})
  void testGetX509ByEndpoint() {
    // Arrange
    when(lwM2mCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
            Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.getX509ByEndpoint(
                "https://config.us-east-2.amazonaws.com"));
    verify(lwM2mCredentialsSecurityInfoValidator)
        .getEndpointSecurityInfoByCredentialsId(
            "https://config.us-east-2.amazonaws.com", LwM2mTypeServer.BOOTSTRAP);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getSessionByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto LwM2MBootstrapSecurityStore.getSessionByEndpoint(String)"
  })
  void testGetSessionByEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.getSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test removeSessionByEndpoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto LwM2MBootstrapSecurityStore.removeSessionByEndpoint(String)"
  })
  void testRemoveSessionByEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.removeSessionByEndpoint(
            "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BootstrapConfig LwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(String)"
  })
  void testGetBootstrapConfigByEndpoint_thenReturnNull() {
    // Arrange
    when(editableBootstrapConfigStore.getAll()).thenReturn(new HashMap<>());

    // Act
    BootstrapConfig actualBootstrapConfigByEndpoint =
        lwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(
            "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(editableBootstrapConfigStore).getAll();
    assertNull(actualBootstrapConfigByEndpoint);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String); then throw LwM2MAuthException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BootstrapConfig LwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(String)"
  })
  void testGetBootstrapConfigByEndpoint_thenThrowLwM2MAuthException() {
    // Arrange
    when(editableBootstrapConfigStore.getAll()).thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(
                "https://config.us-east-2.amazonaws.com"));
    verify(editableBootstrapConfigStore).getAll();
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore() {
    // Arrange
    TbLwM2MSecurityInfo store = mock(TbLwM2MSecurityInfo.class);
    when(store.getBootstrapCredentialConfig()).thenThrow(new LwM2MAuthException());

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.addValueToStore(
                store, "https://config.us-east-2.amazonaws.com"));
    verify(store).getBootstrapCredentialConfig();
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore2() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    ArrayList<LwM2MBootstrapServerCredential> serverConfiguration = new ArrayList<>();
    serverConfiguration.add(mock(LwM2MBootstrapServerCredential.class));
    LwM2MBootstrapConfig lwM2MBootstrapConfig =
        new LwM2MBootstrapConfig(
            serverConfiguration,
            mock(LwM2MBootstrapClientCredential.class),
            mock(LwM2MBootstrapClientCredential.class));

    TbLwM2MSecurityInfo store = mock(TbLwM2MSecurityInfo.class);
    when(store.getSecurityMode()).thenThrow(new LwM2MAuthException());
    when(store.getBootstrapCredentialConfig()).thenReturn(lwM2MBootstrapConfig);

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.addValueToStore(
                store, "https://config.us-east-2.amazonaws.com"));
    verify(store).getBootstrapCredentialConfig();
    verify(store).getSecurityMode();
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2MBootstrapSecurityStore}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addValueToStore(TbLwM2MSecurityInfo, String); given LwM2MBootstrapSecurityStore; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_givenLwM2MBootstrapSecurityStore_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.addValueToStore(
            null, "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbLwM2MSecurityInfo} (default constructor) SecurityMode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addValueToStore(TbLwM2MSecurityInfo, String); given 'null'; when TbLwM2MSecurityInfo (default constructor) SecurityMode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_givenNull_whenTbLwM2MSecurityInfoSecurityModeIsNull() {
    // Arrange
    TbLwM2MSecurityInfo store = new TbLwM2MSecurityInfo();
    store.setBootstrapConfig(new BootstrapConfig());
    store.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    store.setDeviceProfile(new DeviceProfile());
    store.setEndpoint("https://config.us-east-2.amazonaws.com");
    store.setMsg(mock(ValidateDeviceCredentialsResponse.class));
    store.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    store.setSecurityMode(null);

    // Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.addValueToStore(
            store, "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getNodeId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String); then calls getNodeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_thenCallsGetNodeId() {
    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(context);
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig());

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            new LwM2mTransportContext(),
            helper);

    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.getDeviceInfo()).thenThrow(new LwM2MAuthException());

    TbLwM2MSecurityInfo store = new TbLwM2MSecurityInfo();
    store.setBootstrapConfig(new BootstrapConfig());
    store.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    store.setDeviceProfile(new DeviceProfile());
    store.setEndpoint("https://config.us-east-2.amazonaws.com");
    store.setMsg(msg);
    store.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    store.setSecurityMode(SecurityMode.PSK);

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.addValueToStore(
                store, "https://config.us-east-2.amazonaws.com"));
    verify(context).getNodeId();
    verify(msg).getDeviceInfo();
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TbLwM2MSecurityInfo#getSecurityInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String); then calls getSecurityInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_thenCallsGetSecurityInfo() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    ArrayList<LwM2MBootstrapServerCredential> serverConfiguration = new ArrayList<>();
    serverConfiguration.add(mock(LwM2MBootstrapServerCredential.class));
    LwM2MBootstrapConfig lwM2MBootstrapConfig =
        new LwM2MBootstrapConfig(
            serverConfiguration,
            mock(LwM2MBootstrapClientCredential.class),
            mock(LwM2MBootstrapClientCredential.class));

    TbLwM2MSecurityInfo store = mock(TbLwM2MSecurityInfo.class);
    when(store.getSecurityInfo()).thenThrow(new LwM2MAuthException());
    when(store.getSecurityMode()).thenReturn(SecurityMode.PSK);
    when(store.getBootstrapCredentialConfig()).thenReturn(lwM2MBootstrapConfig);

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            lwM2MBootstrapSecurityStore.addValueToStore(
                store, "https://config.us-east-2.amazonaws.com"));
    verify(store).getBootstrapCredentialConfig();
    verify(store).getSecurityInfo();
    verify(store).getSecurityMode();
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>When {@link TbLwM2MSecurityInfo} (default constructor) BootstrapCredentialConfig is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addValueToStore(TbLwM2MSecurityInfo, String); when TbLwM2MSecurityInfo (default constructor) BootstrapCredentialConfig is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_whenTbLwM2MSecurityInfoBootstrapCredentialConfigIsNull() {
    // Arrange
    TbLwM2MSecurityInfo store = new TbLwM2MSecurityInfo();
    store.setBootstrapConfig(new BootstrapConfig());
    store.setBootstrapCredentialConfig(null);
    store.setDeviceProfile(new DeviceProfile());
    store.setEndpoint("https://config.us-east-2.amazonaws.com");
    store.setMsg(mock(ValidateDeviceCredentialsResponse.class));
    store.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    store.setSecurityMode(SecurityMode.PSK);

    // Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.addValueToStore(
            store, "https://config.us-east-2.amazonaws.com"));
  }
}
