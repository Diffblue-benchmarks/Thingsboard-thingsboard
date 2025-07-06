package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.EditableBootstrapConfigStore;
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
  @Tag("MaintainedByDiffblue")
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
            eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
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
  @Tag("MaintainedByDiffblue")
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
        .getEndpointSecurityInfoByCredentialsId(eq("Identity"), eq(LwM2mTypeServer.BOOTSTRAP));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo LwM2MBootstrapSecurityStore.getByIdentity(String)"})
  void testGetByIdentity_thenCallsGetTransportService() {
    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenThrow(new LwM2MAuthException());
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());

    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore =
        new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity =
        new LwM2MBootstrapSecurityStore(
                bootstrapConfigStore,
                lwM2MCredentialsSecurityInfoValidator,
                context2,
                new LwM2mTransportServerHelper(new LwM2mTransportContext()))
            .getByIdentity("Identity");

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
            eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getSessionByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "SecurityInfo LwM2MBootstrapSecurityStore.addValueToStore(TbLwM2MSecurityInfo, String)"
  })
  void testAddValueToStore_givenLwM2MBootstrapSecurityStore_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        lwM2MBootstrapSecurityStore.addValueToStore(
            null, "https://config.us-east-2.amazonaws.com"));
  }
}
