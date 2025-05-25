package org.thingsboard.server.transport.lwm2m.secure.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MBootstrapClientCredential;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MClientCredential;
import org.thingsboard.server.common.data.device.credentials.lwm2m.NoSecClientCredential;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;

class LwM2MClientCredentialsDiffblueTest {
  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}, and {@link LwM2MClientCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials2.hashCode());
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}, and {@link LwM2MClientCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(null);
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(null);
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials2.hashCode());
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}, and {@link LwM2MClientCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials.hashCode());
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(null);
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, null);
  }

  /**
   * Test {@link LwM2MClientCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MClientCredentials.equals(Object)", "int LwM2MClientCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, "Different type to LwM2MClientCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MClientCredentials}
   *   <li>{@link LwM2MClientCredentials#setBootstrap(LwM2MBootstrapConfig)}
   *   <li>{@link LwM2MClientCredentials#setClient(LwM2MClientCredential)}
   *   <li>{@link LwM2MClientCredentials#toString()}
   *   <li>{@link LwM2MClientCredentials#getBootstrap()}
   *   <li>{@link LwM2MClientCredentials#getClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MClientCredentials.<init>()",
      "LwM2MBootstrapConfig LwM2MClientCredentials.getBootstrap()",
      "LwM2MClientCredential LwM2MClientCredentials.getClient()",
      "void LwM2MClientCredentials.setBootstrap(LwM2MBootstrapConfig)",
      "void LwM2MClientCredentials.setClient(LwM2MClientCredential)",
      "java.lang.String LwM2MClientCredentials.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MClientCredentials actualLwM2MClientCredentials = new LwM2MClientCredentials();
    LwM2MBootstrapConfig bootstrap = new LwM2MBootstrapConfig();
    actualLwM2MClientCredentials.setBootstrap(bootstrap);
    NoSecClientCredential client = new NoSecClientCredential();
    actualLwM2MClientCredentials.setClient(client);
    actualLwM2MClientCredentials.toString();
    LwM2MBootstrapConfig actualBootstrap = actualLwM2MClientCredentials.getBootstrap();

    // Assert
    assertSame(client, actualLwM2MClientCredentials.getClient());
    assertSame(bootstrap, actualBootstrap);
  }
}
