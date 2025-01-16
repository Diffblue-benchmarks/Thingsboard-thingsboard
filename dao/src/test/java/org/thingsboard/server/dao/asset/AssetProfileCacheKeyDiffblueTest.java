package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetProfileCacheKeyDiffblueTest {
  /**
   * Test {@link AssetProfileCacheKey#forName(TenantId, String)}.
   * <p>
   * Method under test: {@link AssetProfileCacheKey#forName(TenantId, String)}
   */
  @Test
  public void testForName() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AssetProfileCacheKey actualForNameResult = AssetProfileCacheKey.forName(tenantId, "Name");

    // Assert
    assertEquals("Name", actualForNameResult.getName());
    assertNull(actualForNameResult.getAssetProfileId());
    assertFalse(actualForNameResult.isDefaultProfile());
    assertFalse(actualForNameResult.isVersioned());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForNameResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#forId(AssetProfileId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#forId(AssetProfileId)}
   */
  @Test
  public void testForId_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    AssetProfileCacheKey actualForIdResult = AssetProfileCacheKey.forId(null);

    // Assert
    assertNull(actualForIdResult.getName());
    assertNull(actualForIdResult.getAssetProfileId());
    assertNull(actualForIdResult.getTenantId());
    assertFalse(actualForIdResult.isDefaultProfile());
    assertFalse(actualForIdResult.isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}.
   * <p>
   * Method under test: {@link AssetProfileCacheKey#forDefaultProfile(TenantId)}
   */
  @Test
  public void testForDefaultProfile() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AssetProfileCacheKey actualForDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(tenantId);

    // Assert
    assertNull(actualForDefaultProfileResult.getName());
    assertNull(actualForDefaultProfileResult.getAssetProfileId());
    assertFalse(actualForDefaultProfileResult.isVersioned());
    assertTrue(actualForDefaultProfileResult.isDefaultProfile());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForDefaultProfileResult.getTenantId());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForDefaultProfileSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   * <ul>
   *   <li>Given forId {@link AssetProfileId#AssetProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  public void testToString_givenForIdAssetProfileIdWithIdIsNull_uuid() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        AssetProfileCacheKey.forId(new AssetProfileId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#toString()}.
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080_Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#toString()}
   */
  @Test
  public void testToString_thenReturn138140001dd211b28080808080808080Name() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Name",
        AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name").toString());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given forDefaultProfile {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenForDefaultProfileSystem_tenant_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT).isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given forId {@link AssetProfileId#AssetProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#isVersioned()}
   */
  @Test
  public void testIsVersioned_givenForIdAssetProfileIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AssetProfileCacheKey.forId(new AssetProfileId(ModelConstants.NULL_UUID)).isVersioned());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and
   * {@link AssetProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);
    AssetProfileCacheKey forDefaultProfileResult2 = AssetProfileCacheKey
        .forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and
   * {@link AssetProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);
    AssetProfileCacheKey forDefaultProfileResult2 = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult2);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and
   * {@link AssetProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetProfileCacheKey forNameResult = AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");
    AssetProfileCacheKey forNameResult2 = AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertEquals(forNameResult, forNameResult2);
    int expectedHashCodeResult = forNameResult.hashCode();
    assertEquals(expectedHashCodeResult, forNameResult2.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}, and
   * {@link AssetProfileCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileCacheKey#equals(Object)}
   *   <li>{@link AssetProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(forDefaultProfileResult, forDefaultProfileResult);
    int expectedHashCodeResult = forDefaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, forDefaultProfileResult.hashCode());
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(null);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetProfileCacheKey forNameResult = AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name");

    // Act and Assert
    assertNotEquals(forNameResult, AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(forDefaultProfileResult, AssetProfileCacheKey.forDefaultProfile(null));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetProfileCacheKey forNameResult = AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetProfileCacheKey forNameResult = AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT,
        "org.thingsboard.server.dao.asset.AssetProfileCacheKey");

    // Act and Assert
    assertNotEquals(forNameResult, AssetProfileCacheKey.forName(ModelConstants.SYSTEM_TENANT, "Name"));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetProfileCacheKey forIdResult = AssetProfileCacheKey.forId(mock(AssetProfileId.class));

    // Act and Assert
    assertNotEquals(forIdResult, AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link AssetProfileCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT),
        "Different type to AssetProfileCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileCacheKey#getAssetProfileId()}
   *   <li>{@link AssetProfileCacheKey#getName()}
   *   <li>{@link AssetProfileCacheKey#getTenantId()}
   *   <li>{@link AssetProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AssetProfileCacheKey forDefaultProfileResult = AssetProfileCacheKey.forDefaultProfile(ModelConstants.SYSTEM_TENANT);

    // Act
    AssetProfileId actualAssetProfileId = forDefaultProfileResult.getAssetProfileId();
    String actualName = forDefaultProfileResult.getName();
    TenantId actualTenantId = forDefaultProfileResult.getTenantId();

    // Assert
    assertNull(actualName);
    assertNull(actualAssetProfileId);
    assertTrue(forDefaultProfileResult.isDefaultProfile());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
