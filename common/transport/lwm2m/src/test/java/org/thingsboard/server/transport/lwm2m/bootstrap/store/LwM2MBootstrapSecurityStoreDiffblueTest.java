package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(
            Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenThrow(new LwM2MAuthException());
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    // Act
    SecurityInfo actualByIdentity = lwM2MBootstrapSecurityStore.getByIdentity("Identity");

    // Assert
    verify(lwM2MCredentialsSecurityInfoValidator)
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

    // Act
    SecurityInfo actualByOscoreIdentity =
        lwM2MBootstrapSecurityStore.getByOscoreIdentity(
            new OscoreIdentity("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertNull(actualByOscoreIdentity);
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

    // Act and Assert
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

    // Act and Assert
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

    // Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.getBootstrapConfigByEndpoint(
            "https://config.us-east-2.amazonaws.com"));
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
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String); then throw LwM2MAuthException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_thenThrowLwM2MAuthException() {
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
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            new LwM2mTransportContext(),
            mock(LwM2mTransportServerHelper.class));

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

  /**
   * Test {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   *
   * <ul>
   *   <li>When {@link TbLwM2MSecurityInfo} (default constructor) SecurityMode is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addValueToStore(TbLwM2MSecurityInfo, String); when TbLwM2MSecurityInfo (default constructor) SecurityMode is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_whenTbLwM2MSecurityInfoSecurityModeIsNull_thenReturnNull() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            new LwM2mTransportContext(),
            mock(LwM2mTransportServerHelper.class));

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
}
