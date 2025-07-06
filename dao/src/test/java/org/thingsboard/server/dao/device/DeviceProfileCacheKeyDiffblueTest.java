package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceProfileCacheKeyDiffblueTest {
  /**
   * Test {@link DeviceProfileCacheKey#forName(TenantId, String)}.
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#forName(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceProfileCacheKey DeviceProfileCacheKey.forName(TenantId, String)"})
  public void testForName() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DeviceProfileCacheKey actualForNameResult = DeviceProfileCacheKey.forName(tenantId, "Name");

    // Assert
    assertEquals("Name", actualForNameResult.getName());
    assertNull(actualForNameResult.getProvisionDeviceKey());
    assertNull(actualForNameResult.getDeviceProfileId());
    assertFalse(actualForNameResult.isDefaultProfile());
    assertFalse(actualForNameResult.isVersioned());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForNameResult.getTenantId());
  }

  /**
   * Test {@link DeviceProfileCacheKey#forId(DeviceProfileId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#forId(DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceProfileCacheKey DeviceProfileCacheKey.forId(DeviceProfileId)"})
  public void testForId_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    DeviceProfileCacheKey actualForIdResult = DeviceProfileCacheKey.forId(null);

    // Assert
    assertNull(actualForIdResult.getName());
    assertNull(actualForIdResult.getProvisionDeviceKey());
    assertNull(actualForIdResult.getDeviceProfileId());
    assertNull(actualForIdResult.getTenantId());
    assertFalse(actualForIdResult.isDefaultProfile());
    assertFalse(actualForIdResult.isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#forDefaultProfile(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#forDefaultProfile(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceProfileCacheKey DeviceProfileCacheKey.forDefaultProfile(TenantId)"})
  public void testForDefaultProfile() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DeviceProfileCacheKey actualForDefaultProfileResult =
        DeviceProfileCacheKey.forDefaultProfile(tenantId);

    // Assert
    assertNull(actualForDefaultProfileResult.getName());
    assertNull(actualForDefaultProfileResult.getProvisionDeviceKey());
    assertNull(actualForDefaultProfileResult.getDeviceProfileId());
    assertFalse(actualForDefaultProfileResult.isVersioned());
    assertTrue(actualForDefaultProfileResult.isDefaultProfile());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForDefaultProfileResult.getTenantId());
  }

  /**
   * Test {@link DeviceProfileCacheKey#forProvisionKey(String)}.
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#forProvisionKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceProfileCacheKey DeviceProfileCacheKey.forProvisionKey(String)"})
  public void testForProvisionKey() {
    // Arrange and Act
    DeviceProfileCacheKey actualForProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Assert
    assertEquals("Provision Device Key", actualForProvisionKeyResult.getProvisionDeviceKey());
    assertNull(actualForProvisionKeyResult.getName());
    assertNull(actualForProvisionKeyResult.getDeviceProfileId());
    assertNull(actualForProvisionKeyResult.getTenantId());
    assertFalse(actualForProvisionKeyResult.isDefaultProfile());
    assertFalse(actualForProvisionKeyResult.isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given forProvisionKey empty string.
   *   <li>Then return {@code null_null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceProfileCacheKey.toString()"})
  public void testToString_givenForProvisionKeyEmptyString_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null_null", DeviceProfileCacheKey.forProvisionKey("").toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given forProvisionKey {@code null}.
   *   <li>Then return {@code null_null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceProfileCacheKey.toString()"})
  public void testToString_givenForProvisionKeyNull_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null_null", DeviceProfileCacheKey.forProvisionKey(null).toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given forProvisionKey {@code Provision Device Key}.
   *   <li>Then return {@code Provision Device Key}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceProfileCacheKey.toString()"})
  public void testToString_givenForProvisionKeyProvisionDeviceKey_thenReturnProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertEquals(
        "Provision Device Key",
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key").toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceProfileCacheKey.toString()"})
  public void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        DeviceProfileCacheKey.forId(
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DeviceProfileCacheKey.toString()"})
  public void testToString_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given forProvisionKey {@code Provision Device Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#isVersioned()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceProfileCacheKey.isVersioned()"})
  public void testIsVersioned_givenForProvisionKeyProvisionDeviceKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileCacheKey.forProvisionKey("Provision Device Key").isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#isVersioned()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DeviceProfileCacheKey.isVersioned()"})
  public void testIsVersioned_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        DeviceProfileCacheKey.forId(
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and {@link
   * DeviceProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");
    DeviceProfileCacheKey forProvisionKeyResult2 =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertEquals(forProvisionKeyResult, forProvisionKeyResult2);
    int expectedHashCodeResult = forProvisionKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, forProvisionKeyResult2.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and {@link
   * DeviceProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey(null);
    DeviceProfileCacheKey forProvisionKeyResult2 = DeviceProfileCacheKey.forProvisionKey(null);

    // Act and Assert
    assertEquals(forProvisionKeyResult, forProvisionKeyResult2);
    int expectedHashCodeResult = forProvisionKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, forProvisionKeyResult2.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and {@link
   * DeviceProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult =
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);
    DeviceProfileCacheKey forDefaultProfileResult2 =
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and {@link
   * DeviceProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertEquals(forProvisionKeyResult, forProvisionKeyResult);
    int expectedHashCodeResult = forProvisionKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, forProvisionKeyResult.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey(null);

    // Act and Assert
    assertNotEquals(
        forProvisionKeyResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey(
            "org.thingsboard.server.dao.device.DeviceProfileCacheKey");

    // Act and Assert
    assertNotEquals(
        forProvisionKeyResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult =
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult =
        DeviceProfileCacheKey.forDefaultProfile(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult,
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult = DeviceProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertNotEquals(
        forDefaultProfileResult,
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileCacheKey forIdResult =
        DeviceProfileCacheKey.forId(
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(forIdResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(
        forProvisionKeyResult,
        DeviceProfileCacheKey.forId(
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileCacheKey.forProvisionKey("Provision Device Key"), null);
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileCacheKey.equals(Object)",
    "int DeviceProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key"),
        "Different type to DeviceProfileCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#getDeviceProfileId()}
   *   <li>{@link DeviceProfileCacheKey#getName()}
   *   <li>{@link DeviceProfileCacheKey#getProvisionDeviceKey()}
   *   <li>{@link DeviceProfileCacheKey#getTenantId()}
   *   <li>{@link DeviceProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "DeviceProfileId DeviceProfileCacheKey.getDeviceProfileId()",
    "String DeviceProfileCacheKey.getName()",
    "String DeviceProfileCacheKey.getProvisionDeviceKey()",
    "TenantId DeviceProfileCacheKey.getTenantId()",
    "boolean DeviceProfileCacheKey.isDefaultProfile()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult =
        DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act
    DeviceProfileId actualDeviceProfileId = forProvisionKeyResult.getDeviceProfileId();
    String actualName = forProvisionKeyResult.getName();
    String actualProvisionDeviceKey = forProvisionKeyResult.getProvisionDeviceKey();
    TenantId actualTenantId = forProvisionKeyResult.getTenantId();

    // Assert
    assertEquals("Provision Device Key", actualProvisionDeviceKey);
    assertNull(actualName);
    assertNull(actualDeviceProfileId);
    assertNull(actualTenantId);
    assertFalse(forProvisionKeyResult.isDefaultProfile());
  }
}
