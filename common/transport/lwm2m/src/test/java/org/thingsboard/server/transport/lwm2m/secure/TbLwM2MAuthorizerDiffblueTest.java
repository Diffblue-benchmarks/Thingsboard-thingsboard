package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.peer.LwM2mIdentity;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.core.peer.PskIdentity;
import org.eclipse.leshan.core.peer.X509Identity;
import org.eclipse.leshan.core.request.BootstrapRequest;
import org.eclipse.leshan.core.request.UplinkRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.server.registration.Registration;
import org.eclipse.leshan.server.security.Authorization;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.transport.lwm2m.server.store.TbMainSecurityStore;

@ExtendWith(MockitoExtension.class)
class TbLwM2MAuthorizerDiffblueTest {
  @InjectMocks private TbLwM2MAuthorizer tbLwM2MAuthorizer;

  @Mock private TbMainSecurityStore tbMainSecurityStore;

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mIdentity} {@link LwM2mIdentity#isSecure()} return {@code false}.
   *   <li>Then calls {@link LwM2mIdentity#isSecure()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given LwM2mIdentity isSecure() return 'false'; then calls isSecure()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenLwM2mIdentityIsSecureReturnFalse_thenCallsIsSecure()
      throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mIdentity lwM2mIdentity = mock(LwM2mIdentity.class);
    when(lwM2mIdentity.isSecure()).thenReturn(false);
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(lwM2mIdentity);

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(lwM2mIdentity).isSecure();
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mIdentity} {@link LwM2mIdentity#isSecure()} return {@code true}.
   *   <li>Then calls {@link LwM2mIdentity#isSecure()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given LwM2mIdentity isSecure() return 'true'; then calls isSecure()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenLwM2mIdentityIsSecureReturnTrue_thenCallsIsSecure()
      throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mIdentity lwM2mIdentity = mock(LwM2mIdentity.class);
    when(lwM2mIdentity.isSecure()).thenReturn(true);
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(lwM2mIdentity);

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(lwM2mIdentity).isSecure();
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link OscoreIdentity#OscoreIdentity(byte[])} with recipientId is {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given OscoreIdentity(byte[]) with recipientId is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenOscoreIdentityWithRecipientIdIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8")));

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link PskIdentity#PskIdentity(String)} with {@code Psk Identity}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given PskIdentity(String) with 'Psk Identity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenPskIdentityWithPskIdentity() throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(new PskIdentity("Psk Identity"));

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link TbMainSecurityStore} {@link TbMainSecurityStore#getByEndpoint(String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given TbMainSecurityStore getByEndpoint(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenTbMainSecurityStoreGetByEndpointReturnNull()
      throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any())).thenReturn(null);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mIdentity lwM2mIdentity = mock(LwM2mIdentity.class);
    when(lwM2mIdentity.isSecure()).thenReturn(true);
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(lwM2mIdentity);

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(lwM2mIdentity).isSecure();
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Given {@link X509Identity#X509Identity(String)} with {@code X509 Common Name}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); given X509Identity(String) with 'X509 Common Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_givenX509IdentityWithX509CommonName() throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(new X509Identity("X509 Common Name"));

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(sender).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Then return not Declined.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); then return not Declined")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_thenReturnNotDeclined() throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any())).thenReturn(null);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    LwM2mIdentity lwM2mIdentity = mock(LwM2mIdentity.class);
    when(lwM2mIdentity.isSecure()).thenReturn(false);
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(lwM2mIdentity);

    // Act
    Authorization actualIsAuthorizedResult =
        tbLwM2MAuthorizer.isAuthorized(request, registration, sender);

    // Assert
    verify(lwM2mIdentity).isSecure();
    verify(sender, atLeast(1)).getIdentity();
    verify(registration, atLeast(1)).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isDeclined());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isApproved());
  }
}
