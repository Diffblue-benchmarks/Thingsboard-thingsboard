package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class TbEntitySubEventDiffblueTest {
  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertFalse((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10))
        .hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);

    // Act and Assert
    assertFalse(
        (new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10))
            .hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntitySubEvent(new TenantId(UUID.randomUUID()), null, ComponentLifecycleEvent.CREATED, null, 10))
        .hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, false, tsKeys, true, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  void testHasTsOrAttrSub6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, false, tsKeys, false, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }
}
