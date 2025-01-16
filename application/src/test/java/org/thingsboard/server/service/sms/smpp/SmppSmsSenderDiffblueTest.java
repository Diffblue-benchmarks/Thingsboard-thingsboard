package org.thingsboard.server.service.sms.smpp;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.sms.exception.SmsParseException;
import org.thingsboard.server.common.data.sms.config.SmppSmsProviderConfiguration;

@ContextConfiguration(classes = {SmppSmsSender.class})
@ExtendWith(SpringExtension.class)
class SmppSmsSenderDiffblueTest {
  @Autowired
  private SmppSmsSender smppSmsSender;

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given empty string")
  void testNewSmppSmsSender_givenEmptyString() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getHost()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given 'foo'; when SmppSmsProviderConfiguration getHost() return 'foo'")
  void testNewSmppSmsSender_givenFoo_whenSmppSmsProviderConfigurationGetHostReturnFoo() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("foo");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getPort()} return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given one; when SmppSmsProviderConfiguration getPort() return one")
  void testNewSmppSmsSender_givenOne_whenSmppSmsProviderConfigurationGetPortReturnOne() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(1);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code RX}.</li>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getBindType()} return {@code RX}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given 'RX'; when SmppSmsProviderConfiguration getBindType() return 'RX'")
  void testNewSmppSmsSender_givenRx_whenSmppSmsProviderConfigurationGetBindTypeReturnRx() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.RX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@link SmsParseException#SmsParseException(String)} with
   * {@code Msg}.</li>
   *   <li>Then throw {@link SmsParseException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given SmsParseException(String) with 'Msg'; then throw SmsParseException")
  void testNewSmppSmsSender_givenSmsParseExceptionWithMsg_thenThrowSmsParseException() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceTon()).thenThrow(new SmsParseException("Msg"));
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(SmsParseException.class, () -> new SmppSmsSender(config));
    verify(config).getBindType();
    verify(config).getSourceAddress();
    verify(config).getSourceTon();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given 'TRX'")
  void testNewSmppSmsSender_givenTrx() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TRX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Then calls {@link SmppSmsProviderConfiguration#getSourceNpi()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); then calls getSourceNpi()")
  void testNewSmppSmsSender_thenCallsGetSourceNpi() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration} (default constructor)
   * AddressRange is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration (default constructor) AddressRange is '42 Main St'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationAddressRangeIs42MainSt() {
    // Arrange
    SmppSmsProviderConfiguration config = new SmppSmsProviderConfiguration();
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getDestinationNpi()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getDestinationNpi() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetDestinationNpiReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn(null);
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config, atLeast(1)).setDestinationNpi(Mockito.<Byte>any());
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getDestinationTon()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getDestinationTon() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetDestinationTonReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn(null);
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config, atLeast(1)).setDestinationTon(Mockito.<Byte>any());
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getPassword()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getPassword() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetPasswordReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn(null);
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getSourceAddress()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getSourceAddress() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetSourceAddressReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn(null);
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getSourceNpi()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getSourceNpi() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetSourceNpiReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn(null);
    when(config.getSourceTon()).thenReturn((byte) 'A');
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config, atLeast(1)).setSourceNpi(Mockito.<Byte>any());
    verify(config).setSourceTon(eq((byte) 65));
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link SmppSmsProviderConfiguration}
   * {@link SmppSmsProviderConfiguration#getSourceTon()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration getSourceTon() return 'null'")
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationGetSourceTonReturnNull() {
    // Arrange
    SmppSmsProviderConfiguration config = mock(SmppSmsProviderConfiguration.class);
    when(config.getSourceNpi()).thenReturn((byte) 'A');
    when(config.getSourceTon()).thenReturn(null);
    when(config.getPassword()).thenReturn("iloveyou");
    when(config.getProtocolVersion()).thenReturn("1.0.2");
    when(config.getSystemId()).thenReturn("42");
    when(config.getDestinationNpi()).thenReturn((byte) 'A');
    when(config.getDestinationTon()).thenReturn((byte) 'A');
    when(config.getPort()).thenReturn(8080);
    when(config.getHost()).thenReturn("localhost");
    when(config.getSourceAddress()).thenReturn("42 Main St");
    when(config.getBindType()).thenReturn(SmppSmsProviderConfiguration.SmppBindType.TX);
    doNothing().when(config).setAddressRange(Mockito.<String>any());
    doNothing().when(config).setBindType(Mockito.<SmppSmsProviderConfiguration.SmppBindType>any());
    doNothing().when(config).setCodingScheme(Mockito.<Byte>any());
    doNothing().when(config).setDestinationNpi(Mockito.<Byte>any());
    doNothing().when(config).setDestinationTon(Mockito.<Byte>any());
    doNothing().when(config).setHost(Mockito.<String>any());
    doNothing().when(config).setPassword(Mockito.<String>any());
    doNothing().when(config).setPort(Mockito.<Integer>any());
    doNothing().when(config).setProtocolVersion(Mockito.<String>any());
    doNothing().when(config).setServiceType(Mockito.<String>any());
    doNothing().when(config).setSourceAddress(Mockito.<String>any());
    doNothing().when(config).setSourceNpi(Mockito.<Byte>any());
    doNothing().when(config).setSourceTon(Mockito.<Byte>any());
    doNothing().when(config).setSystemId(Mockito.<String>any());
    doNothing().when(config).setSystemType(Mockito.<String>any());
    config.setAddressRange("42 Main St");
    config.setBindType(SmppSmsProviderConfiguration.SmppBindType.TX);
    config.setCodingScheme((byte) 'A');
    config.setDestinationNpi((byte) 'A');
    config.setDestinationTon((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSourceAddress("42 Main St");
    config.setSourceNpi((byte) 'A');
    config.setSourceTon((byte) 'A');
    config.setSystemId("42");
    config.setSystemType("System Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
    verify(config, atLeast(1)).getBindType();
    verify(config).getDestinationNpi();
    verify(config).getDestinationTon();
    verify(config).getHost();
    verify(config).getPassword();
    verify(config).getPort();
    verify(config, atLeast(1)).getProtocolVersion();
    verify(config).getSourceAddress();
    verify(config).getSourceNpi();
    verify(config).getSourceTon();
    verify(config).getSystemId();
    verify(config).setAddressRange(eq("42 Main St"));
    verify(config).setBindType(eq(SmppSmsProviderConfiguration.SmppBindType.TX));
    verify(config).setCodingScheme(eq((byte) 65));
    verify(config).setDestinationNpi(eq((byte) 65));
    verify(config).setDestinationTon(eq((byte) 65));
    verify(config).setHost(eq("localhost"));
    verify(config).setPassword(eq("iloveyou"));
    verify(config).setPort(eq(8080));
    verify(config).setProtocolVersion(eq("1.0.2"));
    verify(config).setServiceType(eq("Service Type"));
    verify(config).setSourceAddress(eq("42 Main St"));
    verify(config).setSourceNpi(eq((byte) 65));
    verify(config, atLeast(1)).setSourceTon(Mockito.<Byte>any());
    verify(config).setSystemId(eq("42"));
    verify(config).setSystemType(eq("System Type"));
  }
}
