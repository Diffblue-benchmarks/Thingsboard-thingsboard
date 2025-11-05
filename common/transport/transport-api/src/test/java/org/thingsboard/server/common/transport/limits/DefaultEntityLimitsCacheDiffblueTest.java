package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class DefaultEntityLimitsCacheDiffblueTest {
  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId, "42"), false);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId2, "Device Name"), true);
    TenantId tenantId3 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId3, "Device Name"));

    // Assert
    assertTrue(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet2() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId, ""), true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId2, "42"), false);
    TenantId tenantId3 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId3, "Device Name"), true);
    TenantId tenantId4 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId4, "Device Name"));

    // Assert
    assertTrue(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet3() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(
        new EntityLimitKey(new TenantId(new UUID(59L, 59L)), "Device Name"), true);

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(
            new EntityLimitKey(
                mock(TenantId.class),
                "org.thingsboard.server.common.transport.limits.EntityLimitKey"));

    // Assert
    assertFalse(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet4() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(-1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId, ""), true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId2, "42"), false);
    TenantId tenantId3 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId3, "Device Name"), true);
    TenantId tenantId4 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId4, "Device Name"));

    // Assert
    assertFalse(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultEntityLimitsCache#DefaultEntityLimitsCache(int, int)} with ttl is one
   *       and maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName(
      "Test get(EntityLimitKey); given DefaultEntityLimitsCache(int, int) with ttl is one and maxSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_givenDefaultEntityLimitsCacheWithTtlIsOneAndMaxSizeIsThree() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId, "Device Name"));

    // Assert
    assertFalse(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <ul>
   *   <li>Given {@link UUID#UUID(long, long)} with fifty-nine and fifty-nine.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName(
      "Test get(EntityLimitKey); given UUID(long, long) with fifty-nine and fifty-nine; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_givenUuidWithFiftyNineAndFiftyNine_thenReturnFalse() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(
        new EntityLimitKey(new TenantId(new UUID(59L, 59L)), "Device Name"), true);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId, "Device Name"));

    // Assert
    assertFalse(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_thenReturnTrue() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId, "Device Name"), true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(tenantId2, "Device Name"));

    // Assert
    assertTrue(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <ul>
   *   <li>When {@link EntityLimitKey#EntityLimitKey(TenantId, String)} with {@link TenantId} and
   *       {@code Device Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName(
      "Test get(EntityLimitKey); when EntityLimitKey(TenantId, String) with TenantId and 'Device Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_whenEntityLimitKeyWithTenantIdAndDeviceName() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(
        new EntityLimitKey(new TenantId(new UUID(59L, 59L)), "Device Name"), true);

    // Act
    boolean actualGetResult =
        defaultEntityLimitsCache.get(new EntityLimitKey(mock(TenantId.class), "Device Name"));

    // Assert
    assertFalse(actualGetResult);
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   *
   * <ul>
   *   <li>When {@link EntityLimitKey#EntityLimitKey(TenantId, String)} with tenantId is {@link
   *       TenantId#TenantId(UUID)} and deviceName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName(
      "Test get(EntityLimitKey); when EntityLimitKey(TenantId, String) with tenantId is TenantId(UUID) and deviceName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultEntityLimitsCache.get(EntityLimitKey)"})
  void testGet_whenEntityLimitKeyWithTenantIdIsTenantIdAndDeviceNameIsEmptyString() {
    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId, ""), true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId2, "42"), false);
    TenantId tenantId3 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    defaultEntityLimitsCache.put(new EntityLimitKey(tenantId3, "Device Name"), true);
    TenantId tenantId4 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualGetResult = defaultEntityLimitsCache.get(new EntityLimitKey(tenantId4, ""));

    // Assert
    assertTrue(actualGetResult);
  }
}
