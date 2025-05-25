package org.thingsboard.server.service.sms.smpp;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.sms.config.SmppSmsProviderConfiguration;
import org.thingsboard.server.common.data.sms.config.SmppSmsProviderConfiguration.SmppBindType;

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
   * Method under test: {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmppSmsSender.<init>(SmppSmsProviderConfiguration)"})
  void testNewSmppSmsSender_givenEmptyString() {
    // Arrange
    SmppSmsProviderConfiguration config = new SmppSmsProviderConfiguration();
    config.setAddressRange("42 Main St");
    config.setCodingScheme((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSystemId("42");
    config.setSystemType("System Type");
    config.setBindType(null);
    config.setSourceAddress("");
    config.setSourceTon(null);
    config.setSourceNpi(null);
    config.setDestinationTon(null);
    config.setDestinationNpi(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code not empty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmppSmsSender.<init>(SmppSmsProviderConfiguration)"})
  void testNewSmppSmsSender_givenNotEmpty() {
    // Arrange
    SmppSmsProviderConfiguration config = new SmppSmsProviderConfiguration();
    config.setAddressRange("42 Main St");
    config.setCodingScheme((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSystemId("42");
    config.setSystemType("System Type");
    config.setBindType(null);
    config.setSourceAddress("not empty");
    config.setSourceTon(null);
    config.setSourceNpi(null);
    config.setDestinationTon(null);
    config.setDestinationNpi(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
  }

  /**
   * Test {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code TX}.</li>
   *   <li>When {@link SmppSmsProviderConfiguration} (default constructor) BindType is {@code TX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); given 'TX'; when SmppSmsProviderConfiguration (default constructor) BindType is 'TX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmppSmsSender.<init>(SmppSmsProviderConfiguration)"})
  void testNewSmppSmsSender_givenTx_whenSmppSmsProviderConfigurationBindTypeIsTx() {
    // Arrange
    SmppSmsProviderConfiguration config = new SmppSmsProviderConfiguration();
    config.setAddressRange("42 Main St");
    config.setBindType(SmppBindType.TX);
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
   *   <li>When {@link SmppSmsProviderConfiguration} (default constructor) SourceAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsSender#SmppSmsSender(SmppSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new SmppSmsSender(SmppSmsProviderConfiguration); when SmppSmsProviderConfiguration (default constructor) SourceAddress is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmppSmsSender.<init>(SmppSmsProviderConfiguration)"})
  void testNewSmppSmsSender_whenSmppSmsProviderConfigurationSourceAddressIsNull() {
    // Arrange
    SmppSmsProviderConfiguration config = new SmppSmsProviderConfiguration();
    config.setAddressRange("42 Main St");
    config.setCodingScheme((byte) 'A');
    config.setHost("localhost");
    config.setPassword("iloveyou");
    config.setPort(8080);
    config.setProtocolVersion("1.0.2");
    config.setServiceType("Service Type");
    config.setSystemId("42");
    config.setSystemType("System Type");
    config.setBindType(null);
    config.setSourceAddress(null);
    config.setSourceTon(null);
    config.setSourceNpi(null);
    config.setDestinationTon(null);
    config.setDestinationNpi(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SmppSmsSender(config));
  }
}
