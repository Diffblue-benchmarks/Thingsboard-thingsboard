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
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;

@ContextConfiguration(classes = {TenantWidgetTypesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TenantWidgetTypesEdgeEventFetcherDiffblueTest {
  @Autowired
  private TenantWidgetTypesEdgeEventFetcher tenantWidgetTypesEdgeEventFetcher;

  @MockBean
  private WidgetTypeService widgetTypeService;

  /**
   * Test
   * {@link TenantWidgetTypesEdgeEventFetcher#TenantWidgetTypesEdgeEventFetcher(WidgetTypeService)}.
   * <p>
   * Method under test:
   * {@link TenantWidgetTypesEdgeEventFetcher#TenantWidgetTypesEdgeEventFetcher(WidgetTypeService)}
   */
  @Test
  @DisplayName("Test new TenantWidgetTypesEdgeEventFetcher(WidgetTypeService)")
  void testNewTenantWidgetTypesEdgeEventFetcher() {
    // Arrange, Act and Assert
    WidgetTypeService widgetTypeService = (new TenantWidgetTypesEdgeEventFetcher(
        new WidgetTypeServiceImpl())).widgetTypeService;
    assertTrue(widgetTypeService instanceof WidgetTypeServiceImpl);
    assertEquals(EntityType.WIDGET_TYPE, widgetTypeService.getEntityType());
  }

  /**
   * Test
   * {@link TenantWidgetTypesEdgeEventFetcher#findWidgetTypes(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link TenantWidgetTypesEdgeEventFetcher#findWidgetTypes(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findWidgetTypes(TenantId, PageLink)")
  void testFindWidgetTypes() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeService.findTenantWidgetTypesByTenantIdAndPageLink(Mockito.<WidgetTypeFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesResult = tenantWidgetTypesEdgeEventFetcher.findWidgetTypes(tenantId,
        new PageLink(3));

    // Assert
    verify(widgetTypeService).findTenantWidgetTypesByTenantIdAndPageLink(isA(WidgetTypeFilter.class),
        isA(PageLink.class));
    assertSame(actualFindWidgetTypesResult.EMPTY_PAGE_DATA, actualFindWidgetTypesResult);
  }
}
