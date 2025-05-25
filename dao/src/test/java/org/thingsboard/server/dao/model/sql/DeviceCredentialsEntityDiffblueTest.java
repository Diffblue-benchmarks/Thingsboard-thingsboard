package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceCredentialsEntityDiffblueTest {
  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link DeviceCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    int expectedHashCodeResult = deviceCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link DeviceCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId(null);
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId(null);
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    int expectedHashCodeResult = deviceCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link DeviceCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(null);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(null);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    int expectedHashCodeResult = deviceCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link DeviceCredentialsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity);
    int expectedHashCodeResult = deviceCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEntity.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(3L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("Credentials Id");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId(null);
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(null);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("Credentials Value");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue(null);
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(null);
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, null);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceCredentialsEntity.equals(Object)", "int DeviceCredentialsEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, "Different type to DeviceCredentialsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#DeviceCredentialsEntity()}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsId(String)}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentialsEntity#setDeviceId(UUID)}
   *   <li>{@link DeviceCredentialsEntity#toString()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsId()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsType()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsValue()}
   *   <li>{@link DeviceCredentialsEntity#getDeviceId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsEntity.<init>()", "String DeviceCredentialsEntity.getCredentialsId()",
      "DeviceCredentialsType DeviceCredentialsEntity.getCredentialsType()",
      "String DeviceCredentialsEntity.getCredentialsValue()", "UUID DeviceCredentialsEntity.getDeviceId()",
      "void DeviceCredentialsEntity.setCredentialsId(String)",
      "void DeviceCredentialsEntity.setCredentialsType(DeviceCredentialsType)",
      "void DeviceCredentialsEntity.setCredentialsValue(String)", "void DeviceCredentialsEntity.setDeviceId(UUID)",
      "String DeviceCredentialsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity = new DeviceCredentialsEntity();
    actualDeviceCredentialsEntity.setCredentialsId("42");
    actualDeviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentialsEntity.setCredentialsValue("42");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceCredentialsEntity.setDeviceId(deviceId);
    String actualToStringResult = actualDeviceCredentialsEntity.toString();
    String actualCredentialsId = actualDeviceCredentialsEntity.getCredentialsId();
    DeviceCredentialsType actualCredentialsType = actualDeviceCredentialsEntity.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentialsEntity.getCredentialsValue();
    UUID actualDeviceId = actualDeviceCredentialsEntity.getDeviceId();

    // Assert
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDeviceId.toString());
    assertEquals("DeviceCredentialsEntity(deviceId=784f394c-42b6-435a-983c-b7beff2784f9, credentialsType=ACCESS_TOKEN,"
        + " credentialsId=42, credentialsValue=42)", actualToStringResult);
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getId());
    assertNull(actualDeviceCredentialsEntity.getUuid());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertSame(deviceId, actualDeviceId);
  }

  /**
   * Test {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}.
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsEntity.<init>(DeviceCredentials)"})
  public void testNewDeviceCredentialsEntity() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentials.setDeviceId(new DeviceId(id));

    // Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity = new DeviceCredentialsEntity(deviceCredentials);

    // Assert
    UUID deviceId = actualDeviceCredentialsEntity.getDeviceId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", deviceId.toString());
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getCredentialsId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsValue());
    assertNull(actualDeviceCredentialsEntity.getId());
    assertNull(actualDeviceCredentialsEntity.getUuid());
    assertNull(actualDeviceCredentialsEntity.getCredentialsType());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
    assertSame(id, deviceId);
  }

  /**
   * Test {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   *   <li>Then return DeviceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsEntity.<init>(DeviceCredentials)"})
  public void testNewDeviceCredentialsEntity_whenDeviceCredentials_thenReturnDeviceIdIsNull() {
    // Arrange and Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity = new DeviceCredentialsEntity(new DeviceCredentials());

    // Assert
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getCredentialsId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsValue());
    assertNull(actualDeviceCredentialsEntity.getId());
    assertNull(actualDeviceCredentialsEntity.getUuid());
    assertNull(actualDeviceCredentialsEntity.getDeviceId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsType());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
  }

  /**
   * Test {@link DeviceCredentialsEntity#toData()}.
   * <ul>
   *   <li>Given {@link DeviceCredentialsEntity#DeviceCredentialsEntity()}.</li>
   *   <li>Then return Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsEntity.toData()"})
  public void testToData_givenDeviceCredentialsEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    DeviceCredentials actualToDataResult = (new DeviceCredentialsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getCredentialsId());
    assertNull(actualToDataResult.getCredentialsValue());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getDeviceId());
    assertNull(actualToDataResult.getCredentialsType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceCredentialsEntity#toData()}.
   * <ul>
   *   <li>Then return CredentialsId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsEntity.toData()"})
  public void testToData_thenReturnCredentialsIdIs42() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setUuid(id);
    deviceCredentialsEntity.setVersion(1L);
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setDeviceId(deviceId);

    // Act
    DeviceCredentials actualToDataResult = deviceCredentialsEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getCredentialsId());
    assertEquals("42", actualToDataResult.getCredentialsValue());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    DeviceId deviceId2 = actualToDataResult.getDeviceId();
    UUID id2 = deviceId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualToDataResult.getCredentialsType());
    assertFalse(deviceId2.isNullUid());
    assertSame(id, uuidId);
    assertSame(deviceId, id2);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
