package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;

@ContextConfiguration(classes = {TenantWidgetsBundlesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TenantWidgetsBundlesEdgeEventFetcherDiffblueTest {
  @Autowired
  private TenantWidgetsBundlesEdgeEventFetcher tenantWidgetsBundlesEdgeEventFetcher;

  @MockBean
  private WidgetsBundleService widgetsBundleService;

  /**
   * Test
   * {@link TenantWidgetsBundlesEdgeEventFetcher#TenantWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)}.
   * <p>
   * Method under test:
   * {@link TenantWidgetsBundlesEdgeEventFetcher#TenantWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)}
   */
  @Test
  @DisplayName("Test new TenantWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)")
  void testNewTenantWidgetsBundlesEdgeEventFetcher() {
    // Arrange, Act and Assert
    WidgetsBundleService widgetsBundleService = (new TenantWidgetsBundlesEdgeEventFetcher(
        new WidgetsBundleServiceImpl())).widgetsBundleService;
    assertTrue(widgetsBundleService instanceof WidgetsBundleServiceImpl);
    assertEquals(EntityType.WIDGETS_BUNDLE, widgetsBundleService.getEntityType());
  }

  /**
   * Test
   * {@link TenantWidgetsBundlesEdgeEventFetcher#findWidgetsBundles(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link TenantWidgetsBundlesEdgeEventFetcher#findWidgetsBundles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findWidgetsBundles(TenantId, PageLink)")
  void testFindWidgetsBundles() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleService.findTenantWidgetsBundlesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<WidgetsBundle> actualFindWidgetsBundlesResult = tenantWidgetsBundlesEdgeEventFetcher
        .findWidgetsBundles(tenantId, new PageLink(3));

    // Assert
    verify(widgetsBundleService).findTenantWidgetsBundlesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindWidgetsBundlesResult.EMPTY_PAGE_DATA, actualFindWidgetsBundlesResult);
  }
}
