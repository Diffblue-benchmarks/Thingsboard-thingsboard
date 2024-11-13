package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceProfileCacheKeyDiffblueTest {
  /**
   * Test {@link DeviceProfileCacheKey#forName(TenantId, String)}.
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#forName(TenantId, String)}
   */
  @Test
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#forId(DeviceProfileId)}
   */
  @Test
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
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#forDefaultProfile(TenantId)}
   */
  @Test
  public void testForDefaultProfile() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DeviceProfileCacheKey actualForDefaultProfileResult = DeviceProfileCacheKey.forDefaultProfile(tenantId);

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
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#forProvisionKey(String)}
   */
  @Test
  public void testForProvisionKey() {
    // Arrange and Act
    DeviceProfileCacheKey actualForProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

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
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForDefaultProfileSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forId {@link DeviceProfileId#DeviceProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForIdDeviceProfileIdWithIdIsNull_uuid() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        DeviceProfileCacheKey.forId(new DeviceProfileId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forProvisionKey empty string.</li>
   *   <li>Then return {@code null_null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForProvisionKeyEmptyString_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null_null", DeviceProfileCacheKey.forProvisionKey("").toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forProvisionKey {@code null}.</li>
   *   <li>Then return {@code null_null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForProvisionKeyNull_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null_null", DeviceProfileCacheKey.forProvisionKey(null).toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forProvisionKey {@code Provision Device Key}.</li>
   *   <li>Then return {@code Provision Device Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForProvisionKeyProvisionDeviceKey_thenReturnProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertEquals("Provision Device Key", DeviceProfileCacheKey.forProvisionKey("Provision Device Key").toString());
  }

  /**
   * Test {@link DeviceProfileCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given forId {@link DeviceProfileId#DeviceProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenForIdDeviceProfileIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DeviceProfileCacheKey.forId(new DeviceProfileId(ModelConstants.NULL_UUID)).isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given forProvisionKey {@code Provision Device Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenForProvisionKeyProvisionDeviceKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileCacheKey.forProvisionKey("Provision Device Key").isVersioned());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and
   * {@link DeviceProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");
    DeviceProfileCacheKey forProvisionKeyResult2 = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertEquals(forProvisionKeyResult, forProvisionKeyResult2);
    int expectedHashCodeResult = forProvisionKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, forProvisionKeyResult2.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and
   * {@link DeviceProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and
   * {@link DeviceProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult = DeviceProfileCacheKey
        .forDefaultProfile(ModelConstants.SYSTEM_TENANT);
    DeviceProfileCacheKey forDefaultProfileResult2 = DeviceProfileCacheKey
        .forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}, and
   * {@link DeviceProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#equals(Object)}
   *   <li>{@link DeviceProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertEquals(forProvisionKeyResult, forProvisionKeyResult);
    int expectedHashCodeResult = forProvisionKeyResult.hashCode();
    assertEquals(expectedHashCodeResult, forProvisionKeyResult.hashCode());
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey(null);

    // Act and Assert
    assertNotEquals(forProvisionKeyResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey
        .forProvisionKey("org.thingsboard.server.dao.device.DeviceProfileCacheKey");

    // Act and Assert
    assertNotEquals(forProvisionKeyResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult = DeviceProfileCacheKey
        .forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult = DeviceProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, DeviceProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileCacheKey forDefaultProfileResult = DeviceProfileCacheKey
        .forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, DeviceProfileCacheKey.forDefaultProfile(null));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileCacheKey forIdResult = DeviceProfileCacheKey.forId(new DeviceProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertNotEquals(forIdResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfileCacheKey forIdResult = DeviceProfileCacheKey.forId(mock(DeviceProfileId.class));

    // Act and Assert
    assertNotEquals(forIdResult, DeviceProfileCacheKey.forProvisionKey("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

    // Act and Assert
    assertNotEquals(forProvisionKeyResult, DeviceProfileCacheKey.forId(new DeviceProfileId(ModelConstants.NULL_UUID)));
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileCacheKey.forProvisionKey("Provision Device Key"), null);
  }

  /**
   * Test {@link DeviceProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileCacheKey.forProvisionKey("Provision Device Key"),
        "Different type to DeviceProfileCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileCacheKey#getDeviceProfileId()}
   *   <li>{@link DeviceProfileCacheKey#getName()}
   *   <li>{@link DeviceProfileCacheKey#getProvisionDeviceKey()}
   *   <li>{@link DeviceProfileCacheKey#getTenantId()}
   *   <li>{@link DeviceProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DeviceProfileCacheKey forProvisionKeyResult = DeviceProfileCacheKey.forProvisionKey("Provision Device Key");

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
