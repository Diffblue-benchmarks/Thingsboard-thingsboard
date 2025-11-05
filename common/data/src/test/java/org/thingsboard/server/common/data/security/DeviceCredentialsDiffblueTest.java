package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;

class DeviceCredentialsDiffblueTest {
  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    DeviceCredentials deviceCredentials2 = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    assertEquals(deviceCredentials.hashCode(), deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    assertEquals(deviceCredentials.hashCode(), deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsId("42");

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsId("42");

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    assertEquals(deviceCredentials.hashCode(), deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsValue("42");

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    assertEquals(deviceCredentials.hashCode(), deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    assertEquals(deviceCredentials.hashCode(), deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and {@link DeviceCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceCredentials deviceCredentials = new DeviceCredentials(id);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), null);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentials.equals(Object)",
    "int DeviceCredentials.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), "Different type to DeviceCredentials");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#DeviceCredentials(DeviceCredentialsId)}
   *   <li>{@link DeviceCredentials#setCredentialsId(String)}
   *   <li>{@link DeviceCredentials#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentials#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentials#setVersion(Long)}
   *   <li>{@link DeviceCredentials#toString()}
   *   <li>{@link DeviceCredentials#getCredentialsId()}
   *   <li>{@link DeviceCredentials#getCredentialsType()}
   *   <li>{@link DeviceCredentials#getCredentialsValue()}
   *   <li>{@link DeviceCredentials#getDeviceId()}
   *   <li>{@link DeviceCredentials#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentials.<init>()",
    "void DeviceCredentials.<init>(DeviceCredentialsId)",
    "String DeviceCredentials.getCredentialsId()",
    "DeviceCredentialsType DeviceCredentials.getCredentialsType()",
    "String DeviceCredentials.getCredentialsValue()",
    "DeviceId DeviceCredentials.getDeviceId()",
    "Long DeviceCredentials.getVersion()",
    "void DeviceCredentials.setCredentialsId(String)",
    "void DeviceCredentials.setCredentialsType(DeviceCredentialsType)",
    "void DeviceCredentials.setCredentialsValue(String)",
    "void DeviceCredentials.setDeviceId(DeviceId)",
    "void DeviceCredentials.setVersion(Long)",
    "String DeviceCredentials.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceCredentials actualDeviceCredentials = new DeviceCredentials(id);
    actualDeviceCredentials.setCredentialsId("42");
    actualDeviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentials.setCredentialsValue("42");
    actualDeviceCredentials.setVersion(1L);
    String actualToStringResult = actualDeviceCredentials.toString();
    String actualCredentialsId = actualDeviceCredentials.getCredentialsId();
    DeviceCredentialsType actualCredentialsType = actualDeviceCredentials.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentials.getCredentialsValue();
    DeviceId actualDeviceId = actualDeviceCredentials.getDeviceId();

    // Assert
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals(
        "DeviceCredentials [deviceId=null, credentialsType=ACCESS_TOKEN, credentialsId=42, credentialsValue=42,"
            + " createdTime=0, id=784f394c-42b6-435a-983c-b7beff2784f9]",
        actualToStringResult);
    assertNull(actualDeviceId);
    assertEquals(1L, actualDeviceCredentials.getVersion().longValue());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertSame(id, actualDeviceCredentials.getId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentials#DeviceCredentials()}
   *   <li>{@link DeviceCredentials#setCredentialsId(String)}
   *   <li>{@link DeviceCredentials#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentials#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentials#setVersion(Long)}
   *   <li>{@link DeviceCredentials#toString()}
   *   <li>{@link DeviceCredentials#getCredentialsId()}
   *   <li>{@link DeviceCredentials#getCredentialsType()}
   *   <li>{@link DeviceCredentials#getCredentialsValue()}
   *   <li>{@link DeviceCredentials#getDeviceId()}
   *   <li>{@link DeviceCredentials#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentials.<init>()",
    "void DeviceCredentials.<init>(DeviceCredentialsId)",
    "String DeviceCredentials.getCredentialsId()",
    "DeviceCredentialsType DeviceCredentials.getCredentialsType()",
    "String DeviceCredentials.getCredentialsValue()",
    "DeviceId DeviceCredentials.getDeviceId()",
    "Long DeviceCredentials.getVersion()",
    "void DeviceCredentials.setCredentialsId(String)",
    "void DeviceCredentials.setCredentialsType(DeviceCredentialsType)",
    "void DeviceCredentials.setCredentialsValue(String)",
    "void DeviceCredentials.setDeviceId(DeviceId)",
    "void DeviceCredentials.setVersion(Long)",
    "String DeviceCredentials.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    DeviceCredentials actualDeviceCredentials = new DeviceCredentials();
    actualDeviceCredentials.setCredentialsId("42");
    actualDeviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentials.setCredentialsValue("42");
    actualDeviceCredentials.setVersion(1L);
    String actualToStringResult = actualDeviceCredentials.toString();
    String actualCredentialsId = actualDeviceCredentials.getCredentialsId();
    DeviceCredentialsType actualCredentialsType = actualDeviceCredentials.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentials.getCredentialsValue();
    DeviceId actualDeviceId = actualDeviceCredentials.getDeviceId();
    Long actualVersion = actualDeviceCredentials.getVersion();

    // Assert
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals(
        "DeviceCredentials [deviceId=null, credentialsType=ACCESS_TOKEN, credentialsId=42, credentialsValue=42,"
            + " createdTime=0, id=null]",
        actualToStringResult);
    assertNull(actualDeviceCredentials.getId());
    assertNull(actualDeviceId);
    assertEquals(1L, actualVersion.longValue());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
  }

  /**
   * Test {@link DeviceCredentials#DeviceCredentials(DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentials#DeviceCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test new DeviceCredentials(DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentials.<init>(DeviceCredentials)"})
  void testNewDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act
    DeviceCredentials actualDeviceCredentials = new DeviceCredentials(deviceCredentials);

    // Assert
    assertEquals(deviceCredentials, actualDeviceCredentials);
  }

  /**
   * Test {@link DeviceCredentials#getId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentials#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentialsId DeviceCredentials.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DeviceCredentials().getId());
  }

  /**
   * Test {@link DeviceCredentials#getCreatedTime()}.
   *
   * <p>Method under test: {@link DeviceCredentials#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DeviceCredentials.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new DeviceCredentials().getCreatedTime());
  }
}
