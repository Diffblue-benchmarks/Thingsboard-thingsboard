package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.datastax.oss.driver.api.core.config.DriverConfig;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import com.datastax.oss.driver.internal.core.config.typesafe.TypesafeDriverConfig;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CassandraDriverOptionsDiffblueTest {
  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Compression is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Compression is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsCompressionIsEmptyString() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Compression is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Compression is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsCompressionIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression(null);
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Credentials is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Credentials is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsCredentialsIsFalse() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(false);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Credentials is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Credentials is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsCredentialsIsTrue() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) KeepAlive is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) KeepAlive is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsKeepAliveIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(null);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Metrics is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Metrics is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsMetricsIsTrue() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(true);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) ReceiveBufferSize is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) ReceiveBufferSize is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsReceiveBufferSizeIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(null);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) ReuseAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) ReuseAddress is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsReuseAddressIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(null);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) SendBufferSize is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) SendBufferSize is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsSendBufferSizeIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(null);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) SoLinger is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) SoLinger is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsSoLingerIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(null);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) TcpNoDelay is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) TcpNoDelay is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsTcpNoDelayIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(" ");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(null);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Url is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Url is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsUrlIsEmptyString() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl("");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Url is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Url is 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsUrlIsHttpsExampleOrgExample() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl("https://example.org/example");
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#initLoader()}.
   *
   * <ul>
   *   <li>Given {@link CassandraDriverOptions} (default constructor) Url is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#initLoader()}
   */
  @Test
  @DisplayName(
      "Test initLoader(); given CassandraDriverOptions (default constructor) Url is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraDriverOptions.initLoader()"})
  void testInitLoader_givenCassandraDriverOptionsUrlIsNull() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setMetrics(false);
    cassandraDriverOptions.setSsl(false);
    cassandraDriverOptions.setDefaultFetchSize(1);
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setSslTrustStore("");
    cassandraDriverOptions.setSslKeyStore("");
    cassandraDriverOptions.setUrl(null);
    cassandraDriverOptions.setKeepAlive(true);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setReceiveBufferSize(1);
    cassandraDriverOptions.setSendBufferSize(1);

    // Act
    cassandraDriverOptions.initLoader();

    // Assert
    DriverConfigLoader loader = cassandraDriverOptions.getLoader();
    assertTrue(loader instanceof DefaultDriverConfigLoader);
    DriverConfig initialConfig = loader.getInitialConfig();
    assertTrue(initialConfig instanceof TypesafeDriverConfig);
    assertEquals(1, initialConfig.getProfiles().size());
    assertTrue(loader.supportsReloading());
  }

  /**
   * Test {@link CassandraDriverOptions#getDefaultReadConsistencyLevel()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultConsistencyLevel}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#getDefaultReadConsistencyLevel()}
   */
  @Test
  @DisplayName("Test getDefaultReadConsistencyLevel(); then return DefaultConsistencyLevel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConsistencyLevel CassandraDriverOptions.getDefaultReadConsistencyLevel()"})
  void testGetDefaultReadConsistencyLevel_thenReturnDefaultConsistencyLevel() {
    // Arrange and Act
    ConsistencyLevel actualDefaultReadConsistencyLevel =
        new CassandraDriverOptions().getDefaultReadConsistencyLevel();

    // Assert
    assertTrue(actualDefaultReadConsistencyLevel instanceof DefaultConsistencyLevel);
    assertEquals(DefaultConsistencyLevel.ONE, actualDefaultReadConsistencyLevel);
  }

  /**
   * Test {@link CassandraDriverOptions#getDefaultWriteConsistencyLevel()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultConsistencyLevel}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#getDefaultWriteConsistencyLevel()}
   */
  @Test
  @DisplayName("Test getDefaultWriteConsistencyLevel(); then return DefaultConsistencyLevel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConsistencyLevel CassandraDriverOptions.getDefaultWriteConsistencyLevel()"})
  void testGetDefaultWriteConsistencyLevel_thenReturnDefaultConsistencyLevel() {
    // Arrange and Act
    ConsistencyLevel actualDefaultWriteConsistencyLevel =
        new CassandraDriverOptions().getDefaultWriteConsistencyLevel();

    // Assert
    assertTrue(actualDefaultWriteConsistencyLevel instanceof DefaultConsistencyLevel);
    assertEquals(DefaultConsistencyLevel.ONE, actualDefaultWriteConsistencyLevel);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}, and {@link
   * CassandraDriverOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraDriverOptions#equals(Object)}
   *   <li>{@link CassandraDriverOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();

    // Act and Assert
    assertEquals(cassandraDriverOptions, cassandraDriverOptions2);
    assertEquals(cassandraDriverOptions.hashCode(), cassandraDriverOptions2.hashCode());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}, and {@link
   * CassandraDriverOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraDriverOptions#equals(Object)}
   *   <li>{@link CassandraDriverOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    // Act and Assert
    assertEquals(cassandraDriverOptions, cassandraDriverOptions);
    int expectedHashCodeResult = cassandraDriverOptions.hashCode();
    assertEquals(expectedHashCodeResult, cassandraDriverOptions.hashCode());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), 1);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setClusterName("Cluster Name");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setConnectTimeoutMillis(10);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReadTimeoutMillis(10);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setKeepAlive(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReuseAddress(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSoLinger(1);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setTcpNoDelay(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReceiveBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSendBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMax_requests_local(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMax_requests_remote(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultFetchSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReadConsistencyLevel("Read Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setWriteConsistencyLevel("Write Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCompression("Compression");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSsl(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslKeyStore("Ssl Key Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslKeyStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslTrustStore("Ssl Trust Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslTrustStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslHostnameValidation(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslCipherSuites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMetrics(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setInitTimeout(1L);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setInitRetryInterval(42L);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setLoader(new DefaultDriverConfigLoader());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultReadConsistencyLevel(mock(ConsistencyLevel.class));

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultWriteConsistencyLevel(mock(ConsistencyLevel.class));

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setClusterName("Cluster Name");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setKeepAlive(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setReuseAddress(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSoLinger(1);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setTcpNoDelay(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual40() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setReceiveBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual41() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSendBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual42() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setDefaultFetchSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual43() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setReadConsistencyLevel("Read Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual44() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setWriteConsistencyLevel("Write Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual45() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setCompression("Compression");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual46() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSsl(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual47() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslKeyStore("Ssl Key Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual48() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslKeyStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual49() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslTrustStore("Ssl Trust Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual50() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslTrustStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual51() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslHostnameValidation(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual52() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setSslCipherSuites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual53() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setMetrics(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual54() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setCredentials(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual55() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual56() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual57() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();
    cassandraDriverOptions2.setLoader(new DefaultDriverConfigLoader());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, cassandraDriverOptions2);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), null);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CassandraDriverOptions.equals(Object)",
    "int CassandraDriverOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), "Different type to CassandraDriverOptions");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraDriverOptions#setClusterName(String)}
   *   <li>{@link CassandraDriverOptions#setCompression(String)}
   *   <li>{@link CassandraDriverOptions#setConnectTimeoutMillis(int)}
   *   <li>{@link CassandraDriverOptions#setCredentials(Boolean)}
   *   <li>{@link CassandraDriverOptions#setDefaultFetchSize(Integer)}
   *   <li>{@link CassandraDriverOptions#setDefaultReadConsistencyLevel(ConsistencyLevel)}
   *   <li>{@link CassandraDriverOptions#setDefaultWriteConsistencyLevel(ConsistencyLevel)}
   *   <li>{@link CassandraDriverOptions#setInitRetryInterval(long)}
   *   <li>{@link CassandraDriverOptions#setInitTimeout(long)}
   *   <li>{@link CassandraDriverOptions#setKeepAlive(Boolean)}
   *   <li>{@link CassandraDriverOptions#setLoader(DriverConfigLoader)}
   *   <li>{@link CassandraDriverOptions#setMax_requests_local(int)}
   *   <li>{@link CassandraDriverOptions#setMax_requests_remote(int)}
   *   <li>{@link CassandraDriverOptions#setMetrics(Boolean)}
   *   <li>{@link CassandraDriverOptions#setPassword(String)}
   *   <li>{@link CassandraDriverOptions#setReadConsistencyLevel(String)}
   *   <li>{@link CassandraDriverOptions#setReadTimeoutMillis(int)}
   *   <li>{@link CassandraDriverOptions#setReceiveBufferSize(Integer)}
   *   <li>{@link CassandraDriverOptions#setReuseAddress(Boolean)}
   *   <li>{@link CassandraDriverOptions#setSendBufferSize(Integer)}
   *   <li>{@link CassandraDriverOptions#setSoLinger(Integer)}
   *   <li>{@link CassandraDriverOptions#setSsl(Boolean)}
   *   <li>{@link CassandraDriverOptions#setSslCipherSuites(List)}
   *   <li>{@link CassandraDriverOptions#setSslHostnameValidation(Boolean)}
   *   <li>{@link CassandraDriverOptions#setSslKeyStore(String)}
   *   <li>{@link CassandraDriverOptions#setSslKeyStorePassword(String)}
   *   <li>{@link CassandraDriverOptions#setSslTrustStore(String)}
   *   <li>{@link CassandraDriverOptions#setSslTrustStorePassword(String)}
   *   <li>{@link CassandraDriverOptions#setTcpNoDelay(Boolean)}
   *   <li>{@link CassandraDriverOptions#setUrl(String)}
   *   <li>{@link CassandraDriverOptions#setUsername(String)}
   *   <li>{@link CassandraDriverOptions#setWriteConsistencyLevel(String)}
   *   <li>{@link CassandraDriverOptions#toString()}
   *   <li>{@link CassandraDriverOptions#getClusterName()}
   *   <li>{@link CassandraDriverOptions#getCompression()}
   *   <li>{@link CassandraDriverOptions#getConnectTimeoutMillis()}
   *   <li>{@link CassandraDriverOptions#getCredentials()}
   *   <li>{@link CassandraDriverOptions#getDefaultFetchSize()}
   *   <li>{@link CassandraDriverOptions#getInitRetryInterval()}
   *   <li>{@link CassandraDriverOptions#getInitTimeout()}
   *   <li>{@link CassandraDriverOptions#getKeepAlive()}
   *   <li>{@link CassandraDriverOptions#getLoader()}
   *   <li>{@link CassandraDriverOptions#getMax_requests_local()}
   *   <li>{@link CassandraDriverOptions#getMax_requests_remote()}
   *   <li>{@link CassandraDriverOptions#getMetrics()}
   *   <li>{@link CassandraDriverOptions#getPassword()}
   *   <li>{@link CassandraDriverOptions#getReadConsistencyLevel()}
   *   <li>{@link CassandraDriverOptions#getReadTimeoutMillis()}
   *   <li>{@link CassandraDriverOptions#getReceiveBufferSize()}
   *   <li>{@link CassandraDriverOptions#getReuseAddress()}
   *   <li>{@link CassandraDriverOptions#getSendBufferSize()}
   *   <li>{@link CassandraDriverOptions#getSoLinger()}
   *   <li>{@link CassandraDriverOptions#getSsl()}
   *   <li>{@link CassandraDriverOptions#getSslCipherSuites()}
   *   <li>{@link CassandraDriverOptions#getSslHostnameValidation()}
   *   <li>{@link CassandraDriverOptions#getSslKeyStore()}
   *   <li>{@link CassandraDriverOptions#getSslKeyStorePassword()}
   *   <li>{@link CassandraDriverOptions#getSslTrustStore()}
   *   <li>{@link CassandraDriverOptions#getSslTrustStorePassword()}
   *   <li>{@link CassandraDriverOptions#getTcpNoDelay()}
   *   <li>{@link CassandraDriverOptions#getUrl()}
   *   <li>{@link CassandraDriverOptions#getUsername()}
   *   <li>{@link CassandraDriverOptions#getWriteConsistencyLevel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CassandraDriverOptions.getClusterName()",
    "String CassandraDriverOptions.getCompression()",
    "int CassandraDriverOptions.getConnectTimeoutMillis()",
    "Boolean CassandraDriverOptions.getCredentials()",
    "Integer CassandraDriverOptions.getDefaultFetchSize()",
    "long CassandraDriverOptions.getInitRetryInterval()",
    "long CassandraDriverOptions.getInitTimeout()",
    "Boolean CassandraDriverOptions.getKeepAlive()",
    "DriverConfigLoader CassandraDriverOptions.getLoader()",
    "int CassandraDriverOptions.getMax_requests_local()",
    "int CassandraDriverOptions.getMax_requests_remote()",
    "Boolean CassandraDriverOptions.getMetrics()",
    "String CassandraDriverOptions.getPassword()",
    "String CassandraDriverOptions.getReadConsistencyLevel()",
    "int CassandraDriverOptions.getReadTimeoutMillis()",
    "Integer CassandraDriverOptions.getReceiveBufferSize()",
    "Boolean CassandraDriverOptions.getReuseAddress()",
    "Integer CassandraDriverOptions.getSendBufferSize()",
    "Integer CassandraDriverOptions.getSoLinger()",
    "Boolean CassandraDriverOptions.getSsl()",
    "List CassandraDriverOptions.getSslCipherSuites()",
    "Boolean CassandraDriverOptions.getSslHostnameValidation()",
    "String CassandraDriverOptions.getSslKeyStore()",
    "String CassandraDriverOptions.getSslKeyStorePassword()",
    "String CassandraDriverOptions.getSslTrustStore()",
    "String CassandraDriverOptions.getSslTrustStorePassword()",
    "Boolean CassandraDriverOptions.getTcpNoDelay()",
    "String CassandraDriverOptions.getUrl()",
    "String CassandraDriverOptions.getUsername()",
    "String CassandraDriverOptions.getWriteConsistencyLevel()",
    "void CassandraDriverOptions.setClusterName(String)",
    "void CassandraDriverOptions.setCompression(String)",
    "void CassandraDriverOptions.setConnectTimeoutMillis(int)",
    "void CassandraDriverOptions.setCredentials(Boolean)",
    "void CassandraDriverOptions.setDefaultFetchSize(Integer)",
    "void CassandraDriverOptions.setDefaultReadConsistencyLevel(ConsistencyLevel)",
    "void CassandraDriverOptions.setDefaultWriteConsistencyLevel(ConsistencyLevel)",
    "void CassandraDriverOptions.setInitRetryInterval(long)",
    "void CassandraDriverOptions.setInitTimeout(long)",
    "void CassandraDriverOptions.setKeepAlive(Boolean)",
    "void CassandraDriverOptions.setLoader(DriverConfigLoader)",
    "void CassandraDriverOptions.setMax_requests_local(int)",
    "void CassandraDriverOptions.setMax_requests_remote(int)",
    "void CassandraDriverOptions.setMetrics(Boolean)",
    "void CassandraDriverOptions.setPassword(String)",
    "void CassandraDriverOptions.setReadConsistencyLevel(String)",
    "void CassandraDriverOptions.setReadTimeoutMillis(int)",
    "void CassandraDriverOptions.setReceiveBufferSize(Integer)",
    "void CassandraDriverOptions.setReuseAddress(Boolean)",
    "void CassandraDriverOptions.setSendBufferSize(Integer)",
    "void CassandraDriverOptions.setSoLinger(Integer)",
    "void CassandraDriverOptions.setSsl(Boolean)",
    "void CassandraDriverOptions.setSslCipherSuites(List)",
    "void CassandraDriverOptions.setSslHostnameValidation(Boolean)",
    "void CassandraDriverOptions.setSslKeyStore(String)",
    "void CassandraDriverOptions.setSslKeyStorePassword(String)",
    "void CassandraDriverOptions.setSslTrustStore(String)",
    "void CassandraDriverOptions.setSslTrustStorePassword(String)",
    "void CassandraDriverOptions.setTcpNoDelay(Boolean)",
    "void CassandraDriverOptions.setUrl(String)",
    "void CassandraDriverOptions.setUsername(String)",
    "void CassandraDriverOptions.setWriteConsistencyLevel(String)",
    "String CassandraDriverOptions.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();

    // Act
    cassandraDriverOptions.setClusterName("Cluster Name");
    cassandraDriverOptions.setCompression("Compression");
    cassandraDriverOptions.setConnectTimeoutMillis(10);
    cassandraDriverOptions.setCredentials(true);
    cassandraDriverOptions.setDefaultFetchSize(3);
    cassandraDriverOptions.setDefaultReadConsistencyLevel(mock(ConsistencyLevel.class));
    cassandraDriverOptions.setDefaultWriteConsistencyLevel(mock(ConsistencyLevel.class));
    cassandraDriverOptions.setInitRetryInterval(42L);
    cassandraDriverOptions.setInitTimeout(1L);
    cassandraDriverOptions.setKeepAlive(true);
    DefaultDriverConfigLoader loader = new DefaultDriverConfigLoader();
    cassandraDriverOptions.setLoader(loader);
    cassandraDriverOptions.setMax_requests_local(3);
    cassandraDriverOptions.setMax_requests_remote(3);
    cassandraDriverOptions.setMetrics(true);
    cassandraDriverOptions.setPassword("iloveyou");
    cassandraDriverOptions.setReadConsistencyLevel("Read Consistency Level");
    cassandraDriverOptions.setReadTimeoutMillis(10);
    cassandraDriverOptions.setReceiveBufferSize(3);
    cassandraDriverOptions.setReuseAddress(true);
    cassandraDriverOptions.setSendBufferSize(3);
    cassandraDriverOptions.setSoLinger(1);
    cassandraDriverOptions.setSsl(true);
    ArrayList<String> sslCipherSuites = new ArrayList<>();
    cassandraDriverOptions.setSslCipherSuites(sslCipherSuites);
    cassandraDriverOptions.setSslHostnameValidation(true);
    cassandraDriverOptions.setSslKeyStore("Ssl Key Store");
    cassandraDriverOptions.setSslKeyStorePassword("iloveyou");
    cassandraDriverOptions.setSslTrustStore("Ssl Trust Store");
    cassandraDriverOptions.setSslTrustStorePassword("iloveyou");
    cassandraDriverOptions.setTcpNoDelay(true);
    cassandraDriverOptions.setUrl("https://example.org/example");
    cassandraDriverOptions.setUsername("janedoe");
    cassandraDriverOptions.setWriteConsistencyLevel("Write Consistency Level");
    cassandraDriverOptions.toString();
    String actualClusterName = cassandraDriverOptions.getClusterName();
    String actualCompression = cassandraDriverOptions.getCompression();
    int actualConnectTimeoutMillis = cassandraDriverOptions.getConnectTimeoutMillis();
    Boolean actualCredentials = cassandraDriverOptions.getCredentials();
    Integer actualDefaultFetchSize = cassandraDriverOptions.getDefaultFetchSize();
    long actualInitRetryInterval = cassandraDriverOptions.getInitRetryInterval();
    long actualInitTimeout = cassandraDriverOptions.getInitTimeout();
    Boolean actualKeepAlive = cassandraDriverOptions.getKeepAlive();
    DriverConfigLoader actualLoader = cassandraDriverOptions.getLoader();
    int actualMax_requests_local = cassandraDriverOptions.getMax_requests_local();
    int actualMax_requests_remote = cassandraDriverOptions.getMax_requests_remote();
    Boolean actualMetrics = cassandraDriverOptions.getMetrics();
    String actualPassword = cassandraDriverOptions.getPassword();
    String actualReadConsistencyLevel = cassandraDriverOptions.getReadConsistencyLevel();
    int actualReadTimeoutMillis = cassandraDriverOptions.getReadTimeoutMillis();
    Integer actualReceiveBufferSize = cassandraDriverOptions.getReceiveBufferSize();
    Boolean actualReuseAddress = cassandraDriverOptions.getReuseAddress();
    Integer actualSendBufferSize = cassandraDriverOptions.getSendBufferSize();
    Integer actualSoLinger = cassandraDriverOptions.getSoLinger();
    Boolean actualSsl = cassandraDriverOptions.getSsl();
    List<String> actualSslCipherSuites = cassandraDriverOptions.getSslCipherSuites();
    Boolean actualSslHostnameValidation = cassandraDriverOptions.getSslHostnameValidation();
    String actualSslKeyStore = cassandraDriverOptions.getSslKeyStore();
    String actualSslKeyStorePassword = cassandraDriverOptions.getSslKeyStorePassword();
    String actualSslTrustStore = cassandraDriverOptions.getSslTrustStore();
    String actualSslTrustStorePassword = cassandraDriverOptions.getSslTrustStorePassword();
    Boolean actualTcpNoDelay = cassandraDriverOptions.getTcpNoDelay();
    String actualUrl = cassandraDriverOptions.getUrl();
    String actualUsername = cassandraDriverOptions.getUsername();

    // Assert
    assertEquals("Cluster Name", actualClusterName);
    assertEquals("Compression", actualCompression);
    assertEquals("Read Consistency Level", actualReadConsistencyLevel);
    assertEquals("Ssl Key Store", actualSslKeyStore);
    assertEquals("Ssl Trust Store", actualSslTrustStore);
    assertEquals("Write Consistency Level", cassandraDriverOptions.getWriteConsistencyLevel());
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("iloveyou", actualPassword);
    assertEquals("iloveyou", actualSslKeyStorePassword);
    assertEquals("iloveyou", actualSslTrustStorePassword);
    assertEquals("janedoe", actualUsername);
    assertEquals(1, actualSoLinger.intValue());
    assertEquals(10, actualConnectTimeoutMillis);
    assertEquals(10, actualReadTimeoutMillis);
    assertEquals(1L, actualInitTimeout);
    assertEquals(3, actualDefaultFetchSize.intValue());
    assertEquals(3, actualReceiveBufferSize.intValue());
    assertEquals(3, actualSendBufferSize.intValue());
    assertEquals(3, actualMax_requests_local);
    assertEquals(3, actualMax_requests_remote);
    assertEquals(42L, actualInitRetryInterval);
    assertTrue(actualSslCipherSuites.isEmpty());
    assertTrue(actualCredentials);
    assertTrue(actualKeepAlive);
    assertTrue(actualMetrics);
    assertTrue(actualReuseAddress);
    assertTrue(actualSsl);
    assertTrue(actualSslHostnameValidation);
    assertTrue(actualTcpNoDelay);
    assertSame(loader, actualLoader);
    assertSame(sslCipherSuites, actualSslCipherSuites);
  }
}
