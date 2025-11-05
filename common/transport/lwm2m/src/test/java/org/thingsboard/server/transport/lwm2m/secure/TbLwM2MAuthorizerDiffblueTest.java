package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.peer.LwM2mIdentity;
import org.eclipse.leshan.core.peer.LwM2mPeer;
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
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.store.TbMainSecurityStore;

@ExtendWith(MockitoExtension.class)
class TbLwM2MAuthorizerDiffblueTest {
  @InjectMocks private TbLwM2MAuthorizer tbLwM2MAuthorizer;

  @Mock private TbMainSecurityStore tbMainSecurityStore;

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName("Test isAuthorized(UplinkRequest, Registration, LwM2mPeer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized() throws InvalidRequestException {
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
    verify(tbMainSecurityStore).getByEndpoint("https://config.us-east-2.amazonaws.com");
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isApproved());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isDeclined());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName("Test isAuthorized(UplinkRequest, Registration, LwM2mPeer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized2() throws InvalidRequestException {
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
    verify(tbMainSecurityStore).getByEndpoint("https://config.us-east-2.amazonaws.com");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    verify(tbMainSecurityStore).getByEndpoint("https://config.us-east-2.amazonaws.com");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    verify(tbMainSecurityStore).getByEndpoint("https://config.us-east-2.amazonaws.com");
    assertFalse(actualIsAuthorizedResult.hasApplicationData());
    assertFalse(actualIsAuthorizedResult.isDeclined());
    assertTrue(actualIsAuthorizedResult.getApplicationData().isEmpty());
    assertTrue(actualIsAuthorizedResult.isApproved());
  }

  /**
   * Test {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration, LwM2mPeer)}.
   *
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MAuthorizer#isAuthorized(UplinkRequest, Registration,
   * LwM2mPeer)}
   */
  @Test
  @DisplayName(
      "Test isAuthorized(UplinkRequest, Registration, LwM2mPeer); then throw LwM2MAuthException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Authorization TbLwM2MAuthorizer.isAuthorized(UplinkRequest, Registration, LwM2mPeer)"
  })
  void testIsAuthorized_thenThrowLwM2MAuthException() throws InvalidRequestException {
    // Arrange
    when(tbMainSecurityStore.getByEndpoint(Mockito.<String>any()))
        .thenThrow(new LwM2MAuthException());
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");

    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () -> tbLwM2MAuthorizer.isAuthorized(request, registration, mock(LwM2mPeer.class)));
    verify(registration).getEndpoint();
    verify(tbMainSecurityStore).getByEndpoint("https://config.us-east-2.amazonaws.com");
  }
}
