package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.settings.AdminSettingsService;

@ContextConfiguration(classes = {AdminSettingsEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AdminSettingsEdgeEventFetcherDiffblueTest {
  @Autowired
  private AdminSettingsEdgeEventFetcher adminSettingsEdgeEventFetcher;

  @MockBean
  private AdminSettingsService adminSettingsService;

  /**
   * Test {@link AdminSettingsEdgeEventFetcher#getPageLink(int)}.
   * <p>
   * Method under test: {@link AdminSettingsEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull(adminSettingsEdgeEventFetcher.getPageLink(3));
  }

  /**
   * Test
   * {@link AdminSettingsEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); then return TotalElements is zero")
  void testFetchEdgeEvents_thenReturnTotalElementsIsZero() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = adminSettingsEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), Mockito.<String>any());
    assertEquals(0L, actualFetchEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFetchEdgeEventsResult.getTotalPages());
    assertFalse(actualFetchEdgeEventsResult.hasNext());
    assertTrue(actualFetchEdgeEventsResult.getData().isEmpty());
  }
}
