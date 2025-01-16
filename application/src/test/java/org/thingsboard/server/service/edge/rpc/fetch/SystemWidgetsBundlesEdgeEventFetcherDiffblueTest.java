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
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;

@ContextConfiguration(classes = {SystemWidgetsBundlesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SystemWidgetsBundlesEdgeEventFetcherDiffblueTest {
  @Autowired
  private SystemWidgetsBundlesEdgeEventFetcher systemWidgetsBundlesEdgeEventFetcher;

  @MockBean
  private WidgetsBundleService widgetsBundleService;

  /**
   * Test
   * {@link SystemWidgetsBundlesEdgeEventFetcher#SystemWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)}.
   * <p>
   * Method under test:
   * {@link SystemWidgetsBundlesEdgeEventFetcher#SystemWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)}
   */
  @Test
  @DisplayName("Test new SystemWidgetsBundlesEdgeEventFetcher(WidgetsBundleService)")
  void testNewSystemWidgetsBundlesEdgeEventFetcher() {
    // Arrange, Act and Assert
    WidgetsBundleService widgetsBundleService = (new SystemWidgetsBundlesEdgeEventFetcher(
        new WidgetsBundleServiceImpl())).widgetsBundleService;
    assertTrue(widgetsBundleService instanceof WidgetsBundleServiceImpl);
    assertEquals(EntityType.WIDGETS_BUNDLE, widgetsBundleService.getEntityType());
  }

  /**
   * Test
   * {@link SystemWidgetsBundlesEdgeEventFetcher#findWidgetsBundles(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link SystemWidgetsBundlesEdgeEventFetcher#findWidgetsBundles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findWidgetsBundles(TenantId, PageLink)")
  void testFindWidgetsBundles() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleService.findSystemWidgetsBundlesByPageLink(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<WidgetsBundle> actualFindWidgetsBundlesResult = systemWidgetsBundlesEdgeEventFetcher
        .findWidgetsBundles(tenantId, new PageLink(3));

    // Assert
    verify(widgetsBundleService).findSystemWidgetsBundlesByPageLink(isA(WidgetsBundleFilter.class),
        isA(PageLink.class));
    assertSame(actualFindWidgetsBundlesResult.EMPTY_PAGE_DATA, actualFindWidgetsBundlesResult);
  }
}
