package org.thingsboard.server.service.sms.aws;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sms.config.AwsSnsSmsProviderConfiguration;

class AwsSmsSenderDiffblueTest {
  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code Config}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); given 'Config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AwsSmsSender.<init>(AwsSnsSmsProviderConfiguration)"})
  void testNewAwsSmsSender_givenConfig() {
    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("Config");
    config.setSecretAccessKey("");
    config.setRegion("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AwsSmsSender.<init>(AwsSnsSmsProviderConfiguration)"})
  void testNewAwsSmsSender_givenNull() {
    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId(null);
    config.setSecretAccessKey("");
    config.setRegion("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link AwsSnsSmsProviderConfiguration} (default constructor) AccessKeyId is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); when AwsSnsSmsProviderConfiguration (default constructor) AccessKeyId is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AwsSmsSender.<init>(AwsSnsSmsProviderConfiguration)"})
  void testNewAwsSmsSender_whenAwsSnsSmsProviderConfigurationAccessKeyIdIsEmptyString() {
    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("");
    config.setSecretAccessKey("");
    config.setRegion("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link AwsSnsSmsProviderConfiguration} (default constructor) SecretAccessKey is {@code Config}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); when AwsSnsSmsProviderConfiguration (default constructor) SecretAccessKey is 'Config'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AwsSmsSender.<init>(AwsSnsSmsProviderConfiguration)"})
  void testNewAwsSmsSender_whenAwsSnsSmsProviderConfigurationSecretAccessKeyIsConfig() {
    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("Config");
    config.setSecretAccessKey("Config");
    config.setRegion("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }
}
