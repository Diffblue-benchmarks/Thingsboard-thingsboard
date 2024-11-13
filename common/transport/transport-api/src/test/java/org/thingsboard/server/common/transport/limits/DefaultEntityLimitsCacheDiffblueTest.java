package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class DefaultEntityLimitsCacheDiffblueTest {
  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  void testGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(new EntityLimitKey(new TenantId(UUID.randomUUID()), "42"), true);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(mock(EntityLimitKey.class)));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey)")
  void testGet2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), true);
    defaultEntityLimitsCache.put(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), true);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name")));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>When {@link EntityLimitKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when EntityLimitKey")
  void testGet_whenEntityLimitKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultEntityLimitsCache(1, 3)).get(mock(EntityLimitKey.class)));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>When {@link EntityLimitKey#EntityLimitKey(TenantId, String)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and {@code Device Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when EntityLimitKey(TenantId, String) with tenantId is TenantId(UUID) and 'Device Name'")
  void testGet_whenEntityLimitKeyWithTenantIdIsTenantIdAndDeviceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name")));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>When {@link EntityLimitKey#EntityLimitKey(TenantId, String)} with
   * tenantId is {@link TenantId#TenantId(UUID)} and deviceName is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when EntityLimitKey(TenantId, String) with tenantId is TenantId(UUID) and deviceName is '42'")
  void testGet_whenEntityLimitKeyWithTenantIdIsTenantIdAndDeviceNameIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);
    defaultEntityLimitsCache.put(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), true);
    defaultEntityLimitsCache.put(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), true);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(new EntityLimitKey(new TenantId(UUID.randomUUID()), "42")));
  }
}
