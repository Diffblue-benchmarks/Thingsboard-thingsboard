package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class TbEntityRemoteSubsInfoDiffblueTest {
  /**
   * Test
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent)")
  void testUpdateAndCheckIsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo = new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbSubscriptionsInfo info = new TbSubscriptionsInfo();

    // Act
    tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED, info, 10));

    // Assert
    Map<String, TbSubscriptionsInfo> subs = tbEntityRemoteSubsInfo.getSubs();
    assertEquals(1, subs.size());
    assertSame(info, subs.get("42"));
  }

  /**
   * Test
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent)")
  void testUpdateAndCheckIsEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo = new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo tbSubscriptionsInfo = new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(),
        10);

    when(event.getInfo()).thenReturn(tbSubscriptionsInfo);
    when(event.getType()).thenReturn(ComponentLifecycleEvent.UPDATED);

    // Act
    tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42", event);

    // Assert
    verify(event).getInfo();
    verify(event).getType();
    Map<String, TbSubscriptionsInfo> subs = tbEntityRemoteSubsInfo.getSubs();
    assertEquals(1, subs.size());
    assertSame(tbSubscriptionsInfo, subs.get("42"));
  }

  /**
   * Test
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link TbEntitySubEvent} {@link TbEntitySubEvent#getType()} return
   * {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent); given 'DELETED'; when TbEntitySubEvent getType() return 'DELETED'")
  void testUpdateAndCheckIsEmpty_givenDeleted_whenTbEntitySubEventGetTypeReturnDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo = new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    when(event.getType()).thenReturn(ComponentLifecycleEvent.DELETED);

    // Act
    boolean actualUpdateAndCheckIsEmptyResult = tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42", event);

    // Assert
    verify(event).getType();
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
    assertTrue(actualUpdateAndCheckIsEmptyResult);
  }

  /**
   * Test
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Given {@code STARTED}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent); given 'STARTED'; then return 'false'")
  void testUpdateAndCheckIsEmpty_givenStarted_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo = new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    when(event.getType()).thenReturn(ComponentLifecycleEvent.STARTED);

    // Act
    boolean actualUpdateAndCheckIsEmptyResult = tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42", event);

    // Assert
    verify(event).getType();
    assertFalse(actualUpdateAndCheckIsEmptyResult);
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
  }

  /**
   * Test
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Given {@link TbSubscriptionsInfo#TbSubscriptionsInfo()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent); given TbSubscriptionsInfo(); then return 'true'")
  void testUpdateAndCheckIsEmpty_givenTbSubscriptionsInfo_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo = new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));
    TbEntitySubEvent event = mock(TbEntitySubEvent.class);
    when(event.getInfo()).thenReturn(new TbSubscriptionsInfo());
    when(event.getType()).thenReturn(ComponentLifecycleEvent.UPDATED);

    // Act
    boolean actualUpdateAndCheckIsEmptyResult = tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42", event);

    // Assert
    verify(event).getInfo();
    verify(event).getType();
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
    assertTrue(actualUpdateAndCheckIsEmptyResult);
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}.
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}
   */
  @Test
  @DisplayName("Test removeAndCheckIsEmpty(String)")
  void testRemoveAndCheckIsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()), mock(AlarmId.class))).removeAndCheckIsEmpty("42"));
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}
   */
  @Test
  @DisplayName("Test removeAndCheckIsEmpty(String); then return 'false'")
  void testRemoveAndCheckIsEmpty_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()), null)).removeAndCheckIsEmpty("42"));
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#isEmpty()}.
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()), mock(AlarmId.class))).isEmpty());
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#isEmpty()}.
   * <ul>
   *   <li>Given
   * {@link TbEntityRemoteSubsInfo#TbEntityRemoteSubsInfo(TenantId, EntityId)}
   * with tenantId is {@link TenantId#TenantId(UUID)} and entityId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given TbEntityRemoteSubsInfo(TenantId, EntityId) with tenantId is TenantId(UUID) and entityId is 'null'")
  void testIsEmpty_givenTbEntityRemoteSubsInfoWithTenantIdIsTenantIdAndEntityIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TbEntityRemoteSubsInfo(new TenantId(UUID.randomUUID()), null)).isEmpty());
  }
}
