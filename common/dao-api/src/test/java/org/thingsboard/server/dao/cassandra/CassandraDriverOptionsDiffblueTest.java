package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.datastax.oss.driver.internal.core.config.typesafe.DefaultDriverConfigLoader;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CassandraDriverOptionsDiffblueTest {
  /**
   * Test {@link CassandraDriverOptions#getDefaultReadConsistencyLevel()}.
   * <ul>
   *   <li>Then return {@link DefaultConsistencyLevel}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraDriverOptions#getDefaultReadConsistencyLevel()}
   */
  @Test
  @DisplayName("Test getDefaultReadConsistencyLevel(); then return DefaultConsistencyLevel")
  void testGetDefaultReadConsistencyLevel_thenReturnDefaultConsistencyLevel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ConsistencyLevel actualDefaultReadConsistencyLevel = (new CassandraDriverOptions())
        .getDefaultReadConsistencyLevel();

    // Assert
    assertTrue(actualDefaultReadConsistencyLevel instanceof DefaultConsistencyLevel);
    assertEquals(DefaultConsistencyLevel.ONE, actualDefaultReadConsistencyLevel);
  }

  /**
   * Test {@link CassandraDriverOptions#getDefaultWriteConsistencyLevel()}.
   * <ul>
   *   <li>Then return {@link DefaultConsistencyLevel}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CassandraDriverOptions#getDefaultWriteConsistencyLevel()}
   */
  @Test
  @DisplayName("Test getDefaultWriteConsistencyLevel(); then return DefaultConsistencyLevel")
  void testGetDefaultWriteConsistencyLevel_thenReturnDefaultConsistencyLevel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ConsistencyLevel actualDefaultWriteConsistencyLevel = (new CassandraDriverOptions())
        .getDefaultWriteConsistencyLevel();

    // Assert
    assertTrue(actualDefaultWriteConsistencyLevel instanceof DefaultConsistencyLevel);
    assertEquals(DefaultConsistencyLevel.ONE, actualDefaultWriteConsistencyLevel);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}, and
   * {@link CassandraDriverOptions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraDriverOptions#equals(Object)}
   *   <li>{@link CassandraDriverOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    CassandraDriverOptions cassandraDriverOptions2 = new CassandraDriverOptions();

    // Act and Assert
    assertEquals(cassandraDriverOptions, cassandraDriverOptions2);
    int expectedHashCodeResult = cassandraDriverOptions.hashCode();
    assertEquals(expectedHashCodeResult, cassandraDriverOptions2.hashCode());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}, and
   * {@link CassandraDriverOptions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraDriverOptions#equals(Object)}
   *   <li>{@link CassandraDriverOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), 1);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setClusterName("Cluster Name");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setConnectTimeoutMillis(10);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReadTimeoutMillis(10);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setKeepAlive(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReuseAddress(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSoLinger(1);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setTcpNoDelay(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReceiveBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSendBufferSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMax_requests_local(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMax_requests_remote(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultFetchSize(3);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setReadConsistencyLevel("Read Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setWriteConsistencyLevel("Write Consistency Level");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCompression("Compression");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSsl(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslKeyStore("Ssl Key Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslKeyStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslTrustStore("Ssl Trust Store");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslTrustStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslHostnameValidation(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setSslCipherSuites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setMetrics(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setCredentials(true);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setInitTimeout(1L);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setInitRetryInterval(42L);

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setLoader(new DefaultDriverConfigLoader());

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultReadConsistencyLevel(mock(ConsistencyLevel.class));

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    CassandraDriverOptions cassandraDriverOptions = new CassandraDriverOptions();
    cassandraDriverOptions.setDefaultWriteConsistencyLevel(mock(ConsistencyLevel.class));

    // Act and Assert
    assertNotEquals(cassandraDriverOptions, new CassandraDriverOptions());
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), null);
  }

  /**
   * Test {@link CassandraDriverOptions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraDriverOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraDriverOptions(), "Different type to CassandraDriverOptions");
  }
}
