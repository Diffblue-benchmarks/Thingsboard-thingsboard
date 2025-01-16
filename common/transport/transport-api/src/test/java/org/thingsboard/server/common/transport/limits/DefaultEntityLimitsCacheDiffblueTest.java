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
   * <ul>
   *   <li>When {@link EntityLimitKey}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when EntityLimitKey; then return 'false'")
  void testGet_whenEntityLimitKey_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DefaultEntityLimitsCache(1, 3)).get(mock(EntityLimitKey.class)));
  }

  /**
   * Test {@link DefaultEntityLimitsCache#get(EntityLimitKey)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityLimitsCache#get(EntityLimitKey)}
   */
  @Test
  @DisplayName("Test get(EntityLimitKey); when TenantId(UUID) with id is randomUUID; then return 'false'")
  void testGet_whenTenantIdWithIdIsRandomUUID_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityLimitsCache defaultEntityLimitsCache = new DefaultEntityLimitsCache(1, 3);

    // Act and Assert
    assertFalse(defaultEntityLimitsCache.get(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name")));
  }
}
