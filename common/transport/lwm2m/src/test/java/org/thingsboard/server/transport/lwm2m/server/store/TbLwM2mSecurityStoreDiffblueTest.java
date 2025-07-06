package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.security.NonUniqueSecurityInfoException;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

class TbLwM2mSecurityStoreDiffblueTest {
  /**
   * Test {@link TbLwM2mSecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getTbLwM2MSecurityInfoByEndpoint(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbLwM2MSecurityInfo TbLwM2mSecurityStore.getTbLwM2MSecurityInfoByEndpoint(String)"
  })
  void testGetTbLwM2MSecurityInfoByEndpoint_thenReturnNull() {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertNull(
        new TbLwM2mSecurityStore(
                securityStore,
                new LwM2mCredentialsSecurityInfoValidator(
                    context, new LwM2MTransportServerConfig()))
            .getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    new TbLwM2mSecurityStore(
            securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getEndpoint()} throw {@link
   *       LwM2MAuthException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); given SecurityInfo getEndpoint() throw LwM2MAuthException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_givenSecurityInfoGetEndpointThrowLwM2MAuthException() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getEndpoint()).thenThrow(new LwM2MAuthException());
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            new TbLwM2mSecurityStore(
                    securityStore,
                    new LwM2mCredentialsSecurityInfoValidator(
                        context, new LwM2MTransportServerConfig()))
                .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).getEndpoint();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getPreSharedKey()} throw {@link
   *       LwM2MAuthException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); given SecurityInfo getPreSharedKey() throw LwM2MAuthException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_givenSecurityInfoGetPreSharedKeyThrowLwM2MAuthException() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPreSharedKey()).thenThrow(new LwM2MAuthException());
    when(securityInfo.getPskIdentity()).thenReturn("NO_SEC");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            new TbLwM2mSecurityStore(
                    securityStore,
                    new LwM2mCredentialsSecurityInfoValidator(
                        context, new LwM2MTransportServerConfig()))
                .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPreSharedKey();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getPskIdentity()} return {@code Psk
   *       Identity}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); given SecurityInfo getPskIdentity() return 'Psk Identity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_givenSecurityInfoGetPskIdentityReturnPskIdentity() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPskIdentity()).thenReturn("Psk Identity");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    new TbLwM2mSecurityStore(
            securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getPskIdentity()} throw {@link
   *       LwM2MAuthException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); given SecurityInfo getPskIdentity() throw LwM2MAuthException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_givenSecurityInfoGetPskIdentityThrowLwM2MAuthException() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPskIdentity()).thenThrow(new LwM2MAuthException());
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            new TbLwM2mSecurityStore(
                    securityStore,
                    new LwM2mCredentialsSecurityInfoValidator(
                        context, new LwM2MTransportServerConfig()))
                .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#usePSK()} throw {@link LwM2MAuthException}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); given SecurityInfo usePSK() throw LwM2MAuthException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_givenSecurityInfoUsePSKThrowLwM2MAuthException() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.usePSK()).thenThrow(new LwM2MAuthException());
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(
        LwM2MAuthException.class,
        () ->
            new TbLwM2mSecurityStore(
                    securityStore,
                    new LwM2mCredentialsSecurityInfoValidator(
                        context, new LwM2MTransportServerConfig()))
                .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then calls {@link SecurityInfo#getPreSharedKey()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); then calls getPreSharedKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_thenCallsGetPreSharedKey() throws UnsupportedEncodingException {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPreSharedKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(securityInfo.getPskIdentity()).thenReturn("NO_SEC");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    new TbLwM2mSecurityStore(
            securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPreSharedKey();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then return newX509CertInfo {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName(
      "Test getByEndpoint(String); then return newX509CertInfo 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByEndpoint(String)"})
  void testGetByEndpoint_thenReturnNewX509CertInfoHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    SecurityInfo newX509CertInfoResult =
        SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(newX509CertInfoResult);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByEndpoint =
        new TbLwM2mSecurityStore(
                securityStore,
                new LwM2mCredentialsSecurityInfoValidator(
                    context, new LwM2MTransportServerConfig()))
            .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertSame(newX509CertInfoResult, actualByEndpoint);
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByIdentity(String)}.
   *
   * <ul>
   *   <li>Then return newX509CertInfo {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName(
      "Test getByIdentity(String); then return newX509CertInfo 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByIdentity(String)"})
  void testGetByIdentity_thenReturnNewX509CertInfoHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    SecurityInfo newX509CertInfoResult =
        SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(securityStore.getByIdentity(Mockito.<String>any())).thenReturn(newX509CertInfoResult);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity =
        new TbLwM2mSecurityStore(
                securityStore,
                new LwM2mCredentialsSecurityInfoValidator(
                    context, new LwM2MTransportServerConfig()))
            .getByIdentity("Psk Identity");

    // Assert
    verify(securityStore).getByIdentity(eq("Psk Identity"));
    assertSame(newX509CertInfoResult, actualByIdentity);
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByIdentity(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByIdentity(String)"})
  void testGetByIdentity_thenReturnNull() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByIdentity(Mockito.<String>any())).thenReturn(null);
    LwM2mCredentialsSecurityInfoValidator validator =
        mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(validator.getEndpointSecurityInfoByCredentialsId(
            Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenThrow(new LwM2MAuthException());

    // Act
    SecurityInfo actualByIdentity =
        new TbLwM2mSecurityStore(securityStore, validator).getByIdentity("Psk Identity");

    // Assert
    verify(securityStore).getByIdentity(eq("Psk Identity"));
    verify(validator)
        .getEndpointSecurityInfoByCredentialsId(eq("Psk Identity"), eq(LwM2mTypeServer.CLIENT));
    assertNull(actualByIdentity);
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityInfo TbLwM2mSecurityStore.getByOscoreIdentity(OscoreIdentity)"})
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore =
        new TbLwM2mSecurityStore(
            securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    // Act and Assert
    assertNull(
        tbLwM2mSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}.
   *
   * <p>Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  @DisplayName("Test putX509(TbLwM2MSecurityInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2mSecurityStore.putX509(TbLwM2MSecurityInfo)"})
  void testPutX509() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore =
        new TbLwM2mSecurityStore(
            securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    securityInfo.setBootstrapConfig(new BootstrapConfig());
    securityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo2 =
        SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(securityInfo2);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(
        securityInfo2,
        tbLwM2mSecurityStore.getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }
}
