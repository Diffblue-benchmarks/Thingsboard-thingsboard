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

@ContextConfiguration(classes = {SystemWidgetTypesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SystemWidgetTypesEdgeEventFetcherDiffblueTest {
  @Autowired
  private SystemWidgetTypesEdgeEventFetcher systemWidgetTypesEdgeEventFetcher;

  @MockBean
  private WidgetTypeService widgetTypeService;

  /**
   * Test
   * {@link SystemWidgetTypesEdgeEventFetcher#SystemWidgetTypesEdgeEventFetcher(WidgetTypeService)}.
   * <p>
   * Method under test:
   * {@link SystemWidgetTypesEdgeEventFetcher#SystemWidgetTypesEdgeEventFetcher(WidgetTypeService)}
   */
  @Test
  @DisplayName("Test new SystemWidgetTypesEdgeEventFetcher(WidgetTypeService)")
  void testNewSystemWidgetTypesEdgeEventFetcher() {
    // Arrange, Act and Assert
    WidgetTypeService widgetTypeService = (new SystemWidgetTypesEdgeEventFetcher(
        new WidgetTypeServiceImpl())).widgetTypeService;
    assertTrue(widgetTypeService instanceof WidgetTypeServiceImpl);
    assertEquals(EntityType.WIDGET_TYPE, widgetTypeService.getEntityType());
  }

  /**
   * Test
   * {@link SystemWidgetTypesEdgeEventFetcher#findWidgetTypes(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link SystemWidgetTypesEdgeEventFetcher#findWidgetTypes(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findWidgetTypes(TenantId, PageLink)")
  void testFindWidgetTypes() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeService.findSystemWidgetTypesByPageLink(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesResult = systemWidgetTypesEdgeEventFetcher.findWidgetTypes(tenantId,
        new PageLink(3));

    // Assert
    verify(widgetTypeService).findSystemWidgetTypesByPageLink(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFindWidgetTypesResult.EMPTY_PAGE_DATA, actualFindWidgetTypesResult);
  }
}
